package gov.nsf.research.psm.model.wrapper;

import gov.nsf.research.psm.rules.factmodel.PropWizAnswers;

public class WizardAnswersRequest extends BaseRequest {

	private static final long serialVersionUID = -2827481476051528009L;
	private PropWizAnswers propWizAnswers;

	public WizardAnswersRequest(){
		super();
	}
	
	public WizardAnswersRequest(PropWizAnswers propWizAnswers) {
		super();
		this.propWizAnswers = propWizAnswers;
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
	
}
