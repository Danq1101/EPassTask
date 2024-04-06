package com.example.task.web.controller;


import com.example.task.domain.Parties;
import com.example.task.domain.TradeItems;
import com.example.task.service.PartiesService;
import com.example.task.service.TradeItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ePass")
@RequiredArgsConstructor
public class MainController {

    @Autowired
    private final PartiesService partiesService;

    @Autowired
    private final TradeItemsService tradeItemsService;

    @GetMapping()
    public String home(Model model){
        List<Parties> parties = partiesService.getAll();
        model.addAttribute("parties", parties);
        List<TradeItems> tradeItems = tradeItemsService.getAll();
        model.addAttribute("tradeItems", tradeItems);
        return "index";
    }


}
