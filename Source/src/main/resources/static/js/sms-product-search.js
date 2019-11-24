$(function () {
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
	$('#id_product_menu_3').addClass('active');
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

	self.doInit = function( param ) {
		var u = '/product/init';
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(response);
			self.dataModel.title("商品検索");
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

    self.doCustomerChange = function() {
        var u = '/product/productChange';
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
        var u = '/product/search';
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

    self.doDelete = function() {
        var u = '/product/detete';
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
        var product = {"customerNo":"setCustomerNo1",
                        "productCode":"setProductCode1",
                        "productName":"setProductName1",
                        "quantity":"1",
                        "quantityPerBox":"setQuantityPerBox1",
                        "quantityOfBox":"setQuantityOfBox1",
                        "unitPrice":"setUnitPrice1",
                        "discountPrice":"setDiscountPrice1",
                        "amount":"setAmount1",
                        "productType":"setProductType1",
                        "unitType":"setUnitType1",
                        "remarks":"setRemarks1",
                        "productTypeList":[
                            {"key":"0001","value":"送料別"},
                            {"key":"0002","value":"送料込"},
                            {"key":"0003","value":"その他"}
                        ],
                        "unitTypeList":[
                            {"key":"0001","value":"本"},
                            {"key":"0002","value":"丁"},
                            {"key":"0003","value":"個"},
                            {"key":"0004","value":"BOX"}
                        ],
                        "productMasterList":[
                            {"key":"0000","value":"product 0"},
                            {"key":"0001","value":"product 1"},
                            {"key":"0002","value":"product 2"},
                            {"key":"0003","value":"product 3"},
                            {"key":"0004","value":"product 4"}
                        ]
        };
        self.dataModel.productModelList.push(product);
    };

    self.doDeleteItem = function() {
        self.dataModel.productModelList.pop();
    };

	self.bind = function() {
		ko.applyBindings(this);
	};
};

