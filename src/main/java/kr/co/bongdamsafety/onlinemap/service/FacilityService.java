package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.dto.FacilityForm;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {
    @Autowired
    private FacilityRepository facilityRepository; // 시설물 리포지토리
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository; // 시설물유형 리포지토리
    @Autowired
    private AccountRepository accountRepository_new; // 이 시설물을 생성한 계정 정보가 저장되는 리포지토리
    @Autowired
    private AccountRepository accountRepository_edit; // 이 시설물을 수정한 계정 정보가 저장되는 리포지토리

    public List<Facility> findAll() {
        return facilityRepository.findAll(); // 모든 시설물 정보 물러오기
    }

    public Facility findById(Long id) {
        return facilityRepository.findById(id).orElse(null); // id를 받아 해당하는 시설물 정보 불러오기
    }

    public Facility create(FacilityForm dto) { // 신규 시설물 생성
        Facility facility = dto.toEntity(facilityCategoryRepository, accountRepository_new, accountRepository_edit);
        return facilityRepository.save(facility);
    }
}