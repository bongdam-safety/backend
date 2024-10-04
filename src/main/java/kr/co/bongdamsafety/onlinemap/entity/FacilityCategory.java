package kr.co.bongdamsafety.onlinemap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @Column(nullable = false)
    private String categoryName;
    @Column(nullable = false)
    private boolean visible;

    public void patch(FacilityCategory category) {
        this.categoryName = category.categoryName;
    }
}
