package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InvoiceController {

//	請求検索画面
	@RequestMapping("/sms-invoice.html")	
	public String invoiceForm(Model model) {
		return "sms-invoice";
	}

//	請求登録画面
	@RequestMapping("/sms-invoice-add.html")	
	public String invoiceAddForm(Model model) {
		return "sms-invoice-add";
	}
	
//	請求詳細画面
	@RequestMapping("/sms-invoice-detail.html")	
	public String invoiceDetailForm(Model model) {
		return "sms-invoice-detail";
	}
	
//	請求変更画面
	@RequestMapping("/sms-invoice-update.html")	
	public String invoiceUpdateForm(Model model) {
		return "sms-invoice-update";
	}
	
}
