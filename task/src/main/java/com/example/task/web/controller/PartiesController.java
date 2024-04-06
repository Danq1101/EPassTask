package com.example.task.web.controller;

import com.example.task.domain.Parties;
import com.example.task.service.PartiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
//@RequestMapping("/ePass/searchparties")
@RequiredArgsConstructor
public class PartiesController {

    @Autowired
    private final PartiesService partiesService;

    @RequestMapping("/ePass/searchparties")
    public String getGln(
            @RequestParam(value="gln") Long gln,
            @RequestParam(value = "fromDate") String fromDate,
            @RequestParam(value = "toDate") String toDate){
        return "searchparties";
    }


    @GetMapping("/ePass/searchparties/gln")
    public String getFullPartyByGLN(Long gln, Model model){
        Parties parties = partiesService.getFullPartyByGLN(gln);
        model.addAttribute("partiesByGln", parties);
        model.addAttribute("totalRecordCount");
        return "searchparties";
    }

    @GetMapping("/ePass/searchparties/total")
    public String SearchPartiesByModifiedTime
            (String fromDate, String toDate, Integer startRecord, Integer recordCount, Model model){
        List<Parties> parties = partiesService.searchPartiesByModifiedTimes(fromDate, toDate, startRecord, recordCount);
        model.addAttribute("partiesByDate", parties);
        int count = 0;
        for (Parties p: parties) {
            count++;
        }
        model.addAttribute("totalParties", count);
        return "searchparties";
    }

    @GetMapping("/ePass/searchparties")
    public String home(){
        return "searchparties";
    }


}
