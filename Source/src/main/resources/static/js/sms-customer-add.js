$(function () {
    // ------------------------------------------------------- //
    // Datepicker Functionality
    // ------------------------------------------------------ //
    $('.input-datepicker-autoclose').datepicker({
        autoclose: true,
        format: 'yyyy-mm-dd'
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

    self.doCustomerChange = function() {
        var u = '/customer/customerChange';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            //TODO 時間がかかる場合は個別に実施
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

