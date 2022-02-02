package com.suda.resume.controller;

import com.suda.resume.pojo.User;
import com.suda.resume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping
    public String index(){
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/user/info";
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpSession session) {

        User user = userService.getUserByName(username);
        if (user == null) {
            model.addAttribute("msg", "用户不存在！");
            return "/login";
        }
        System.out.println(password);
        System.out.println(user.getPassword());
        if (!user.getPassword().equals(password)) {
            model.addAttribute("msg", "密码错误！");
            return "/login";
        }

        session.setAttribute("user", user);

        return "redirect:/user/info";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/user";
    }

    @GetMapping("/info")
    public String info() {
        return "/info";
    }

    @GetMapping("/update")
    public String update() {
        return "/updatePwd";
    }

    @PostMapping("/update")
    public String update(@RequestParam("username") String username,
                         @RequestParam("prePwd") String prePwd,
                         @RequestParam("newPwd") String newPwd,
                         @RequestParam("repPwd") String repPwd,
                         Model model) {
        System.out.println(prePwd);
        System.out.println(newPwd);
        System.out.println(repPwd);

        User user = userService.getUserByName(username);
        if (!user.getPassword().equals(prePwd)) {
            model.addAttribute("msg", "原始密码输入错误！");
            return "/updatePwd";
        }

        if (user.getPassword().equals(newPwd)) {
            model.addAttribute("msg", "新密码不能与旧密码相同！");
            return "/updatePwd";
        }

        if (!newPwd.equals(repPwd)) {
            model.addAttribute("msg", "新密码与重复密码不相同！");
            return "/updatePwd";
        }

        if (userService.updatePassword(user, newPwd) == 0) {
            model.addAttribute("msg", "发生未知错误，密码更新失败，请联系网站管理员！");
            return "/updatePwd";
        }

        return "redirect:/user/logout";
    }
}
