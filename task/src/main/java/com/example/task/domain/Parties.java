package com.example.task.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "parties", schema = "testtask")
public class Parties {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="parties_id_seq")
    @SequenceGenerator(name = "parties_id_seq",sequenceName = "parties_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "parties_name")
    private String name;

    @Column(name = "gln")
    private Long gln;

    @Column(name = "trade_item")
    private String tradeItem;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @Column(name = "from_date")
    private String fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @Column(name = "to_date")
    private String toDate;

    @Column(name = "start_count")
    private Integer startCount;

    @Column(name = "record_count")
    private Integer recordCount;

//    @Column(name = "total_record_count")
//    private Integer totalRecordCount;


    @JsonIgnore
    @OneToMany(mappedBy = "parties", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeItems> tradeItems = new ArrayList<>();

//    public void addTradeItems(TradeItems tradeItem){
//        this.tradeItems.add(tradeItem);
//    }

}
