package com.example.task.service;

import com.example.task.domain.TradeItems;

import java.util.Date;
import java.util.List;

public interface TradeItemsService {

    List<TradeItems> getAll();

    List<TradeItems> searchSimpleTradeItemsByModifiedTime3(String fromDate, String toDate, Integer recordCount, Integer startCount);

}
