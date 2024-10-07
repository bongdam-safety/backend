package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacilityCategoryForm {
    private Long id;
    private String categoryName;
    private boolean visible;
    private String note;
    private Timestamp date_created;
    private Timestamp date_edited;

    public FacilityCategory toEntity() {
        return new FacilityCategory(id, categoryName, visible, note, date_created, date_edited);
    }
}
