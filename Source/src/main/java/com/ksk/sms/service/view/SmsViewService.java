package com.ksk.sms.service.view;

import com.ksk.sms.model.SmsViewModel;

public interface SmsViewService <T extends SmsViewModel> {

    public T init();

    public T search(T inModel);

    public T create(T inModel);

    public T update(T inModel);

    public T delete(T inModel);

	public T customerChange(T inModel);

    public T branchChange(T inModel);

    public T close(T inModel);

}
