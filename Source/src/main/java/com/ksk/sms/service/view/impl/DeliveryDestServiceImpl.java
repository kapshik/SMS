package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ksk.sms.common.KeyValue;
import com.ksk.sms.model.BranchModel;
import com.ksk.sms.model.DeliveryDestModel;
import com.ksk.sms.model.DeliveryDestViewModel;
import com.ksk.sms.model.ProductModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DeliveryDestServiceImpl extends SmsService implements SmsViewService<DeliveryDestViewModel> {

	@Override
    public DeliveryDestViewModel init() {

        DeliveryDestViewModel outModel = new DeliveryDestViewModel();

		outModel.setUsername(getUsername());
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList());
		outModel.setDeliveryDestList(makeDeliveryDestList());
		outModel.setProductMasterList(makeProductMasterList());
		outModel.setPaymentTermsList(makePaymentTermsList());

		outModel.setCriteria(new DeliveryDestModel());
		outModel.setDetail(new DeliveryDestModel());
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
    public DeliveryDestViewModel search(DeliveryDestViewModel inModel) {

        DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);

log.info("inModel.getUsername = " + inModel.getUsername());
log.info("inModel.getDeliveryDestNo = " + inModel.getCriteria().getDeliveryDestNo());

		outModel.setDetail(makeDeliveryDestModel("BB"));
		outModel.setBranchModel(makeBranchModel("AA"));
		outModel.setDeliveryDestModel(makeDeliveryDestModel("CC"));
		outModel.setProductModel(makeProductModel("XX"));
    	
		outModel.setProductModelList(makeProductModelList());
		outModel.setBranchModelList(makeBranchModelList());
		outModel.setDeliveryDestModelList(makeDeliveryDestModelList());

    	log.info("search");
log.info("outModel.getUsername = " + outModel.getUsername());
		
        return outModel;
    }

    @Override
    public DeliveryDestViewModel customerChange(DeliveryDestViewModel inModel) {

        DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);

    	outModel.setBranchList(makeBranchList());

        return outModel;
    }

    @Override
    public DeliveryDestViewModel branchChange(DeliveryDestViewModel inModel) {
    	
        DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);
    	
		outModel.setDeliveryDestList(makeDeliveryDestList());

    	return outModel;

    }

    @Override
    public DeliveryDestViewModel close(DeliveryDestViewModel inModel) {
    	
        DeliveryDestViewModel outModel = Objects.requireNonNull(inModel);

    	return outModel;

    }

	private List<KeyValue> makeBranchList() {
        List<KeyValue> list = new ArrayList<KeyValue>();
		
		for(int i=1; i<5; i++) {
			String strNo = Integer.toString(i);
			KeyValue item = new KeyValue();

			item.setKey("000"+strNo);
			item.setValue("Branch "+strNo);
			
			list.add(item);
		}
		
        return list;
    }

	private List<KeyValue> makeDeliveryDestList() {
        List<KeyValue> list = new ArrayList<KeyValue>();
		
		for(int i=1; i<5; i++) {
			String strNo = Integer.toString(i);
			KeyValue item = new KeyValue();

			item.setKey("000"+strNo);
			item.setValue("DeliveryDest "+strNo);
			
			list.add(item);
		}
		
        return list;
    }

	private List<BranchModel> makeBranchModelList() {
		List<BranchModel> list = new ArrayList<BranchModel>();
		
		for(int i=1; i<10; i++) {
			String strNo = Integer.toString(i);
			BranchModel customerData = makeBranchModel(strNo);
			list.add(customerData);
		}

log.info("makeBranchModelList " + list.size());
		return list;
		
	}
	
	private BranchModel makeBranchModel(String strNo) {

		BranchModel item = new BranchModel();

		item.setCustomerNo("C002");
		item.setBranchNo("B00" + strNo);
		item.setBranchName("支店名" + strNo);
		item.setZipcode("101-0015");
		item.setAddress("東京都千代田区水道橋");
		item.setAddressDetail("尾道ラーメン3階" + strNo);
		item.setTelNo("03-1234-5678");
		item.setFaxNo("03-9876-5432");

		return item;
		
	}

	private List<DeliveryDestModel> makeDeliveryDestModelList() {
		List<DeliveryDestModel> list = new ArrayList<DeliveryDestModel>();
		
		for(int i=1; i<10; i++) {
			String strNo = Integer.toString(i);
			DeliveryDestModel item = makeDeliveryDestModel(strNo);
			list.add(item);
		}

log.info("makeDeliveryDestModelList " + list.size());
		return list;
		
	}
	
	private DeliveryDestModel makeDeliveryDestModel(String strNo) {

		DeliveryDestModel item = new DeliveryDestModel();

		item.setCustomerNo("C003");
		item.setBranchNo("B003");
		item.setDeliveryDestNo("D003");
		item.setDeliveryDestName("納品先"+strNo);
		item.setZipcode("101-0015");
		item.setAddress("東京都千代田区水道橋");
		item.setAddressDetail("尾道ラーメン3階");
		item.setTelNo("03-1234-5678");
		item.setFaxNo("03-9876-5432");

		return item;
		
	}

	private List<ProductModel> makeProductModelList() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		
		for(int i=1; i<10; i++) {
			String strNo = Integer.toString(i);
			ProductModel item = makeProductModel(strNo);
			list.add(item);
		}

log.info("makeProductModelList " + list.size());
		return list;
		
	}

	private ProductModel makeProductModel(String strNo) {

		ProductModel item = new ProductModel();

		item.setCustomerNo("setCustomerNo"+strNo);
		item.setProductCode("setProductCode"+strNo);
		item.setProductName("setProductName"+strNo);
		item.setQuantity(0);
		item.setQuantityPerBox(0);
		item.setQuantityOfBox(0);
		item.setUnitPrice(0);
		item.setDiscountPrice(0);
		item.setAmount(0);
		item.setProductType("setProductType"+strNo);
		item.setUnitType("setUnitType"+strNo);
		item.setRemarks("setRemarks"+strNo);
		item.setUnitTypeList(makeÙnitTypeList());
		item.setProductTypeList(makeProductTypeList());
		item.setProductMasterList(makeProductMasterList());

		return item;
		
	}

	@Override
	public DeliveryDestViewModel create(DeliveryDestViewModel inModel) {
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
