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
    private Request_NewToMapRepository request_NewToMapRepository;
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository;

    public List<Request_NewToMap> findAll() {
        return request_NewToMapRepository.findAll();
    }

    public Request_NewToMap findById(Long id) {
        return request_NewToMapRepository.findById(id).orElse(null);
    }

    public Request_NewToMap create(Request_NewToMapForm dto) {
        Request_NewToMap request_NewToMap = dto.toEntity(facilityCategoryRepository);
        return request_NewToMapRepository.save(request_NewToMap);
    }
}