package com.ksk.sms.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class BranchController extends SmsController {

//	支店メイン画面
	@RequestMapping("/sms-branch.html")	
	public String mainForm(Model model) {

        log.info(model);
		return "sms-branch";
	}

//	支店状況画面
	@RequestMapping("/sms-branch-status.html")	
	public String statusForm(Model model) {

        log.info(model);
		return "sms-branch-status";
	}

//	支店登録画面
	@RequestMapping("/sms-branch-add.html")	
	public String addForm(Model model) {
		model.addAttribute("isListNeedBtn", true);

        log.info(model);
		return "sms-branch-add";
	}
	
//	支店検索画面
	@RequestMapping("/sms-branch-search.html")	
	public String searchForm(Model model) {

        log.info(model);
		return "sms-branch-search";
	}

//	支店変更画面
	@RequestMapping("/sms-branch-update.html")	
	public String updateForm(Model model) {
		model.addAttribute("isListNeedBtn", true);

        log.info(model);
		return "sms-branch-update";
	}

}
