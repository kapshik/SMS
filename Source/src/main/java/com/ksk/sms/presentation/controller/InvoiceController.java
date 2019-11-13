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
public class InvoiceController {

//	請求検索画面
	@RequestMapping("/sms-invoice.html")	
	public String invoiceForm(Model model) {
		return "sms-invoice";
	}

//	請求詳細画面
	@RequestMapping("/sms-invoice-detail.html")	
	public String invoiceDetailForm(Model model) {
		return "sms-invoice-detail";
	}
	
//	請求登録画面
	@RequestMapping("/sms-invoice-add.html")	
	public String invoiceAddForm(Model model) {
		return "sms-invoice-add";
	}
	
}
