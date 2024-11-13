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
public class Request_NewToMap {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_newtomap_seq_gen")
    @SequenceGenerator(name = "request_newtomap_seq_gen", sequenceName = "request_newtomap_seq", allocationSize = 1)
    private Long id; // 요청번호

    @ManyToOne
    @JoinColumn(name = "facilityCategoryId", referencedColumnName = "id")
    private FacilityCategory facilityCategory; // 시설물 분류(예: CCTV, 비상벨)

    @Column(length = 4000)
    private String content; // 요청내용
    @Column (nullable=false)
    private double latitude; // 위도
    @Column (nullable=false)
    private double longitude; // 경도
//    @Column(length = 4000)
//    private String photolink1;
//    @Column(length = 4000)
//    private String photolink2;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> imageUrls;
    public List<String> getImageUrls() {
        return imageUrls;
    }
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Column(length = 4000)
    private String note;

    @Column(updatable = false) // 변경 불가
    private Timestamp date_requested; // 요청일
    @PrePersist // 저장하기 전에 실행
    public void onCreate() {
        this.date_requested = new Timestamp(System.currentTimeMillis()); // 요청일 자동생성
    }

}
