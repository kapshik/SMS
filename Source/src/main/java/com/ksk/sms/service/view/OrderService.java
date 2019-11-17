package com.ksk.sms.service.view;

import com.ksk.sms.datamodel.OrderDataModel;

public interface OrderService {

    OrderDataModel init();

    OrderDataModel search(OrderDataModel inModel);

	OrderDataModel customerChange(OrderDataModel inModel);

    OrderDataModel branchChange(OrderDataModel inModel);

    OrderDataModel close(OrderDataModel inModel);
}
