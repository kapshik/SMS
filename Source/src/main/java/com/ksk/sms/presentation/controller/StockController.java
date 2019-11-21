package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockController {

//	在庫検索画面
	@RequestMapping("/sms-stock.html")	
	public String stockForm(Model model) {
		return "sms-stock";
	}

//	在庫登録画面
	@RequestMapping("/sms-stock-add.html")	
	public String stockAddForm(Model model) {
		return "sms-stock-add";
	}
	
//	在庫詳細画面
	@RequestMapping("/sms-stock-detail.html")	
	public String stockDetailForm(Model model) {
		return "sms-stock-detail";
	}
	
//	在庫変更画面
	@RequestMapping("/sms-stock-update.html")	
	public String stockUpdateForm(Model model) {
		return "sms-stock-update";
	}
	
}
