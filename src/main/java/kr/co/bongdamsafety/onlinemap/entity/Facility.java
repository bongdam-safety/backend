package kr.co.bongdamsafety.onlinemap.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
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
    private String content; // 시설물 설명

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> imageUrls;
    public List<String> getImageUrls() {
        return imageUrls;
    }
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
