package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class OrderController extends SmsController {

//	注文メイン画面
	@RequestMapping("/sms-order.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-order";
	}

//	注文状況画面
	@RequestMapping("/sms-order-status.html")	
	public String statusForm(Model model) {

        log.info(model);
		return "sms-order-status";
	}

//	注文登録画面
	@RequestMapping("/sms-order-add.html")	
	public String addForm(Model model) {

        log.info(model);
		return "sms-order-add";
	}
	
//	注文検索画面
	@RequestMapping("/sms-order-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-order-search";
	}

//	注文変更画面
	@RequestMapping("/sms-order-update.html")	
	public String updateForm(Model model) {

        log.info(model);
		return "sms-order-update";
	}

//	注文詳細画面
	@RequestMapping("/sms-order-detail.html")	
	public String detailForm(Model model) {

        log.info(model);
		return "sms-order-detail";
	}

//	注文確認書作成画面
	@RequestMapping("/sms-order-create.html")	
	public String createForm(Model model) {

        log.info(model);
		return "sms-order-create";
	}

}
