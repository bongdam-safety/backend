package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.Account;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
public class AccountForm {
    private String id;
    private String password;
    private String name;
    private int permlevel;
    private String content;
    private Timestamp date_created;
    private Timestamp date_edited;
    private String account_id_created_this;



    public Account toEntity(AccountRepository accountRepository) {

        Account account_created_this = accountRepository.findById(account_id_created_this)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 수정계정입니다: " + account_id_created_this));

        return new Account(id, password, name, permlevel, content, date_created, date_edited, account_created_this);
    }
}
