package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class DeliverydestController extends SmsController {

//	納品先登録画面
	@RequestMapping("/sms-deliverydest-add.html")	
	public String addForm(Model model) {

        log.info(model);
		return "sms-deliverydest-add";
	}

//	納品先検索画面
	@RequestMapping("/sms-deliverydest-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-deliverydest-search";
	}

}
