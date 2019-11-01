/**
 * Common Functions for Sales Management System
 */

const DEBUG_MODE = false;

/***********************************************************
 * Event Listener for Window
 ***********************************************************/
$(window).on('load', function( event ){
	//history.back()先を白ページにする。
	history.pushState(null, null, null);
	
	//scroll positionを自動復元しない。
	history.scrollRestoration = "manual";
});

$(window).on('unload', function( event ){
	//TODO
	//何かあれば。。。
});

$(window).on('hashchange', function( event ){
	//history.back()先を白ページにする。
	history.pushState(null, null, null);
	
	//link入力欄をクリア。
	history.replaceState(null, null, location.pathname);
});

$(window).on('popstate', function( event ){
	//history.back()先を白ページにする。
	history.pushState(null, null, null);
	
	//link入力欄をクリア。
	history.replaceState(null, null, location.pathname);

	event.preventDefault();
});

/***********************************************************
 * Event Listener for Document
 ***********************************************************/
var outOfDocument = false;

$(document).on('mouseenter mouseover', function( event ){
	outOfDocument = false;
});

$(document).on('mouseleave mouseout', function( event ){
	outOfDocument = true;
});

$(document).on('contextmenu', function( event ){
	event.preventDefault();
	
	return false;
});


/***********************************************************
 * Common Functions
 ***********************************************************/
sms.common.ajaxSetup = function() {
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
}

sms.common.loadHtml = function( inLoadList, inCallback ) {

  var cnt = 0;
  $.each( inLoadList, function( i, row ){
    if (!row.url) {
      return;
    }
    
    $(row.id).load(row.url, null, localCallback);
  });

  function localCallback() {
    if ( ++cnt === inLoadList.length ) {
      //sms.common.initTopButton();
      //sms.common.initNavBarButton();
      inCallback();
    }
  }

}

sms.common.log.debug = function( inMessage ) {
	if( DEBUG_MODE ) {
		console.log( inMessage );
	}
}

sms.common.log.info = function( inMessage ) {
	console.log( inMessage );
}

// JSONにKOオブジェクトを変換
function toJSON( data ) {
  var d = ko.toJS(data);
  return ko.toJSON(d);
}

// 数値をカンマ区切りにする
sms.common.formatNumber = function( num ) {
  return String( num ).replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,' );


/**
 * オブジェクトをコピー
 * @param src		コピー元オブジェクト
 * @param trg		コピー先オブジェクト
 */
sms.common.copyObject = function(src, trg){
	for(var key in src) {
		var val = src[key];
		if (typeof val === 'object' && !Array.isArray( val )) {
			sms.common.copyObject(val, trg[key]);
		}
		else {
			if (trg !== undefined && typeof trg[key] === 'function') {
				trg[key](src[key]);
			}
		}
	}
};
