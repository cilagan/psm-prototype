
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for Budget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Budget">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}Section">
 *       &lt;sequence>
 *         &lt;element name="budgetYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="performingOrganizationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="otherSeniorPersonnelBudget" type="{Proposal-V1.0}BudgetInfo" minOccurs="0"/>
 *         &lt;element name="postDoctoralScholarBudget" type="{Proposal-V1.0}BudgetInfo" minOccurs="0"/>
 *         &lt;element name="otherProfessionalsBudget" type="{Proposal-V1.0}BudgetInfo" minOccurs="0"/>
 *         &lt;element name="graduateStudentsBudget" type="{Proposal-V1.0}BudgetInfo" minOccurs="0"/>
 *         &lt;element name="undergraduateStudentsBudget" type="{Proposal-V1.0}BudgetInfo" minOccurs="0"/>
 *         &lt;element name="secretarialBudget" type="{Proposal-V1.0}BudgetInfo" minOccurs="0"/>
 *         &lt;element name="otherStaffBudget" type="{Proposal-V1.0}BudgetInfo" minOccurs="0"/>
 *         &lt;element name="snrPersonnelBudget" type="{Proposal-V1.0}SeniorPersonnelBudget" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="equipmentCost" type="{Proposal-V1.0}EquipmentCost" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="indirectCost" type="{Proposal-V1.0}IndirectCost" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fringeBenefitsDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="foreignTravelDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="domesticTravelDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="participantSupportCost" type="{Proposal-V1.0}ParticipantSupportCost" minOccurs="0"/>
 *         &lt;element name="otherDirectCost" type="{Proposal-V1.0}OtherDirectCost" minOccurs="0"/>
 *         &lt;element name="residualFunds" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="costSharingDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Budget", propOrder = {
    "budgetYear",
    "performingOrganizationId",
    "revisionNumber",
    "otherSeniorPersonnelBudget",
    "postDoctoralScholarBudget",
    "otherProfessionalsBudget",
    "graduateStudentsBudget",
    "undergraduateStudentsBudget",
    "secretarialBudget",
    "otherStaffBudget",
    "snrPersonnelBudget",
    "equipmentCost",
    "indirectCost",
    "fringeBenefitsDollars",
    "foreignTravelDollars",
    "domesticTravelDollars",
    "participantSupportCost",
    "otherDirectCost",
    "residualFunds",
    "costSharingDollars"
})
public class Budget
    extends Section
{

    protected int budgetYear;
    @XmlElement(required = true)
    protected String performingOrganizationId;
    protected Integer revisionNumber;
    protected BudgetInfo otherSeniorPersonnelBudget;
    protected BudgetInfo postDoctoralScholarBudget;
    protected BudgetInfo otherProfessionalsBudget;
    protected BudgetInfo graduateStudentsBudget;
    protected BudgetInfo undergraduateStudentsBudget;
    protected BudgetInfo secretarialBudget;
    protected BudgetInfo otherStaffBudget;
    protected List<SeniorPersonnelBudget> snrPersonnelBudget;
    protected List<EquipmentCost> equipmentCost;
    protected List<IndirectCost> indirectCost;
    protected BigDecimal fringeBenefitsDollars;
    protected BigDecimal foreignTravelDollars;
    protected BigDecimal domesticTravelDollars;
    protected ParticipantSupportCost participantSupportCost;
    protected OtherDirectCost otherDirectCost;
    protected BigDecimal residualFunds;
    protected BigDecimal costSharingDollars;

    /**
     * Gets the value of the budgetYear property.
     * 
     */
    public int getBudgetYear() {
        return budgetYear;
    }

    /**
     * Sets the value of the budgetYear property.
     * 
     */
    public void setBudgetYear(int value) {
        this.budgetYear = value;
    }

    /**
     * Gets the value of the performingOrganizationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformingOrganizationId() {
        return performingOrganizationId;
    }

    /**
     * Sets the value of the performingOrganizationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformingOrganizationId(String value) {
        this.performingOrganizationId = value;
    }

    /**
     * Gets the value of the revisionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRevisionNumber() {
        return revisionNumber;
    }

    /**
     * Sets the value of the revisionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRevisionNumber(Integer value) {
        this.revisionNumber = value;
    }

    /**
     * Gets the value of the otherSeniorPersonnelBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetInfo }
     *     
     */
    public BudgetInfo getOtherSeniorPersonnelBudget() {
        return otherSeniorPersonnelBudget;
    }

    /**
     * Sets the value of the otherSeniorPersonnelBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetInfo }
     *     
     */
    public void setOtherSeniorPersonnelBudget(BudgetInfo value) {
        this.otherSeniorPersonnelBudget = value;
    }

    /**
     * Gets the value of the postDoctoralScholarBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetInfo }
     *     
     */
    public BudgetInfo getPostDoctoralScholarBudget() {
        return postDoctoralScholarBudget;
    }

    /**
     * Sets the value of the postDoctoralScholarBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetInfo }
     *     
     */
    public void setPostDoctoralScholarBudget(BudgetInfo value) {
        this.postDoctoralScholarBudget = value;
    }

    /**
     * Gets the value of the otherProfessionalsBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetInfo }
     *     
     */
    public BudgetInfo getOtherProfessionalsBudget() {
        return otherProfessionalsBudget;
    }

    /**
     * Sets the value of the otherProfessionalsBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetInfo }
     *     
     */
    public void setOtherProfessionalsBudget(BudgetInfo value) {
        this.otherProfessionalsBudget = value;
    }

    /**
     * Gets the value of the graduateStudentsBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetInfo }
     *     
     */
    public BudgetInfo getGraduateStudentsBudget() {
        return graduateStudentsBudget;
    }

    /**
     * Sets the value of the graduateStudentsBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetInfo }
     *     
     */
    public void setGraduateStudentsBudget(BudgetInfo value) {
        this.graduateStudentsBudget = value;
    }

    /**
     * Gets the value of the undergraduateStudentsBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetInfo }
     *     
     */
    public BudgetInfo getUndergraduateStudentsBudget() {
        return undergraduateStudentsBudget;
    }

    /**
     * Sets the value of the undergraduateStudentsBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetInfo }
     *     
     */
    public void setUndergraduateStudentsBudget(BudgetInfo value) {
        this.undergraduateStudentsBudget = value;
    }

    /**
     * Gets the value of the secretarialBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetInfo }
     *     
     */
    public BudgetInfo getSecretarialBudget() {
        return secretarialBudget;
    }

    /**
     * Sets the value of the secretarialBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetInfo }
     *     
     */
    public void setSecretarialBudget(BudgetInfo value) {
        this.secretarialBudget = value;
    }

    /**
     * Gets the value of the otherStaffBudget property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetInfo }
     *     
     */
    public BudgetInfo getOtherStaffBudget() {
        return otherStaffBudget;
    }

    /**
     * Sets the value of the otherStaffBudget property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetInfo }
     *     
     */
    public void setOtherStaffBudget(BudgetInfo value) {
        this.otherStaffBudget = value;
    }

    /**
     * Gets the value of the snrPersonnelBudget property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snrPersonnelBudget property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnrPersonnelBudget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SeniorPersonnelBudget }
     * 
     * 
     */
    public List<SeniorPersonnelBudget> getSnrPersonnelBudget() {
        if (snrPersonnelBudget == null) {
            snrPersonnelBudget = new ArrayList<SeniorPersonnelBudget>();
        }
        return this.snrPersonnelBudget;
    }

    /**
     * Gets the value of the equipmentCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipmentCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipmentCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EquipmentCost }
     * 
     * 
     */
    public List<EquipmentCost> getEquipmentCost() {
        if (equipmentCost == null) {
            equipmentCost = new ArrayList<EquipmentCost>();
        }
        return this.equipmentCost;
    }

    /**
     * Gets the value of the indirectCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indirectCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndirectCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndirectCost }
     * 
     * 
     */
    public List<IndirectCost> getIndirectCost() {
        if (indirectCost == null) {
            indirectCost = new ArrayList<IndirectCost>();
        }
        return this.indirectCost;
    }

    /**
     * Gets the value of the fringeBenefitsDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFringeBenefitsDollars() {
        return fringeBenefitsDollars;
    }

    /**
     * Sets the value of the fringeBenefitsDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFringeBenefitsDollars(BigDecimal value) {
        this.fringeBenefitsDollars = value;
    }

    /**
     * Gets the value of the foreignTravelDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForeignTravelDollars() {
        return foreignTravelDollars;
    }

    /**
     * Sets the value of the foreignTravelDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForeignTravelDollars(BigDecimal value) {
        this.foreignTravelDollars = value;
    }

    /**
     * Gets the value of the domesticTravelDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDomesticTravelDollars() {
        return domesticTravelDollars;
    }

    /**
     * Sets the value of the domesticTravelDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDomesticTravelDollars(BigDecimal value) {
        this.domesticTravelDollars = value;
    }

    /**
     * Gets the value of the participantSupportCost property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantSupportCost }
     *     
     */
    public ParticipantSupportCost getParticipantSupportCost() {
        return participantSupportCost;
    }

    /**
     * Sets the value of the participantSupportCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantSupportCost }
     *     
     */
    public void setParticipantSupportCost(ParticipantSupportCost value) {
        this.participantSupportCost = value;
    }

    /**
     * Gets the value of the otherDirectCost property.
     * 
     * @return
     *     possible object is
     *     {@link OtherDirectCost }
     *     
     */
    public OtherDirectCost getOtherDirectCost() {
        return otherDirectCost;
    }

    /**
     * Sets the value of the otherDirectCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherDirectCost }
     *     
     */
    public void setOtherDirectCost(OtherDirectCost value) {
        this.otherDirectCost = value;
    }

    /**
     * Gets the value of the residualFunds property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getResidualFunds() {
        return residualFunds;
    }

    /**
     * Sets the value of the residualFunds property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setResidualFunds(BigDecimal value) {
        this.residualFunds = value;
    }

    /**
     * Gets the value of the costSharingDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCostSharingDollars() {
        return costSharingDollars;
    }

    /**
     * Sets the value of the costSharingDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCostSharingDollars(BigDecimal value) {
        this.costSharingDollars = value;
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
