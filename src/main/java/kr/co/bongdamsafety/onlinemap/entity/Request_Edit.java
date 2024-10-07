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
public class Request_Edit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_edit_seq_gen")
    @SequenceGenerator(name = "request_edit_seq_gen", sequenceName = "request_edit_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facilityId", referencedColumnName = "id")
    private Facility facility;

    @Column(length = 4000)
    private String content;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column(length = 4000)
    private String photolink1;
    @Column(length = 4000)
    private String photolink2;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp date_requested;

}
