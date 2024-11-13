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
    @GetMapping("/api/facility") // 모든 시설물 정보 조회
    public List<Facility> index() {
        return facilityService.findAll();
    }

    // GET - 단일 시설물
    @GetMapping("/api/facility/{id}") // 특정 id의 시설물 정보 조회
    public Facility show(@PathVariable Long id) { // pathvariable -> url의 id를 매개변수로 갖고오기
        return facilityService.findById(id);
    }

    // GET - category별 시설물
    @GetMapping("/api/facility/category/{id}") // FacilityCategory id에 해당하는 시설물 정보 조회
    public List<Facility> showByCategory(@PathVariable Long id) { // pathvariable -> url의 id를 매개변수로 갖고오기
        return facilityService.findByCategory(id);
    }

    // POST **** 관리자만 추가 가능하도록 해야함 ****
    @PostMapping("api/facility") // 신규 시설물 지도에 생성
    public Facility create(@ModelAttribute FacilityForm dto) { // requestbody -> 요청시 본문(body)에 실어보내는 데이터를 create 메서드의 매개변수로 받아올수 있게함
        return facilityService.create(dto);
    }

    // POST - 신규 요청 들어운 시설물 승인 **** 관리자만 승인 가능하도록 해야함 ****
    @PostMapping("api/facility/from_newtomap/{NewToMapId}") // 신규 요청 들어온 시설물 지도에 추가
    public Facility create(@PathVariable Long NewToMapId) { // pathvariable -> url의 id를 매개변수로 갖고오기
        return facilityService.createByNewToMapId(NewToMapId);
    }
}
