package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class StockController extends SmsController {

//	在庫メイン画面
	@RequestMapping("/sms-stock.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-stock";
	}

//	在庫状況画面
	@RequestMapping("/sms-stock-status.html")	
	public String statusForm(Model model) {

        log.info(model);
		return "sms-stock-status";
	}

//	在庫検索画面
	@RequestMapping("/sms-stock-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-stock-search";
	}

//	在庫登録画面
	@RequestMapping("/sms-stock-add.html")	
	public String addForm(Model model) {

        log.info(model);
		return "sms-stock-add";
	}
	
//	在庫登録画面
	@RequestMapping("/sms-stock-in.html")	
	public String inForm(Model model) {

        log.info(model);
		return "sms-stock-in";
	}
	
//	在庫登録画面
	@RequestMapping("/sms-stock-out.html")	
	public String outForm(Model model) {

        log.info(model);
		return "sms-stock-out";
	}
	
//	在庫詳細画面
	@RequestMapping("/sms-stock-detail.html")	
	public String detailForm(Model model) {

        log.info(model);
		return "sms-stock-detail";
	}
	
//	在庫変更画面
	@RequestMapping("/sms-stock-update.html")	
	public String updateForm(Model model) {

        log.info(model);
		return "sms-stock-update";
	}
	
}
