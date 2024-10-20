package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface Request_NewToMapRepository extends CrudRepository<Request_NewToMap, Long> { // 신규 시설물 지도에 추가요청 레포지토리
    @Override
    ArrayList<Request_NewToMap> findAll(); // 오버라이딩 안하면 원래는 Iterable
}
