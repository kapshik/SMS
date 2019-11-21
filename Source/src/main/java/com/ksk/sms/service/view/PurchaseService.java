package com.ksk.sms.service.view;

import com.ksk.sms.model.PurchaseViewModel;

public interface PurchaseService {
	
    public PurchaseViewModel init();

    public PurchaseViewModel search(PurchaseViewModel inModel);

    public PurchaseViewModel create(PurchaseViewModel inModel);

    public PurchaseViewModel update(PurchaseViewModel inModel);

    public PurchaseViewModel delete(PurchaseViewModel inModel);
	
    public PurchaseViewModel customerChange(PurchaseViewModel inModel);

    public PurchaseViewModel branchChange(PurchaseViewModel inModel);

    public PurchaseViewModel close(PurchaseViewModel inModel);
    
}
