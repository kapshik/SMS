ko.extenders.date = function(target, options) {
  target.format = ko.computed({
    read : function() {
      var value = target();
      return moment(value).isValid() ? moment(value).format(options) : value;
    },
    write : function(newValue) {
      var current = target();
      var valueToWrite = moment(newValue).isValid() ? moment(newValue).format(options) : newValue;
      if (valueToWrite !== current) {
        target(valueToWrite);
      } else {
        if (newValue != current) {
          target.notifySubscribers(valueToWrite);
        }
      }
    }
  });
  target.format(target());
  return target;
};

ko.extenders.arrayExtensions = function(target, options) {
  target.filter = function(targetPropertyName, containts) {
    return ko.computed(function() {
      var targetProperty = ko.unwrap(targetPropertyName);
      return ko.utils.arrayFilter(this(), function(item) {
        if (targetProperty) {
          var itemProp = ko.unwrap(item[targetProperty]);
          return itemProp.toString().indexOf(containts) > -1;
        } else {
          return false;
        }
      });
    }, target).extend({arrayExtensions: true});
  };
  target.hasError = function(targetPropertyName, containts) {
    return ko.computed(function() {
      var targetProperty = ko.unwrap(targetPropertyName);
      return ko.utils.arrayFilter(this(), function(item) {
        if (targetProperty) {
          var itemProp = ko.unwrap(item[targetProperty]);
          return itemProp.toString().indexOf(containts) > -1;
        } else {
          return false;
        }
      }).length !== 0 ? true : false;
    }, target).extend({arrayExtensions: true});
  };
  return target;
};
