package com.ksk.sms.dao.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
    private String customerNo;
    private String branchNo;
    private String deliveryDestNo;
    private String orderNo;
    private String shippingLabelNo;
    private String estimationNo;
    private String memo;
    private Date estimationDate;
    private Date orderDate;
    private Date registrationDate;
    private Date shippingDate;
    private Date deliveryDate;
    private Date invoiceDate;
    private Date requiredDate;
    private String status;
}
