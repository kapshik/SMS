package com.cms.sms.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.cms.sms.validator.NotExist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String orderNo;
	private String customerNo;
    @NotBlank(message = "顧客名は必須です。")
	@NotExist(tableName="tbl_customer", columnName="customerName")
	private String customerName;
	private String branchName;
	private String deliveryDestName;
    @NotBlank(message = "郵便番号は必須です。")
	@Pattern(regexp="\\d{3}-\\d{4}")
	private String zipcode;
    @NotBlank(message = "住所は必須です。")
	private String address;
    @NotBlank(message = "住所は必須です。")
	private String addressDetail;
    @NotBlank(message = "電話番号は必須です。")
	@Pattern(regexp="0\\d{1,4}-\\d{3,4}-\\d{4}")
	private String telNo;
    @NotBlank(message = "ファックス番号は必須です。")
	private String faxNo;
	@JsonFormat(pattern="yyyy/MM/dd")
    @NotNull(message = "開始日は必須です。")
	private LocalDate startDate;
	private String paymentTerms;
	private String paymentTermsName;
}

