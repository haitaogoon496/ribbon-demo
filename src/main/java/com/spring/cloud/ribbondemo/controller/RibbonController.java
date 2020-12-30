package com.spring.cloud.ribbondemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon/")
public class RibbonController {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @GetMapping("index")
    public String index() {
        String applicationName = "ribbon-provider";
        return restTemplate.getForObject("http://" + applicationName+"/user/getUserName", String.class);
    }
}
