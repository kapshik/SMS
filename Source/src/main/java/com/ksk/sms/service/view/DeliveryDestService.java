package com.ksk.sms.service.view;

import com.ksk.sms.model.DeliveryDestViewModel;

public interface DeliveryDestService {

    public DeliveryDestViewModel init();

    public DeliveryDestViewModel search(DeliveryDestViewModel inModel);

    public DeliveryDestViewModel create(DeliveryDestViewModel inModel);

    public DeliveryDestViewModel update(DeliveryDestViewModel inModel);

    public DeliveryDestViewModel delete(DeliveryDestViewModel inModel);

    public DeliveryDestViewModel customerChange(DeliveryDestViewModel inModel);

    public DeliveryDestViewModel branchChange(DeliveryDestViewModel inModel);

    public DeliveryDestViewModel close(DeliveryDestViewModel inModel);
}
