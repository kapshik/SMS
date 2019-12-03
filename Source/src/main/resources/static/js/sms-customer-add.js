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

    self.doAddItem = function() {
        var branchModel = { "customerNo":"C002",
                            "branchNo":"B002",
                            "branchName":"支店名",
                            "zipcode":"101-0015",
                            "address":"東京都千代田区水道橋",
                            "addressDetail":"尾道ラーメン3階",
                            "telNo":"03-1234-5678",
                            "faxNo":"03-9876-5432"
        };
        self.dataModel.branchModelList.push(branchModel);
    };

    self.doDeleteItem = function() {
        self.dataModel.branchModelList.pop();
    };

	self.bind = function() {
		ko.applyBindings(this);
	};
};

