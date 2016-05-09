package com.chinese.controller;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Ranunculus on 29.04.2016.
 */
@Controller
public class MainController {

    private JadeConfiguration jadeConfiguration;

    @RequestMapping("/")
    public String showMainModel(){
        try {
            ModelAndView modelAndView = new ModelAndView("main");
            JadeTemplate template = jadeConfiguration.getTemplate(modelAndView.getViewName());
            System.out.println(jadeConfiguration.renderTemplate(template, modelAndView.getModel()));
            return jadeConfiguration.renderTemplate(template, modelAndView.getModel());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public JadeConfiguration getJadeConfiguration() {
        return jadeConfiguration;
    }

    public void setJadeConfiguration(JadeConfiguration jadeConfiguration) {
        this.jadeConfiguration = jadeConfiguration;
    }
}
