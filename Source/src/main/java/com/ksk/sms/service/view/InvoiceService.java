package com.ksk.sms.service.view;

import com.ksk.sms.model.InvoiceViewModel;

public interface InvoiceService {
	
    public InvoiceViewModel init();

    public InvoiceViewModel search(InvoiceViewModel inModel);

    public InvoiceViewModel create(InvoiceViewModel inModel);

    public InvoiceViewModel update(InvoiceViewModel inModel);

    public InvoiceViewModel delete(InvoiceViewModel inModel);
	
    public InvoiceViewModel customerChange(InvoiceViewModel inModel);

    public InvoiceViewModel branchChange(InvoiceViewModel inModel);

    public InvoiceViewModel close(InvoiceViewModel inModel);
    
}
