package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class CommonController extends SmsController {

	// エラー画面（login前）
	@RequestMapping("/error.html")	
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

        log.info(model);
		return "sms-home";
	}

//	エラー画面（login後）
	@RequestMapping("/sms-internal-error.html")	
	public String internalErrorForm(Model model) {

        log.info(model);
		return "sms-internal-error";
	}

}
