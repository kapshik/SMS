package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class EstimationController extends SmsController {

//	見積メイン画面
	@RequestMapping("/sms-estimation.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-estimation";
	}

//	見積状況画面
	@RequestMapping("/sms-estimation-status.html")	
	public String statusForm(Model model) {

        log.info(model);
		return "sms-estimation-status";
	}

//	見積登録画面
	@RequestMapping("/sms-estimation-add.html")	
	public String addForm(Model model) {

        log.info(model);
		return "sms-estimation-add";
	}
	
//	見積検索画面
	@RequestMapping("/sms-estimation-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-estimation-search";
	}

//	見積変更画面
	@RequestMapping("/sms-estimation-update.html")	
	public String updateForm(Model model) {

        log.info(model);
		return "sms-estimation-update";
	}
	
//	見積詳細画面
	@RequestMapping("/sms-estimation-detail.html")	
	public String detailForm(Model model) {

        log.info(model);
		return "sms-estimation-detail";
	}
	
}
