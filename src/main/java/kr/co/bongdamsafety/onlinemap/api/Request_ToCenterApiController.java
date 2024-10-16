package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.Request_ToCenterForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_ToCenter;
import kr.co.bongdamsafety.onlinemap.repository.Request_ToCenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Request_ToCenterApiController {
    @Autowired
    Request_ToCenterRepository request_ToCenterRepository;

    // GET **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_ToCenter")
    public List<Request_ToCenter> index(){
        return request_ToCenterRepository.findAll();
    }

    // GET - 단일 센터에 요청 **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_ToCenter/{id}")
    public Request_ToCenter show(@PathVariable Long id){
        return request_ToCenterRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("api/request_ToCenter")
    public Request_ToCenter create(@RequestBody Request_ToCenterForm dto) {
        Request_ToCenter request_ToCenter = dto.toEntity();
        return request_ToCenterRepository.save(request_ToCenter);
    }
}
