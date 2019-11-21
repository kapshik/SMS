package com.ksk.sms.service.view;

import com.ksk.sms.model.StockViewModel;

public interface StockService {
	
    public StockViewModel init();

    public StockViewModel search(StockViewModel inModel);

    public StockViewModel create(StockViewModel inModel);

    public StockViewModel update(StockViewModel inModel);

    public StockViewModel delete(StockViewModel inModel);
	
    public StockViewModel customerChange(StockViewModel inModel);

    public StockViewModel branchChange(StockViewModel inModel);

    public StockViewModel close(StockViewModel inModel);
    
}
