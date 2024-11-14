package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.Request_ToCenter;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
public class Request_ToCenterForm {
    private Long id; // 요청 번호
    private String requester_name; // 요청자 이름
    private String requester_contact; // 요청자 연락처
    private double latitude; // 위도
    private double longitude; // 경도
    private String title; // 요청 제목
    private String content; // 요청 내용
    List<MultipartFile> images; // 사진
    private Timestamp date_requested; // 요청일자

    public Request_ToCenter toEntity() { // DTO(데이터 전송 객체)를 Entity(데이터베이스 객체)로 변환
        return new Request_ToCenter(id, requester_name, requester_contact, latitude, longitude, title, content, null, null);
        // Entity 객체 생성 후 요청 정보 반환
    }
}
