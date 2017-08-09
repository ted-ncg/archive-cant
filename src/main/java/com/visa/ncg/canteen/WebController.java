package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public  String root(){
        return  "index";
    }
}
