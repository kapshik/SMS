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
public class StockController {

//	在庫検索画面
	@RequestMapping("/sms-stock.html")	
	public String stockForm(Model model) {
		return "sms-stock";
	}

//	在庫詳細画面
	@RequestMapping("/sms-stock-detail.html")	
	public String stockDetailForm(Model model) {
		return "sms-stock-detail";
	}
	
//	在庫登録画面
	@RequestMapping("/sms-stock-add.html")	
	public String stockAddForm(Model model) {
		return "sms-stock-add";
	}
	
}
