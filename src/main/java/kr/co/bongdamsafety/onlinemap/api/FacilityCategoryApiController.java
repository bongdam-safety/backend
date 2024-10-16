package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.FacilityCategoryForm;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class FacilityCategoryApiController {
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository;

    // GET
    @GetMapping("/api/facilityCategory")
    public List<FacilityCategory> index() {
        return facilityCategoryRepository.findAll();
    }

    // GET - 단일 카테고리
    @GetMapping("/api/facilityCategory/{id}")
    public FacilityCategory show(@PathVariable Long id) { // pathvariable -> url의 id를 매개변수로 갖고오기
        return facilityCategoryRepository.findById(id).orElse(null);
    }

    // POST **** 관리자만 추가 가능하도록 해야함 ****
    @PostMapping("api/facilityCategory")
    public FacilityCategory create(@RequestBody FacilityCategoryForm dto) { // requestbody -> 요청시 본문(body)에 실어보내는 데이터를 create 메서드의 매개변수로 받아올수 있게함
        FacilityCategory facilityCategory = dto.toEntity();
        return facilityCategoryRepository.save(facilityCategory);
    }
}
