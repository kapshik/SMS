package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksk.sms.common.SmsBeanUtilsBean;
import com.ksk.sms.dao.domain.Product;
import com.ksk.sms.dao.mapper.ProductMapper;
import com.ksk.sms.model.BranchModel;
import com.ksk.sms.model.CustomerModel;
import com.ksk.sms.model.DeliveryDestModel;
import com.ksk.sms.model.OrderModel;
import com.ksk.sms.model.ProductModel;
import com.ksk.sms.model.ProductViewModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductServiceImpl extends SmsService implements SmsViewService<ProductViewModel> {

    @Autowired
    private ProductMapper productMapper;

	@Override
    public ProductViewModel init() {

        ProductViewModel outModel = new ProductViewModel();

		outModel.setUsername(getUsername());
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList(""));
		outModel.setDeliveryDestList(makeDeliveryDestList(""));
		outModel.setProductMasterList(makeProductMasterList());
		outModel.setPaymentTermsList(makePaymentTermsList());

		outModel.setCriteria(new ProductModel());
		outModel.setDetail(new ProductModel());
    	
		outModel.setOrderDetail(new OrderModel());
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
    public ProductViewModel search(ProductViewModel inModel) {

        ProductViewModel outModel = Objects.requireNonNull(inModel);
    	Product criteria = new Product();
    	SmsBeanUtilsBean.copyProperties(criteria, inModel.getCriteria());
    	
		List<ProductModel> productModelList = new ArrayList<ProductModel>();
		List<Product> selectedList = productMapper.findList(criteria);
        for(Product item : selectedList){
			ProductModel productModel = new ProductModel();

    		SmsBeanUtilsBean.copyProperties(productModel, item);

			log.info(productModel.toString());
			productModelList.add(productModel);
		}
		
		outModel.setProductModelList(productModelList);

        return outModel;
    }

    @Override
    public ProductViewModel customerChange(ProductViewModel inModel) {

        ProductViewModel outModel = Objects.requireNonNull(inModel);

    	outModel.setBranchList(makeBranchList(inModel.getCustomerModel().getCustomerNo()));

        return outModel;
    }

    @Override
    public ProductViewModel branchChange(ProductViewModel inModel) {
    	
        ProductViewModel outModel = Objects.requireNonNull(inModel);
    	
    	outModel.setDeliveryDestList(makeDeliveryDestList(inModel.getBranchModel().getBranchNo()));

    	return outModel;

    }

    @Override
    public ProductViewModel close(ProductViewModel inModel) {
    	
        ProductViewModel outModel = Objects.requireNonNull(inModel);

    	return outModel;

    }

	@Override
	public ProductViewModel create(ProductViewModel inModel) {
        ProductViewModel outModel = Objects.requireNonNull(inModel);
        Product product = new Product();
        
    	SmsBeanUtilsBean.copyProperties(product, inModel.getProductModel());
        int iCreated = productMapper.create(product);
    	log.info("Product iCreated {}", iCreated);
    			
        return outModel;
	}

	@Override
	public ProductViewModel update(ProductViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ProductViewModel delete(ProductViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ProductViewModel deliveryDestChange(ProductViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
