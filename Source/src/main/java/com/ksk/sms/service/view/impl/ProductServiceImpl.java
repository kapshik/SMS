package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ksk.sms.common.SmsBeanUtilsBean;
import com.ksk.sms.dao.domain.Product;
import com.ksk.sms.dao.mapper.ProductMapper;
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
    	
    	//登録・詳細・更新画面用
		outModel.setProductModel(new ProductModel());
		outModel.setDetail(new ProductModel());

    	//検索画面用
		outModel.setCriteria(new ProductModel());
		outModel.setProductModelList(new ArrayList<ProductModel>());

    	return outModel;
    }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public ProductViewModel create(ProductViewModel inModel) {
        ProductViewModel outModel = Objects.requireNonNull(inModel);
        Product product = new Product();
        
    	SmsBeanUtilsBean.copyProperties(product, inModel.getProductModel());
        int iCreated = productMapper.create(product);
    			
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

			productModelList.add(productModel);
		}
		
		outModel.setProductModelList(productModelList);

        return outModel;
    }

	@Override
	public ProductViewModel detail(ProductViewModel inModel) {
		ProductViewModel outModel = Objects.requireNonNull(inModel);

		Product criteria = new Product();
    	SmsBeanUtilsBean.copyProperties(criteria, inModel.getDetail());

    	Product product = productMapper.findOne(criteria);
    	ProductModel productModel = new ProductModel();
    	SmsBeanUtilsBean.copyProperties(productModel, product);
		outModel.setProductModel(productModel);

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
    public ProductViewModel close(ProductViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
    }

    @Override
    public ProductViewModel customerChange(ProductViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
    }

    @Override
    public ProductViewModel branchChange(ProductViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
    }

	@Override
	public ProductViewModel deliveryDestChange(ProductViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
