package com.chinese.controller;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by Ranunculus on 29.04.2016.
 */
@Controller
public class MainController {

    private JadeConfiguration jadeConfiguration;

    @RequestMapping(value="/", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String showMainModel(){
        try {
            ModelAndView e = new ModelAndView("layout/layout");
            e.getModel().put("myText", "你好，近看! 这是编程人员的博客。我决定委弃我的在公司的工作，因为我要看别的外国和人");
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
