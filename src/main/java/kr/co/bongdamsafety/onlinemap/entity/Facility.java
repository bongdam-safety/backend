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
    @Column(length = 4000)
    private String address;
    @Column(length = 4000)
    private String content;
    @Column(length = 4000)
    private String photolink1;
    @Column(length = 4000)
    private String photolink2;
    @Column(length = 4000)
    private String note_for_manager;

    @Column
    private Timestamp date_requested_new;
    @Column
    private Timestamp date_requested_edit;

    @Column(updatable = false)
    private Timestamp date_created;
    @PrePersist
    public void onCreate() {
        this.date_created = new Timestamp(System.currentTimeMillis());
    }

    @Column
    private Timestamp date_edited;
    @PreUpdate
    public void onUpdate() {
        this.date_edited = new Timestamp(System.currentTimeMillis());
    }

    @ManyToOne
    @JoinColumn(name = "account_id_agreed_new", referencedColumnName = "id")
    private Account account_agreed_new;
    @ManyToOne
    @JoinColumn(name = "account_id_agreed_edit", referencedColumnName = "id")
    private Account account_agreed_edit;
}
