package com.andorid.controller;

import com.andorid.dao.UserImp;
import com.andorid.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String goHome() {
        System.out.println("in home controller");
        var all = userRepository.findAll();
        return "index";
    }

}
