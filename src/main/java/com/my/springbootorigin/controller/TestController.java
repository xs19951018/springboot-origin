package com.my.springbootorigin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private int count = 0;

    @RequestMapping("/single")
    public int testSingle() throws InterruptedException {
        Thread.sleep(4000);
        count ++;
        return count;
    }

}
