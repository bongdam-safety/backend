package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.Account;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
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
    private String address; // 주소
    private String content; // 설명
    List<MultipartFile> images; // 사진
    private String note_for_manager; // 관리자만 확인 가능한 메모
    private Timestamp date_requested_new; // 신규 요청일
    private Timestamp date_requested_edit; // 정보수정 요청일
    private Timestamp date_created; // 신규요청 승인일
    private Timestamp date_edited; // 수정요청 승인일
    private String account_id_agreed_new; // 신규요청 승인한 계정
    private String account_id_agreed_edit; // 수정요청 승인한 계정


    public Facility toEntity(FacilityCategoryRepository facilityCategoryRepository, AccountRepository accountRepository_new, AccountRepository accountRepository_edit) {
        // DTO(데이터 전송 객체)를 Entity(데이터베이스 객체)로 변환
        // 매개변수 : 시설물 분류 조회를 위한 리포지토리, 생성계정 조회를 위한 리포지토리, 수정계정 조회를 위한 리포지토리
        FacilityCategory facilityCategory = facilityCategoryRepository.findById(facilityCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 시설물 분류번호입니다: " + facilityCategoryId));
        // id를 통해 시설물 찾기. 만약 없을 경우 예외처리

        Account account_agreed_new = null;
        if (account_id_agreed_new != null) { // 신규장소추가요청 승인한 계정이 있을 경우
            account_agreed_new = accountRepository_new.findById(account_id_agreed_new)
                    .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 생성계정입니다: " + account_id_agreed_new));
            // id를 통해 계정 찾기. 만약 없을 경우 예외처리
        }

        Account account_agreed_edit = null;
        if (account_id_agreed_edit != null) { // 수정요청 승인한 계정이 있을 경우
            account_agreed_edit = accountRepository_edit.findById(account_id_agreed_edit)
                    .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 수정계정입니다: " + account_id_agreed_edit));
            // id를 통해 계정 찾기. 만약 없을 경우 예외처리
        }


        return new Facility(id, facilityCategory, latitude, longitude,
                 address, content, null, note_for_manager,
                null, null,
                account_agreed_new, account_agreed_edit);
        // Entity 객체 생성 후 시설물 정보 반환

    }



}
