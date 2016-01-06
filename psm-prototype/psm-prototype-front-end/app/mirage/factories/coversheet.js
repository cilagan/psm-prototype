import Mirage from 'ember-cli-mirage';

export default Mirage.Factory.extend({
  proposalId(i) { return  i+1; },
  // proposalTitle(i) { return `Proposal Title ${i+1}`; }

  fundingMechanism(i) { return `Funding Mechanism ${i+1}`; },
  requestedBudgetAmount(i) { return i+100; },
  submissionDate() {return new Date();}

});
