package kr.co.bongdamsafety.onlinemap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Facility {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facility_seq_gen") // 1부터 차례대로
    @SequenceGenerator(name = "facility_seq_gen", sequenceName = "facility_seq", allocationSize = 1) // 1씩 증가
    private Long id; // 시설물번호

    @ManyToOne
    @JoinColumn(name = "facilityCategoryId", referencedColumnName = "id")
    private FacilityCategory facilityCategory; // 시설물 분류(예: CCTV, 비상벨)

    @Column(nullable = false)
    private double latitude; // 위도
    @Column(nullable = false)
    private double longitude; // 경도
    @Column(length = 4000)
    private String address; // 주소
    @Column(length = 4000)
    private String content; // 시설물 설명

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> imageUrls;
    public List<String> getImageUrls() {
        return imageUrls;
    }
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Column(length = 4000)
    private String note_for_manager; // 관리자만 볼 수 있는 메모

    @Column(updatable = false)
    private Timestamp date_created; // 시설물 생성일
    @PrePersist
    public void onCreate() {
        this.date_created = new Timestamp(System.currentTimeMillis());
    }

    @Column
    private Timestamp date_edited; // 시설물 정보수정일
    @PreUpdate
    public void onUpdate() {
        this.date_edited = new Timestamp(System.currentTimeMillis());
    }

    @ManyToOne
    @JoinColumn(name = "account_id_agreed_new", referencedColumnName = "id")
    private Account account_agreed_new; // 시설물 추가요청 승인한 관리자
    @ManyToOne
    @JoinColumn(name = "account_id_agreed_edit", referencedColumnName = "id")
    private Account account_agreed_edit; // 시설물 장보수정요청 승인한 관리자


}
