package com.chinese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ranunculus on 29.04.2016.
 */
@Controller
public class MainController {

    @RequestMapping("/main")
    public void showMainModel(){
    }
}
