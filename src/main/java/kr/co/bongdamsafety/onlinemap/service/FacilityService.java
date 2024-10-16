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
    private FacilityRepository facilityRepository;
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository;
    @Autowired
    private AccountRepository accountRepository_new;
    @Autowired
    private AccountRepository accountRepository_edit;

    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    public Facility findById(Long id) {
        return facilityRepository.findById(id).orElse(null);
    }

    public Facility create(FacilityForm dto) {
        Facility facility = dto.toEntity(facilityCategoryRepository, accountRepository_new, accountRepository_edit);
        return facilityRepository.save(facility);
    }
}