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
public class DeliveryController {

//	納品メイン画面
	@RequestMapping("/sms-delivery.html")	
	public String mainForm(Model model) {
		return "sms-delivery";
	}

//	納品状況画面
	@RequestMapping("/sms-delivery-status.html")	
	public String statusForm(Model model) {
		return "sms-delivery-status";
	}

//	納品検索画面
	@RequestMapping("/sms-delivery-search.html")	
	public String searchForm(Model model) {
		return "sms-delivery-search";
	}

//	納品登録画面
	@RequestMapping("/sms-delivery-add.html")	
	public String addForm(Model model) {
		return "sms-delivery-add";
	}
	
//	納品詳細画面
	@RequestMapping("/sms-delivery-detail.html")	
	public String detailForm(Model model) {
		return "sms-delivery-detail";
	}
	
//	納品変更画面
	@RequestMapping("/sms-delivery-update.html")	
	public String updateForm(Model model) {
		return "sms-delivery-update";
	}
	
}
