package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.dto.Request_ToCenterForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_ToCenter;
import kr.co.bongdamsafety.onlinemap.repository.Request_ToCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Request_ToCenter create(Request_ToCenterForm dto) { // 센터로 한 요청 저장
        Request_ToCenter request_ToCenter = dto.toEntity();
        return request_ToCenterRepository.save(request_ToCenter);
    }
}