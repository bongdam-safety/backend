package kr.co.bongdamsafety.onlinemap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Request_ToCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_tocenter_seq_gen")
    @SequenceGenerator(name = "request_tocenter_seq_gen", sequenceName = "request_tocenter_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String requester_name;
    @Column
    private String requester_contact;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column
    private Timestamp date_requested;

}
