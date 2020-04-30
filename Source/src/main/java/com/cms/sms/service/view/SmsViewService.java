package com.cms.sms.service.view;

import com.cms.sms.model.SmsViewModel;

public interface SmsViewService <T extends SmsViewModel> {

    public T init();

    public T create(T inModel);

    public T search(T inModel);

    public T detail(T inModel);

	public T update(T inModel);

    public T delete(T inModel);

    public T close(T inModel);

	public T customerChange(T inModel);

    public T branchChange(T inModel);

    public T deliveryDestChange(T inModel);

}
