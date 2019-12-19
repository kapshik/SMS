package com.ksk.sms.dao.domain;

import java.time.LocalDate;

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
    private LocalDate deliveryDate;
    private LocalDate estimationDate;
    private LocalDate invoiceDate;
    private LocalDate orderDate;
    private LocalDate registrationDate;
    private LocalDate requiredDate;
    private LocalDate shippingDate;
}
