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
public class FacilityCategory {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facilitycategory_seq_gen") // 1부터 차례대로
    @SequenceGenerator(name = "facilitycategory_seq_gen", sequenceName = "facilitycategory_seq", allocationSize = 1) // 1씩 증가
    private Long id; // 시설물유형 번호
    @Column(nullable = false, length = 4000)
    private String categoryName; // 시설물 분류명(CCTV, 비상벨 등)
    @Column(nullable = false)
    private boolean visible; // 지도상에 이 카테고리의 시설물을 표시할지 여부
    @Column(length = 4000)
    private String note; // 관리자만 볼 수 있는 메모

    @Column(updatable = false)
    private Timestamp date_created; // 시설물유형 생성일
    @PrePersist // 저장하기 전에 실행
    public void onCreate() {
        this.date_created = new Timestamp(System.currentTimeMillis()); // 날짜 자동생성
    }

    @Column
    private Timestamp date_edited; // 시설물유형 정보수정일
    @PreUpdate // 저장하기 전에 실행
    public void onUpdate() {
        this.date_edited = new Timestamp(System.currentTimeMillis()); // 날짜 자동생성
    }


}
