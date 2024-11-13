package kr.co.bongdamsafety.onlinemap.service;

import jakarta.annotation.PostConstruct;
import kr.co.bongdamsafety.onlinemap.dto.Request_NewToMapForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.Request_NewToMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Request_NewToMapService {
    @Autowired
    private Request_NewToMapRepository request_NewToMapRepository; // 지도에 새로운 정보 추가 요청 리포지토리
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository; // 새로 추가될 시설물의 분류가 저장되는 리포지토리

    public List<Request_NewToMap> findAll() { // 모든 추가요청 정보 불러오기
        return request_NewToMapRepository.findAll();
    }

    public Request_NewToMap findById(Long id) { // id를 받아 해당하는 추가요청 정보 불러오기
        return request_NewToMapRepository.findById(id).orElse(null);
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

    public Request_NewToMap create(Request_NewToMapForm dto) { // 정보추가요청 생성
        Request_NewToMap request_NewToMap = dto.toEntity(facilityCategoryRepository);
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
        request_NewToMap.setImageUrls(imageUrls); // 저장된 이미지 주소들을 요청 엔티티 객체에 저장. 안하면 null로 표시된다!
        return request_NewToMapRepository.save(request_NewToMap);
    }
}