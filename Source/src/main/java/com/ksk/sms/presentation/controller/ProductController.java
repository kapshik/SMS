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
public class ProductController {

//	商品検索画面
	@RequestMapping("/sms-product.html")	
	public String productForm(Model model) {
		return "sms-product";
	}

//	商品詳細画面
	@RequestMapping("/sms-product-detail.html")	
	public String productDetailForm(Model model) {
		return "sms-product-detail";
	}
	
//	商品登録画面
	@RequestMapping("/sms-product-add.html")	
	public String productAddForm(Model model) {
		return "sms-product-add";
	}

}
