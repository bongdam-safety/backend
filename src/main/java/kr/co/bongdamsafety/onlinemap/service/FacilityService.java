package kr.co.bongdamsafety.onlinemap.service;

import jakarta.annotation.PostConstruct;
import kr.co.bongdamsafety.onlinemap.dto.FacilityForm;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import kr.co.bongdamsafety.onlinemap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityService {
    @Autowired
    private FacilityRepository facilityRepository; // 시설물 리포지토리
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository; // 시설물유형 리포지토리
    @Autowired
    private UserRepository userRepository_new; // 이 시설물을 생성한 계정 정보가 저장되는 리포지토리
    @Autowired
    private UserRepository userRepository_edit; // 이 시설물을 수정한 계정 정보가 저장되는 리포지토리

    public List<Facility> findAll() {
        return facilityRepository.findAll(); // 모든 시설물 정보 물러오기
    }

    public Facility findById(Long id) {
        return facilityRepository.findById(id).orElse(null); // id를 받아 해당하는 시설물 정보 불러오기
    }

    public List<Facility> findByCategory(Long id) { // 카테고리 아이디로 해당 카테고리에 해당하는 시설물 정보 불러오기
        FacilityCategory facilityCategory = facilityCategoryRepository.findById(id).orElse(null);
        if (facilityCategory != null) {
            return facilityRepository.findByFacilityCategory(facilityCategory); // 카테고리에 해당하는 시설물 목록 반환
        }
        return new ArrayList<>(); // 없는 카테고리일 경우 빈 리스트 리턴
    }

    private static final String UPLOAD_DIR = "C:/websites/bongdamsafe1/src/main/resources/static/upload/images";
    private static final String RELATIVE_UPLOAD_DIR = "/static/upload/images";

    @PostConstruct
    public void init() {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public Facility create(FacilityForm dto) { // 신규 시설물 생성
        Facility facility = dto.toEntity(facilityCategoryRepository, userRepository_new, userRepository_edit);

        List<String> imageUrls = new ArrayList<>(); // 이미지 주소들이 들어가는 리스트
        for (MultipartFile file : dto.getImages()) { // 들어온 이미지파일들이 하나씩 돌아가면서 반복
            if (!file.isEmpty()) {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // 현재시간과 기존 파일명을 합쳐 새 파일명 제작
                File dest = new File(UPLOAD_DIR + "/" + fileName); // 파일경로
                try {
                    file.transferTo(dest); // 파일을 경로에 그 파일명으로 저장
                    imageUrls.add(RELATIVE_UPLOAD_DIR + "/" + fileName); // 리스트에 파일 상대주소 추가
                } catch (IOException e) {
                    e.printStackTrace(); // 에러 발생시 콘솔에 출력
                }
            }
        }
        facility.setImageUrls(imageUrls); // 이미지 주소들은 시설물 객체에 저장
        return facilityRepository.save(facility); // 시설물 저장
    }

    public ResponseEntity<Facility> update(Long id, FacilityForm dto) { // 시설물 정보 수정
        Facility facility = dto.toEntity(facilityCategoryRepository, userRepository_new, userRepository_edit);

        Facility target = facilityRepository.findById(id).orElse(null);

        if (target == null || id != facility.getId()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        target.patch(facility);
        Facility updated = facilityRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    public ResponseEntity<Facility> delete(Long id) {
        Facility target = facilityRepository.findById(id).orElse(null);

        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        facilityRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}