import DS from 'ember-data';

export default DS.Model.extend({
  proposalId: DS.attr('number'),
  proposalTitle: DS.attr('string'),

  coverSheet: DS.belongsTo('proposal/cover-sheet'),
  projectDescription: DS.belongsTo('proposal/project-description'),
  dmp: DS.belongsTo('proposal/data-management-plan'),
  bioSketches: DS.hasMany('proposal/bio-sketch')

});
