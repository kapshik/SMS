package com.ksk.sms.service.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ksk.sms.common.KeyValue;
import com.ksk.sms.common.SmsConst;
import com.ksk.sms.common.SmsUserInfoUtil;
import com.ksk.sms.dao.domain.Branch;
import com.ksk.sms.dao.domain.Customer;
import com.ksk.sms.dao.domain.DeliveryDest;
import com.ksk.sms.dao.domain.Reference;
import com.ksk.sms.dao.mapper.BranchMapper;
import com.ksk.sms.dao.mapper.CustomerMapper;
import com.ksk.sms.dao.mapper.DeliveryDestMapper;
import com.ksk.sms.dao.mapper.ReferenceMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SmsService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private DeliveryDestMapper deliveryDestMapper;
    @Autowired
    private ReferenceMapper referenceMapper;
	
	protected String getUsername() {
		log.debug("getUsername");
		return SmsUserInfoUtil.getUsername();
	}

	protected String getRole() {
		return SmsUserInfoUtil.getRole();
	}
	
	protected List<KeyValue> makeCustomerList() {
        List<KeyValue> customerList = new ArrayList<KeyValue>();
		List<Customer> selectedList = customerMapper.findList(new Customer());
		
        for(Customer item : selectedList){
			KeyValue customer = new KeyValue();

			customer.setKey(item.getCustomerNo());
			customer.setValue(item.getCustomerName());

			customerList.add(customer);
		}
		
        return customerList;
    }
	
	protected List<KeyValue> makeBranchList(String inCustomerNo) {
        List<KeyValue> branchList = new ArrayList<KeyValue>();
        Branch criteria = new Branch();
        criteria.setCustomerNo(inCustomerNo);
        
//		log.info("inCustomerNo:{}", inCustomerNo);
		List<Branch> selectedList = branchMapper.findList(criteria);
		
        for(Branch item : selectedList){
			KeyValue branch = new KeyValue();

			branch.setKey(item.getBranchNo());
			branch.setValue(item.getBranchName());

			branchList.add(branch);
		}
		
        return branchList;
    }

	protected List<KeyValue> makeDeliveryDestList(String inBranchNo) {
        List<KeyValue> deliveryDestList = new ArrayList<KeyValue>();
        DeliveryDest criteria = new DeliveryDest();
        criteria.setBranchNo(inBranchNo);
        
//		log.info("inBranchNo:{}", inBranchNo);
		List<DeliveryDest> selectedList = deliveryDestMapper.findList(criteria);
		
        for(DeliveryDest item : selectedList){
			KeyValue deliveryDest = new KeyValue();

			deliveryDest.setKey(item.getDeliveryDestNo());
			deliveryDest.setValue(item.getDeliveryDestName());

			deliveryDestList.add(deliveryDest);
		}
		
        return deliveryDestList;
    }

	protected List<KeyValue> makeProductMasterList() {
        List<KeyValue> productMasterList = new ArrayList<KeyValue>();
		
		for(int i=0; i<5; i++) {
			String strNo = Integer.toString(i);
			KeyValue productMaster = new KeyValue();

			productMaster.setKey("000"+strNo);
			productMaster.setValue("product "+strNo);
			
			productMasterList.add(productMaster);
		}
		
        return productMasterList;
    }

	protected List<KeyValue> makePaymentTermsList() {
        return makeReferenceList(SmsConst.REF_PAYMENT_TERMS);
    }
	
	protected List<KeyValue> makeProductTypeList() {
        return makeReferenceList(SmsConst.REF_PRODUCT_TYPE);
    }

	protected List<KeyValue> makeUnitTypeList() {
        return makeReferenceList(SmsConst.REF_UNIT_TYPE);
    }

	private List<KeyValue> makeReferenceList(String inType) {

        List<KeyValue> kvList = new ArrayList<KeyValue>();
		
		List<Reference> selectedList = referenceMapper.findList(inType);
        for(Reference item : selectedList){
			KeyValue kv = new KeyValue();

			kv.setKey(item.getCode());
			kv.setValue(item.getName());

			kvList.add(kv);
		}
		
        return kvList;
    }

//	protected String getListValue(String inKey) {
//        String outValue = inKey;
//		
//		if( paymentTermsList.contains(inKey) ) {
//	        outValue = paymentTermsList.stream().filter(s->inKey.equals(s)).findFirst();
//		} else if( productTypeList.contains(inKey) ) {
//	        outValue = productTypeList.stream().filter(s->inKey.equals(s)).findFirst();
//		} else if( unitTypeList.contains(inKey) ) {
//	        outValue = unitTypeList.stream().filter(s->inKey.equals(s)).findFirst();
//		}
//			
//        return outValue;
//    }

}
