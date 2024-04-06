package com.example.task.web.controller;

import com.example.task.domain.Parties;
import com.example.task.domain.TradeItems;
import com.example.task.service.TradeItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class TradeItemController {

    private final TradeItemsService tradeItemsService;
    
    @GetMapping("/ePass/searchparties/tradeitems/total")
    public String searchSimpleTradeItemsByModifiedTime3(String fromDate, String toDate, Integer recordCount, Integer startRecord, Model model){

        List<TradeItems> tradeItems = tradeItemsService.searchSimpleTradeItemsByModifiedTime3(fromDate, toDate, recordCount, startRecord);
        model.addAttribute("tradeItemsByDate", tradeItems);
        int count = 0;
        for (TradeItems t: tradeItems) {
            count++;
        }
        model.addAttribute("totalTradeItems", count);
        return "searchparties";
    }


}
