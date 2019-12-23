package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksk.sms.common.SmsBeanUtilsBean;
import com.ksk.sms.common.SmsConst;
import com.ksk.sms.dao.domain.Branch;
import com.ksk.sms.dao.domain.DeliveryDest;
import com.ksk.sms.dao.mapper.BranchMapper;
import com.ksk.sms.dao.mapper.DeliveryDestMapper;
import com.ksk.sms.model.BranchModel;
import com.ksk.sms.model.BranchViewModel;
import com.ksk.sms.model.DeliveryDestModel;
import com.ksk.sms.model.ProductModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BranchServiceImpl extends SmsService implements SmsViewService<BranchViewModel> {

    @Autowired
    private DeliveryDestMapper deliveryDestMapper;
    @Autowired
    private BranchMapper branchMapper;

	@Override
    public BranchViewModel init() {

        BranchViewModel outModel = new BranchViewModel();

		outModel.setUsername(getUsername());
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList(""));
		outModel.setDeliveryDestList(makeDeliveryDestList(""));
		outModel.setProductMasterList(makeProductMasterList());
		outModel.setPaymentTermsList(makePaymentTermsList());

		outModel.setCriteria(new BranchModel());
		outModel.setDetail(new BranchModel());
		outModel.setBranchModel(new BranchModel());
		outModel.setDeliveryDestModel(new DeliveryDestModel());
		outModel.setProductModel(new ProductModel());
    	
		outModel.setBranchModelList(new ArrayList<BranchModel>());
		outModel.setDeliveryDestModelList(new ArrayList<DeliveryDestModel>());
		outModel.setProductModelList(new ArrayList<ProductModel>());
log.info("init");
    	return outModel;
    }

	@Override
    public BranchViewModel search(BranchViewModel inModel) {

        BranchViewModel outModel = Objects.requireNonNull(inModel);
    	Branch criteria = new Branch();
    	SmsBeanUtilsBean.copyProperties(criteria, inModel.getCriteria());
    	
		List<BranchModel> branchModelList = new ArrayList<BranchModel>();
		List<Branch> selectedList = branchMapper.findList(criteria);
        for(Branch item : selectedList){
			BranchModel branchModel = new BranchModel();

    		SmsBeanUtilsBean.copyProperties(branchModel, item);

			log.info(branchModel.toString());
			branchModelList.add(branchModel);
		}
		outModel.setBranchModelList(branchModelList);
		
        return outModel;
    }

    @Override
    public BranchViewModel customerChange(BranchViewModel inModel) {

        BranchViewModel outModel = Objects.requireNonNull(inModel);

       	outModel.setBranchList(makeBranchList(inModel.getCustomerModel().getCustomerNo()));

        return outModel;
    }

    @Override
    public BranchViewModel branchChange(BranchViewModel inModel) {
    	
        BranchViewModel outModel = Objects.requireNonNull(inModel);
    	
    	outModel.setDeliveryDestList(makeDeliveryDestList(inModel.getBranchModel().getBranchNo()));

    	return outModel;

    }

    @Override
    public BranchViewModel close(BranchViewModel inModel) {
    	
        BranchViewModel outModel = Objects.requireNonNull(inModel);

    	return outModel;

    }

	@Override
	public BranchViewModel create(BranchViewModel inModel) {
        BranchViewModel outModel = Objects.requireNonNull(inModel);
        Branch branch = new Branch();
        
    	SmsBeanUtilsBean.copyProperties(branch, inModel.getBranchModel());
    	log.info("branch {}", branch.getBranchName());
    	log.info("branch {}", branch.getCustomerNo());
		
        String newNo = branchMapper.nextNo(branch);
        branch.setBranchNo(SmsConst.BRANCH_PREFIX + newNo);
    	
        int iCreated = branchMapper.create(branch);
    	log.info("iCreated {}", iCreated);
		
		if( inModel.getDeliveryDestModelList().size() > 0 ) {
			List<DeliveryDest> deliveryDestList = new ArrayList<DeliveryDest>();
	        for(DeliveryDestModel item : inModel.getDeliveryDestModelList()){
				DeliveryDest deliveryDest = new DeliveryDest();

		    	SmsBeanUtilsBean.copyProperties(deliveryDest, item);
		    	deliveryDest.setCustomerNo(branch.getBranchNo());

	        	deliveryDestList.add(deliveryDest);
			}
			iCreated = deliveryDestMapper.createAll(deliveryDestList);
	    	log.info("DeliveryDest iCreated {}", iCreated);
		}
		
        return outModel;
	}

	@Override
	public BranchViewModel update(BranchViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BranchViewModel delete(BranchViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BranchViewModel deliveryDestChange(BranchViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
