$(function () {
    // ------------------------------------------------------- //
    // Datepicker Functionality
    // ------------------------------------------------------ //
    $('.input-datepicker-autoclose').datepicker({
        autoclose: true,
        format: 'yyyy/mm/dd'
    });

    // ------------------------------------------------------- //
    // Initialize Page By Server Data
    // ------------------------------------------------------ //
    var viewModel = new sms.vm.customer();
    viewModel.doInit({
        success : function() {
        viewModel.bind();
    },
    failed : function() {
        viewModel.bind();
        }
    });
	$('#id_customer_menu').collapse('show');
	$('#id_customer_menu_3').addClass('active');
    setTimeout( function(){
            $('.loading').addClass('hidden');
    }, LOADING_TIMEOUT);
});

// ------------------------------------------------------- //
// ViewModel
// ------------------------------------------------------ //
sms.vm.customer = function() {
	var self = this;

	self.messages = ko.observableArray();
	self.handler = new sms.vm.ErrorViewModel();
	self.validationViewModel = new sms.validation.ViewModel();

	self.doInit = function( param ) {
		var u = '/customer/init';
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(response);
			self.dataModel.title("顧客検索");
	        self.validationViewModel.init(null);
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

    self.doCustomerChange = function() {
        var u = '/customer/customerChange';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

    self.doSearch = function() {
        var u = '/customer/search';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

    self.doCreate = function() {
        if(!self.validationViewModel.validateAll()) {
            alert("Validation Error!!");
            return;
        }

        var u = '/customer/create';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
            alert("登録しました!!");
            $('#id_modal_form').get(0).reset();
            $('#id_modal_customer_add').modal('hide');
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

    self.doDetail = function() {
        self.dataModel.detail.customerNo($("#id_customer_list tr.selected td:first").text());
        
        var u = '/customer/detail';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
            window.location.href = '/sms-customer-detail.html';
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

    self.doUpdate = function() {
        alert($("#id_customer_list tr.selected td:nth-of-type(5)").html());
        return;
        
        var u = '/customer/update';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

    self.doDelete = function() {
        alert($("#id_customer_list tr.selected td:nth-child(3)").html());
        return;
        
        var u = '/customer/delete';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

	self.doGetAddress = function( param ) {
	    if(!$('#zipcode').get(0).checkValidity()) {
	        return;
	    }

		var u = 'common/search_address?zipcode=' + $('#zipcode').val();
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
		    self.dataModel.customerModel.address(response.address1+response.address2+response.address3);
		}).fail(function(xhr, exception){
		});
	};

	self.bind = function() {
		ko.applyBindings(this);
	};
};
