sms.vm.mainmenu = function() {
	var self = this;

	self.messages = ko.observableArray();
	self.handler = new sms.vm.ErrorViewModel();

	self.doInit = function( param ) {
		var u = '/mainmenu/init';
sms.common.log.info( '/mainmenu/init');
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(ko.toJS(response));
sms.common.log.info(response);
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
sms.common.log.info(exception);
		});
	};

	self.bind = function() {
		ko.applyBindings(this);
	};
};

