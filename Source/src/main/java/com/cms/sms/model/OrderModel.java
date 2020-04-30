package com.cms.sms.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderModel implements Serializable{

	private static final long serialVersionUID = 1L;

    private String branchNo;
    private String branchName;
    private String customerNo;
    private String customerName;
    private String deliveryDestNo;
    private String deliveryDestName;
    private String estimationNo;
    private String estimationSendDate;
    private String memo;
    private String orderNo;
    private String shippingLabelNo;
    private String status;
    private int discountUnitPrice;
    private int quantity;
    private int unitPrice;
	@JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate deliveryDate;
	@JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate estimationDate;
	@JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate invoiceDate;
	@JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate orderDate;
	@JsonFormat(pattern="yyyy年MM月dd日")
    private LocalDate registrationDate;
	@JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate requiredDate;
	@JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate shippingDate;
}

