package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.Account;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
public class FacilityForm {
    private Long id;
    private Long facilityCategoryId; // 외래 키
    private double latitude;
    private double longitude;
    private String address;
    private String content;
    private String photolink1;
    private String photolink2;
    private String note_for_manager;
    private Timestamp date_requested_new;
    private Timestamp date_created;
    private Timestamp date_requested_edit;
    private Timestamp date_edited;
    private String account_id_agreed_new;
    private String account_id_agreed_edit;


    public Facility toEntity(FacilityCategoryRepository facilityCategoryRepository, AccountRepository accountRepository_new, AccountRepository accountRepository_edit) {

        FacilityCategory facilityCategory = facilityCategoryRepository.findById(facilityCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 시설물 분류번호입니다: " + facilityCategoryId));

        Account account_agreed_new = accountRepository_new.findById(account_id_agreed_new)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 생성계정입니다: " + account_id_agreed_new));

        Account account_agreed_edit = accountRepository_edit.findById(account_id_agreed_edit)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 수정계정입니다: " + account_id_agreed_new));


        return new Facility(id, facilityCategory, latitude, longitude,
                 address, content, photolink1, photolink2, note_for_manager,
                date_requested_new, date_created, date_requested_new, date_edited,
                account_agreed_new, account_agreed_edit);

    }



}
