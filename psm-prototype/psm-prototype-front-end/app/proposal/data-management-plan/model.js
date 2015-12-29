
import DS from 'ember-data';

export default DS.Model.extend({

  uploadDate: DS.attr('date', {
    defaultValue() { return new Date(); }
  }),
  size: DS.attr('number'),
  pages: DS.attr('number'),

  proposal: DS.belongsTo('proposal')
});
