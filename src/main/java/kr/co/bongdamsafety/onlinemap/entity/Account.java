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
public class Account {
    @Id
    private String id;
    @Column(nullable = false, columnDefinition = "char(128)")
    private String password;
    @Column(nullable = false, length = 4000)
    private String name;
    @Column(nullable = false)
    private int permlevel;
    @Column(length = 4000)
    private String content;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp date_created;
    @Column
    private Timestamp date_edited;

    @ManyToOne
    @JoinColumn(name = "account_id_created_this", referencedColumnName = "id")
    private Account account_created_this;
}
