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
	@RequestMapping("cover_header")	
	public String coverHeaderForm(Model model) {
		return "cmn/cover_header";
	}
	@RequestMapping("cover_main")	
	public String coverMainForm(Model model) {
		return "cmn/cover_main";
	}
  
	// ログイン画面
    @RequestMapping({"login", "invalidSession"})	
    public String loginForm(Model model) {
        return "cmn/login";
    }
	@RequestMapping("login_header")	
	public String loginHeaderForm(Model model) {
		return "cmn/login_header";
	}
	@RequestMapping("login_main")	
	public String loginMainForm(Model model) {
		return "cmn/login_main";
	}
	
	@RequestMapping("home")	
	public String homeForm(Model model) {
		return "cmn/home";
	}
	@RequestMapping("home_header")	
	public String homeHeaderForm(Model model) {
		return "cmn/home_header";
	}
	@RequestMapping("home_main")	
	public String homeMainForm(Model model) {
		return "cmn/home_main";
	}
  
	@RequestMapping("sms_home")	
	public String smsHomeForm(Model model) {
		return "sales/sms_home";
	}
	@RequestMapping("sms_home_header")	
	public String smsHomeHeadertForm(Model model) {
		return "sales/sms_home_header";
	}
	@RequestMapping("sms_home_main")	
	public String smsHomeMaintForm(Model model) {
		return "sales/sms_home_main";
	}

	@RequestMapping("sms_order")	
	public String smsOrderForm(Model model) {
		return "sales/sms_order";
	}
	@RequestMapping("sms_order_header")	
	public String smsOrderHeadertForm(Model model) {
		return "sales/sms_order_header";
	}
	@RequestMapping("sms_order_left")	
	public String smsOrderLefttForm(Model model) {
		return "sales/sms_order_left";
	}
	@RequestMapping("sms_order_main")	
	public String smsOrderMaintForm(Model model) {
		return "sales/sms_order_main";
	}
  
}
