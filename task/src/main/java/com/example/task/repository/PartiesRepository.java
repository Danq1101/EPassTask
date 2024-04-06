package com.example.task.repository;

import com.example.task.domain.Parties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PartiesRepository {
//    void save (Parties parties);
//
//    void update(Parties parties);
//
//    void delete(Parties parties);

    List<Parties> findAll();

    List<Parties> searchPartiesByModifiedTimes(String fromDate, String toDate, Integer startRecord, Integer recordCount);

    Parties getFullPartyByGLN(Long gln);

}
