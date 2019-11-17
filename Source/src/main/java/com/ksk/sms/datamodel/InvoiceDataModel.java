package com.ksk.sms.datamodel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

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

