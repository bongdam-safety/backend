package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.service.FacilityCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class FacilityCategoryApiController {
    @Autowired
    private FacilityCategoryService facilityCategoryService;

    // GET
    @GetMapping("/api/facilityCategory") // 모든 시설물 분류 정보 조회
    public List<FacilityCategory> index() {
        return facilityCategoryService.findAll();
    }

    // GET - 단일 카테고리
    @GetMapping("/api/facilityCategory/{id}") // 특정 id의 시설물 분류 정보 조회
    public FacilityCategory show(@PathVariable Long id) {
        // pathvariable -> url의 id를 매개변수로 갖고오기
        return facilityCategoryService.findById(id);
    }
}
