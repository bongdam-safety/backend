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
    private Long id;
    private String categoryName;
    private boolean visible;
    private String note;
    private Timestamp date_created;
    private Timestamp date_edited;

    public FacilityCategory toEntity() {
        return new FacilityCategory(id, categoryName, visible, note, null, null);
    }
}
