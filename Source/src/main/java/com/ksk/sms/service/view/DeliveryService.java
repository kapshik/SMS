package com.ksk.sms.service.view;

import com.ksk.sms.model.DeliveryViewModel;

public interface DeliveryService {
	
    public DeliveryViewModel init();

    public DeliveryViewModel search(DeliveryViewModel inModel);

    public DeliveryViewModel create(DeliveryViewModel inModel);

    public DeliveryViewModel update(DeliveryViewModel inModel);

    public DeliveryViewModel delete(DeliveryViewModel inModel);
	
    public DeliveryViewModel customerChange(DeliveryViewModel inModel);

    public DeliveryViewModel branchChange(DeliveryViewModel inModel);

    public DeliveryViewModel close(DeliveryViewModel inModel);
    
}
