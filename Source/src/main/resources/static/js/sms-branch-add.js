$(function () {
    // ------------------------------------------------------- //
    // Initialize Page By Server Data
    // ------------------------------------------------------ //
    var viewModel = new sms.vm.branch();
    viewModel.doInit({
        success : function() {
        viewModel.bind();
    },
    failed : function() {
        viewModel.bind();
        }
    });
	$('#id_branch_menu').collapse('show');
	$('#id_branch_menu_4').addClass('active');
    setTimeout( function(){
            $('.loading').addClass('hidden');
    }, LOADING_TIMEOUT);
});

// ------------------------------------------------------- //
// ViewModel
// ------------------------------------------------------ //
sms.vm.branch = function() {
	var self = this;

	self.messages = ko.observableArray();
	self.handler = new sms.vm.ErrorViewModel();

	self.doInit = function( param ) {
		var u = '/branch/init';
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(ko.toJS(response));
			self.dataModel.title("支店登録");
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

    self.doSearch = function() {
        var u = '/branch/search';
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
        var u = '/branch/create';
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

    self.doDeliveryDestListAdd = function() {
        var deliveryDest = $.extend({}, ko.mapping.toJS(self.dataModel.deliveryDestModel));
        self.dataModel.deliveryDestModelList.push(deliveryDest);
    };

    self.doDeleteItem = function() {
        self.dataModel.deliveryDestModelList.pop();
    };

	self.bind = function() {
		ko.applyBindings(this);
	};
};

