package kr.co.bongdamsafety.onlinemap.dto;

import jakarta.persistence.Column;
import kr.co.bongdamsafety.onlinemap.entity.Account;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@ToString
public class AccountForm {
    private String id;
    private String password;
    private String name;
    private Timestamp date_created;

    public Account toEntity(){
        return new Account(id, password, name, date_created);
    }
}
