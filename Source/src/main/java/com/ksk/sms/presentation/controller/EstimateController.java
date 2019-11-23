package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstimateController {

//	見積メイン画面
	@RequestMapping("/sms-estimate.html")	
	public String mainForm(Model model) {
		return "sms-estimate";
	}

//	見積状況画面
	@RequestMapping("/sms-estimate-status.html")	
	public String statusForm(Model model) {
		return "sms-estimate-status";
	}

//	見積検索画面
	@RequestMapping("/sms-estimate-search.html")	
	public String searchForm(Model model) {
		return "sms-estimate-search";
	}

//	見積登録画面
	@RequestMapping("/sms-estimate-add.html")	
	public String addForm(Model model) {
		return "sms-estimate-add";
	}
	
//	見積詳細画面
	@RequestMapping("/sms-estimate-detail.html")	
	public String detailForm(Model model) {
		return "sms-estimate-detail";
	}
	
//	見積変更画面
	@RequestMapping("/sms-estimate-update.html")	
	public String updateForm(Model model) {
		return "sms-estimate-update";
	}
	
}
