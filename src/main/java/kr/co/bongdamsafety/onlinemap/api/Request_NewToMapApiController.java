package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.Request_NewToMapForm;
import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import kr.co.bongdamsafety.onlinemap.service.Request_NewToMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Request_NewToMapApiController {
    @Autowired
    Request_NewToMapService request_NewToMapService;

    // GET **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_NewToMap") // 모든 신규시설물 지도에 추가요청 정보 조회
    public List<Request_NewToMap> index(){
        return request_NewToMapService.findAll();
    }

    // GET - 단일 신규장소 지도에 추가요청 조회 **** 로그인되고 승인된 관리자만 조회가능하도록 해야함 ****
    @GetMapping("/api/request_NewToMap/{id}") // 특정 id의 신규시설물 지도에 추가요청 정보 조회
    public Request_NewToMap show(@PathVariable Long id){
        return request_NewToMapService.findById(id);
    }

    // POST
    @PostMapping("api/request_NewToMap") // 신규시설물 지도에 추가요청 접수 및 데이터베이스에 저장
    public Request_NewToMap create(@ModelAttribute Request_NewToMapForm dto){
        return request_NewToMapService.create(dto);
    }

    // DELETE
    @DeleteMapping("api/request_NewToMap/{id}")
    public ResponseEntity<Request_NewToMap> delete(@PathVariable Long id) {
        return request_NewToMapService.delete(id);
    }

}
