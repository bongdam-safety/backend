package kr.co.bongdamsafety.onlinemap.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@ToString
public class Request_NewToMapForm {
    private Long id;
    private Long facilityCategoryId;
    private String content;
    private double latitude;
    private double longitude;
    private String photolink1;
    private String photolink2;
    private String note;
    private Timestamp date_requested;

    public Request_NewToMap toEntity(FacilityCategoryRepository facilityCategoryRepository) {
        FacilityCategory facilityCategory = facilityCategoryRepository.findById(facilityCategoryId)
                .orElseThrow( () -> new IllegalArgumentException("유효하지 않은 분류 번호입니다. 입력된 분류 번호 : " + facilityCategoryId));
        return new Request_NewToMap(id, facilityCategory, content, latitude, longitude, photolink1, photolink2, note, date_requested);
    }
}
