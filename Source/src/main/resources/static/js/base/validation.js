
const SINGLE_MODE = true;
const MULTIPLE_MODE = false;

sms.validation.pattern = {
    ID_PW : {
        id    : "ID_PW",
        name  : "半額英数字記号8桁",
        regexp: "^[\x20-\x7F]{4,8}"
    },
    ALPHA_NUM_SYM : {
        id    : "ALPHA_NUM_SYM",
        name  : "半額英数字記号",
        regexp: "^[0-9a-zA-Z!-/:-@\[-`{-~]*$"
    },
    ALPHA_NUM : {
        id    : "ALPHA_NUM",
        name  : "半額英数字",
        regexp: "^[0-9a-zA-Z]+$"
    },
    ALPHA : {
        id    : "ALPHA",
        name  : "半額英字",
        regexp: "^[a-zA-Z]+$"
    },
    NUM : {
        id    : "NUM",
        name  : "数字",
        regexp: "^[0-9]*"
    },
    ZIP : {
        id    : "ZIP",
        name  : "郵便番号",
        regexp: "[0-9]{3}-[0-9]{4}"
    },
    TEL : {
        id    : "TEL",
        name  : "電話番号",
        regexp: "0[0-9]{1,4}-[0-9]{3,4}-[0-9]{4}"
    },
    IP : {
        id    : "IP",
        name  : "IPアドレス",
        regexp: "[0-9]{1,3}(\.[0-9]{1,3}){3}$"
    },
    EMAIL : {
        id    : "EMAIL",
        name  : "EMAILアドレス",
        regexp: "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
    },
    DECIMAL : {
        id    : "DECIMAL",
        name  : "小数",
        regexp: "-?([1-9][0-9]*|0)(\.[0-9]+)?$"
    },
    HIRAGANA : {
        id    : "HIRAGANA",
        name  : "全角ひらがな",
        regexp: "[\u3041-\u3096]*"
    },
    KATAKANA : {
        id    : "KATAKANA",
        name  : "全角カタカナ",
        regexp: "[\u30A1-\u30FA]*"
    },
    KANJI : {
        id    : "KANJI",
        name  : "漢字",
        regexp: "[\u3400-\u9FFF]*"
    }
}

sms.validation.pattern.getName = function(patternId) {
    return eval("sms.validation.pattern." + patternId + ".name");
}

sms.validation.pattern.getRegexp = function(patternId) {
    return eval("sms.validation.pattern." + patternId + ".regexp");
}

sms.validation.ViewModel = function() {
    var self = this;
    self.validationErrorList = [];
    
    self.init = function(consistencyCheck) {
        //ボタンの制御
        $('form').on('input', function(event) {
            self.preventExecute(!self.isValidAll());
        });
        //パターン項目の「初期化
        $('input[name^="sms.validation.pattern"]').each( function(index, element) {
            $(element).prop('pattern', eval($(element).prop('name')+".regexp"));
            $(element).prop('title', eval($(element).prop('name')+".name"));
            $(element).prop('placeholder', eval($(element).prop('name')+".name"));
        });
        //ブラウザ依存をなくすため無行にする
        $('input, select, textarea').on('invalid', function(event) {
            event.preventDefault();
        });
        //イベントリスナ登録
        $('input, textarea').each( function(index, element) {
            self.addCommonListener(element);
            $(element).on('change', function(event) {
                sms.validation.setValidationResult(element, SINGLE_MODE, self.getValidationErrorMessage(element.id));
            });
        });
        //イベントリスナ登録
        $('select').each( function(index, element) {
            self.addCommonListener(element);
            $(element).on('change', function(event) {
                $(element).hide(0);
                $(element).get(0).checkValidity();
                sms.validation.setValidationResult(element, SINGLE_MODE, self.getValidationErrorMessage(element.id));
                $(element).show(0).focus();
            });
        });
        //相関チェックは画面に任せる。（コールバック関数を実行）
        if(consistencyCheck !== null) {
            consistencyCheck();
        }
        
        //ボタンの制御（初期設定）
        self.preventExecute(!self.isValidAll());
    }

    self.addCommonListener = function(element) {
        $(element).on('blur', function(event) {
            $(element).siblings('label.help-block').remove();
        });
        $(element).on('mouseleave', function(event) {
            if(!$(element).is(':focus')){
                $(element).siblings('label.help-block').remove();
            }
        });
        $(element).on('focus mouseenter', function(event) {
            sms.validation.setValidationResult(element, SINGLE_MODE, self.getValidationErrorMessage(element.id));
        });
        $(element).on('keyup', function(event) {
            $(element).siblings('label.help-block').remove();
            sms.validation.setValidationResult(element, SINGLE_MODE, self.getValidationErrorMessage(element.id));
        });
    }

    self.isValidAll = function() {
        return $('form').get(0).checkValidity();
    }
    
    self.preventExecute = function(mode) {
        $("div[id='id_main'] button").each( function(index, element) {
            element.disabled = mode;
        });
    }
    
    self.validateAll = function() {
        var result = true;
        
        $('input, select, textarea').each( function(index, element) {
            if(element.willValidate) {
                var checkResult = element.checkValidity(); 
                sms.validation.setValidationResult(element, MULTIPLE_MODE, self.getValidationErrorMessage(element.id));
                result = result && checkResult;
            }
        });
        return result;
    }

    self.getValidationErrorMessage = function(inId) {
        console.log("self.validationErrorList.length : " + self.validationErrorList.length);
        if( self.validationErrorList.length > 0 ) {
            var result = self.validationErrorList.find((value) => value.id === inId);
            if(result !== undefined) {
                return result.message;
            }
        }
        return null;
    }
}

sms.validation.setValidationResult = function(element, isSingleMode, inMessage) {
    if(!element.willValidate) {
        return;
    }
    console.log(element.id + ":" + inMessage);
    if(inMessage == null && element.validity.valid) {
        element.setCustomValidity('');
        $(element).parent('div').parent('div').removeClass('has-error');
        $(element).parent('div').parent('div').addClass('has-success');
        if($(element).siblings('label.help-block').length > 0) {
            $(element).siblings('label.help-block').remove();
        }
    } else {
        $(element).parent('div').parent('div').removeClass('has-success');
        $(element).parent('div').parent('div').addClass('has-error');
        if(isSingleMode && $(element).siblings('label.help-block').length == 0) {
            if( inMessage == null ) {
                $(element).after('<label class="help-block show text-danger" for="' + element.id +'">' + element.validationMessage + '</lavel>');
            } else {
                $(element).after('<label class="help-block show text-danger" for="' + element.id +'">' + inMessage + '</lavel>');
            }
        }
    }
    if(element.pattern === undefined || element.pattern.length <= 0 ) {
        element.setAttribute('title', element.validationMessage);
    }
};
