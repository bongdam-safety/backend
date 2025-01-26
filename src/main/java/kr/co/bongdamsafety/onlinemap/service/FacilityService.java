package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityService {
    @Autowired
    private FacilityRepository facilityRepository; // 시설물 리포지토리
    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository; // 시설물유형 리포지토리

    public List<Facility> findAll() {
        return facilityRepository.findAll(); // 모든 시설물 정보 물러오기
    }

    public Facility findById(Long id) {
        return facilityRepository.findById(id).orElse(null); // id를 받아 해당하는 시설물 정보 불러오기
    }

    public List<Facility> findByCategory(Long id) { // 카테고리 아이디로 해당 카테고리에 해당하는 시설물 정보 불러오기
        FacilityCategory facilityCategory = facilityCategoryRepository.findById(id).orElse(null);
        if (facilityCategory != null) {
            return facilityRepository.findByFacilityCategory(facilityCategory); // 카테고리에 해당하는 시설물 목록 반환
        }
        return new ArrayList<>(); // 없는 카테고리일 경우 빈 리스트 리턴
    }
}