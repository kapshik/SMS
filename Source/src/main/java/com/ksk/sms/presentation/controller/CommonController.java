package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	// エラー画面
	@RequestMapping("error.html")	
	public String errorForm(Model model) {
		return "error";
	}

	// ログイン画面
    @RequestMapping({"/", "/login.html", "/invalidSession"})	
    public String loginForm(Model model) {
        return "login";
    }

//	エントリ画面（login後）
	@RequestMapping("/sms-home.html")	
	public String homeForm(Model model) {
		return "sms-home";
	}
}
