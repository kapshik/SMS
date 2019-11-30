package com.ksk.sms.presentation.controller;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksk.sms.service.report.impl.InvoiceReportFactory;

import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

@Log4j2
@Controller
public class CommonController extends SmsController {

	// エラー画面
	@RequestMapping("/error.html")	
	public String errorForm(Model model) {
		return "error";
	}

	// ログイン画面
    @RequestMapping({"/", "/login.html", "/invalidSession"})	
    public String loginForm(Model model) {
        return "login";
    }

//	エントリ画面（login後）
	@RequestMapping("/sms-home.html")	
	public String homeForm(Model model) {
		//makePdf(model);
		//model.addAttribute("reportFileName", makePdf());

        log.info(model);
		return "sms-home";
	}

	private String makePdf(){
		String outFile = "./reportOut/Invoice_" + LocalDate.now() + ".pdf";
		InputStream is = CommonController.class.getResourceAsStream("/report/Invoice.jrxml");

//		TestReportDataFactory testReportDataFactory = new TestReportDataFactory();
		Collection<Map<String, ?>> source = new InvoiceReportFactory().makeList();

		Map<String, Object> parameters = new InvoiceReportFactory().makeParameters();

		JasperReport jasperReport = null;
		try {
			jasperReport = JasperCompileManager.compileReport(is);
		} catch (JRException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return outFile;
		}
		JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRMapCollectionDataSource(source));
		} catch (JRException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return outFile;
		}
		try {
			JasperExportManager.exportReportToPdfFile(jasperPrint, outFile);
		} catch (JRException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return outFile;
		}
		return outFile;
	}

}
