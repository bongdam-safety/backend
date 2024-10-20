package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface Request_EditRepository extends CrudRepository<Request_Edit, Long> { // 지도의 정보 수정요청 레포지토리
    @Override
    ArrayList<Request_Edit> findAll(); // 오버라이딩 안하면 원래는 Iterable
}
