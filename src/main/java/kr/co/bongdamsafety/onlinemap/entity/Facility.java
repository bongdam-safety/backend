package kr.co.bongdamsafety.onlinemap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facility_seq_gen")
    @SequenceGenerator(name = "facility_seq_gen", sequenceName = "facility_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facilityCategoryId", referencedColumnName = "id")
    private FacilityCategory facilityCategory;

    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;
    @Column
    private String address;
    @Column
    private String content;
    @Column
    private String photolink1;
    @Column
    private String photolink2;
    @Column
    private Timestamp date_created;
    @Column
    private Timestamp date_edited;

    @ManyToOne
    @JoinColumn(name = "account_id_agreed_new", referencedColumnName = "id")
    private Account account_agreed_new;
    @ManyToOne
    @JoinColumn(name = "account_id_agreed_edit", referencedColumnName = "id")
    private Account account_agreed_edit;
}
