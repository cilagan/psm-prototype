/*
* document-meta-data/model.js
*/

import DS from 'ember-data';

export default DS.Model.extend({

  fileName:     DS.attr('string'),
  length:       DS.attr('number'),
  contentType:  DS.attr('string'),
  md5:          DS.attr('string'),
  uploadDate:   DS.attr('date', { defaultValue() { return new Date(); } })

});
