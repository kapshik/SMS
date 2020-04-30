package com.cms.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cms.sms.common.SmsBeanUtilsBean;
import com.cms.sms.common.SmsConst;
import com.cms.sms.dao.domain.Branch;
import com.cms.sms.dao.domain.DeliveryDest;
import com.cms.sms.dao.mapper.BranchMapper;
import com.cms.sms.dao.mapper.DeliveryDestMapper;
import com.cms.sms.model.BranchModel;
import com.cms.sms.model.BranchViewModel;
import com.cms.sms.model.DeliveryDestModel;
import com.cms.sms.service.common.SmsService;
import com.cms.sms.service.view.SmsViewService;

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
    	
    	//登録・詳細・更新画面用
		outModel.setBranchModel(new BranchModel());
		outModel.setDetail(new BranchModel());
		//outModel.setCustomerList(makeCustomerList());
    	//TODO リスト無しで確定したら削除
		outModel.setDeliveryDestModel(new DeliveryDestModel());
		outModel.setDeliveryDestModelList(new ArrayList<DeliveryDestModel>());

    	//検索画面用
		outModel.setCriteria(new BranchModel());
		outModel.setBranchModelList(new ArrayList<BranchModel>());

    	return outModel;
    }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public BranchViewModel create(BranchViewModel inModel) {
        BranchViewModel outModel = Objects.requireNonNull(inModel);
        Branch branch = new Branch();
        
    	SmsBeanUtilsBean.copyProperties(branch, inModel.getBranchModel());
		
        String newNo = branchMapper.nextNo(branch);
        branch.setBranchNo(SmsConst.BRANCH_PREFIX + newNo);
    	
        int iCreated = branchMapper.create(branch);
		
		if( inModel.getDeliveryDestModelList().size() > 0 ) {
			List<DeliveryDest> deliveryDestList = new ArrayList<DeliveryDest>();
	        for(DeliveryDestModel item : inModel.getDeliveryDestModelList()){
				DeliveryDest deliveryDest = new DeliveryDest();

		    	SmsBeanUtilsBean.copyProperties(deliveryDest, item);
		    	deliveryDest.setCustomerNo(branch.getBranchNo());

	        	deliveryDestList.add(deliveryDest);
			}
			iCreated = deliveryDestMapper.createAll(deliveryDestList);
		}
		
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

//			log.info(branchModel.toString());
			branchModelList.add(branchModel);
		}
		outModel.setBranchModelList(branchModelList);
		
        return outModel;
    }

	@Override
	public BranchViewModel detail(BranchViewModel inModel) {
        BranchViewModel outModel = Objects.requireNonNull(inModel);

		Branch criteria = new Branch();
    	SmsBeanUtilsBean.copyProperties(criteria, inModel.getDetail());

log.info("criteria.getCustomerNo : ", criteria.getCustomerNo());
        Branch branch = branchMapper.findOne(criteria);
		BranchModel branchModel = new BranchModel();
    	SmsBeanUtilsBean.copyProperties(branchModel, branch);
		outModel.setBranchModel(branchModel);

    	DeliveryDest deliveryDestCriteria = new DeliveryDest();
    	SmsBeanUtilsBean.copyProperties(deliveryDestCriteria, criteria);
		List<DeliveryDest> deliveryDestList = deliveryDestMapper.findList(deliveryDestCriteria);
	log.info("deliveryDestList.size() : {}", deliveryDestList.size());
		if( deliveryDestList.size() > 0 ) {
			List<DeliveryDestModel> deliveryDestModelList = new ArrayList<DeliveryDestModel>();
	        for(DeliveryDest item : deliveryDestList){
				DeliveryDestModel deliveryDestModel = new DeliveryDestModel();

		    	SmsBeanUtilsBean.copyProperties(deliveryDestModel, item);

				deliveryDestModelList.add(deliveryDestModel);
			}
	log.info("deliveryDestModelList.size() : {}", deliveryDestModelList.size());
			outModel.setDeliveryDestModelList(deliveryDestModelList);
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
    public BranchViewModel close(BranchViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
    }

    @Override
    public BranchViewModel customerChange(BranchViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
    }

    @Override
    public BranchViewModel branchChange(BranchViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
    }

	@Override
	public BranchViewModel deliveryDestChange(BranchViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
