package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AccountRepository extends CrudRepository<Account, String> {
    @Override
    ArrayList<Account> findAll();
}
