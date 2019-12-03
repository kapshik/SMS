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
