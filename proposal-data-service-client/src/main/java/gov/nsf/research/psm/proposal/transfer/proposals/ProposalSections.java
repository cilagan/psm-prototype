
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ProposalSections complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProposalSections">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remainderCoverSheet" type="{Proposal-V1.0}RemainderCoverSheet" minOccurs="0"/>
 *         &lt;element name="projectSummary" type="{Proposal-V1.0}ProjectSummary" minOccurs="0"/>
 *         &lt;element name="projectDescription" type="{Proposal-V1.0}ProjectDescription" minOccurs="0"/>
 *         &lt;element name="referencesCited" type="{Proposal-V1.0}ReferencesCited" minOccurs="0"/>
 *         &lt;element name="bioSketches" type="{Proposal-V1.0}BioSketches" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="budget" type="{Proposal-V1.0}Budget" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="budgetJustification" type="{Proposal-V1.0}BudgetJustification" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="currentPendingSupport" type="{Proposal-V1.0}CurrentPendingSupport" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="facilitiesEquipmentResources" type="{Proposal-V1.0}FacilitiesEquipmentResources" minOccurs="0"/>
 *         &lt;element name="dataMgtPlan" type="{Proposal-V1.0}DataMgtPlan" minOccurs="0"/>
 *         &lt;element name="mentoringPlan" type="{Proposal-V1.0}MentoringPlan" minOccurs="0"/>
 *         &lt;element name="otherSupplementaryDoc" type="{Proposal-V1.0}OtherSupplementaryDoc" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deviationAuthorization" type="{Proposal-V1.0}DeviationAuthorization" minOccurs="0"/>
 *         &lt;element name="suggestedReviewers" type="{Proposal-V1.0}SuggestedReviewers" minOccurs="0"/>
 *         &lt;element name="addlSingleCopyDoc" type="{Proposal-V1.0}AddlSingleCopyDoc" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProposalSections", propOrder = {
    "remainderCoverSheet",
    "projectSummary",
    "projectDescription",
    "referencesCited",
    "bioSketches",
    "budget",
    "budgetJustification",
    "currentPendingSupport",
    "facilitiesEquipmentResources",
    "dataMgtPlan",
    "mentoringPlan",
    "otherSupplementaryDoc",
    "deviationAuthorization",
    "suggestedReviewers",
    "addlSingleCopyDoc"
})
public class ProposalSections {

    protected RemainderCoverSheet remainderCoverSheet;
    protected ProjectSummary projectSummary;
    protected ProjectDescription projectDescription;
    protected ReferencesCited referencesCited;
    protected List<BioSketches> bioSketches;
    protected List<Budget> budget;
    protected List<BudgetJustification> budgetJustification;
    protected List<CurrentPendingSupport> currentPendingSupport;
    protected FacilitiesEquipmentResources facilitiesEquipmentResources;
    protected DataMgtPlan dataMgtPlan;
    protected MentoringPlan mentoringPlan;
    protected List<OtherSupplementaryDoc> otherSupplementaryDoc;
    protected DeviationAuthorization deviationAuthorization;
    protected SuggestedReviewers suggestedReviewers;
    protected List<AddlSingleCopyDoc> addlSingleCopyDoc;

    /**
     * Gets the value of the remainderCoverSheet property.
     * 
     * @return
     *     possible object is
     *     {@link RemainderCoverSheet }
     *     
     */
    public RemainderCoverSheet getRemainderCoverSheet() {
        return remainderCoverSheet;
    }

    /**
     * Sets the value of the remainderCoverSheet property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemainderCoverSheet }
     *     
     */
    public void setRemainderCoverSheet(RemainderCoverSheet value) {
        this.remainderCoverSheet = value;
    }

    /**
     * Gets the value of the projectSummary property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectSummary }
     *     
     */
    public ProjectSummary getProjectSummary() {
        return projectSummary;
    }

    /**
     * Sets the value of the projectSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectSummary }
     *     
     */
    public void setProjectSummary(ProjectSummary value) {
        this.projectSummary = value;
    }

    /**
     * Gets the value of the projectDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ProjectDescription }
     *     
     */
    public ProjectDescription getProjectDescription() {
        return projectDescription;
    }

    /**
     * Sets the value of the projectDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectDescription }
     *     
     */
    public void setProjectDescription(ProjectDescription value) {
        this.projectDescription = value;
    }

    /**
     * Gets the value of the referencesCited property.
     * 
     * @return
     *     possible object is
     *     {@link ReferencesCited }
     *     
     */
    public ReferencesCited getReferencesCited() {
        return referencesCited;
    }

    /**
     * Sets the value of the referencesCited property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferencesCited }
     *     
     */
    public void setReferencesCited(ReferencesCited value) {
        this.referencesCited = value;
    }

    /**
     * Gets the value of the bioSketches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bioSketches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBioSketches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BioSketches }
     * 
     * 
     */
    public List<BioSketches> getBioSketches() {
        if (bioSketches == null) {
            bioSketches = new ArrayList<BioSketches>();
        }
        return this.bioSketches;
    }

    /**
     * Gets the value of the budget property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the budget property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBudget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Budget }
     * 
     * 
     */
    public List<Budget> getBudget() {
        if (budget == null) {
            budget = new ArrayList<Budget>();
        }
        return this.budget;
    }

    /**
     * Gets the value of the budgetJustification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the budgetJustification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBudgetJustification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BudgetJustification }
     * 
     * 
     */
    public List<BudgetJustification> getBudgetJustification() {
        if (budgetJustification == null) {
            budgetJustification = new ArrayList<BudgetJustification>();
        }
        return this.budgetJustification;
    }

    /**
     * Gets the value of the currentPendingSupport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currentPendingSupport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrentPendingSupport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrentPendingSupport }
     * 
     * 
     */
    public List<CurrentPendingSupport> getCurrentPendingSupport() {
        if (currentPendingSupport == null) {
            currentPendingSupport = new ArrayList<CurrentPendingSupport>();
        }
        return this.currentPendingSupport;
    }

    /**
     * Gets the value of the facilitiesEquipmentResources property.
     * 
     * @return
     *     possible object is
     *     {@link FacilitiesEquipmentResources }
     *     
     */
    public FacilitiesEquipmentResources getFacilitiesEquipmentResources() {
        return facilitiesEquipmentResources;
    }

    /**
     * Sets the value of the facilitiesEquipmentResources property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilitiesEquipmentResources }
     *     
     */
    public void setFacilitiesEquipmentResources(FacilitiesEquipmentResources value) {
        this.facilitiesEquipmentResources = value;
    }

    /**
     * Gets the value of the dataMgtPlan property.
     * 
     * @return
     *     possible object is
     *     {@link DataMgtPlan }
     *     
     */
    public DataMgtPlan getDataMgtPlan() {
        return dataMgtPlan;
    }

    /**
     * Sets the value of the dataMgtPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataMgtPlan }
     *     
     */
    public void setDataMgtPlan(DataMgtPlan value) {
        this.dataMgtPlan = value;
    }

    /**
     * Gets the value of the mentoringPlan property.
     * 
     * @return
     *     possible object is
     *     {@link MentoringPlan }
     *     
     */
    public MentoringPlan getMentoringPlan() {
        return mentoringPlan;
    }

    /**
     * Sets the value of the mentoringPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link MentoringPlan }
     *     
     */
    public void setMentoringPlan(MentoringPlan value) {
        this.mentoringPlan = value;
    }

    /**
     * Gets the value of the otherSupplementaryDoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherSupplementaryDoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherSupplementaryDoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherSupplementaryDoc }
     * 
     * 
     */
    public List<OtherSupplementaryDoc> getOtherSupplementaryDoc() {
        if (otherSupplementaryDoc == null) {
            otherSupplementaryDoc = new ArrayList<OtherSupplementaryDoc>();
        }
        return this.otherSupplementaryDoc;
    }

    /**
     * Gets the value of the deviationAuthorization property.
     * 
     * @return
     *     possible object is
     *     {@link DeviationAuthorization }
     *     
     */
    public DeviationAuthorization getDeviationAuthorization() {
        return deviationAuthorization;
    }

    /**
     * Sets the value of the deviationAuthorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviationAuthorization }
     *     
     */
    public void setDeviationAuthorization(DeviationAuthorization value) {
        this.deviationAuthorization = value;
    }

    /**
     * Gets the value of the suggestedReviewers property.
     * 
     * @return
     *     possible object is
     *     {@link SuggestedReviewers }
     *     
     */
    public SuggestedReviewers getSuggestedReviewers() {
        return suggestedReviewers;
    }

    /**
     * Sets the value of the suggestedReviewers property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuggestedReviewers }
     *     
     */
    public void setSuggestedReviewers(SuggestedReviewers value) {
        this.suggestedReviewers = value;
    }

    /**
     * Gets the value of the addlSingleCopyDoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addlSingleCopyDoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddlSingleCopyDoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddlSingleCopyDoc }
     * 
     * 
     */
    public List<AddlSingleCopyDoc> getAddlSingleCopyDoc() {
        if (addlSingleCopyDoc == null) {
            addlSingleCopyDoc = new ArrayList<AddlSingleCopyDoc>();
        }
        return this.addlSingleCopyDoc;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.MULTI_LINE_STYLE);
    }

}
