package com.ksk.sms.service.view.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ksk.sms.common.SmsBeanUtilsBean;
import com.ksk.sms.dao.domain.Branch;
import com.ksk.sms.dao.domain.Customer;
import com.ksk.sms.dao.domain.DeliveryDest;
import com.ksk.sms.dao.domain.Order;
import com.ksk.sms.dao.domain.OrderDetail;
import com.ksk.sms.dao.mapper.BranchMapper;
import com.ksk.sms.dao.mapper.CustomerMapper;
import com.ksk.sms.dao.mapper.DeliveryDestMapper;
import com.ksk.sms.dao.mapper.OrderDetailMapper;
import com.ksk.sms.dao.mapper.OrderMapper;
import com.ksk.sms.model.BranchModel;
import com.ksk.sms.model.CustomerModel;
import com.ksk.sms.model.DeliveryDestModel;
import com.ksk.sms.model.OrderModel;
import com.ksk.sms.model.OrderViewModel;
import com.ksk.sms.model.ProductModel;
import com.ksk.sms.service.common.SmsService;
import com.ksk.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrderServiceImpl extends SmsService implements SmsViewService<OrderViewModel>{

	@Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private BranchMapper branchMapper;
    @Autowired
    private DeliveryDestMapper deliveryDestMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private OrderMapper orderMapper;
    
	@Override
    public OrderViewModel init() {

        OrderViewModel outModel = new OrderViewModel();

		outModel.setUsername(getUsername());
    	
		outModel.setCustomerList(makeCustomerList());
		outModel.setBranchList(makeBranchList(""));
		outModel.setDeliveryDestList(makeDeliveryDestList(""));
		outModel.setProductMasterList(makeProductMasterList());
		outModel.setPaymentTermsList(makePaymentTermsList());

		outModel.setCriteria(new OrderModel());
		outModel.setOrderModel(new OrderModel());
		outModel.setBranchModel(new BranchModel());
		outModel.setCustomerModel(new CustomerModel());
		outModel.setDeliveryDestModel(new DeliveryDestModel());
		outModel.setProductModel(new ProductModel());
    	
		outModel.setOrderModelList(new ArrayList<OrderModel>());
		outModel.setProductModelList(new ArrayList<ProductModel>());
log.info("OrderServiceImpl init");
    	return outModel;
    }

	@Override
    public OrderViewModel search(OrderViewModel inModel) {

        OrderViewModel outModel = Objects.requireNonNull(inModel);
    	Order criteria = new Order();
    	SmsBeanUtilsBean.copyProperties(criteria, inModel.getCriteria());
    	
		List<OrderModel> orderModelList = new ArrayList<OrderModel>();
		List<Order> selectedList = orderMapper.findList(criteria);
        for(Order item : selectedList){
			OrderModel orderModel = new OrderModel();

    		SmsBeanUtilsBean.copyProperties(orderModel, item);

			log.info(orderModel.toString());
			orderModelList.add(orderModel);
		}
		
		outModel.setOrderModelList(orderModelList);

        return outModel;
    }

    @Override
    public OrderViewModel customerChange(OrderViewModel inModel) {

    	OrderViewModel outModel = Objects.requireNonNull(inModel);
		CustomerModel customerModel = inModel.getCustomerModel();
    	Customer criteria = new Customer();
    	criteria.setCustomerNo(customerModel.getCustomerNo());
    	
		Customer customer = customerMapper.findOne(criteria);
		if(Objects.nonNull(customer)) {
	    	SmsBeanUtilsBean.copyProperties(customerModel, customer);
		}
		
    	outModel.setCustomerModel(customerModel);
    	outModel.setBranchList(makeBranchList(customerModel.getCustomerNo()));

        return outModel;
    }

    @Override
    public OrderViewModel branchChange(OrderViewModel inModel) {
    	
    	OrderViewModel outModel = Objects.requireNonNull(inModel);
    	
		BranchModel branchModel = inModel.getBranchModel();
		Branch criteria = new Branch();
    	criteria.setCustomerNo(inModel.getCustomerModel().getCustomerNo());
    	criteria.setBranchNo(branchModel.getBranchNo());
    	
		Branch branch = branchMapper.findOne(criteria);
		if(Objects.nonNull(branch)) {
			SmsBeanUtilsBean.copyProperties(branchModel, branch);
		}

    	outModel.setBranchModel(branchModel);
    	outModel.setDeliveryDestList(makeDeliveryDestList(branchModel.getBranchNo()));
    	
        return outModel;

    }

	@Override
    public OrderViewModel deliveryDestChange(OrderViewModel inModel) {
    	
    	OrderViewModel outModel = Objects.requireNonNull(inModel);
    	
    	DeliveryDestModel deliveryDestModel = inModel.getDeliveryDestModel();
		DeliveryDest criteria = new DeliveryDest();
    	criteria.setCustomerNo(inModel.getCustomerModel().getCustomerNo());
    	criteria.setBranchNo(inModel.getBranchModel().getBranchNo());
    	criteria.setDeliveryDestNo(deliveryDestModel.getDeliveryDestNo());
    	log.info(criteria.toString());
   	
		DeliveryDest deliveryDest = deliveryDestMapper.findOne(criteria);
		if(Objects.nonNull(deliveryDest)) {
			SmsBeanUtilsBean.copyProperties(deliveryDestModel, deliveryDest);
	    	log.info(deliveryDest.toString());
		}

    	outModel.setDeliveryDestModel(deliveryDestModel);

    	log.info("inModel.getCustomerNo = " + inModel.getDeliveryDestModel().getCustomerNo());
    	log.info("inModel.getBranchNo = " + inModel.getDeliveryDestModel().getBranchNo());
    	log.info("outModel.getCustomerNo = " + outModel.getDeliveryDestModel().getCustomerNo());
    	log.info("outModel.getBranchNo = " + outModel.getDeliveryDestModel().getBranchNo());
    	
        return outModel;

    }

	@Override
    public OrderViewModel close(OrderViewModel inModel) {
    	
        OrderViewModel outModel = Objects.requireNonNull(inModel);

    	return outModel;

    }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public OrderViewModel create(OrderViewModel inModel) {
        OrderViewModel outModel = Objects.requireNonNull(inModel);
        Order order = new Order();
        
    	SmsBeanUtilsBean.copyProperties(order, inModel.getOrderModel());
//    	SmsBeanUtilsBean.copyProperties(order, inModel.getCustomerModel());
//    	SmsBeanUtilsBean.copyProperties(order, inModel.getBranchModel());
//    	SmsBeanUtilsBean.copyProperties(order, inModel.getDeliveryDestModel());
    	order.setCustomerNo(inModel.getCustomerModel().getCustomerNo());
    	order.setBranchNo(inModel.getBranchModel().getBranchNo());
    	order.setDeliveryDestNo(inModel.getDeliveryDestModel().getDeliveryDestNo());
    	order.setRegistrationDate(LocalDate.now());
    	order.setRequiredDate(LocalDate.now());
    	order.setStatus("CREATED");
       	log.info(order.toString());
    	
        int iCreated = orderMapper.create(order);
    	log.info("Order iCreated {}", iCreated);
    	log.info("order.getOrderNo {}", order.getOrderNo());

		if( inModel.getProductModelList().size() > 0 ) {
			List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
	        for(ProductModel item : inModel.getProductModelList()){
				OrderDetail orderDetail = new OrderDetail();

		    	SmsBeanUtilsBean.copyProperties(orderDetail, item);
		    	SmsBeanUtilsBean.copyProperties(orderDetail, order);

		    	log.info("orderDetail.orderNo {}", orderDetail.getOrderNo());
				orderDetailList.add(orderDetail);
			}
			iCreated = orderDetailMapper.createAll(orderDetailList);
	    	log.info("OrderDetail iCreated {}", iCreated);
		}
		
        return outModel;
	}

	@Override
	public OrderViewModel update(OrderViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public OrderViewModel delete(OrderViewModel inModel) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
