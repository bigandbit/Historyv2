package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.HistoryService;

@Controller
public class HistoryController {
	@Autowired HistoryService historyService;
	

    @RequestMapping(value = "/history")
    public String showHistory(Model model) {
        model.addAttribute("histories", historyService.findAll());
        return "History";
    }
}
