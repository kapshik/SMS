package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksk.sms.common.KeyValue;
import com.ksk.sms.dao.domain.Customer;
import com.ksk.sms.dao.mapper.CustomerMapper;
import com.ksk.sms.model.OutStockModel;
import com.ksk.sms.model.SmsViewModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SmsCommonServiceImpl extends SmsService implements SmsViewService<SmsViewModel> {

    @Autowired
    private CustomerMapper customerMapper;
	
	@Override
    public SmsViewModel init() {

		SmsViewModel outModel = new SmsViewModel();

		outModel.setUsername(getUsername());
		outModel.setRole(getRole());
    	
		outModel.setCustomerList(makeCustomerList());
    	outModel.setPaymentTermsList(makePaymentTermsList());

    	outModel.setBranchList(makeBranchList());
		outModel.setDeliveryDestList(makeDeliveryDestList());

    	outModel.setProductMasterList(makeProductMasterList());
		outModel.setProductTypeList(makeProductTypeList());
		outModel.setUnitTypeList(makeÙnitTypeList());

		outModel.setOutStockList(makeOutStockList());
    	
    	log.info("init");
    	return outModel;
    }

	private List<KeyValue> makeCustomerList() {
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
	
	private List<KeyValue> makeBranchList() {
        List<KeyValue> branchList = new ArrayList<KeyValue>();
		
		for(int i=1; i<5; i++) {
			String strNo = Integer.toString(i);
			KeyValue branch = new KeyValue();

			branch.setKey("000"+strNo);
			branch.setValue("Branch "+strNo);
			
			branchList.add(branch);
		}
		
        return branchList;
    }

	private List<KeyValue> makeDeliveryDestList() {
        List<KeyValue> deliveryDestList = new ArrayList<KeyValue>();
		
		for(int i=1; i<5; i++) {
			String strNo = Integer.toString(i);
			KeyValue deliveryDest = new KeyValue();

			deliveryDest.setKey("000"+strNo);
			deliveryDest.setValue("DeliveryDest "+strNo);
			
			deliveryDestList.add(deliveryDest);
		}
		
        return deliveryDestList;
    }

	private List<KeyValue> makeProductMasterList() {
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

	private List<KeyValue> makePaymentTermsList() {
        List<KeyValue> paymentTermsList = new ArrayList<KeyValue>();

		KeyValue paymentTerms = new KeyValue();
		paymentTerms.setKey("0001");
		paymentTerms.setValue("月末締め翌月末支払い");
		paymentTermsList.add(paymentTerms);
		
		paymentTerms = new KeyValue();
		paymentTerms.setKey("0002");
		paymentTerms.setValue("月末締め翌月25日手形支払い");
		paymentTermsList.add(paymentTerms);
		
		paymentTerms = new KeyValue();
		paymentTerms.setKey("0003");
		paymentTerms.setValue("25日締め翌月末支払い");
		paymentTermsList.add(paymentTerms);
		
		paymentTerms = new KeyValue();
		paymentTerms.setKey("0004");
		paymentTerms.setValue("月末締め翌々月10日支払い");
		paymentTermsList.add(paymentTerms);
		
        return paymentTermsList;
    }
	
	private List<KeyValue> makeProductTypeList() {
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

	private List<KeyValue> makeÙnitTypeList() {
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

	private List<OutStockModel> makeOutStockList() {
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

}
