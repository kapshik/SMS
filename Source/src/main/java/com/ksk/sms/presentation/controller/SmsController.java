package com.ksk.sms.presentation.controller;

import org.springframework.ui.Model;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SmsController {

	public Model setCommonAttribute(Model model) {
//		model.addAttribute("username", SmsUserInfoUtil.getUsername());
//        model.addAttribute("isAdmin", SmsUserInfoUtil.getRole().equals("ROLE_ADMIN") );

        log.info(model);
		return model;
	}

}
