import Mirage from 'ember-cli-mirage';

export default Mirage.Factory.extend({
  proposalId(i) { return  i; },
  proposalTitle(i) { return `Proposal Title ${i}`; }

});
