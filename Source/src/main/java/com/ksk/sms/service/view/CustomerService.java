package com.ksk.sms.service.view;

import com.ksk.sms.model.CustomerViewModel;

public interface CustomerService {
	
    public CustomerViewModel init();

    public CustomerViewModel search(CustomerViewModel inModel);

    public CustomerViewModel create(CustomerViewModel inModel);

    public CustomerViewModel update(CustomerViewModel inModel);

    public CustomerViewModel delete(CustomerViewModel inModel);

	public CustomerViewModel customerChange(CustomerViewModel inModel);

    public CustomerViewModel branchChange(CustomerViewModel inModel);

    public CustomerViewModel close(CustomerViewModel inModel);
    

}
