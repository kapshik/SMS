package com.ksk.sms.presentation.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksk.sms.service.report.impl.TestReportDataFactory;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

@Controller
public class BranchController {

//	支店メイン画面
	@RequestMapping("/sms-branch.html")	
	public String mainForm(Model model) {
		return "sms-branch";
	}

//	支店状況画面
	@RequestMapping("/sms-branch-status.html")	
	public String statusForm(Model model) {
		return "sms-branch-status";
	}

//	支店検索画面
	@RequestMapping("/sms-branch-search.html")	
	public String searchForm(Model model) {
		return "sms-branch-search";
	}

//	支店登録画面
	@RequestMapping("/sms-branch-add.html")	
	public String addForm(Model model) {
		return "sms-branch-add";
	}
	
//	支店詳細画面
	@RequestMapping("/sms-branch-detail.html")	
	public String detailForm(Model model) {
		return "sms-branch-detail";
	}
	
//	支店変更画面
	@RequestMapping("/sms-branch-update.html")	
	public String updateForm(Model model) {
		return "sms-branch-update";
	}
	
//	納品先登録画面
	@RequestMapping("/sms-deliverydest-add.html")	
	public String deliverydestAddForm(Model model) {
		return "sms-deliverydest-add";
	}

}
