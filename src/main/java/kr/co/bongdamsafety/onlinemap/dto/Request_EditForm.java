package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.Request_Edit;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
public class Request_EditForm {
    private Long id; // 요청 번호
    private Long facilityId; // 시설물 번호
    private String content; // 요청 내용
    private double latitude; // 위도
    private double longitude; // 경도
//    private String photolink1; // 사진 링크1
//    private String photolink2; // 사진 링크2
    List<MultipartFile> images; // 사진
    private Timestamp date_requested; // 요청일자

    public Request_Edit toEntity(FacilityRepository facilityRepository) {
        // DTO(데이터 전송 객체)를 Entity(데이터베이스 객체)로 변환
        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 시설물 번호입니다. 입력된 번호: " + facilityId));
        // id를 통해 시설물 찾기. 만약 없을 경우 예외처리

        return new Request_Edit(id, facility, content, latitude, longitude, null, null);
        // Entity 객체 생성 후 요청 정보 반환
    }
}
