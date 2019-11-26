package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class InvoiceController extends SmsController {

//	請求メイン画面
	@RequestMapping("/sms-invoice.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-invoice";
	}

//	請求状況画面
	@RequestMapping("/sms-invoice-status.html")	
	public String statusForm(Model model) {

        log.info(model);
		return "sms-invoice-status";
	}

//	請求検索画面
	@RequestMapping("/sms-invoice-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-invoice-search";
	}

//	請求登録画面
	@RequestMapping("/sms-invoice-add.html")	
	public String addForm(Model model) {

        log.info(model);
		return "sms-invoice-add";
	}
	
//	請求詳細画面
	@RequestMapping("/sms-invoice-detail.html")	
	public String detailForm(Model model) {

        log.info(model);
		return "sms-invoice-detail";
	}
	
//	請求変更画面
	@RequestMapping("/sms-invoice-update.html")	
	public String updateForm(Model model) {

        log.info(model);
		return "sms-invoice-update";
	}
	
}
