package com.cms.sms.model.report;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceTableModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String no;
	private String productName;
	private String quantity;
	private String box;
	private String unitPrice;
	private String amount;
	private String branch;
	private String orderNo;
}

