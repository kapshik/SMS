package com.ksk.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

	@RequestMapping("mainmenu")	
	public String mainMenuForm(Model model) {
		return "cmn/mainmenu";
	}
  
	// 部品画面
	@RequestMapping("footer")	
	public String footerForm(Model model) {
		return "cmn/footer";
	}
	
	// ルート画面
	@RequestMapping({"", "index", "cover"})	
	public String coverForm(Model model) {
		return "cmn/cover";
	}
  
	// ログイン画面
    @RequestMapping({"login", "invalidSession"})	
    public String loginForm(Model model) {
        return "cmn/login";
    }
	
	@RequestMapping("home")	
	public String homeForm(Model model) {
		return "cmn/home";
	}
  
	@RequestMapping("sms_home")	
	public String smsHomeForm(Model model) {
		return "sales/sms_home";
	}

	@RequestMapping("sms_order")	
	public String smsOrderForm(Model model) {
		return "sales/sms_order";
	}
  
}
