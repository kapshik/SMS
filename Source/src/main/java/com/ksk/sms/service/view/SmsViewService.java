package com.ksk.sms.service.view;

import com.ksk.sms.model.SmsViewModel;

public interface SmsViewService {

    public <T extends SmsViewModel> T init();

    public <T extends SmsViewModel> T search(T inModel);

    public <T extends SmsViewModel> T create(T inModel);

    public <T extends SmsViewModel> T update(T inModel);

    public <T extends SmsViewModel> T delete(T inModel);

	public <T extends SmsViewModel> T customerChange(T inModel);

    public <T extends SmsViewModel> T branchChange(T inModel);

    public <T extends SmsViewModel> T close(T inModel);
}
