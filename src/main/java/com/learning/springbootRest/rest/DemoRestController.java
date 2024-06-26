package com.learning.springbootRest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/hii")
    public String sayHello()
    {
        return "hey hello";
    }

}
