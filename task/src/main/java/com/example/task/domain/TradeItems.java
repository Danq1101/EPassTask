package com.example.task.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "tradeitems", schema = "testtask")
public class TradeItems {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="tradeitems_id_seq")
    @SequenceGenerator(name = "tradeitems_id_seq",sequenceName = "tradeitems_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "gtin")
    private Long gtin;

    @Column(name = "name")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "synchronized_date")
    private String fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "flag_date")
    private String toDate;

    @Column(name = "start_count")
    private Integer startCount;

    @Column(name = "record_count")
    private Integer recordCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parties_gln", referencedColumnName = "gln")
    private Parties parties;

}
