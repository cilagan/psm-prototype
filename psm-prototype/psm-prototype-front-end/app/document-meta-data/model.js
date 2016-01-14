import DS from 'ember-data';

export default DS.Model.extend({

  compositeId:  DS.attr('string'),
  tempPropId:   DS.attr('number'),
  seqNo:        DS.attr('number'),
  sectionType:  DS.attr('string'),
  fileName:     DS.attr('string'),
  size:         DS.attr('number'),
  pages:        DS.attr('number'),
  uploadDate:   DS.attr('date'),
  content:      DS.attr('string'),
  urlend:       DS.attr('string')

  // length:       DS.attr('number'),
  // contentType:  DS.attr('string'),
  // md5:          DS.attr('string'),
});
