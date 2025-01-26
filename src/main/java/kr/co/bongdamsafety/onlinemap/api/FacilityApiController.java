package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.service.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
