$(function () {
    // ------------------------------------------------------- //
    // Datepicker Functionality
    // ------------------------------------------------------ //
    $('.input-datepicker-autoclose').datepicker({
        autoclose: true,
        format: 'yyyy/mm/dd'
    });
/*
    $('.zipcode').blur(function(e) {
		var u = 'customer/search_address?zipcode=' + $(this).val();
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
		    $('#address1').val(response.results[0].address1);
		}).fail(function(xhr, exception){
		});
    });
*/
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
	$('#id_customer_menu_4').addClass('active');
	var validationViewModel = new sms.validation.ViewModel();
	validationViewModel.init(null);
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

	self.doInit = function( param ) {
		var u = '/customer/init';
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(response);
			self.dataModel.title("顧客登録");
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

	self.doGetAddress = function( param ) {
		var u = 'common/search_address?zipcode=' + $('#zipcode').val();
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
//            var obj = JSON.parse(response);
//		    $('#address1').val(obj.results[0].address1+obj.results[0].address2+obj.results[0].address3);
//		    $('#address1').val(response.address1+response.address2+response.address3);
		    self.dataModel.customerModel.address(response.address1+response.address2+response.address3);
		}).fail(function(xhr, exception){
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
        var u = '/customer/create';
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

    self.doBranchListAdd = function() {
        var branch = $.extend({}, ko.mapping.toJS(self.dataModel.branchModel));
        self.dataModel.branchModelList.push(branch);
    };

    self.doProductListAdd = function() {
        var product = $.extend({}, ko.mapping.toJS(self.dataModel.productModel));
        self.dataModel.productModelList.push(product);
    };

    self.doDeleteProductItem = function() {
        self.dataModel.productModelList.pop();
    };

    self.doDeleteBranchItem = function() {
        self.dataModel.branchModelList.pop();
    };

	self.bind = function() {
		ko.applyBindings(this);
	};
};

