package com.cht.producter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producter")
public class ProducterController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam String name){
        return name+", hello";
    }
}
