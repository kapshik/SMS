$(function () {
    // ------------------------------------------------------- //
    // Initialize Page By Server Data
    // ------------------------------------------------------ //
    var viewModel = new sms.vm.stock();
    viewModel.doInit({
        success : function() {
            viewModel.bind();
        },
        failed : function() {
            viewModel.bind();
        }
    });
    
    var dataTable = $('#id_out_stock_list').DataTable({
        scrollX: true,
        paging: false,
        searching: false,
        ordering: false,
        info: false,
        select: false,
        scrollY: '64vh'
    });
    new $.fn.dataTable.Buttons( dataTable, {
        buttons: [
            {
                extend: 'copyHtml5',
                className: 'btn btn-info btn-sm',
                text: 'Copy to clipboard'
            }, 
            {
                extend: 'csvHtml5',
                className: 'btn btn-primary btn-sm' 
            }, 
            {
                extend: 'excelHtml5',
                title: '株式会社シーエムエス様　出荷履歴',
                className: 'btn btn-danger btn-sm',
                filename: '出荷履歴',
                text: 'Excel Download'
            },
            {
                extend: 'pdfHtml5',
                download: 'open',
                pageSize: 'A3',
                orientation: 'landscape',
                className: 'btn btn-warning btn-sm',
                download: 'open'
            }
        ]
    });
    dataTable.buttons().container().appendTo( '#id_out_stock_list_wrapper .col-md-6:eq(0)' );
    
    
	$('#id_report_menu').collapse('show');
	$('#id_report_menu_1').addClass('active');
    setTimeout( function(){
            $('.loading').addClass('hidden');
    }, LOADING_TIMEOUT);
});

sms.vm.stock = function() {
	var self = this;

	self.messages = ko.observableArray();
	self.handler = new sms.vm.ErrorViewModel();

	self.doInit = function( param ) {
		var u = '/report/init';
		$.ajax({
			type: 'get',
			url: u,
		}).done(function(response) {
			self.dataModel = ko.mapping.fromJS(response);
			self.dataModel.title("在庫管理");
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

    self.doSearch = function() {
        var u = '/report/search';
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

	self.bind = function() {
		ko.applyBindings(this);
	};
};

