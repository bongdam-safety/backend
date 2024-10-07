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
public class FacilityCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facilitycategory_seq_gen")
    @SequenceGenerator(name = "facilitycategory_seq_gen", sequenceName = "facilitycategory_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false, length = 4000)
    private String categoryName;
    @Column(nullable = false)
    private boolean visible;
    @Column(length = 4000)
    private String note;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp date_created;
    @Column
    private Timestamp date_edited;

    public void patch(FacilityCategory category) {
        this.categoryName = category.categoryName;
    }
}
