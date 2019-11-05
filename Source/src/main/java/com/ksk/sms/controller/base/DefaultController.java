package com.ksk.sms.controller.base;

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

import com.ksk.sms.model.report.TestReportDataFactory;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

@Controller
@RequestMapping("/")
public class DefaultController {

	@RequestMapping("mainmenu")	
	public String mainMenuForm(Model model) {
		return "base/mainmenu";
	}
  
//	@RequestMapping("error")	
//	public String errorForm(Model model) {
//		return "base/error";
//	}

	// ルート画面
	@RequestMapping({"", "index", "cover"})	
	public String coverForm(Model model) {
		createPDF();
		createPDFWithBean();
		return "base/cover";
	}
  
	// ログイン画面
    @RequestMapping({"login", "invalidSession"})	
    public String loginForm(Model model) {
        return "base/login";
    }
	
	@RequestMapping("home")	
	public String homeForm(Model model) {
		return "base/home";
	}
  
	@RequestMapping("sms_home")	
	public String smsHomeForm(Model model) {
		return "sales/sms_home";
	}

	@RequestMapping("sms_order")	
	public String smsOrderForm(Model model) {
		return "sales/sms_order";
	}
  
	@RequestMapping("sms_order_search")	
	public String smsOrderSearchForm(Model model) {
		return "sales/sms_order_search";
	}
  
	@RequestMapping("sms_costomer_search")	
	public String smsCostomerSearchForm(Model model) {
		return "sales/sms_costomer_search";
	}

		@RequestMapping("sms_product_search")	
	public String smsProductSearchForm(Model model) {
		return "sales/sms_product_search";
	}

	@RequestMapping("sms_stock_search")	
	public String smsStockSearchForm(Model model) {
		return "sales/sms_stock_search";
	}

	@RequestMapping("sms_print_report")	
	public String smsReportSearchForm(Model model) {
		return "sales/sms_print_report";
	}

	public void createPDF() {
		Logger logger = LogManager.getLogger(this.getClass());

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("REPORT_TITLE", "請求書試験");
		
		try {
			InputStream is = new ClassPathResource("report/FirstTest.csv").getInputStream();
			JRCsvDataSource dataSource = new JRCsvDataSource(is);
			dataSource.setUseFirstRowAsHeader(true);
			try (InputStream template = new ClassPathResource("report/FirstTestCoffee.jrxml").getInputStream()) {
				logger.info("Start JR");
				JasperReport report = JasperCompileManager.compileReport(template);
				JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);
				JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\dev\\JasperReports\\MyReports\\example.pdf");
				logger.info("End JR");
			} catch(Exception e){
				logger.info(e);
				 e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}

	public void createPDFWithBean() {
		Logger logger = LogManager.getLogger(this.getClass());

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("REPORT_TITLE", "請求書本番");
		
		TestReportDataFactory tdf = new TestReportDataFactory();
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(tdf.makeList());
		try (InputStream template = new ClassPathResource("report/FirstTest_A4_Table.jrxml").getInputStream()) {
			logger.info("Start JR");
			JasperReport report = JasperCompileManager.compileReport(template);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\dev\\JasperReports\\MyReports\\example2.pdf");
			logger.info("End JR");
		} catch(Exception e){
			logger.info(e);
			 e.printStackTrace();
		}
	}
}
