package com.ksk.sms.datamodel;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDestDataModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userName;

	private DeliveryDestDataCriteria deliveryDestCriteria;
	private List<DeliveryDestData> deliveryDestDataList;

}

