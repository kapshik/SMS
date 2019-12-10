package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class CustomerController extends SmsController  {

//	顧客メイン画面
	@RequestMapping("/sms-customer.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-customer";
	}

//	顧客状況画面
	@RequestMapping("/sms-customer-status.html")	
	public String statusForm(Model model) {

        log.info(model);
		return "sms-customer-status";
	}

//	顧客登録画面
	@RequestMapping("/sms-customer-add.html")	
	public String addForm(Model model) {
        model.addAttribute("isListNeedBtn", true);

        log.info(model);
		return "sms-customer-add";
	}

//	顧客検索画面
	@RequestMapping("/sms-customer-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-customer-search";
	}

//	顧客変更画面
	@RequestMapping("/sms-customer-update.html")	
	public String updateForm(Model model) {
		model.addAttribute("isListNeedBtn", true);

        log.info(model);
		return "sms-customer-update";
	}

//	顧客詳細画面
	@RequestMapping("/sms-customer-detail.html")	
	public String detailForm(Model model) {

        log.info(model);
		return "sms-customer-detail";
	}

}
