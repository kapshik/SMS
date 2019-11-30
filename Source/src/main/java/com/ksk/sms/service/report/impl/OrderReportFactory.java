package com.ksk.sms.service.report.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrderReportFactory {

    @Autowired
    ResourceLoader resourceLoader;
	
	public Collection<Map<String, ?>> makeList() {
		//使わない
		return null;
	}

	public Map<String, Object> makeParameters() {
		Map<String, Object> parameters = new HashMap<>();
		Calendar calendar= new GregorianCalendar(Locale.JAPAN);

        try {
            InputStream tmcLogo = new FileInputStream(resourceLoader.getResource("classpath:static/img/tmc_logo.png").getFile());
			parameters.put("tmcLogo", tmcLogo);
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        parameters.put("ReportTitle", "注文確認書");
		
		parameters.put("companyName", "株式会社ティ・エム・シー");

		parameters.put("zipcode", "135-0004");
		parameters.put("address1", "東京都江東区森下5-11-8");
		parameters.put("address2", "荒川ビル2F");

		parameters.put("tel", "03-6659-3871");
		parameters.put("fax", "03-6659-3872");
		parameters.put("mailAddress", "spsong.tmc@gmail.com");

		parameters.put("customerName", "株式会社日本＃＃＃");
		parameters.put("branchName", "京滋営業所　御中");
		parameters.put("staffName", "宋承必(ソンスンピル)");
		
		parameters.put("customerFax", "075-601-3235");

		parameters.put("customerTel", "075-601-3234");
		parameters.put("issuedDate", new Date());

		parameters.put("customerAddress1", "京都府京都市伏見区西大手町307-60");
		parameters.put("customerAddress2", "太陽生命京都南ビル5Ｆ");

		parameters.put("confirmationNote", "さて、10月31日付きでご注文いただいた商品の納品日について連絡いたします。");


		calendar.add(Calendar.DAY_OF_MONTH, -15);
		parameters.put("orderDate", calendar.getTime() );
		parameters.put("orderNo", "A0028-178053-1");
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		parameters.put("shippingDate", calendar.getTime() );
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		parameters.put("deliveryDate", calendar.getTime() );
		parameters.put("deliveryDest", "大阪営業所【北和建設様分】");
		parameters.put("shippingLabelNo", "(西濃運輸) 800-980-8891");
		parameters.put("productName", "ワールド151ガン");
		parameters.put("quantity", "1ケース(1丁)");
		
		return parameters;
	}
}
