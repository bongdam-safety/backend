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
    private String id; // 계정 아이디
    private String password; // 비밀번호 해시
    private String name; // 이름
    private int permlevel; // 권한레벨
    private String content; // 계정 설명
    private Timestamp date_created; // 계정 생성일
    private Timestamp date_edited; // 계정 정보 수정일
    private String account_id_created_this; // 이 계정을 생성한 계정



    public Account toEntity(AccountRepository accountRepository) { // DTO(데이터 전송 객체)를 Entity(데이터베이스 객체)로 변환
        // 매개변수 : 이 계정을 생성한 계정 조회를 위한 리포지토리

        Account account_created_this = accountRepository.findById(account_id_created_this)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 수정계정입니다: " + account_id_created_this));
        // id를 통해 계정 찾기. 만약 없을 경우 예외처리

        return new Account(id, password, name, permlevel, content, date_created, date_edited, account_created_this);
        // Entity 객체 생성 후 계정 정보 반환
    }
}
