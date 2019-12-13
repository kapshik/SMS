package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksk.sms.common.KeyValue;
import com.ksk.sms.common.SmsBeanUtilsBean;
import com.ksk.sms.dao.domain.Branch;
import com.ksk.sms.dao.domain.Customer;
import com.ksk.sms.dao.mapper.BranchMapper;
import com.ksk.sms.dao.mapper.CustomerMapper;
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
    private CustomerMapper customerMapper;
    @Autowired
    private BranchMapper branchMapper;

	@Override
    public BranchViewModel init() {

        BranchViewModel outModel = new BranchViewModel();

		outModel.setUsername(getUsername());
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList());
		outModel.setDeliveryDestList(makeDeliveryDestList());
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

log.info("inModel.getUsername = " + inModel.getUsername());
log.info("inModel.getBranchNo = " + inModel.getCriteria().getBranchNo());

		outModel.setDetail(makeBranchModel("XX"));
		outModel.setBranchModel(makeBranchModel("AA"));
		outModel.setDeliveryDestModel(makeDeliveryDestModel());
		outModel.setProductModel(makeProductModel("XX"));
    	
		outModel.setProductModelList(makeProductModelList());
		outModel.setBranchModelList(makeBranchModelList());

    	log.info("search");
log.info("outModel.getUsername = " + outModel.getUsername());
		
        return outModel;
    }

    @Override
    public BranchViewModel customerChange(BranchViewModel inModel) {

        BranchViewModel outModel = Objects.requireNonNull(inModel);

    	outModel.setBranchList(makeBranchList());

        return outModel;
    }

    @Override
    public BranchViewModel branchChange(BranchViewModel inModel) {
    	
        BranchViewModel outModel = Objects.requireNonNull(inModel);
    	
		outModel.setDeliveryDestList(makeDeliveryDestList());

    	return outModel;

    }

    @Override
    public BranchViewModel close(BranchViewModel inModel) {
    	
        BranchViewModel outModel = Objects.requireNonNull(inModel);

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
	
	private List<BranchModel> makeBranchModelList() {
		List<BranchModel> customerList = new ArrayList<BranchModel>();
		
		for(int i=1; i<10; i++) {
			String strNo = Integer.toString(i);
			BranchModel customerData = makeBranchModel(strNo);
			customerList.add(customerData);
		}

log.info("makeBranchModelList " + customerList.size());
		return customerList;
		
	}
	
	private BranchModel makeBranchModel(String strNo) {

		BranchModel branchData = new BranchModel();

		branchData.setCustomerNo("C002");
		branchData.setBranchNo("B00" + strNo);
		branchData.setBranchName("支店名" + strNo);
		branchData.setZipcode("101-0015");
		branchData.setAddress("東京都千代田区水道橋");
		branchData.setAddressDetail("尾道ラーメン3階" + strNo);
		branchData.setTelNo("03-1234-5678");
		branchData.setFaxNo("03-9876-5432");

		return branchData;
		
	}

	private DeliveryDestModel makeDeliveryDestModel() {

		DeliveryDestModel deliveryDestData = new DeliveryDestModel();

		deliveryDestData.setCustomerNo("C003");
		deliveryDestData.setBranchNo("B003");
		deliveryDestData.setDeliveryDestNo("D003");
		deliveryDestData.setDeliveryDestName("納品先");
		deliveryDestData.setZipcode("101-0015");
		deliveryDestData.setAddress("東京都千代田区水道橋");
		deliveryDestData.setAddressDetail("尾道ラーメン3階");
		deliveryDestData.setTelNo("03-1234-5678");
		deliveryDestData.setFaxNo("03-9876-5432");

		return deliveryDestData;
		
	}

	private List<ProductModel> makeProductModelList() {
		List<ProductModel> productList = new ArrayList<ProductModel>();
		
		for(int i=1; i<10; i++) {
			String strNo = Integer.toString(i);
			ProductModel productData = makeProductModel(strNo);
			productList.add(productData);
		}

log.info("makeProductModelList " + productList.size());
		return productList;
		
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

	private ProductModel makeProductModel(String strNo) {

		ProductModel productData = new ProductModel();

		productData.setCustomerNo("setCustomerNo"+strNo);
		productData.setProductCode("setProductCode"+strNo);
		productData.setProductName("setProductName"+strNo);
		productData.setQuantity(strNo);
		productData.setQuantityPerBox("setQuantityPerBox"+strNo);
		productData.setQuantityOfBox("setQuantityOfBox"+strNo);
		productData.setUnitPrice("setUnitPrice"+strNo);
		productData.setDiscountPrice("setDiscountPrice"+strNo);
		productData.setAmount("setAmount"+strNo);
		productData.setProductType("setProductType"+strNo);
		productData.setUnitType("setUnitType"+strNo);
		productData.setRemarks("setRemarks"+strNo);
		productData.setUnitTypeList(makeÙnitTypeList());
		productData.setProductTypeList(makeProductTypeList());
		productData.setProductMasterList(makeProductMasterList());

		return productData;
		
	}

	@Override
	public BranchViewModel create(BranchViewModel inModel) {
        BranchViewModel outModel = Objects.requireNonNull(inModel);
        Branch branch = new Branch();
        
    	SmsBeanUtilsBean.copyProperties(branch, inModel.getBranchModel());
    	log.info("branch {}", branch.getBranchName());
    	log.info("branch {}", branch.getCustomerNo());
    	
        int iCreated = branchMapper.create(branch);

    	log.info("iCreated {}", iCreated);
		
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
}
