package com.comtest.forwork.controller;

import com.comtest.forwork.service.OrderService;
import com.comtest.forwork.utils.ResBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chaoqi")
public class ChaoQiController {

    @Autowired
    OrderService orderService;

    @PostMapping("/everyday")
    public ResBack everyday() {
        return orderService.everyday();
    }

    @PostMapping("/everyDept")
    public ResBack everyDept() {
        return orderService.everyDept();
    }

}
