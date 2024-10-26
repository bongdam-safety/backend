package kr.co.bongdamsafety.onlinemap.service;

import jakarta.annotation.PostConstruct;
import kr.co.bongdamsafety.onlinemap.dto.FacilityForm;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AccountRepository accountRepository_new; // 이 시설물을 생성한 계정 정보가 저장되는 리포지토리
    @Autowired
    private AccountRepository accountRepository_edit; // 이 시설물을 수정한 계정 정보가 저장되는 리포지토리

    public List<Facility> findAll() {
        return facilityRepository.findAll(); // 모든 시설물 정보 물러오기
    }

    public Facility findById(Long id) {
        return facilityRepository.findById(id).orElse(null); // id를 받아 해당하는 시설물 정보 불러오기
    }

    private static final String UPLOAD_DIR = "D:/github/backend/src/main/resources/static/upload/images";
    private static final String RELATIVE_UPLOAD_DIR = "/static/upload/images";

    @PostConstruct
    public void init() {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public Facility create(FacilityForm dto) { // 신규 시설물 생성
        Facility facility = dto.toEntity(facilityCategoryRepository, accountRepository_new, accountRepository_edit);

        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : dto.getImages()) {
            if(!file.isEmpty()) {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                File dest = new File(UPLOAD_DIR + "/" + fileName);
                try {
                    file.transferTo(dest);
                    imageUrls.add(RELATIVE_UPLOAD_DIR + "/" + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        facility.setImageUrls(imageUrls);
        return facilityRepository.save(facility);
    }

//    @PostConstruct
//    public void init() {
//        File uploadDir = new File("/upload/images");
//        if (!uploadDir.exists()) {
//            uploadDir.mkdirs();
//        }
//    }
}