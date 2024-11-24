package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.Request_EditForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import kr.co.bongdamsafety.onlinemap.service.Request_EditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Request_Edit create(@ModelAttribute Request_EditForm dto) {
        // modelattribute : html의 form 태그로 전송된 데이터 받아옴
        return request_EditService.create(dto);
    }

    // DELETE **** 로그인되고 승인된 관리자만 삭제가능하도록 해야함 ****
    @DeleteMapping("api/request_Edit/{id}")
    public ResponseEntity<Request_Edit> delete(@PathVariable Long id) {
        return request_EditService.delete(id);
    }
}
