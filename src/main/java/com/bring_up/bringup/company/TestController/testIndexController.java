package com.bring_up.bringup.company.TestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testIndexController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}