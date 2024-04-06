package com.example.task.repository;

import com.example.task.domain.Parties;
import com.example.task.domain.TradeItems;

import java.util.Date;
import java.util.List;

public interface TradeItemsRepository {

    List<TradeItems> searchSimpleTradeItemsByModifiedTime3(String fromDate, String toDate, Integer recordCount, Integer startCount);

    List<TradeItems> findAll();

}
