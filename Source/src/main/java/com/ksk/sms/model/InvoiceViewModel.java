package com.ksk.sms.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceViewModel extends SmsViewModel{

	private String invoiceNo;
	private String customerNo;
	private String branchNo;
	private String deliveryDestNo;
	private String orderNo;
	private String shippingLabelNo;
	private String orderDate;
	private String shippingDate;
	private String deliveryDate;
	private String quantity;
	private String unitPrice;
	private String discountUnitPrice;
	private String memo;

}

