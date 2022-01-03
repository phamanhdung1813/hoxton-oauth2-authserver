package com.anhdungpham.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test1")
    public String testController1() {
        return "TEST1 SUCCESS !!!";
    }

    @GetMapping(value = "/test2")
    public String testController2() {
        return "TEST2 SUCCESS !!!";
    }
}
