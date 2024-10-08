package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
public class Request_EditForm {
    private Long id;
    private Long facilityId;
    private String content;
    private double latitude;
    private double longitude;
    private String photolink1;
    private String photolink2;
    private Timestamp date_requested;

    public Request_Edit toEntity(FacilityRepository facilityRepository) {
        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 시설물 번호입니다. 입력된 번호: " + facilityId));
        return new Request_Edit(id, facility, content, latitude, longitude, photolink1, photolink2, date_requested);
    }
}
