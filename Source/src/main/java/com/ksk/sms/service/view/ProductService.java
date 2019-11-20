package com.ksk.sms.service.view;

import com.ksk.sms.model.ProductViewModel;

public interface ProductService {
	
    public ProductViewModel init();

    public ProductViewModel search(ProductViewModel inModel);

    public ProductViewModel create(ProductViewModel inModel);

    public ProductViewModel update(ProductViewModel inModel);

    public ProductViewModel delete(ProductViewModel inModel);
	
    public ProductViewModel customerChange(ProductViewModel inModel);

    public ProductViewModel branchChange(ProductViewModel inModel);

    public ProductViewModel close(ProductViewModel inModel);
    
}
