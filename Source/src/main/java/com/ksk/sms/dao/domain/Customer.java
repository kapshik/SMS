package com.ksk.sms.dao.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Customer {
    private String customerNo;
    private String customerName;
    private String zipcode;
    private String address;
    private String addressDetail;
    private String telNo;
    private String faxNo;
    private LocalDate startDate;
    private String paymentTerms;
}
