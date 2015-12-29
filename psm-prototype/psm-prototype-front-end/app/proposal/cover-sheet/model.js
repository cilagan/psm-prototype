import DS from 'ember-data';

export default DS.Model.extend({

  proposalId: DS.attr('string'),
  temporaryProposalId: DS.attr('string'),
  proposalTitle: DS.attr('string'),
  proposalStatus: DS.attr('string'),
  submissionDate: DS.attr('date'), //submitTimeStamp: DS.attr(''),
  fundingMechanism: DS.attr('string'),
  requestedBudgetAmount: DS.attr('number'),
  proposalDurationInMonth: DS.attr('number'),
  requestedStatingDate: DS.attr('date'),
  hasPreliminaryProposal: DS.attr('boolean'),

  proposal: DS.belongsTo('proposal')

});
