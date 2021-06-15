package org.example.controllers;

import org.apache.log4j.Logger;
import org.example.filter.SampleFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class IndexController {

    Logger log = Logger.getLogger(IndexController.class);

    @GetMapping("/")
    public String index(Model m) {

        System.out.println("■■■■■ IndexController");

        m.addAttribute("someAttribute", "Hello world!");
        return "index";
    }
}
