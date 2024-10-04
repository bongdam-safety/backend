package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Facility;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FacilityRepository extends CrudRepository<Facility, Long> {
    @Override
    ArrayList<Facility> findAll(); // 오버라이딩 안하면 원래는 Iterable
}
