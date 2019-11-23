package com.ksk.sms.presentation.controller;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksk.sms.service.report.impl.TestReportDataFactory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

@Controller
public class CommonController {

	// エラー画面
	@RequestMapping("/error.html")	
	public String errorForm(Model model) {
		return "error";
	}

	// ログイン画面
    @RequestMapping({"/", "/login.html", "/invalidSession"})	
    public String loginForm(Model model) {
    	makePdf();
        return "login";
    }

//	エントリ画面（login後）
	@RequestMapping("/sms-home.html")	
	public String homeForm(Model model) {
		return "sms-home";
	}

	private void makePdf(){
		String outFile = "./first.pdf";
		InputStream is = CommonController.class.getResourceAsStream("/report/FirstTest_A4_Table.jrxml");

		TestReportDataFactory testReportDataFactory = new TestReportDataFactory();
		Collection<Map<String, ?>> source = testReportDataFactory.makeList();

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("ReportTitle", "請求書");

			JasperReport jasperReport = null;
			try {
				jasperReport = JasperCompileManager.compileReport(is);
			} catch (JRException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return;
			}
			JasperPrint jasperPrint = null;
			try {
				jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRMapCollectionDataSource(source));
			} catch (JRException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return;
			}
			try {
				JasperExportManager.exportReportToPdfFile(jasperPrint, outFile);
			} catch (JRException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return;
			}
	}

}
