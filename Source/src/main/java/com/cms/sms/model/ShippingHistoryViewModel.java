package com.cms.sms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingHistoryViewModel extends SmsViewModel{

	private List<ShippingHistoryModel> shippingHistoryModelList;

}

