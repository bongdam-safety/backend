package kr.co.bongdamsafety.onlinemap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Account { // 계정
    @Id // 기본키
    private String id; // 아이디
    @Column(nullable = false, columnDefinition = "char(128)")
    private String password; // 비밀번호 해시
    @Column(nullable = false, length = 4000)
    private String name; // 관리자면
    @Column(nullable = false)
    private int permlevel;
    /*
    * 0 : 권한 없음(사퇴 등의 사유로 더이상 시설물 관리를 하면 안 되는 관리자)
    * 1 : 시설물 관리자(시설물 추가, 수정, 삭제, 추가요청 승인, 수정 및 삭제요청 승인 가능)
    * 2 : 시설물 및 계정 관리자(시설물 관리자의 권한 + 계정 추가, 수정, 삭제 가능, 단 최고관리자 계정은 수정 및 삭제 불가)
    * 3 : 최고 관리자
    * */

    @Column(length = 4000)
    private String content; // 계정 설명 혹은 자기소개

    @Column(updatable = false)
    private Timestamp date_created; // 계정 생성일자
    @PrePersist
    public void onCreate() {
        this.date_created = new Timestamp(System.currentTimeMillis());
    }

    @Column
    private Timestamp date_edited; // 계정정보 수정일자
    @PreUpdate
    public void onUpdate() {
        this.date_edited = new Timestamp(System.currentTimeMillis());
    }

    @ManyToOne
    @JoinColumn(name = "account_id_created_this", referencedColumnName = "id")
    private Account account_created_this; // 이 계정을 생성한 관리자
}
