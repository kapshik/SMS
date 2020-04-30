package com.cms.sms.service.view.impl;

import org.springframework.stereotype.Service;

import com.cms.sms.model.SmsViewModel;
import com.cms.sms.service.common.SmsService;
import com.cms.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SmsCommonServiceImpl extends SmsService implements SmsViewService<SmsViewModel> {
	
	@Override
    public SmsViewModel init() {

		SmsViewModel outModel = new SmsViewModel();

		outModel.setUsername(getUsername());
		outModel.setRole(getRole());
    	
		outModel.setCustomerList(makeCustomerList());
    	outModel.setBranchList(makeBranchList(""));
		outModel.setDeliveryDestList(makeDeliveryDestList(""));

    	outModel.setPaymentTermsList(makePaymentTermsList());
		outModel.setProductTypeList(makeProductTypeList());
		outModel.setUnitTypeList(makeUnitTypeList());
    	
    	log.info("SmsCommonServiceImpl init");
    	return outModel;
    }

	@Override
	public SmsViewModel search(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SmsViewModel create(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SmsViewModel update(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SmsViewModel delete(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SmsViewModel customerChange(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SmsViewModel branchChange(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SmsViewModel close(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SmsViewModel deliveryDestChange(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SmsViewModel detail(SmsViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
