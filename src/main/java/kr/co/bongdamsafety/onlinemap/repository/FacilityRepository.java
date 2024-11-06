package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FacilityRepository extends CrudRepository<Facility, Long> { // 시설물 레포지토리
    @Override
    ArrayList<Facility> findAll(); // 오버라이딩 안하면 원래는 Iterable
    ArrayList<Facility> findByFacilityCategory(FacilityCategory facilityCategory);

}
