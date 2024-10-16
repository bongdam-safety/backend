package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.AccountForm;
import kr.co.bongdamsafety.onlinemap.entity.Account;
import kr.co.bongdamsafety.onlinemap.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class AccountApiController {
    @Autowired
    private AccountService accountService;

    // **** 아래의 모든 것은 로그인되고 승인된 관리자만 수행 가능하도록 해야함 ****

    // GET
    @GetMapping("/api/account")
    public List<Account> index(){
        return accountService.findAll();
    }

    // GET - 단일 사용자 조회
    @GetMapping("/api/account/{id}")
    public Account show(@PathVariable String id){
        return accountService.findById(id);
    }

    // POST
    @PostMapping("api/account")
    public Account create(@RequestBody AccountForm dto){
        return accountService.create(dto);
    }
}
