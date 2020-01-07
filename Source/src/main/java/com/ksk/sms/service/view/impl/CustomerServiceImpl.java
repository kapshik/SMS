package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ksk.sms.common.SmsBeanUtilsBean;
import com.ksk.sms.common.SmsConst;
import com.ksk.sms.dao.domain.Branch;
import com.ksk.sms.dao.domain.Customer;
import com.ksk.sms.dao.domain.Product;
import com.ksk.sms.dao.mapper.BranchMapper;
import com.ksk.sms.dao.mapper.CustomerMapper;
import com.ksk.sms.dao.mapper.ProductMapper;
import com.ksk.sms.model.AddressModel;
import com.ksk.sms.model.BranchModel;
import com.ksk.sms.model.CustomerModel;
import com.ksk.sms.model.CustomerViewModel;
import com.ksk.sms.model.DeliveryDestModel;
import com.ksk.sms.model.ProductModel;
import com.ksk.sms.service.common.SmsAddressService;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerServiceImpl extends SmsService implements SmsViewService<CustomerViewModel> {

    @Autowired
    private SmsAddressService smsAddressService;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private ProductMapper productMapper;
	
	@Override
    public CustomerViewModel init() {

        CustomerViewModel outModel = new CustomerViewModel();

		outModel.setUsername(getUsername());
    	
    	//登録・詳細・更新画面用
		outModel.setCustomerModel(new CustomerModel());
		outModel.setDetail(new CustomerModel());
		//outModel.setPaymentTermsList(makePaymentTermsList());
    	//TODO リスト無しで確定したら削除
		outModel.setBranchModel(new BranchModel());
    	outModel.setBranchModelList(new ArrayList<BranchModel>());
		outModel.setProductModel(new ProductModel());
		outModel.setProductModelList(new ArrayList<ProductModel>());
    	
    	//検索画面用
		outModel.setCriteria(new CustomerModel());
		outModel.setCustomerModelList(new ArrayList<CustomerModel>());

    	return outModel;
    }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public CustomerViewModel create(CustomerViewModel inModel) {
        CustomerViewModel outModel = Objects.requireNonNull(inModel);
        Customer customer = new Customer();
        
    	SmsBeanUtilsBean.copyProperties(customer, inModel.getCustomerModel());
		
        String newNo = customerMapper.nextNo(customer);
		customer.setCustomerNo(SmsConst.CUSTOMER_PREFIX + newNo);

		int iCreated = customerMapper.create(customer);
		if( iCreated > 0 ) {
			outModel.setCustomerModel(new CustomerModel());
		}

    	//TODO リスト無しで確定したら削除
		if( inModel.getBranchModelList().size() > 0 ) {
			List<Branch> branchList = new ArrayList<Branch>();
	        for(BranchModel item : inModel.getBranchModelList()){
				Branch branch = new Branch();

		    	SmsBeanUtilsBean.copyProperties(branch, item);

		    	branch.setCustomerNo(customer.getCustomerNo());
				branchList.add(branch);
			}
			iCreated = branchMapper.createAll(branchList);
		}
		
    	//TODO リスト無しで確定したら削除
		if( inModel.getProductModelList().size() > 0 ) {
			List<Product> productList = new ArrayList<Product>();
	        for(ProductModel item : inModel.getProductModelList()){
				Product product = new Product();

		    	SmsBeanUtilsBean.copyProperties(product, item);

				productList.add(product);
			}
			iCreated = productMapper.createAll(productList);
		}
		
		return outModel;
	}

	@Override
    public CustomerViewModel search(CustomerViewModel inModel) {

        CustomerViewModel outModel = Objects.requireNonNull(inModel);
    	Customer criteria = new Customer();
    	SmsBeanUtilsBean.copyProperties(criteria, inModel.getCriteria());
    	
		List<CustomerModel> customerModelList = new ArrayList<CustomerModel>();
		List<Customer> selectedList = customerMapper.findList(criteria);
        for(Customer item : selectedList){
			CustomerModel customerModel = new CustomerModel();

    		SmsBeanUtilsBean.copyProperties(customerModel, item);

			log.info(customerModel.toString());
			customerModelList.add(customerModel);
		}
		
		outModel.setCustomerModelList(customerModelList);

        return outModel;
    }

	@Override
	public CustomerViewModel detail(CustomerViewModel inModel) {
        CustomerViewModel outModel = Objects.requireNonNull(inModel);

		Customer criteria = new Customer();
    	SmsBeanUtilsBean.copyProperties(criteria, inModel.getDetail());

log.info("criteria.getCustomerNo : ", criteria.getCustomerNo());
        Customer customer = customerMapper.findOne(criteria);
		CustomerModel customerModel = new CustomerModel();
    	SmsBeanUtilsBean.copyProperties(customerModel, customer);
		outModel.setCustomerModel(customerModel);

    	Branch branchCriteria = new Branch();
    	SmsBeanUtilsBean.copyProperties(branchCriteria, criteria);
		List<Branch> branchList = branchMapper.findList(branchCriteria);
	log.info("branchList.size() : {}", branchList.size());
		if( branchList.size() > 0 ) {
			List<BranchModel> branchModelList = new ArrayList<BranchModel>();
	        for(Branch item : branchList){
				BranchModel branchModel = new BranchModel();

		    	SmsBeanUtilsBean.copyProperties(branchModel, item);

				branchModelList.add(branchModel);
			}
	log.info("branchModelList.size() : {}", branchModelList.size());
			outModel.setBranchModelList(branchModelList);
		}
		
    	Product productCriteria = new Product();
    	SmsBeanUtilsBean.copyProperties(productCriteria, criteria);
		List<Product> productList = productMapper.findList(productCriteria);
	log.info("productList.size() : {}", productList.size());
		if( productList.size() > 0 ) {
			List<ProductModel> productModelList = new ArrayList<ProductModel>();
	        for(Product item : productList){
				ProductModel productModel = new ProductModel();

		    	SmsBeanUtilsBean.copyProperties(productModel, item);

				productModelList.add(productModel);
			}
	log.info("productModelList.size() : {}", productModelList.size());
			outModel.setProductModelList(productModelList);
		}

		return outModel;
	}

	@Override
	public CustomerViewModel update(CustomerViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public CustomerViewModel delete(CustomerViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    @Override
    public CustomerViewModel close(CustomerViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
    }

    @Override
    public CustomerViewModel customerChange(CustomerViewModel inModel) {

        CustomerViewModel outModel = Objects.requireNonNull(inModel);

    	outModel.setBranchList(makeBranchList(inModel.getCustomerModel().getCustomerNo()));

        return outModel;
    }

    @Override
    public CustomerViewModel branchChange(CustomerViewModel inModel) {
    	
        CustomerViewModel outModel = Objects.requireNonNull(inModel);
    	
    	outModel.setDeliveryDestList(makeDeliveryDestList(inModel.getBranchModel().getBranchNo()));

    	return outModel;

    }

	@Override
	public CustomerViewModel deliveryDestChange(CustomerViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
}
