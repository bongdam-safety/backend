package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.FacilityForm;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.service.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class FacilityApiController {
    @Autowired
    private FacilityService facilityService;

    // GET
    @GetMapping("/api/facility")
    public List<Facility> index() {
        return facilityService.findAll();
    }

    // GET - 단일 시설물
    @GetMapping("/api/facility/{id}")
    public Facility show(@PathVariable Long id) { // pathvariable -> url의 id를 매개변수로 갖고오기
        return facilityService.findById(id);
    }

    // POST **** 관리자만 추가 가능하도록 해야함 ****
    @PostMapping("api/facility")
    public Facility create(@RequestBody FacilityForm dto) { // requestbody -> 요청시 본문(body)에 실어보내는 데이터를 create 메서드의 매개변수로 받아올수 있게함
        return facilityService.create(dto);
    }
}
