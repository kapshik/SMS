package com.ksk.sms.service.view.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ksk.sms.common.SmsBeanUtilsBean;
import com.ksk.sms.dao.domain.Address;
import com.ksk.sms.dao.domain.Branch;
import com.ksk.sms.dao.domain.Customer;
import com.ksk.sms.dao.domain.Product;
import com.ksk.sms.dao.mapper.AddressMapper;
import com.ksk.sms.dao.mapper.BranchMapper;
import com.ksk.sms.dao.mapper.CustomerMapper;
import com.ksk.sms.dao.mapper.ProductMapper;
import com.ksk.sms.model.BranchModel;
import com.ksk.sms.model.CustomerModel;
import com.ksk.sms.model.CustomerViewModel;
import com.ksk.sms.model.DeliveryDestModel;
import com.ksk.sms.model.ProductModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerServiceImpl extends SmsService implements SmsViewService<CustomerViewModel> {

    @Autowired
    private AddressMapper addressMapper;
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
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList(""));
		outModel.setDeliveryDestList(makeDeliveryDestList(""));
		outModel.setProductMasterList(makeProductMasterList());
		outModel.setPaymentTermsList(makePaymentTermsList());

		outModel.setCriteria(new CustomerModel());
		outModel.setDetail(new CustomerModel());
		outModel.setCustomerModel(makeCustomerModel("XX"));
		outModel.setBranchModel(new BranchModel());
		outModel.setDeliveryDestModel(new DeliveryDestModel());
		outModel.setProductModel(new ProductModel());
    	
		outModel.setCustomerModelList(new ArrayList<CustomerModel>());
		outModel.setBranchModelList(new ArrayList<BranchModel>());
		outModel.setProductModelList(new ArrayList<ProductModel>());

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
    public CustomerViewModel close(CustomerViewModel inModel) {
    	
        CustomerViewModel outModel = Objects.requireNonNull(inModel);

    	return outModel;

    }

	private CustomerModel makeCustomerModel(String strNo) {

		CustomerModel customerData = new CustomerModel();
		Address address = addressMapper.findOne("101-0061");
		
		customerData.setCustomerNo("C00" + strNo);
		customerData.setCustomerName("顧客名" + strNo);
		customerData.setZipcode("101-0015");
		customerData.setAddress(address.getKenName() + address.getCityName() + address.getTownName());
		customerData.setAddressDetail("尾道ラーメン3階" + strNo);
		customerData.setTelNo("03-1234-5678");
		customerData.setFaxNo("03-9876-5432");
//		customerData.setStartDate("2019/11/22");
		customerData.setPaymentTerms("月末締め翌月末払い");

		return customerData;
		
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public CustomerViewModel create(CustomerViewModel inModel) {
        CustomerViewModel outModel = Objects.requireNonNull(inModel);
        Customer customer = new Customer();
        
    	SmsBeanUtilsBean.copyProperties(customer, inModel.getCustomerModel());
        int iCreated = customerMapper.create(customer);
    	log.info("Customer iCreated {}", iCreated);
    	log.info("customer.getCustomerNo {}", customer.getCustomerNo());

		if( inModel.getBranchModelList().size() > 0 ) {
			List<Branch> branchList = new ArrayList<Branch>();
	        for(BranchModel item : inModel.getBranchModelList()){
				Branch branch = new Branch();

		    	SmsBeanUtilsBean.copyProperties(branch, item);

		    	log.info("branch.customerNo1 {}", branch.getCustomerNo());
		    	branch.setCustomerNo(customer.getCustomerNo());
		    	log.info("branch.customerNo2 {}", branch.getCustomerNo());
				branchList.add(branch);
			}
			iCreated = branchMapper.createAll(branchList);
	    	log.info("Branch iCreated {}", iCreated);
		}
		
		if( inModel.getProductModelList().size() > 0 ) {
			List<Product> productList = new ArrayList<Product>();
	        for(ProductModel item : inModel.getProductModelList()){
				Product product = new Product();

		    	SmsBeanUtilsBean.copyProperties(product, item);

				productList.add(product);
			}
			iCreated = productMapper.createAll(productList);
	    	log.info("Product iCreated {}", iCreated);
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
	public CustomerViewModel deliveryDestChange(CustomerViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
}
