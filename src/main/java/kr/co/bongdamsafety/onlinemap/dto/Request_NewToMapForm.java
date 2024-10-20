package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.entity.Request_NewToMap;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
public class Request_NewToMapForm {
    private Long id; // 요청 번호
    private Long facilityCategoryId; // 시설물 분류 번호
    private String content; // 장소정보 내용
    private double latitude; // 위도
    private double longitude; // 경도
    private String photolink1; // 사진 링크1
    private String photolink2; // 사진 링크2
    private String note; // 메모
    private Timestamp date_requested; // 요청일자

    public Request_NewToMap toEntity(FacilityCategoryRepository facilityCategoryRepository) {
        // DTO(데이터 전송 객체)를 Entity(데이터베이스 객체)로 변환
        FacilityCategory facilityCategory = facilityCategoryRepository.findById(facilityCategoryId)
                .orElseThrow( () -> new IllegalArgumentException("유효하지 않은 분류 번호입니다. 입력된 분류 번호 : " + facilityCategoryId));
        // id를 통해 시설물 분류 찾기. 만약 없을 경우 예외처리

        return new Request_NewToMap(id, facilityCategory, content, latitude, longitude, photolink1, photolink2, note, date_requested);
        // Entity 객체 생성 후 요청 정보 반환
    }
}
