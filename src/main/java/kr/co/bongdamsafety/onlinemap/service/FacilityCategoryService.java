package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityCategoryService {
    private final FacilityCategoryRepository facilityCategoryRepository; // 시설물유형 리포지토리
    @Autowired
    public FacilityCategoryService(FacilityCategoryRepository facilityCategoryRepository) {
        this.facilityCategoryRepository = facilityCategoryRepository;
    }

    public List<FacilityCategory> findAll() { // 모든 분류 다 불러오기
        return facilityCategoryRepository.findAll();
    }

    public FacilityCategory findById(Long id) { // 시설물번호를 토대로 분류 정보 불러오기
        return facilityCategoryRepository.findById(id).orElse(null);
    }
}