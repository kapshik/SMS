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

	// エラー画面（login前）
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

        log.info(model);
		return "sms-home";
	}

//	エラー画面（login後）
	@RequestMapping("/sms-internal-error.html")	
	public String internalErrorForm(Model model) {

        log.info(model);
		return "sms-internal-error";
	}

}
