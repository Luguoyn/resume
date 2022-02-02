package com.suda.resume.controller;

import com.suda.resume.pojo.Music;
import com.suda.resume.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mus")
public class MusicController {

    @Autowired
    MusicService service;

    @RequestMapping("")
    public String index() {
        return "redirect:/mus/query";
    }

    @GetMapping("/query")
    public String query(Model model) {
        List<Music> muss = service.getAll();
        model.addAttribute("muss", muss);
        return "/mus/listMus";
    }

    @PostMapping("/query")
    public String query(String name, Model model) {
        List<Music> muss = service.getByNameOrSinger(name);
        model.addAttribute("query", name);
        model.addAttribute("muss", muss);
        return "/mus/listMus";
    }

    @GetMapping("/add")
    public String add(){
        return "/mus/addMus";
    }

    @PostMapping("/add")
    public String add(Music music){
        service.add(music);
        return "redirect:/mus";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model){
        Music mus = service.getById(id);
        model.addAttribute("mus", mus);
        return "/mus/updateMus";
    }

    @PostMapping("/update")
    public String update(Music music){
        service.update(music);
        return "redirect:/mus";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/mus";
    }
}
