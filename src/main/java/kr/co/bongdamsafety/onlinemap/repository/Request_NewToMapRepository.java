package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface Request_NewToMapRepository extends CrudRepository<Request_NewToMap, Long> {
    @Override
    ArrayList<Request_NewToMap> findAll();
}
