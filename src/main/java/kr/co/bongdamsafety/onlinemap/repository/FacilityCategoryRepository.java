package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FacilityCategoryRepository extends CrudRepository<FacilityCategory, Long> {
    @Override
    ArrayList<FacilityCategory> findAll();
}
