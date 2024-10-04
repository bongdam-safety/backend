package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Request_ToCenter;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface Request_ToCenterRepository extends CrudRepository<Request_ToCenter, Long> {
    @Override
    ArrayList<Request_ToCenter> findAll();
}
