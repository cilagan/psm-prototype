import Ember from 'ember';

export default Ember.Route.extend({
  model(params) {
    return this.store.findRecord('proposal', params.proposal_id);
    // return this.store.findRecord('model', params.proposal_id);
  }
});
