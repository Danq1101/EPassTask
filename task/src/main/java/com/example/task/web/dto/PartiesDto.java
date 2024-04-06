package com.example.task.web.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class PartiesDto {

    private Long GLN;

    private Date fromDate;

    private Date toDate;

    private Integer recordCount;

    private Integer startCount;
}
