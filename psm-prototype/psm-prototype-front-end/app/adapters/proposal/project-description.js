import DS from 'ember-data';

export default DS.RESTAdapter.extend( {
  namespace: 'docService',

  buildURL: function (modelName, id, snapshot, requestType, query) {
    var url = this._super();
    switch (requestType) {
      case 'deleteRecord':
        url += '/delete';
      case 'createRecord':
      case 'findRecord':
      case 'updateRecord':
        url += '/proposal/'+id+'/projdesc';
        return url;
    }
  }

});
