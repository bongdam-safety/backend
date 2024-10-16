package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.Request_NewToMapForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import kr.co.bongdamsafety.onlinemap.service.Request_NewToMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Request_NewToMapApiController {
    @Autowired
    Request_NewToMapService request_NewToMapService;

    // GET **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_NewToMap")
    public List<Request_NewToMap> index(){
        return request_NewToMapService.findAll();
    }

    // GET - 단일 신규장소 지도에 추가요청 조회 **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_NewToMap/{id}")
    public Request_NewToMap show(@PathVariable Long id){
        return request_NewToMapService.findById(id);
    }

    // POST
    @PostMapping("api/request_NewToMap")
    public Request_NewToMap create(@RequestBody Request_NewToMapForm dto){
        return request_NewToMapService.create(dto);
    }

}
