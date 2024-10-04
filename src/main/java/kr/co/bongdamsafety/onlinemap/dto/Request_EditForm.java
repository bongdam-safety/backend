package kr.co.bongdamsafety.onlinemap.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.co.bongdamsafety.onlinemap.entity.Account;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@ToString
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
