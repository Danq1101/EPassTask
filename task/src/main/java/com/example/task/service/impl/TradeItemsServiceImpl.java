package com.example.task.service.impl;


import com.example.task.domain.TradeItems;
import com.example.task.repository.TradeItemsRepository;
import com.example.task.service.TradeItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TradeItemsServiceImpl implements TradeItemsService {

    private final TradeItemsRepository tradeItemsRepository;

    @Override
    public List<TradeItems> getAll(){
        return tradeItemsRepository.findAll();
    }

    @Override
    public List<TradeItems> searchSimpleTradeItemsByModifiedTime3(String fromDate, String toDate, Integer recordCount, Integer startCount) {
        return tradeItemsRepository.searchSimpleTradeItemsByModifiedTime3(fromDate, toDate, startCount, recordCount);
    }
}
