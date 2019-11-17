$(function () {
    var basicNoUISlider = $('#basicNoUISlider');
    if (basicNoUISlider.length > 0) {
        noUiSlider.create(basicNoUISlider[0], { // we need to pass only the element, not jQuery object
            start: [20, 80],
            range: {
                'min': [0],
                'max': [100]
            }
        });

    }

    var stepNoUISlider = $('#stepNoUISlider');
    if (stepNoUISlider.length > 0) {
        noUiSlider.create(stepNoUISlider[0], { // we need to pass only the element, not jQuery object
            start: [200, 1000],
            range: {
                'min': [0],
                'max': [1800]
            },
            step: 100,
            tooltips: true,
            connect: true
        });
    }    

    $('.input-datepicker').datepicker({
        format: 'mm/dd/yyyy'
    });

    $('.input-datepicker-autoclose').datepicker({
        autoclose: true,
        format: 'mm/dd/yyyy'
    });

    $('.input-datepicker-multiple').datepicker({
        multidate: true,
        format: 'mm/dd/yyyy'
    });

    $('.input-datepicker-range').datepicker({
        format: 'mm/dd/yyyy'
    });

    $("input[name='touchspin0']").TouchSpin({
        buttondown_class: 'btn btn-secondary',
        buttonup_class: 'btn btn-secondary'
    });
    $("input[name='touchspin1']").TouchSpin({
        min: 0,
        max: 100,
        step: 0.1,
        decimals: 2,
        boostat: 5,
        maxboostedstep: 10,
        postfix: '%',
        buttondown_class: 'btn btn-secondary',
        buttonup_class: 'btn btn-secondary'
    });

    $("input[name='touchspin2']").TouchSpin({
        min: -1000000000,
        max: 1000000000,
        step: 50,
        maxboostedstep: 10000000,
        prefix: '$',
        buttondown_class: 'btn btn-secondary',
        buttonup_class: 'btn btn-secondary'
    });

    $('.selectpicker-primary').selectpicker({
        style: 'btn-primary',
        size: 4
    });

    $('.selectpicker-secondary').selectpicker({
        style: 'btn-secondary',
        size: 4
    });

    $('.selectpicker-light').selectpicker({
        style: 'btn-outline-light',
        size: 4
    });

    $('#multiselect1').multiSelect();

    $(document).on('sidebarChanged', function () {
        dataTable.columns.adjust();
        dataTable.responsive.recalc();
        dataTable.responsive.rebuild();
    });

/*
console.log("DataTable");

    var dataTable = $('#id_order_list').DataTable({
//        scrollX: true,
//        paging: false,
//        searching: false,
//        info: false,
        select: true,
//        dom: 'Bfrtip',
        buttons: 
        [
            {
                extend: 'copy',
                "className": 'btn btn-info btn-xs' 
            }, 
            {
                extend: 'csvHtml5',
                "className": 'btn btn-info btn-xs' 
            }, 
            {
                extend: 'excelHtml5',
                "className": 'btn btn-info btn-xs' 
            }, 
            {
                extend: 'pdf',
                download: 'open',
                "className": 'btn btn-info btn-xs' 
            }, 
            {
                extend: 'print',
                "className": 'btn btn-info btn-xs' 
            }
        ]
    });

    dataTable.on( 'select', function ( e, dt, type, indexes ) {
        var rowData = dataTable.rows(indexes).data().toArray();
        $('#id_order_selected').text(JSON.stringify(rowData));
        $('.with-table-row').prop("disabled", false);
    } )
    .on( 'deselect', function ( e, dt, type, indexes ) {
        var rowData = dataTable.rows(indexes).data().toArray();
        $('#id_order_selected').text("");
        $('.with-table-row').prop("disabled", true);
    });

//    $('#id_btn_order_delete').on('click', function () {
//        dataTable.button( '0-3' ).trigger();
//    });
*/

    sms.common.ajaxSetup();

console.log("new sms.vm.order");
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
			param.success();
		}).fail(function(xhr, exception){
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			param.failed();
		});
	};

    self.doCustomerChange = function( param ) {
        var u = '/order/customerChange';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            //TODO 時間がかかる場合は個別に実施
			self.dataModel = ko.mapping.fromJS(ko.toJS(response));
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

    self.doSearch = function( param ) {
        var u = '/order/search';
        $.ajax({
            type: 'post',
            url: u,
            data: toJSON(self.dataModel)
          }).done(function(response) {
            //TODO 時間がかかる場合は個別に実施
            self.dataModel.orderDataList.removeAll();
            ko.utils.arrayPushAll(self.dataModel.orderDataList, response.orderDataList);
          }).fail(function(xhr, exception){
            self.messages.removeAll();
            self.handler.handle(xhr, exception);
        });
    };

	self.bind = function() {
		ko.applyBindings(this);
	};
};

