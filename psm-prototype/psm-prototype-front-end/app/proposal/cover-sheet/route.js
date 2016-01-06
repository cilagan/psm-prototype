import Ember from 'ember';

export default Ember.Route.extend({

  model: function () {
    let proposal = this.modelFor('proposal');
    let coversheet = proposal.get('coverSheet');

    return coversheet;
  }

});
