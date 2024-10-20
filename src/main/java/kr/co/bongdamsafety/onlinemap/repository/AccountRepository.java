package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AccountRepository extends CrudRepository<Account, String> { // 계정 레포지토리
    @Override
    ArrayList<Account> findAll(); // 오버라이딩 안하면 원래는 Iterable
}
