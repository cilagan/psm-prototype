import DS from 'ember-data';

export default DS.Model.extend({
  proposalId: DS.attr('number'),
  proposalTitle: DS.attr('string'),

  coverSheet: DS.belongsTo('cover-sheet'),
  projectDescription: DS.belongsTo('project-description'),
  dmp: DS.belongsTo('data-management-plan'),
  bioSketches: DS.hasMany('bio-sketch')

});
