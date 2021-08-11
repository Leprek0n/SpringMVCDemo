package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("users", userService.getCustomerList());
        return "index";
    }
    @GetMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("user", new com.luv2code.springdemo.entity.User());
        return "create";
    }
    @PostMapping()
    public String saveCustomer(@ModelAttribute("user") com.luv2code.springdemo.entity.User user) {
        userService.save(user);
        return "redirect:/user/list";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showById(id));
        return "show";
    }
    @GetMapping("/{id}/edit")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(user, id);
        return "redirect:/user/list";
    }
    @GetMapping("/{id}/delete")
    public String delete(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.delete(user, id);
        return "redirect:/user/list";

    }
}
