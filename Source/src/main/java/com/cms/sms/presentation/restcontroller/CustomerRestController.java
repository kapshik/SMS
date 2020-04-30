package com.cms.sms.presentation.restcontroller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.sms.model.AddressModel;
import com.cms.sms.model.CustomerModel;
import com.cms.sms.model.CustomerViewModel;
import com.cms.sms.model.ValidationErrorModel;
import com.cms.sms.service.common.SmsAddressService;
import com.cms.sms.service.view.SmsViewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class CustomerRestController {

	@Autowired
	HttpSession session;  
	@Autowired
	private SmsViewService<CustomerViewModel> service;
	@Autowired
	private SmsAddressService smsAddressService;
	@Autowired
	SmartValidator validator;
	
	@GetMapping("customer/init")
	public CustomerViewModel init() {
		CustomerViewModel outModel = service.init();
		
		return outModel;
	}
	
	@GetMapping("customer/init_detail")
	public CustomerViewModel init_detail() {
		CustomerViewModel outModel = service.detail((CustomerViewModel)session.getAttribute("customerViewModel"));
		
		return outModel;
	}
	
	@PostMapping("customer/search")
	public CustomerViewModel search(@RequestBody CustomerViewModel inModel) {
		CustomerViewModel outModel = service.search(inModel);

		return outModel;
	}
	
	@GetMapping("customer/search_address")
	public AddressModel search_address(@RequestParam("zipcode") String zipcode) {
		
	    return smsAddressService.getAddressModelByObject(zipcode);
	    
	}
	
	@PostMapping("customer/create")
	public CustomerViewModel create(@RequestBody CustomerViewModel inModel, BindingResult result) {
		CustomerViewModel outModel = inModel;
		
		Class<?> validationGroup = Default.class;
		validator.validate(inModel.getCustomerModel(), result, validationGroup);
	    if (result.hasErrors()) {
	    	CustomerModel cm = new CustomerModel();
	    	for( ObjectError error : result.getAllErrors() ) {
log.info("{} : {}", error.getObjectName(), error.getDefaultMessage());
	    		Field field = ReflectionUtils.findField( CustomerModel.class, error.getObjectName() );
	    		if( !Objects.isNull(field) && !Objects.isNull(error.getDefaultMessage()) ) {
		    		ReflectionUtils.makeAccessible(field);
		            ReflectionUtils.setField(field, cm, error.getDefaultMessage());
	    		}
	    	}
	    	
	    	List<ValidationErrorModel> validationErrorList = new ArrayList<ValidationErrorModel>();
	    	for( FieldError error : result.getFieldErrors() ) {
log.info("{} : {}", error.getField(), error.getDefaultMessage());
	    		Field field = ReflectionUtils.findField( CustomerModel.class, error.getField() );
	    		if( !Objects.isNull(field) && !Objects.isNull(error.getDefaultMessage()) ) {
		    		ReflectionUtils.makeAccessible(field);
		    		if( field.getType().isInstance(new String()) ) {
		    			ReflectionUtils.setField(field, cm, error.getDefaultMessage());
		    		}
	    			ValidationErrorModel validationErrorModel = new ValidationErrorModel(error.getField(), error.getDefaultMessage());
	    			validationErrorList.add(validationErrorModel);
	    		}
	    	}
//			outModel.setCustomerModel(cm);
			outModel.setValidationErrorList(validationErrorList);
	    } else {
			outModel = service.create(inModel);
	    }
		
		return outModel;
	}
	
	@PostMapping("customer/detail")
	public CustomerViewModel detail(@RequestBody CustomerViewModel inModel) {
        CustomerViewModel outModel = Objects.requireNonNull(inModel);
		session.setAttribute("customerViewModel", outModel);

		return outModel;
	}
	
	@PostMapping("customer/delete")
	public CustomerViewModel delete(@RequestBody CustomerViewModel inModel) {
		CustomerViewModel outModel = service.detail(inModel);
		
		return outModel;
	}
	
	@PostMapping("customer/customerChange")
	public CustomerViewModel customerChange(@RequestBody CustomerViewModel inModel) {
		CustomerViewModel outModel = service.customerChange(inModel);
		
		return outModel;
	}
	
}
