package com.ksk.sms.service.view;

import com.ksk.sms.model.EstimateViewModel;

public interface EstimateService {
	
    public EstimateViewModel init();

    public EstimateViewModel search(EstimateViewModel inModel);

    public EstimateViewModel create(EstimateViewModel inModel);

    public EstimateViewModel update(EstimateViewModel inModel);

    public EstimateViewModel delete(EstimateViewModel inModel);
	
    public EstimateViewModel customerChange(EstimateViewModel inModel);

    public EstimateViewModel branchChange(EstimateViewModel inModel);

    public EstimateViewModel close(EstimateViewModel inModel);
    
}
