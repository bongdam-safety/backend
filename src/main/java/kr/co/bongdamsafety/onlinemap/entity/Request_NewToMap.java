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
public class Request_NewToMap {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_newtomap_seq_gen")
    @SequenceGenerator(name = "request_newtomap_seq_gen", sequenceName = "request_newtomap_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facilityCategoryId", referencedColumnName = "id")
    private FacilityCategory facilityCategory;

    @Column
    private String content;
    @Column (nullable=false)
    private double latitude;
    @Column (nullable=false)
    private double longitude;
    @Column
    private String photolink1;
    @Column
    private String photolink2;
    @Column
    private String note;
    @Column
    private Timestamp date_requested;

}