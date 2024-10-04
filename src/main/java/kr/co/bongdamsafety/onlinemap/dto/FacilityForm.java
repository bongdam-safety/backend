package kr.co.bongdamsafety.onlinemap.dto;

import jakarta.persistence.Column;
import kr.co.bongdamsafety.onlinemap.entity.Account;
import kr.co.bongdamsafety.onlinemap.entity.Facility;
import kr.co.bongdamsafety.onlinemap.entity.FacilityCategory;
import kr.co.bongdamsafety.onlinemap.repository.AccountRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityCategoryRepository;
import kr.co.bongdamsafety.onlinemap.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@AllArgsConstructor
@ToString
public class FacilityForm {
    private Long id;
    private Long facilityCategoryId; // 외래 키
    private double latitude;
    private double longitude;
    private String address;
    private String content;
    private String photolink1;
    private String photolink2;
    private Timestamp date_created;
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


        return new Facility(id, facilityCategory,
                latitude, longitude, address, content,
                photolink1, photolink2, date_created, date_edited,
                account_agreed_new, account_agreed_edit);

    }



}
