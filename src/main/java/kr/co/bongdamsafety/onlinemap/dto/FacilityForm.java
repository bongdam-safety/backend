package kr.co.bongdamsafety.onlinemap.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
@Data
public class FacilityForm {
    private Long id; // 시설물 번호
    private Long facilityCategoryId; // 외래 키
    private double latitude; // 위도
    private double longitude; // 경도
    private String content; // 설명
    List<MultipartFile> images; // 사진
}
