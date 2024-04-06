package com.example.task.service;

import com.example.task.domain.Parties;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PartiesService {

//    void saveParties(Parties parties);
//
//    void updateParties(Parties parties);
//
//    void deleteParties(Parties parties);

    List<Parties> getAll();

//    Map<Long, Integer> searchPartiesByModifiedTimes(Date fromDate, Date toDate, Integer recordCount, Integer startRecord);

    List<Parties> searchPartiesByModifiedTimes(String fromDate, String toDate, Integer startRecord, Integer recordCount);

    Parties getFullPartyByGLN(Long gln);

}
