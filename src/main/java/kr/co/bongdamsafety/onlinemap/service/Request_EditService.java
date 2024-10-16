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
    private Request_EditRepository request_EditRepository;
    @Autowired
    private FacilityRepository facilityRepository;

    public List<Request_Edit> findAll() {
        return request_EditRepository.findAll();
    }

    public Request_Edit findById(Long id) {
        return request_EditRepository.findById(id).orElse(null);
    }

    public Request_Edit create(Request_EditForm dto) {
        Request_Edit request_Edit = dto.toEntity(facilityRepository);
        return request_EditRepository.save(request_Edit);
    }
}