package com.chinese.controller;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public String showMainModel(){
        try {
            ModelAndView e = new ModelAndView("main");
            e.getModel().put("title", "Finally");
            JadeTemplate template = jadeConfiguration.getTemplate(e.getViewName());
            return jadeConfiguration.renderTemplate(template, e.getModel());
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
