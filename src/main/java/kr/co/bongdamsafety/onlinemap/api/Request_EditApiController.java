package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.Request_EditForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import kr.co.bongdamsafety.onlinemap.service.Request_EditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Request_EditApiController {
    @Autowired
    Request_EditService request_EditService;

    // GET **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_Edit") // 모든 수정요청 정보 조회
    public List<Request_Edit> index(){
        return request_EditService.findAll();
    }

    // GET - 단일 수정요청 조회 **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_Edit/{id}") // 특정 id의 수정요청 정보 조회
    public Request_Edit show(@PathVariable Long id) {
        return request_EditService.findById(id);
    }

    // POST
    @PostMapping("api/request_Edit") // 수정요청 생성
    public Request_Edit create(@RequestBody Request_EditForm dto) { // requestbody -> 요청시 본문(body)에 실어보내는 데이터를 create 메서드의 매개변수로 받아올수 있게함
        return request_EditService.create(dto);
    }
}
