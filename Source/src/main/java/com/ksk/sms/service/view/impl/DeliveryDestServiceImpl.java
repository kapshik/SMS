package com.ksk.sms.service.view.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksk.sms.common.SmsBeanUtilsBean;
import com.ksk.sms.common.SmsConst;
import com.ksk.sms.dao.domain.DeliveryDest;
import com.ksk.sms.dao.mapper.DeliveryDestMapper;
import com.ksk.sms.model.DeliveryDestModel;
import com.ksk.sms.model.DeliveryDestViewModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DeliveryDestServiceImpl extends SmsService implements SmsViewService<DeliveryDestViewModel> {

    @Autowired
    private DeliveryDestMapper deliveryDestMapper;

	@Override
    public DeliveryDestViewModel init() {

        DeliveryDestViewModel outModel = new DeliveryDestViewModel();

		outModel.setUsername(getUsername());
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList(""));

		outModel.setDeliveryDestModel(new DeliveryDestModel());
    	
log.info("init");
    	return outModel;
    }

	@Override
    public DeliveryDestViewModel search(DeliveryDestViewModel inModel) {

        DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);

        return outModel;
    }

    @Override
    public DeliveryDestViewModel customerChange(DeliveryDestViewModel inModel) {

    	DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);
		DeliveryDestModel deliveryDestModel = inModel.getDeliveryDestModel();
		
    	outModel.setBranchList(makeBranchList(deliveryDestModel.getCustomerNo()));

        return outModel;
    }

	@Override
	public DeliveryDestViewModel create(DeliveryDestViewModel inModel) {
        DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);
        DeliveryDest deliveryDest = new DeliveryDest();
        
    	SmsBeanUtilsBean.copyProperties(deliveryDest, inModel.getDeliveryDestModel());
    	log.info("branch {}", deliveryDest.getDeliveryDestName());
    	log.info("branch {}", deliveryDest.getCustomerNo());
		
        String newNo = deliveryDestMapper.nextNo(deliveryDest);
        deliveryDest.setDeliveryDestNo(SmsConst.DELIVERY_DEST_PREFIX + newNo);
    	
        int iCreated = deliveryDestMapper.create(deliveryDest);
    	log.info("iCreated {}", iCreated);
		
        return outModel;
	}

	@Override
    public DeliveryDestViewModel close(DeliveryDestViewModel inModel) {
    	
        DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);

    	return outModel;

    }

    @Override
    public DeliveryDestViewModel branchChange(DeliveryDestViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
    }

	@Override
	public DeliveryDestViewModel update(DeliveryDestViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public DeliveryDestViewModel delete(DeliveryDestViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public DeliveryDestViewModel deliveryDestChange(DeliveryDestViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
