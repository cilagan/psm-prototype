import Ember from 'ember';

export default Ember.Route.extend({
  // model(params) {
  //
  //   return this.store.findRecord('proposal/cover-sheet', params.proposal_id);
  // }

  model: function () {

    //return this.store.findRecord('proposal/cover-sheet', this.modelFor('proposal').get('proposalId'));

    return this.store.queryRecord('proposal/cover-sheet', { proposalId: this.modelFor('proposal').get('proposalId')});
    // /api/proposal/coverSheets?proposalId=3
  }

});
