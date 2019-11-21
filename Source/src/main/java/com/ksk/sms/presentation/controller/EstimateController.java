package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstimateController {

//	見積検索画面
	@RequestMapping("/sms-estimate.html")	
	public String estimateForm(Model model) {
		return "sms-estimate";
	}

//	見積登録画面
	@RequestMapping("/sms-estimate-add.html")	
	public String estimateAddForm(Model model) {
		return "sms-estimate-add";
	}
	
//	見積詳細画面
	@RequestMapping("/sms-estimate-detail.html")	
	public String estimateDetailForm(Model model) {
		return "sms-estimate-detail";
	}
	
//	見積変更画面
	@RequestMapping("/sms-estimate-update.html")	
	public String estimateUpdateForm(Model model) {
		return "sms-estimate-update";
	}
	
}
