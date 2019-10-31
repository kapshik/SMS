package com.ksk.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

	// ルート画面
    @RequestMapping({"", "index", "login", "invalidSession"})	
    public String defaultForm(Model model) {
        return "login";
    }

    @RequestMapping("main_menu")	
    public String mainMenuForm(Model model) {
        return "main_menu";
    }
}
