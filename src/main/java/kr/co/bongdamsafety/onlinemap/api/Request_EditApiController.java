package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.Request_EditForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import kr.co.bongdamsafety.onlinemap.repository.Request_EditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Request_EditApiController {
    @Autowired
    Request_EditRepository request_EditRepository;
    @Autowired
    FacilityRepository facilityRepository;

    // GET **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_Edit")
    public List<Request_Edit> index(){
        return request_EditRepository.findAll();
    }

    // GET - 단일 수정요청 조회 **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_Edit/{id}")
    public Request_Edit show(@PathVariable Long id) {
        return request_EditRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("api/request_Edit")
    public Request_Edit create(@RequestBody Request_EditForm dto) { // requestbody -> 요청시 본문(body)에 실어보내는 데이터를 create 메서드의 매개변수로 받아올수 있게함
        Request_Edit request_Edit = dto.toEntity(facilityRepository);
        return request_EditRepository.save(request_Edit);
    }
}
