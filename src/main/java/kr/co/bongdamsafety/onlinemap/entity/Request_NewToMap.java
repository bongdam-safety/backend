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
public class Request_NewToMap {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_newtomap_seq_gen")
    @SequenceGenerator(name = "request_newtomap_seq_gen", sequenceName = "request_newtomap_seq", allocationSize = 1)
    private Long id; // 요청번호

    @ManyToOne
    @JoinColumn(name = "facilityCategoryId", referencedColumnName = "id")
    private FacilityCategory facilityCategory;

    @Column(length = 4000)
    private String content;
    @Column (nullable=false)
    private double latitude;
    @Column (nullable=false)
    private double longitude;
    @Column(length = 4000)
    private String photolink1;
    @Column(length = 4000)
    private String photolink2;
    @Column(length = 4000)
    private String note;

    @Column(updatable = false) // 변경 불가
    private Timestamp date_requested; // 요청일
    @PrePersist // 저장하기 전에 실행
    public void onCreate() {
        this.date_requested = new Timestamp(System.currentTimeMillis()); // 요청일 자동생성
    }

}
