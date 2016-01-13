import DS from 'ember-data';

export default DS.Model.extend({
  proposalId: DS.attr('number'),
  proposalTitle: DS.attr('string'),

  coverSheet: DS.belongsTo('proposal/cover-sheet', {async: true}),

  projectDescription: DS.belongsTo('proposal/project-description', {async: true}),
  // projectDescriptionMetaData: DS.belongsTo('proposal/document-meta-data', {async: true}),

  dmp: DS.belongsTo('proposal/data-management-plan', {async: true}),
  bioSketches: DS.hasMany('proposal/bio-sketch', {async: true})

});
