package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseController {

//	仕入検索画面
	@RequestMapping("/sms-purchase.html")	
	public String purchaseForm(Model model) {
		return "sms-purchase";
	}

//	仕入登録画面
	@RequestMapping("/sms-purchase-add.html")	
	public String purchaseAddForm(Model model) {
		return "sms-purchase-add";
	}
	
//	仕入詳細画面
	@RequestMapping("/sms-purchase-detail.html")	
	public String purchaseDetailForm(Model model) {
		return "sms-purchase-detail";
	}
	
//	仕入変更画面
	@RequestMapping("/sms-purchase-update.html")	
	public String purchaseUpdateForm(Model model) {
		return "sms-purchase-update";
	}
	
}
