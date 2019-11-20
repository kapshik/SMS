package com.ksk.sms.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockViewModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;

	private StockCriteria stockCriteria;
	private List<StockModel> stockModelList;

}

