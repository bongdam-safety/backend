package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FacilityCategoryRepository extends CrudRepository<FacilityCategory, Long> { // 시설물유형 레포지토리
    @Override
    ArrayList<FacilityCategory> findAll(); // 오버라이딩 안하면 원래는 Iterable
}
