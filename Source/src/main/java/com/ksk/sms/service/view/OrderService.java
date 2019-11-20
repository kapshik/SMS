package com.ksk.sms.service.view;

import com.ksk.sms.model.OrderViewModel;

public interface OrderService {
	
    public OrderViewModel init();

    public OrderViewModel search(OrderViewModel inModel);

    public OrderViewModel create(OrderViewModel inModel);

    public OrderViewModel update(OrderViewModel inModel);

    public OrderViewModel delete(OrderViewModel inModel);
	
    public OrderViewModel customerChange(OrderViewModel inModel);

    public OrderViewModel branchChange(OrderViewModel inModel);

    public OrderViewModel close(OrderViewModel inModel);
    
}
