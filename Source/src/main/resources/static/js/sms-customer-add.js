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
			self.dataModel.title("顧客登録");
	        self.validationViewModel.init(null);
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
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
        if(!self.validationViewModel.validateAll()) {
            return;
        }
        
        var u = '/customer/create';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
//            console.log( self.dataModel.validationErrorList.length );
            console.log( response.validationErrorList.length );
            if(response.validationErrorList.length > 0) {
                //self.validationViewModel.validationErrorList.removeAll();
                self.validationViewModel.validationErrorList = response.validationErrorList;
                /*
                for( const item of response.validationErrorList ) {
                    //console.log( item.id + " : " + item.message );
                    self.validationViewModel.validationErrorList.push(item);
                    //console.log( response.validationErrorList.find((value) => value.id === item.id).message );
                }
                */
            }
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

