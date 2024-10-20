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
public class Request_ToCenter {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_tocenter_seq_gen") // 1부터 차례대로
    @SequenceGenerator(name = "request_tocenter_seq_gen", sequenceName = "request_tocenter_seq", allocationSize = 1) // 1씩 증가
    private Long id; // 요청번호
    @Column(nullable = false, length = 4000)
    private String requester_name; // 요청자명
    @Column(length = 4000)
    private String requester_contact; // 요청자 연락처
    @Column
    private double latitude; // 위도
    @Column
    private double longitude; // 경도
    @Column(nullable = false, length = 4000)
    private String title; // 요청 제목
    @Column(nullable = false, length = 4000)
    private String content; // 요청 내용

    @Column(updatable = false)
    private Timestamp date_requested; // 요청일
    @PrePersist // 저장하기 전에 실행
    public void onCreate() {
        this.date_requested = new Timestamp(System.currentTimeMillis()); // 요청일 자동생성
    }

}
