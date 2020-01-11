
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
        regexp: "[0-9]{2,4}-[0-9]{3,4}-[0-9]{3,4}"
    },
    IP : {
        id    : "IP",
        name  : "IPアドレス",
        regexp: "[0-9]{1,3}(\.[0-9]{1,3}){3}$"
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
                sms.validation.setValidationResult(element, SINGLE_MODE);
            });
        });
        //イベントリスナ登録
        $('select').each( function(index, element) {
            self.addCommonListener(element);
            $(element).on('change', function(event) {
                $(element).hide(0);
                $(element).get(0).checkValidity();
                sms.validation.setValidationResult(element, SINGLE_MODE);
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
            sms.validation.setValidationResult(element, SINGLE_MODE);
        });
        $(element).on('keyup', function(event) {
            $(element).siblings('label.help-block').remove();
            sms.validation.setValidationResult(element, SINGLE_MODE);
        });
    }

    self.isValidAll = function() {
        return $('form').get(0).checkValidity();
    }
    
    self.preventExecute = function(mode) {
        $("div[id='id_main_pannel'] button").each( function(index, element) {
            element.disabled = mode;
        });
    }
    
    self.validateAll = function() {
        var result = true;
        
        $('input, select, textarea').each( function(index, element) {
            if(element.willValidate) {
                var checkResult = element.checkValidity(); 
                sms.validation.setValidationResult(element, MULTIPLE_MODE);
                result = result && checkResult;
            }
        });
        return result;
    }
}

sms.validation.setValidationResult = function(element, isSingleMode) {
    if(!element.willValidate) {
        return;
    }
    if(element.validity.valid) {
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
            $(element).after('<label class="help-block show" for"' + element.id +'">' + element.validationMessage + '</lavel>');
        }
    }
    if(element.pattern === undefined || element.pattern.length <= 0 ) {
        element.setAttribute('title', element.validationMessage);
    }
};

sms.model.data.Message = function(msg) {
  var self = this;
  self.code = msg.code;
  self.message = ko.observable(msg.message);
};

sms.model.data.ValidationMessage = function(validation) {
  var self = this;
  self.path = validation.path;
  self.message = validation.message;
  self.fullMessage = ko.computed(function() {
    var key = self.path.substring(self.path.lastIndexOf(".") + 1);
    var p = $('label[for="'+ key +'"]').text();
    return p + ":" + self.message;
  });
};

sms.model.data.ErrorMessage = function(error) {
  var self = this;
  self.code = error.code;
  self.id = error.id;
  self.message = error.message;
  self.status = error.status;
};

sms.vm.ErrorViewModel = function() {
  var self = this;
  self.validations = ko.observableArray([]).extend({ arrayExtensions: true });
  self.errors = ko.observableArray([]).extend({ arrayExtensions: true });
  self.handle = function(xhr, exception) {
    var statusCode = xhr.status;
    switch(statusCode) {
    case 400:
      self.validations.removeAll();
      var error = JSON.parse(xhr.responseText);
      if (error.validationMessages) {
        ko.utils.arrayForEach(error.validationMessages, function(v){
          self.validations.push(new sms.model.data.ValidationMessage(v));
        });
      } else {
        sms.model.ErrorModel.goToSystemError();
      }
      break;
    case 401:
      sms.model.ErrorModel.goToVerifyFound();
      break;
    case 404:
      sms.model.ErrorModel.goToPageNotFound();
      break;
    default:
      sms.model.ErrorModel.goToSystemError();
    }
  };
  self.removeValidationMessage = function() {
    self.validations.removeAll();
  };
  self.removeMessage = function() {
    self.errors.removeAll();
  };
  self.addMessage = function(msg) {
    this.removeMessage();
    self.errors.push(new sms.model.data.ErrorMessage({
      code: "",
      message: msg,
      id: "",
      status: -1
    }));
  };
  self.addError = function(response) {
    var error = JSON.parse(response.responseText);
    self.validations.push(new sms.model.data.ErrorMessage(error));
  };
};

sms.model.ErrorModel = {
  goToVerifyFound : function() {
    window.location = "/error.html"; //401
  },
  goToPageNotFound : function() {
    window.location = "/error.html"; //404
  },
  goToSystemError : function() {
    window.location = "/error.html"; //
  }
};
