package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.Request_ToCenter;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter // Getter, Setter 잊지 말자...
@Setter
public class Request_ToCenterForm {
    private Long id;
    private String requester_name;
    private String requester_contact;
    private double latitude;
    private double longitude;
    private String title;
    private String content;
    private Timestamp date_requested;

    public Request_ToCenter toEntity() {
        return new Request_ToCenter(id, requester_name, requester_contact, latitude, longitude, title, content, date_requested);
    }
}
