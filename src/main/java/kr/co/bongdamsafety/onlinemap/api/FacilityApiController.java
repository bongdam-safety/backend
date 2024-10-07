package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.FacilityForm;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class FacilityApiController {
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository;
    @Autowired
    private AccountRepository accountRepository_new;
    @Autowired
    private AccountRepository accountRepository_edit;

    // GET
    @GetMapping("/api/facility")
    public List<Facility> index() {
        return facilityRepository.findAll();
    }

    // GET - 단일 시설물
    @GetMapping("/api/facility/{id}")
    public Facility show(@PathVariable Long id) { // pathvariable -> url의 id를 매개변수로 갖고오기
        return facilityRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("api/facility")
    public Facility create(@RequestBody FacilityForm dto) { // requestbody -> 요청시 본문(body)에 실어보내는 데이터를 create 메서드의 매개변수로 받아올수 있게함
        Facility facility = dto.toEntity(facilityCategoryRepository, accountRepository_new, accountRepository_edit);
        return facilityRepository.save(facility);
    }
}
