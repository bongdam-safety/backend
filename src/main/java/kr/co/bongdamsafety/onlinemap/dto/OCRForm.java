package kr.co.bongdamsafety.onlinemap.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OCRForm {
    private String trackingnumber;
    private String phonenumber;
    private String name;

    public OCRForm(String trackingnumber, String phonenumber, String name) {
        this.trackingnumber = trackingnumber;
        this.phonenumber = phonenumber;
        this.name = name;
    }
}
