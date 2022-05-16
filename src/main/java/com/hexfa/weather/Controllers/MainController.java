package com.hexfa.weather.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/")
public class MainController {

    @GetMapping(path="/")
    public @ResponseBody String index() {
        return "OK" ;
    }
}