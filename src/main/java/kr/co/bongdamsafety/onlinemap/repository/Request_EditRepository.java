package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface Request_EditRepository extends CrudRepository<Request_Edit, Long> {
    @Override
    ArrayList<Request_Edit> findAll();
}
