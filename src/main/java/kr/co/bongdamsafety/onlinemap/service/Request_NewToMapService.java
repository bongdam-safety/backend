package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.dto.Request_NewToMapForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.Request_NewToMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Request_NewToMap create(Request_NewToMapForm dto) { // 정보추가요청 생성
        Request_NewToMap request_NewToMap = dto.toEntity(facilityCategoryRepository);
        return request_NewToMapRepository.save(request_NewToMap);
    }
}