import Ember from 'ember';

export default Ember.Route.extend({
  // model(params) {
  //
  //   return this.store.findRecord('proposal/cover-sheet', params.proposal_id);
  // }

  model: function () {

    let proposal = this.modelFor('proposal');

    // if (proposal.get('cover-sheet'))

    let coversheet = proposal.get('coverSheet');
    return coversheet;

    //TODO: Should check to see if the proposal has a cover-sheet?
    //TODO: If there is a cover-sheet found in the DB, it should be put in the proposal
    //TODO: If the proposal does not have a cover-sheet, and the db does not have a cover-sheet for this proposal, then new cover-sheet


    //Native: GET '/docService/proposal/coverSheets/2'
    //Now with overridden buildURL in the cover-sheet adapter /docService/proposal/:proposal_id/coversheet

    // var cs = this.store.findRecord('proposal.coverSheet', proposal.get('proposalId'));

    //proposal.set('coverSheet', cs);

    // this.store.push(proposal);

    // return cs;
  }

});
