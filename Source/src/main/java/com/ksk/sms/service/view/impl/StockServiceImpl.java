package com.ksk.sms.service.view.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ksk.sms.common.KeyValue;
import com.ksk.sms.model.BranchModel;
import com.ksk.sms.model.CustomerModel;
import com.ksk.sms.model.DeliveryDestModel;
import com.ksk.sms.model.OrderModel;
import com.ksk.sms.model.ProductModel;
import com.ksk.sms.model.StockViewModel;
import com.ksk.sms.service.view.SmsViewService;

@Service
public class StockServiceImpl implements SmsViewService<StockViewModel> {

	private static final Logger log = LogManager.getLogger(StockServiceImpl.class);

	@Override
    public StockViewModel init() {

        StockViewModel outModel = new StockViewModel();

		outModel.setUserName("user guest");
//		outModel.setTitle("注文管理");
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList());
		outModel.setDeliveryDestList(makeDeliveryDestList());
		outModel.setProductMasterList(makeProductMasterList());
		outModel.setPaymentTermsList(makePaymentTermsList());

		outModel.setCriteria(new OrderModel());
		outModel.setDetail(new OrderModel());
		outModel.setBranchModel(new BranchModel());
		outModel.setCustomerModel(new CustomerModel());
		outModel.setDeliveryDestModel(new DeliveryDestModel());
		outModel.setProductModel(new ProductModel());
    	
		outModel.setOrderModelList(new ArrayList<OrderModel>());
		outModel.setProductModelList(new ArrayList<ProductModel>());
log.info("init");
    	return outModel;
    }

	@Override
    public StockViewModel search(StockViewModel inModel) {

        StockViewModel outModel = Objects.requireNonNull(inModel);

log.info("inModel.getUserName = " + inModel.getUserName());
log.info("inModel.getOrderNo = " + inModel.getCriteria().getOrderNo());

		outModel.setDetail(makeOrderModel("XX"));
		outModel.setBranchModel(makeBranchModel());
		outModel.setCustomerModel(makeCustomerModel());
		outModel.setDeliveryDestModel(makeDeliveryDestModel());
		outModel.setProductModel(makeProductModel("XX"));
    	
		outModel.setProductModelList(makeProductModelList());
		outModel.setOrderModelList(makeOrderModelList());

    	log.info("search");
log.info("outModel.getUserName = " + outModel.getUserName());
		
        return outModel;
    }

    @Override
    public StockViewModel customerChange(StockViewModel inModel) {

        StockViewModel outModel = Objects.requireNonNull(inModel);

    	outModel.setBranchList(makeBranchList());

        return outModel;
    }

    @Override
    public StockViewModel branchChange(StockViewModel inModel) {
    	
        StockViewModel outModel = Objects.requireNonNull(inModel);
    	
        try {
			BeanUtils.copyProperties(inModel, outModel);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		outModel.setDeliveryDestList(makeDeliveryDestList());

    	return outModel;

    }

    @Override
    public StockViewModel close(StockViewModel inModel) {
    	
        StockViewModel outModel = Objects.requireNonNull(inModel);

    	return outModel;

    }

	private List<KeyValue> makeCustomerList() {
        List<KeyValue> customerList = new ArrayList<KeyValue>();
		
		for(int i=1; i<5; i++) {
			String strNo = Integer.toString(i);
			KeyValue customer = new KeyValue();

			customer.setKey("000"+strNo);
			customer.setValue("Customer "+strNo);
			
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
	
	private List<OrderModel> makeOrderModelList() {
		List<OrderModel> orderList = new ArrayList<OrderModel>();
		
		for(int i=1; i<10; i++) {
			String strNo = Integer.toString(i);
			OrderModel orderData = makeOrderModel(strNo);
			orderList.add(orderData);
		}

log.info("makeOrderModelList " + orderList.size());
		return orderList;
		
	}
	
	private OrderModel makeOrderModel(String strNo) {

		OrderModel orderData = new OrderModel();

		orderData.setCustomerNo("001");
		orderData.setBranchNo("001");
		orderData.setDeliveryDestNo("001");
		orderData.setOrderNo(strNo);
		orderData.setShippingLabelNo("ShippingLabel"+strNo);
		orderData.setOrderDate("11/11/2019");
		orderData.setShippingDate("11/22/2019");
		orderData.setDeliveryDate("11/30/2019");
		orderData.setRegistrationDate("11/01/2019");
		orderData.setQuantity("Quantity"+strNo);
		orderData.setUnitPrice("UnitPrice"+strNo);
		orderData.setDiscountUnitPrice("DiscountUnitPrice"+strNo);
		orderData.setMemo("Memo"+strNo);

		return orderData;
		
	}

	private CustomerModel makeCustomerModel() {

		CustomerModel customerData = new CustomerModel();

		customerData.setCustomerNo("C001");
		customerData.setCustomerName("顧客名");
		customerData.setZipcode("101-0015");
		customerData.setAddress("東京都千代田区水道橋");
		customerData.setAddressDetail("尾道ラーメン3階");
		customerData.setTelNo("03-1234-5678");
		customerData.setFaxNo("03-9876-5432");
		customerData.setStartDate("2019/11/22");
		customerData.setPaymentTerms("月末締め翌月末払い");

		return customerData;
		
	}

	private BranchModel makeBranchModel() {

		BranchModel branchData = new BranchModel();

		branchData.setCustomerNo("C002");
		branchData.setBranchNo("B002");
		branchData.setBranchName("支店名");
		branchData.setZipcode("101-0015");
		branchData.setAddress("東京都千代田区水道橋");
		branchData.setAddressDetail("尾道ラーメン3階");
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
	public StockViewModel create(StockViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public StockViewModel update(StockViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public StockViewModel delete(StockViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
