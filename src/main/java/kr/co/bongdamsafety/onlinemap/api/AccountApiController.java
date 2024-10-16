package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.AccountForm;
import kr.co.bongdamsafety.onlinemap.entity.Account;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AccountApiController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountRepository account_id_created_this;

    // **** 아래의 모든 것은 로그인되고 승인된 관리자만 수행 가능하도록 해야함 ****

    // GET
    @GetMapping("/api/account")
    public List<Account> index(){
        return accountRepository.findAll();
    }

    // GET - 단일 사용자 조회
    @GetMapping("/api/account/{id}")
    public Account show(@PathVariable String id){
        return accountRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("api/account")
    public Account create(@RequestBody AccountForm dto){
        Account account = dto.toEntity(account_id_created_this);
        return accountRepository.save(account);
    }
}
