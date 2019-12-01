package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class DeliveryController extends SmsController {

//	納品メイン画面
	@RequestMapping("/sms-delivery.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-delivery";
	}

//	納品状況画面
	@RequestMapping("/sms-delivery-status.html")	
	public String statusForm(Model model) {

        log.info(model);
		return "sms-delivery-status";
	}

//	納品書作成画面
	@RequestMapping("/sms-delivery-create.html")	
	public String createForm(Model model) {

        log.info(model);
		return "sms-delivery-create";
	}
	
//	納品書検索画面
	@RequestMapping("/sms-delivery-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-delivery-search";
	}

//	納品書確認画面
	@RequestMapping("/sms-delivery-detail.html")	
	public String detailForm(Model model) {

        log.info(model);
		return "sms-delivery-detail";
	}
	
}
