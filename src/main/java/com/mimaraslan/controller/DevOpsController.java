package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


//   http://localhost:8080
@RestController
@RequestMapping
public class DevOpsController {

    //   http://localhost:8080
    @GetMapping
    public String devopsHello(){

        LocalDateTime myTimeObj = LocalDateTime.now();
        System.out.println(myTimeObj);

        return "Welcome to DevOps: " + myTimeObj;
    }


    //   http://localhost:8080/info
    @GetMapping("/info")
    public String devopsInfo(){

        LocalDateTime myTimeObj = LocalDateTime.now();
        System.out.println(myTimeObj);

        return "DevOps Info: "+ myTimeObj;
    }

}
