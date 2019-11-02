package com.ksk.sms.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainmenuDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String user;
	
	private String password;

    private List<OrderDataModel> orderList;
}

