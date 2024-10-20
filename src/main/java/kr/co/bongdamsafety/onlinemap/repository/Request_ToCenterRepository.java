package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Request_ToCenter;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface Request_ToCenterRepository extends CrudRepository<Request_ToCenter, Long> { // 시설물 설치를 요청하는 레포지토리
    @Override
    ArrayList<Request_ToCenter> findAll(); // 오버라이딩 안하면 원래는 Iterable
}
