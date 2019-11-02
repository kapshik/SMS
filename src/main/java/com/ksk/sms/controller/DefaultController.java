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
        return "cmn/login";
    }
	
	@RequestMapping("mainmenu")	
	public String mainMenuForm(Model model) {
		return "cmn/mainmenu";
	}
  
	@RequestMapping("home")	
	public String homeForm(Model model) {
		return "cmn/home";
	}
  
	@RequestMapping("footer")	
	public String footerForm(Model model) {
		return "cmn/footer";
	}
	
	@RequestMapping("fixed_navbar_layout")	
	public String navbarLayoutForm(Model model) {
		return "cmn/fixed_navbar_layout";
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
