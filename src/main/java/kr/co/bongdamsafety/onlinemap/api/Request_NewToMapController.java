package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.Request_NewToMapForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.Request_NewToMapRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Request_NewToMapController {
    @Autowired
    Request_NewToMapRepository request_NewToMapRepository;
    @Autowired
    FacilityCategoryRepository facilityCategoryRepository;

    // GET **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_NewToMap")
    public List<Request_NewToMap> index(){
        return request_NewToMapRepository.findAll();
    }

    // GET - 단일 신규장소 지도에 추가요청 조회 **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_NewToMap/{id}")
    public Request_NewToMap show(@PathVariable Long id){
        return request_NewToMapRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("api/request_NewToMap")
    public Request_NewToMap create(@RequestBody Request_NewToMapForm dto){
        Request_NewToMap request_NewToMap = dto.toEntity(facilityCategoryRepository);
        return request_NewToMapRepository.save(request_NewToMap);
    }

}
