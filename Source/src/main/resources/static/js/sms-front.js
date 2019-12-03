$(document).ready(function () {

    // ------------------------------------------------------- //
    // Custom Scrollbar
    // ------------------------------------------------------ //
    if ($(window).outerWidth() > 992) {
        $("nav.side-navbar").mCustomScrollbar({
            scrollInertia: 200
        });
    }

    // Main Template Color (style.sea.premium.css)
    var brandPrimary = '#379392';

    // ------------------------------------------------------- //
    // Side Navbar Functionality
    // ------------------------------------------------------ //
    $('#toggle-btn').on('click', function (e) {

        e.preventDefault();

        if ($(window).outerWidth() > 1194) {
            $('nav.side-navbar').toggleClass('shrink');
            $('.page').toggleClass('active');
        } else {
            $('nav.side-navbar').toggleClass('show-sm');
            $('.page').toggleClass('active-sm');
        }
    });

    // ------------------------------------------------------- //
    // Tooltips init
    // ------------------------------------------------------ //    
    $('[data-toggle="tooltip"]').tooltip()

    // ------------------------------------------------------- //
    // Universal Form Validation
    // ------------------------------------------------------ //
    $('.form-validate').each(function() {  
        $(this).validate({
            errorElement: "div",
            errorClass: 'is-invalid',
            validClass: 'is-valid',
            ignore: ':hidden:not(.summernote),.note-editable.card-block',
            errorPlacement: function (error, element) {
                // Add the `invalid-feedback` class to the error element
                error.addClass("invalid-feedback");
                //console.log(element);
                if (element.prop("type") === "checkbox") {
                    error.insertAfter(element.siblings("label"));
                } 
                else {
                    error.insertAfter(element);
                }
            }
        });
    });

    // ------------------------------------------------------- //
    // Material Inputs
    // ------------------------------------------------------ //
    var materialInputs = $('input.input-material');

    // activate labels for prefilled values
    materialInputs.filter(function () {
        return $(this).val() !== "";
    }).siblings('.label-material').addClass('active');

    // move label on focus
    materialInputs.on('focus', function () {
        $(this).siblings('.label-material').addClass('active');
    });

    // remove/keep label on blur
    materialInputs.on('blur', function () {
        $(this).siblings('.label-material').removeClass('active');

        if ($(this).val() !== '') {
            $(this).siblings('.label-material').addClass('active');
        } else {
            $(this).siblings('.label-material').removeClass('active');
        }
    });

    // ------------------------------------------------------- //
    // External links to new window
    // ------------------------------------------------------ //
    $('.external').on('click', function (e) {
        e.preventDefault();
        window.open($(this).attr("href"));
    });

/* 削除または使う画面へ移動
    // ------------------------------------------------------- //
    // Jquery Progress Circle
    // ------------------------------------------------------ //
    var progress_circle = $("#progress-circle").gmpc({
        color: brandPrimary,
        line_width: 5,
        percent: 80
    });
    progress_circle.gmpc('animate', 80, 3000);

    // ------------------------------------------------------- //
    // TouchSpin Functionality
    // ------------------------------------------------------ //
    $("input[name='touchspin-num']").TouchSpin({
        initval: 0,
        min: 0,
        max: 100,
        maxboostedstep: 10,
        postfix: '個',
    });

    $("input[name='touchspin-yen']").TouchSpin({
        initval: 0,
        min: 0,
        max: 10000,
        maxboostedstep: 10,
        postfix: '円',
    });

    // ------------------------------------------------------- //
    // Datepicker Functionality
    // ------------------------------------------------------ //
    $('.input-datepicker-autoclose').datepicker({
        autoclose: true,
        format: 'yyyy/mm/dd'
    });
*/
    // ------------------------------------------------------- //
    // Ajax Functionality
    // ------------------------------------------------------ //
	$.ajaxSetup({
		cache: false,
		global: true,
		timeout: 60000,
		scriptCharset: "UTF-8",
		contentType: "application/json; charset=UTF-8",
		accepts: {
			json: "application/json",
			text: "text/plain"
		}
	});

});

// ------------------------------------------------------- //
// Javascript Object To JSOM
// ------------------------------------------------------ //
function toJSON( data ) {
  var d = ko.toJS(data);
  return ko.toJSON(d);
}

// ------------------------------------------------------- //
// Enable Buttons(Detail, Update, Delete)
// ------------------------------------------------------ //
function doCheckedTableRow() {
    var r = $('input[name="table_radio"]:checked').val();
    if(r) {
        $('.with-table-row').prop("disabled", false);
        $('.with-table-row').removeClass("disabled");
    } else {
        $('.with-table-row').prop("disabled", true);
        $('.with-table-row').addClass("disabled");
    }
};
