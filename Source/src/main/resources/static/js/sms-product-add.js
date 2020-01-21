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
    var viewModel = new sms.vm.product();
    viewModel.doInit({
        success : function() {
        viewModel.bind();
    },
    failed : function() {
        viewModel.bind();
        }
    });
	$('#id_product_menu').collapse('show');
	$('#id_product_menu_4').addClass('active');
    setTimeout( function(){
            $('.loading').addClass('hidden');
    }, LOADING_TIMEOUT);
});

// ------------------------------------------------------- //
// ViewModel
// ------------------------------------------------------ //
sms.vm.product = function() {
	var self = this;

	self.messages = ko.observableArray();
	self.handler = new sms.vm.ErrorViewModel();
	self.validationViewModel = new sms.validation.ViewModel();

	self.doInit = function( param ) {
		var u = '/product/init';
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(response);
			self.dataModel.title("商品登録");
	        self.validationViewModel.init(null);
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

    self.doCreate = function() {
        if(!self.validationViewModel.validateAll()) {
            alert("Validation Error!!");
            return;
        }

        var u = '/product/create';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
            alert("登録しました!!");
            $('form').get(0).reset();
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

	self.bind = function() {
		ko.applyBindings(this);
	};
};
