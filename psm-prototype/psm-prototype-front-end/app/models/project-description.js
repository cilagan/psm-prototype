
import DS from 'ember-data';

export default DS.Model.extend({
  //author: DS.attr('string'),
  //title: DS.attr('string'),
//  description: DS.attr('string'),
  uploadDate: DS.attr('date'),
  size: DS.attr('number'),
  pages: DS.attr('number')
});
