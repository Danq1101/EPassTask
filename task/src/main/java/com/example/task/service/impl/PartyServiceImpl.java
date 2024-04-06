package com.example.task.service.impl;

import com.example.task.domain.exception.Exception;
import com.example.task.repository.PartiesRepository;
import com.example.task.domain.Parties;
import com.example.task.service.PartiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.task.domain.exception.Exceptions.INVALID_GLN;
import static com.example.task.domain.exception.Exceptions.NO_RESULT;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartiesService {

    private final PartiesRepository partiesRepository;

    private Exception exception;

//    public void saveParties(Parties parties){
//        partiesRepository.save(parties);
//    }
//
//    public void updateParties(Parties parties){
//        partiesRepository.update(parties);
//    }
//
//    public void deleteParties(Parties parties){
//        partiesRepository.delete(parties);
//    }

    @Override
    @Transactional
    public List<Parties> getAll(){
        return partiesRepository.findAll();
    }

    @Override
    @Transactional
    public Parties getFullPartyByGLN(Long gln) {
//        if (String.valueOf(gln).length() != 13) throw new Exception(exception.status(INVALID_GLN));
        return partiesRepository.getFullPartyByGLN(gln);
    }

    @Override
    public List<Parties> searchPartiesByModifiedTimes
            (String fromDate, String toDate, Integer startRecord, Integer recordCount) {
        List<Parties> partiesList = partiesRepository.searchPartiesByModifiedTimes(fromDate, toDate, startRecord, recordCount);
//        if (partiesList == null) throw new Exception(exception.status(NO_RESULT));
//        Map<Long, Integer> map = new HashMap<>();
//        for (Parties parties: partiesList) {
//            map.put(parties.getGln(), (parties.getRecordCount() - parties.getStartCount()));
//        }
        return partiesList;
    }

}
