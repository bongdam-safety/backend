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
    private String note; // 시설물 분류에 대한 설명
    private Timestamp date_created; // 시설물 분류 생성일
    private Timestamp date_edited; // 시설물 분류 정보 수정일

    public FacilityCategory toEntity() { // DTO(데이터 전송 객체)를 Entity(데이터베이스 객체)로 변환
        return new FacilityCategory(id, categoryName, visible, note, null, null);
        // Entity 객체 생성 후 시설물 분류 정보 반환
    }
}
