package org.misan.controller;

import org.misan.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "home";
    }

    @GetMapping("welcome")
    public String welcome(@RequestParam String user, Model model){

        model.addAttribute("Dummy", demoService.getGetHelloMessage(user));
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcome_message(){
         return demoService.getWelcomeMessage();
    }


}
