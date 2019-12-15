package com.ksk.sms.dao.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
    private String branchNo;
    private String customerNo;
    private String deliveryDestNo;
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
