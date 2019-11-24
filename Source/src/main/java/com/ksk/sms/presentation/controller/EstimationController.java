package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstimationController {

//	見積メイン画面
	@RequestMapping("/sms-estimation.html")	
	public String mainForm(Model model) {
		return "sms-estimation";
	}

//	見積状況画面
	@RequestMapping("/sms-estimation-status.html")	
	public String statusForm(Model model) {
		return "sms-estimation-status";
	}

//	見積検索画面
	@RequestMapping("/sms-estimation-search.html")	
	public String searchForm(Model model) {
		return "sms-estimation-search";
	}

//	見積登録画面
	@RequestMapping("/sms-estimation-add.html")	
	public String addForm(Model model) {
		return "sms-estimation-add";
	}
	
//	見積詳細画面
	@RequestMapping("/sms-estimation-detail.html")	
	public String detailForm(Model model) {
		return "sms-estimation-detail";
	}
	
//	見積変更画面
	@RequestMapping("/sms-estimation-update.html")	
	public String updateForm(Model model) {
		return "sms-estimation-update";
	}
	
}
