package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ShippingHistoryController extends SmsController {

//	出荷履歴画面
	@RequestMapping("/sms-shipping-history.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-shipping-history";
	}

}
