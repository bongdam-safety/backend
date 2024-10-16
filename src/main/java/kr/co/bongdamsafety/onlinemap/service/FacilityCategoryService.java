package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.dto.FacilityCategoryForm;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityCategoryService {
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository;

    public List<FacilityCategory> findAll() {
        return facilityCategoryRepository.findAll();
    }

    public FacilityCategory findById(Long id) {
        return facilityCategoryRepository.findById(id).orElse(null);
    }

    public FacilityCategory create(FacilityCategoryForm dto) {
        FacilityCategory facilityCategory = dto.toEntity();
        return facilityCategoryRepository.save(facilityCategory);
    }
}