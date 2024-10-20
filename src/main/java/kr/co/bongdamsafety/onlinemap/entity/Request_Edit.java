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
public class Request_Edit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_edit_seq_gen") // 1부터 차례대로
    @SequenceGenerator(name = "request_edit_seq_gen", sequenceName = "request_edit_seq", allocationSize = 1) // 1씩 증가
    private Long id; // 요청번호

    @ManyToOne
    @JoinColumn(name = "facilityId", referencedColumnName = "id")
    private Facility facility; // 어떤 시설물에 대한 요청인지

    @Column(length = 4000)
    private String content; // 요청 내용
    @Column
    private double latitude; // 위도
    @Column
    private double longitude; // 경도
    @Column(length = 4000)
    private String photolink1; // 사진 링크1
    @Column(length = 4000)
    private String photolink2; // 사진 링크2

    @Column(updatable = false)
    private Timestamp date_requested; // 요청일
    @PrePersist
    public void onCreate() {
        this.date_requested = new Timestamp(System.currentTimeMillis()); // 요청일 자동생성
    }

}
