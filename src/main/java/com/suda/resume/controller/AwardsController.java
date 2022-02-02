package com.suda.resume.controller;

import com.suda.resume.pojo.Awards;
import com.suda.resume.service.AwardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/awa")
public class AwardsController {

    @Autowired
    private AwardsService service;

    @RequestMapping("")
    public String index(){
        return "redirect:/awa/query";
    }

    @GetMapping("/query")
    public String query(Model model){
        List<Awards> awas = service.getAll();
        model.addAttribute("awas", awas);
        return "/awa/listAwa";
    }

    @PostMapping("/query")
    public String query(String name, Model model){
        List<Awards> awas = service.getByName(name);
        model.addAttribute("query", name);
        model.addAttribute("awas", awas);
        return "awa/listAwa";
    }

    @GetMapping("/add")
    public String add(){
        return "awa/addAwa";
    }

    @PostMapping("/add")
    public String add(Awards awards){
        service.add(awards);
        return "redirect:/awa";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Awards awa = service.getById(id);
        model.addAttribute("awa", awa);
        return "/awa/updateAwa";
    }

    @PostMapping("/update")
    public String update(Awards awards){
        service.update(awards);
        return "redirect:/awa";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/awa";
    }
}
