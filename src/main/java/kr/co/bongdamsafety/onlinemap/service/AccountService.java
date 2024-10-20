package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.dto.AccountForm;
import kr.co.bongdamsafety.onlinemap.entity.Account;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository; // 계정 리포지토리
    @Autowired
    private AccountRepository account_id_created_this; // 이 계정을 생성한 계정 정보가 저장되는 리포지토리

    public List<Account> findAll() { // 계정 전체 조회
        return accountRepository.findAll();
    }

    public Account findById(String id) { // id를 받아 해당하는 계정 조회
        return accountRepository.findById(id).orElse(null);
    }

    public Account create(AccountForm dto) { // 계정 생성
        Account account = dto.toEntity(account_id_created_this);
        return accountRepository.save(account);
    }
}