package kr.co.bongdamsafety.onlinemap.dto;

import jakarta.persistence.Column;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class FacilityCategoryForm {
    private Long id;
    private String categoryName;
    private boolean visible;

    public FacilityCategory toEntity() {
        return new FacilityCategory(id, categoryName, visible);
    }
}
