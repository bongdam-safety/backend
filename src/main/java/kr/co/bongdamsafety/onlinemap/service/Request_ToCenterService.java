package kr.co.bongdamsafety.onlinemap.service;

import jakarta.annotation.PostConstruct;
import kr.co.bongdamsafety.onlinemap.dto.Request_ToCenterForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_ToCenter;
import kr.co.bongdamsafety.onlinemap.repository.Request_ToCenterRepository;
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
public class Request_ToCenterService {
    @Autowired
    private Request_ToCenterRepository request_ToCenterRepository; // 센터에 요청하는 정보 리포지토리

    public List<Request_ToCenter> findAll() {
        return request_ToCenterRepository.findAll(); // 모든 요청정보 불러오기
    }

    public Request_ToCenter findById(Long id) {
        return request_ToCenterRepository.findById(id).orElse(null); // id를 받아 해당하는 요청정보 불러오기
    }

    private static final String UPLOAD_DIR = "D:/github/backend/src/main/resources/static/upload/tocenter_images";
    private static final String RELATIVE_UPLOAD_DIR = "/static/upload/tocenter_images";

    @PostConstruct
    public void init() {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public Request_ToCenter create(Request_ToCenterForm dto) { // 센터로 한 요청 저장
        Request_ToCenter request_ToCenter = dto.toEntity();

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
        request_ToCenter.setImageUrls(imageUrls); // 이미지 주소들은 시설물 객체에 저장

        return request_ToCenterRepository.save(request_ToCenter);
    }

    public ResponseEntity<Request_ToCenter> delete(Long id) {
        Request_ToCenter target = request_ToCenterRepository.findById(id).orElse(null);

        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        request_ToCenterRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}