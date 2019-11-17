package com.ksk.sms.service.view.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksk.sms.common.KeyValue;
import com.ksk.sms.datamodel.BranchData;
import com.ksk.sms.datamodel.CustomerData;
import com.ksk.sms.datamodel.DeliveryDestData;
import com.ksk.sms.datamodel.OrderData;
import com.ksk.sms.datamodel.OrderDataModel;
import com.ksk.sms.datamodel.ProductData;
import com.ksk.sms.service.view.OrderService;

@Service
public class OrderServiceImpl implements  OrderService {

	private static final Logger log = LogManager.getLogger(OrderServiceImpl.class);

	@Override
    public OrderDataModel init() {

        OrderDataModel outModel = new OrderDataModel();

		outModel.setUserName("user kapshik");
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList());
		outModel.setDeliveryDestList(makeDeliveryDestList());
		outModel.setProductMasterList(makeProductMasterList());

		outModel.setOrderCriteria(new OrderData());
		outModel.setOrderDetail(new OrderData());
		outModel.setBranchData(new BranchData());
		outModel.setCustomerData(new CustomerData());
		outModel.setDeliveryDestData(new DeliveryDestData());
    	
		outModel.setOrderDataList(new ArrayList<OrderData>());
		outModel.setProductDataList(new ArrayList<ProductData>());
log.info("init");
    	return outModel;
    }

	@Override
    public OrderDataModel search(OrderDataModel inModel) {

        OrderDataModel outModel = Objects.requireNonNull(inModel);;

log.info("inModel.getUserName = " + inModel.getUserName());
log.info("inModel.getOrderNo = " + inModel.getOrderCriteria().getOrderNo());
//        try {
//			BeanUtils.copyProperties(inModel, outModel);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//    	
//		ObjectMapper mapper = new ObjectMapper();
//		outModel = mapper.convertValue(inModel, OrderDataModel.class);

		outModel.setOrderDetail(makeOrderData("XX"));
		outModel.setBranchData(makeBranchData());
		outModel.setCustomerData(makeCustomerData());
		outModel.setDeliveryDestData(makeDeliveryDestData());
    	
		outModel.setProductDataList(makeProductDataList());
		outModel.setOrderDataList(makeOrderDataList());

    	log.info("search");
log.info("outModel.getUserName = " + outModel.getUserName());
		
        return outModel;
    }

    @Override
    public OrderDataModel customerChange(OrderDataModel inModel) {

        OrderDataModel outModel = new OrderDataModel();

        try {
			BeanUtils.copyProperties(inModel, outModel);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		outModel = mapper.convertValue(inModel, OrderDataModel.class);

    	outModel.setBranchList(makeBranchList());

        return outModel;
    }

    @Override
    public OrderDataModel branchChange(OrderDataModel inModel) {
    	
        OrderDataModel outModel = new OrderDataModel();
    	
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
    public OrderDataModel close(OrderDataModel inModel) {
    	
        OrderDataModel outModel = new OrderDataModel();

    	return outModel;

    }

	private List<KeyValue> makeCustomerList() {
        List<KeyValue> branchList = new ArrayList<KeyValue>();
		
		for(int i=1; i<5; i++) {
			String strNo = Integer.toString(i);
			KeyValue branch = new KeyValue();

			branch.setKey("000"+strNo);
			branch.setValue("Customer "+strNo);
			
			branchList.add(branch);
		}
		
        return branchList;
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

	private List<OrderData> makeOrderDataList() {
		List<OrderData> orderList = new ArrayList<OrderData>();
		
		for(int i=1; i<10; i++) {
			String strNo = Integer.toString(i);
			OrderData orderData = makeOrderData(strNo);
			orderList.add(orderData);
		}

log.info("makeOrderDataList " + orderList.size());
		return orderList;
		
	}
	
	private OrderData makeOrderData(String strNo) {

		OrderData orderData = new OrderData();

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

	private CustomerData makeCustomerData() {

		CustomerData customerData = new CustomerData();

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

	private BranchData makeBranchData() {

		BranchData branchData = new BranchData();

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

	private DeliveryDestData makeDeliveryDestData() {

		DeliveryDestData deliveryDestData = new DeliveryDestData();

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

	private List<ProductData> makeProductDataList() {
		List<ProductData> productList = new ArrayList<ProductData>();
		
		for(int i=1; i<10; i++) {
			String strNo = Integer.toString(i);
			ProductData productData = makeProductData(strNo);
			productList.add(productData);
		}

log.info("makeProductDataList " + productList.size());
		return productList;
		
	}

	private ProductData makeProductData(String strNo) {

		ProductData productData = new ProductData();

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
		productData.setProductMasterList(makeProductMasterList());

		return productData;
		
	}
}
