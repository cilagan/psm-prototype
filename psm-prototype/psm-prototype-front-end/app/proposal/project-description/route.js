import Ember from 'ember';

export default Ember.Route.extend({

  model: function () {
    let proposal = this.modelFor('proposal');
    let pd = proposal.get('projectDescription').get('metaData');
    return pd;
  }

});
