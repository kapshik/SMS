package com.ksk.sms.service.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.ksk.sms.common.KeyValue;
import com.ksk.sms.common.SmsUserInfoUtil;
import com.ksk.sms.dao.domain.Branch;
import com.ksk.sms.dao.domain.Customer;
import com.ksk.sms.dao.domain.DeliveryDest;
import com.ksk.sms.dao.mapper.BranchMapper;
import com.ksk.sms.dao.mapper.CustomerMapper;
import com.ksk.sms.dao.mapper.DeliveryDestMapper;
import com.ksk.sms.model.OutStockModel;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SmsService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private DeliveryDestMapper deliveryDestMapper;
	
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

			log.info("Key:{}, Value:{}", customer.getKey(), customer.getValue());
			customerList.add(customer);
		}
		
        return customerList;
    }
	
	protected List<KeyValue> makeBranchList(String inCustomerNo) {
        List<KeyValue> branchList = new ArrayList<KeyValue>();
        Branch criteria = new Branch();
        criteria.setCustomerNo(inCustomerNo);
        
		log.info("inCustomerNo:{}", inCustomerNo);
		List<Branch> selectedList = branchMapper.findList(criteria);
		
        for(Branch item : selectedList){
			KeyValue branch = new KeyValue();

			branch.setKey(item.getBranchNo());
			branch.setValue(item.getBranchName());

			log.info("Key:{}, Value:{}", branch.getKey(), branch.getValue());
			branchList.add(branch);
		}
		
        return branchList;
    }

	protected List<KeyValue> makeDeliveryDestList(String inBranchNo) {
        List<KeyValue> deliveryDestList = new ArrayList<KeyValue>();
        DeliveryDest criteria = new DeliveryDest();
        criteria.setBranchNo(inBranchNo);
        
		log.info("inBranchNo:{}", inBranchNo);
		List<DeliveryDest> selectedList = deliveryDestMapper.findList(criteria);
		
        for(DeliveryDest item : selectedList){
			KeyValue deliveryDest = new KeyValue();

			deliveryDest.setKey(item.getDeliveryDestNo());
			deliveryDest.setValue(item.getDeliveryDestName());

			log.info("Key:{}, Value:{}", deliveryDest.getKey(), deliveryDest.getValue());
			deliveryDestList.add(deliveryDest);
		}
		
        return deliveryDestList;
    }

	protected List<KeyValue> makePaymentTermsList() {
        List<KeyValue> paymentTermsList = new ArrayList<KeyValue>();
		KeyValue paymentTerms = new KeyValue();

		paymentTerms.setKey("0001");
		paymentTerms.setValue("月末締め翌月末支払い");
		paymentTermsList.add(paymentTerms);
		
		paymentTerms.setKey("0002");
		paymentTerms.setValue("月末締め翌月25日手形支払い");
		paymentTermsList.add(paymentTerms);
		
		paymentTerms.setKey("0003");
		paymentTerms.setValue("25日締め翌月末支払い");
		paymentTermsList.add(paymentTerms);
		
		paymentTerms.setKey("0004");
		paymentTerms.setValue("月末締め翌々月10日支払い");
		paymentTermsList.add(paymentTerms);
		
        return paymentTermsList;
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

	protected List<KeyValue> makeProductTypeList() {
        List<KeyValue> productTypeList = new ArrayList<KeyValue>();

        KeyValue productType = new KeyValue();
		productType.setKey("0001");
		productType.setValue("送料別");
		productTypeList.add(productType);
		
		productType = new KeyValue();
		productType.setKey("0002");
		productType.setValue("送料込");
		productTypeList.add(productType);
		
		productType = new KeyValue();
		productType.setKey("0003");
		productType.setValue("その他");
		productTypeList.add(productType);
		
        return productTypeList;
    }

	protected List<KeyValue> makeÙnitTypeList() {
        List<KeyValue> unitTypeList = new ArrayList<KeyValue>();

        KeyValue unitType = new KeyValue();
		unitType.setKey("0001");
		unitType.setValue("本");
		unitTypeList.add(unitType);
		
        unitType = new KeyValue();
		unitType.setKey("0002");
		unitType.setValue("丁");
		unitTypeList.add(unitType);
		
        unitType = new KeyValue();
		unitType.setKey("0003");
		unitType.setValue("個");
		unitTypeList.add(unitType);
		
        unitType = new KeyValue();
		unitType.setKey("0004");
		unitType.setValue("BOX");
		unitTypeList.add(unitType);
		
        return unitTypeList;
    }

	protected List<OutStockModel> makeOutStockList() {
        List<OutStockModel> outStockList = new ArrayList<OutStockModel>();

		Random random = new Random();
		for(int i=1; i<50; i++) {
	        OutStockModel outStock = new OutStockModel();

			outStock.setProductCode("CODE_" + random.nextInt(10)+i);
			outStock.setProductName("商品名　"+ random.nextInt(1000));
			outStock.setNum01(random.nextInt(1000));
			outStock.setNum02(random.nextInt(1000));
			outStock.setNum03(random.nextInt(1000));
			outStock.setNum04(random.nextInt(1000));
			outStock.setNum05(random.nextInt(1000));
			outStock.setNum06(random.nextInt(1000));
			outStock.setNum07(random.nextInt(1000));
			outStock.setNum08(random.nextInt(1000));
			outStock.setNum09(random.nextInt(1000));
			outStock.setNum10(random.nextInt(1000));
			outStock.setNum11(random.nextInt(1000));
			outStock.setNum12(random.nextInt(1000));
			outStock.setNum13(random.nextInt(1000));
			outStock.setNum14(random.nextInt(1000));
			outStock.setNum15(random.nextInt(1000));
			outStock.setNum16(random.nextInt(1000));
			outStock.setNum17(random.nextInt(1000));
			outStock.setNum18(random.nextInt(1000));
			outStock.setNum19(random.nextInt(1000));
			outStock.setNum20(random.nextInt(1000));
			outStock.setNum21(random.nextInt(1000));
			outStock.setNum22(random.nextInt(1000));
			outStock.setNum23(random.nextInt(1000));
			outStock.setNum24(random.nextInt(1000));
			outStock.setNum25(random.nextInt(1000));
			outStock.setNum26(random.nextInt(1000));
			outStock.setNum27(random.nextInt(1000));
			outStock.setNum28(random.nextInt(1000));
			outStock.setNum29(random.nextInt(1000));
			outStock.setNum30(random.nextInt(1000));
			outStock.setNum31(random.nextInt(1000));
			outStock.setSum(random.nextInt(10000));

			outStockList.add(outStock);
		}
        return outStockList;
    }

}
