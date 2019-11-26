package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class PurchaseController extends SmsController {

//	仕入メイン画面
	@RequestMapping("/sms-purchase.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-purchase";
	}

//	仕入状況画面
	@RequestMapping("/sms-purchase-status.html")	
	public String statusForm(Model model) {

        log.info(model);
		return "sms-purchase-status";
	}

//	仕入検索画面
	@RequestMapping("/sms-purchase-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-purchase-search";
	}

//	仕入登録画面
	@RequestMapping("/sms-purchase-add.html")	
	public String paddForm(Model model) {

        log.info(model);
		return "sms-purchase-add";
	}
	
//	仕入詳細画面
	@RequestMapping("/sms-purchase-detail.html")	
	public String detailForm(Model model) {

        log.info(model);
		return "sms-purchase-detail";
	}
	
//	仕入変更画面
	@RequestMapping("/sms-purchase-update.html")	
	public String updateForm(Model model) {

        log.info(model);
		return "sms-purchase-update";
	}
	
}
