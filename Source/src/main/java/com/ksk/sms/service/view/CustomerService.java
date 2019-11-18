package com.ksk.sms.service.view;

import com.ksk.sms.datamodel.CustomerDataModel;

public interface CustomerService {

    CustomerDataModel init();

    CustomerDataModel search(CustomerDataModel inModel);

	CustomerDataModel customerChange(CustomerDataModel inModel);

    CustomerDataModel branchChange(CustomerDataModel inModel);

    CustomerDataModel close(CustomerDataModel inModel);
}
