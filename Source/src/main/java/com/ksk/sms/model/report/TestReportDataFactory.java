package com.ksk.sms.model.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestReportDataFactory {

	public Collection<Map<String, ?>> makeList() {
		Collection<Map<String, ?>> orderList = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			String strNo = Integer.toString(i);
			Map<String, Object> rowData = new HashMap<>();

			rowData.put("orderNo", strNo);
			rowData.put("customer", "Customer"+strNo);
			rowData.put("branchName", "BranchName"+strNo);
			rowData.put("deliveryDestination", "DeliveryDestination"+strNo);
			rowData.put("orderDate", "OrderDate"+strNo);
			rowData.put("deliveryDate", "DeliveryDate"+strNo);
			rowData.put("shippingDate", "ShippingDate"+strNo);
			rowData.put("creationDate", "CreationDate"+strNo);
			
			orderList.add(rowData);
		}

		return orderList;
	}
}
