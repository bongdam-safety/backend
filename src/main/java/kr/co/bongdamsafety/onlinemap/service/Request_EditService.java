package kr.co.bongdamsafety.onlinemap.service;

import jakarta.annotation.PostConstruct;
import kr.co.bongdamsafety.onlinemap.dto.Request_EditForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import kr.co.bongdamsafety.onlinemap.repository.Request_EditRepository;
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
public class Request_EditService {
    @Autowired
    private Request_EditRepository request_EditRepository; // 지도의 정보 수정요청 리포지토리
    @Autowired
    private FacilityRepository facilityRepository; // 수정요청된 시설물 정보가 저장되는 리포지토리

    public List<Request_Edit> findAll() {
        return request_EditRepository.findAll(); // 모든 수정요청 정보 불러오기
    }

    public Request_Edit findById(Long id) {
        return request_EditRepository.findById(id).orElse(null); // id를 받아 해당하는 수정요청 정보 불러오기
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

    public Request_Edit create(Request_EditForm dto) { // 신규 수정요청 생성
        Request_Edit request_Edit = dto.toEntity(facilityRepository);

        List<String> imageUrls = new ArrayList<>(); // 이미지 주소들이 들어가는 리스트
        for (MultipartFile file : dto.getImages()) { // 들어온 이미지파일들이 하나씩 돌아가면서 반복
            if(!file.isEmpty()) {
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
        request_Edit.setImageUrls(imageUrls); // 이미지 주소들은 시설물 객체에 저장

        return request_EditRepository.save(request_Edit);
    }

    public ResponseEntity<Request_Edit> delete(Long id) {
        Request_Edit target = request_EditRepository.findById(id).orElse(null);

        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        request_EditRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}