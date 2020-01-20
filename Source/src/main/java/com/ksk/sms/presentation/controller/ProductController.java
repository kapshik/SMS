package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ProductController extends SmsController {

//	商品登録画面
	@RequestMapping("/sms-product-add.html")	
	public String addForm(Model model) {

        log.info(model);
		return "sms-product-add";
	}

//	商品検索画面
	@RequestMapping("/sms-product-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-product-search";
	}

//	商品変更画面
	@RequestMapping("/sms-product-update.html")	
	public String updateForm(Model model) {

        log.info(model);
		return "sms-product-update";
	}
	
//	商品詳細画面
	@RequestMapping("/sms-product-detail.html")	
	public String detailForm(Model model) {

        log.info(model);
		return "sms-product-detail";
	}

}
