package com.ksk.sms.model;

import java.io.Serializable;
import java.util.Date;

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
    private Date deliveryDate;
    private Date estimationDate;
    private Date invoiceDate;
    private Date orderDate;
    private Date registrationDate;
    private Date requiredDate;
    private Date shippingDate;
}

