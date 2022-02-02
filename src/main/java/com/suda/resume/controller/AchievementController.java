package com.suda.resume.controller;

import com.suda.resume.pojo.Achievement;
import com.suda.resume.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ach")
public class AchievementController {

    @Autowired
    AchievementService service;

    @RequestMapping("")
    public String index() {
        return "redirect:/ach/query";
    }

    @GetMapping("/query")
    public String query(Model model) {
        List<Achievement> achs = service.getAll();

        model.addAttribute("achs", achs);

        return "ach/listAch";
    }

    @PostMapping("/query")
    public String query(String name, Model model) {
        List<Achievement> achs = service.getByName(name);
        model.addAttribute("query", name);
        model.addAttribute("achs", achs);
        return "ach/listAch";
    }

    @GetMapping("add")
    public String add() {
        return "ach/addAch";
    }

    @PostMapping("add")
    public String add(Achievement achievement, Model model) {

        if (achievement.getCredit() >= 0 && achievement.getCredit() <= 5
                && achievement.getGrade() >= 0 && achievement.getGrade() <= 100) {
            if (service.add(achievement) > 0) {
                return "redirect:/ach";
            }
        }

        model.addAttribute("msg", "成绩数据有误，无法添加");
        model.addAttribute("ach", achievement);
        return "ach/addAch";

    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Achievement ach = service.getById(id);
        model.addAttribute("ach", ach);
        return "/ach/updateAch";
    }

    @PostMapping("/update")
    public String update(Achievement achievement, Model model) {

        if (achievement.getCredit() >= 0 && achievement.getCredit() <= 5
                && achievement.getGrade() >= 0 && achievement.getGrade() <= 100) {
            if (service.update(achievement) > 0) {
                return "redirect:/ach";
            }
        }
        model.addAttribute("msg", "成绩数据有误，无法修改");
        model.addAttribute("ach", achievement);
        return "/ach/updateAch";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/ach";
    }


}

