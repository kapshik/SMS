package com.ksk.sms.service.report.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DeliveryReportFactory {

	public Collection<Map<String, ?>> makeList() {
		Collection<Map<String, ?>> list = new ArrayList<>();
		Random random = new Random();
		for(int i=1; i<=10; i++) {
			Map<String, Object> rowData = new HashMap<>();

			rowData.put("no", String.format("%d", i));
			rowData.put("productName", "品名"+String.format("%04d", random.nextInt(1000)));
			rowData.put("quantity", random.nextInt(100));
			rowData.put("box", random.nextInt(10));
			rowData.put("unitPrice", random.nextInt(999));
			rowData.put("amount", random.nextInt(10000));
			rowData.put("remarks", "備考です。"+String.format("%04d", random.nextInt(9999)));
			
			list.add(rowData);
		}

		return list;
	}

	public Map<String, Object> makeParameters() {
		Map<String, Object> parameters = new HashMap<>();
		Calendar calendar= new GregorianCalendar(Locale.JAPAN);

		parameters.put("ReportTitle", "納　品　書");
		
		parameters.put("customerAddress1", "京都府京都市伏見区西大手町307-60");
		parameters.put("customerAddress2", "太陽生命京都南ビル5Ｆ");
		parameters.put("customerName", "株式会社日本＃＃＃");
		parameters.put("branchName", "京滋営業所　御中");
		parameters.put("orderNo", "A0028-178053-1");
		calendar.add(Calendar.DAY_OF_MONTH, -10);
		parameters.put("shippingDate", calendar.getTime() );
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		parameters.put("deliveryDate", calendar.getTime() );
		parameters.put("deliveryNote", "＊大阪営業所【北和建設様分】様への納品分");
		
		parameters.put("staffName", "宋　承必");
		parameters.put("zipcode", "135-0004");
		parameters.put("address1", "東京都江東区森下5-11-8");
		parameters.put("address2", "荒川ビル2F");
		parameters.put("companyName", "株式会社ティ・エム・シー");
		parameters.put("tel", "03-6659-3871");
		parameters.put("fax", "03-6659-3872");
		parameters.put("issuedDate", LocalDate.now());
		parameters.put("deliveryNo", "D-" + LocalDate.now().getYear() + "-" + "001");
		
		parameters.put("paymentTerms", "●　月末閉め翌月末支払い");
		parameters.put("bankAccount", "三菱UFJ銀行　虎ノ門支店　普通 01565##　カ）ティエムシー");

		return parameters;
	}
}
