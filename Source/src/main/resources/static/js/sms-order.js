$(function () {
    // ------------------------------------------------------- //
    // Initialize Page By Server Data
    // ------------------------------------------------------ //
    var viewModel = new sms.vm.order();
    $("#id_main").hide();
    viewModel.doInit({
        success : function() {
        viewModel.bind();
    },
    failed : function() {
        viewModel.bind();
        }
    });
    $("#id_main").show();
});

sms.vm.order = function() {
	var self = this;

	self.messages = ko.observableArray();
	self.handler = new sms.vm.ErrorViewModel();

	self.doInit = function( param ) {
		var u = '/order/init';
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(ko.toJS(response));
console.log("after init" + self.dataModel.userName);
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

    self.doCustomerChange = function() {
        var u = '/order/customerChange';
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
        var u = '/order/search';
console.log("before search" + self.dataModel.userName());
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            ko.mapping.fromJS(response, self.dataModel);
/*
            //TODO 時間がかかる場合は個別に実施
            self.dataModel.orderDataList.removeAll();
            ko.utils.arrayPushAll(self.dataModel.orderDataList, response.orderDataList);

            self.dataModel.productDataList.removeAll();
            ko.utils.arrayPushAll(self.dataModel.productDataList, response.productDataList);
*/
console.log("after search" + response.userName);
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

	self.bind = function() {
		ko.applyBindings(this);
	};
};

