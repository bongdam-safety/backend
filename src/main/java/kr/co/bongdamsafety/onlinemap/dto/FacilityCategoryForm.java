package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
public class FacilityCategoryForm {
    private Long id; // 시설물 분류 번호
    private String categoryName; // 시설물 분류 이름
    private boolean visible; // 지도에 보이는지 여부
}
