package gov.nsf.research.psm.rules.factmodel;

import gov.nsf.research.psm.model.AbstractTransferObject;

public class ProposalFactModel extends AbstractTransferObject{

	private static final long serialVersionUID = 703158123487788794L;
	
	private PropWizAnswers propWizAnswers;
	private ProposalTemplate propTemplate;

	public ProposalFactModel(){
		super();
	}
	
	public ProposalFactModel(PropWizAnswers propWizAnswers, ProposalTemplate propTemplate) {
		super();
		this.propWizAnswers = propWizAnswers;
		this.propTemplate = propTemplate;
	}
	
	/**
	 * @return the propWizAnswers
	 */
	public PropWizAnswers getPropWizAnswers() {
		return propWizAnswers;
	}
	/**
	 * @param propWizAnswers the propWizAnswers to set
	 */
	public void setPropWizAnswers(PropWizAnswers propWizAnswers) {
		this.propWizAnswers = propWizAnswers;
	}
	/**
	 * @return the propTemplate
	 */
	public ProposalTemplate getPropTemplate() {
		return propTemplate;
	}
	/**
	 * @param propTemplate the propTemplate to set
	 */
	public void setPropTemplate(ProposalTemplate propTemplate) {
		this.propTemplate = propTemplate;
	}
	
	
}
