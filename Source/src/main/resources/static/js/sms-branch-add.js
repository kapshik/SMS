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
	$('#id_branch_menu_2').addClass('active');
    $('.loading').addClass('hidden');
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

    self.doCustomerChange = function() {
        var u = '/branch/branchChange';
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

    self.doAddItem = function() {
        var deliveryDestModel = { 
                "customerNo":"C003",
                "branchNo":"B003",
                "deliveryDestNo":"D003",
                "deliveryDestName":"納品先",
                "zipcode":"101-0015",
                "address":"東京都千代田区水道橋",
                "addressDetail":"尾道ラーメン3階",
                "telNo":"03-1234-5678",
                "faxNo":"03-9876-5432"
        };
        self.dataModel.deliveryDestModelList.push(deliveryDestModel);
    };

    self.doDeleteItem = function() {
        self.dataModel.deliveryDestModelList.pop();
    };

	self.bind = function() {
		ko.applyBindings(this);
	};
};

