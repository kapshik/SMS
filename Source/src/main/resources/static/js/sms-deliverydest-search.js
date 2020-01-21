$(function () {
    // ------------------------------------------------------- //
    // Initialize Page By Server Data
    // ------------------------------------------------------ //
    var viewModel = new sms.vm.deliverydest();
    viewModel.doInit({
        success : function() {
        viewModel.bind();
    },
    failed : function() {
        viewModel.bind();
        }
    });
	$('#id_deliverydest_menu').collapse('show');
	$('#id_deliverydest_menu_3').addClass('active');
    setTimeout( function(){
            $('.loading').addClass('hidden');
    }, LOADING_TIMEOUT);
});

// ------------------------------------------------------- //
// ViewModel
// ------------------------------------------------------ //
sms.vm.deliverydest = function() {
	var self = this;

	self.messages = ko.observableArray();
	self.handler = new sms.vm.ErrorViewModel();
	self.validationViewModel = new sms.validation.ViewModel();

	self.doInit = function( param ) {
		var u = '/deliverydest/init';
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(response);
			self.dataModel.title("納品先検索");
	        self.validationViewModel.init(null);
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

    self.doSearch = function() {
        var u = '/deliverydest/search';
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

        var u = '/deliverydest/create';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
            alert("登録しました!!");
            $('#id_modal_form').get(0).reset();
            $('#id_modal_deliverydest_add').modal('hide');
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

    self.doDetail = function() {
        self.dataModel.detail.customerNo($("#id_deliverydest_list tr.selected td:first").text());
        self.dataModel.detail.branchNo($("#id_deliverydest_list tr.selected td:nth-of-type(2)").text());
        self.dataModel.detail.deliveryDestNo($("#id_deliverydest_list tr.selected td:nth-of-type(3)").text());

        var u = '/deliverydest/detail';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
console.log("To sms-branch-detail.html");
            window.location.href = '/sms-deliverydest-detail.html';
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

    self.doDelete = function() {
        var u = '/deliverydest/detete';
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
		    self.dataModel.deliveryDestModel.address(response.address1+response.address2+response.address3);
		}).fail(function(xhr, exception){
		});
	};

	self.bind = function() {
		ko.applyBindings(this);
	};
};

