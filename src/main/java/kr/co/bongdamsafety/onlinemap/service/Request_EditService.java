package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.dto.Request_EditForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import kr.co.bongdamsafety.onlinemap.repository.Request_EditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Request_Edit create(Request_EditForm dto) { // 신규 수정요청 생성
        Request_Edit request_Edit = dto.toEntity(facilityRepository);
        return request_EditRepository.save(request_Edit);
    }
}