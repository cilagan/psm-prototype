import DS from 'ember-data';

export default DS.JSONSerializer.extend({
  normalize: function(typeClass, hash) {
    var fields = Ember.get(typeClass, 'fields');
    fields.forEach(function(field) {
      var payloadField = Ember.String.camelize(field);
      if (field === payloadField) { return; }

      hash[field] = hash[payloadField];
      delete hash[payloadField];
    });
    return this._super.apply(this, arguments);
  }
});
