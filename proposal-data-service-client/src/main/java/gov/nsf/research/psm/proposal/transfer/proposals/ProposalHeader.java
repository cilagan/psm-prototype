
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ProposalHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProposalHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="proposalId" type="{Proposal-V1.0}ProposalIdType" minOccurs="0"/>
 *         &lt;element name="temporaryProposalId" type="{Proposal-V1.0}TemporaryProposalIdType"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{Proposal-V1.0}ProposalStatus" minOccurs="0"/>
 *         &lt;element name="PI" type="{RgovTypesLibrary-V1.0}Person" minOccurs="0"/>
 *         &lt;element name="awardeeOrganization" type="{Proposal-V1.0}AwardeeOrganization" minOccurs="0"/>
 *         &lt;element name="institution" type="{Proposal-V1.0}Institution" minOccurs="0"/>
 *         &lt;element name="primaryPlaceofPerformanceOrg" type="{Proposal-V1.0}PrimaryPlaceOfPerfomanceOrganization" minOccurs="0"/>
 *         &lt;element name="submissionType" type="{Proposal-V1.0}SubmissionType" minOccurs="0"/>
 *         &lt;element name="submitTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fundingOpportunity" type="{Proposal-V1.0}FundingOpportunity" minOccurs="0"/>
 *         &lt;element name="fundingMechanism" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nsfUnitofConsideration" type="{Proposal-V1.0}unitOfConsideration" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="eligibilityData" type="{Proposal-V1.0}EligibilityData" minOccurs="0"/>
 *         &lt;element name="requestedBudgetAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="proposalDurationInMonths" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="requestedStartingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="preliminaryProposal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isPFU" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProposalHeader", propOrder = {
    "proposalId",
    "temporaryProposalId",
    "title",
    "status",
    "pi",
    "awardeeOrganization",
    "institution",
    "primaryPlaceofPerformanceOrg",
    "submissionType",
    "submitTimeStamp",
    "fundingOpportunity",
    "fundingMechanism",
    "nsfUnitofConsideration",
    "eligibilityData",
    "requestedBudgetAmount",
    "proposalDurationInMonths",
    "requestedStartingDate",
    "preliminaryProposal",
    "isPFU"
})
public class ProposalHeader {

    protected String proposalId;
    @XmlElement(required = true)
    protected String temporaryProposalId;
    protected String title;
    protected ProposalStatus status;
    @XmlElement(name = "PI")
    protected Person pi;
    protected AwardeeOrganization awardeeOrganization;
    protected Institution institution;
    protected PrimaryPlaceOfPerfomanceOrganization primaryPlaceofPerformanceOrg;
    protected SubmissionType submissionType;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submitTimeStamp;
    protected FundingOpportunity fundingOpportunity;
    protected String fundingMechanism;
    protected List<UnitOfConsideration> nsfUnitofConsideration;
    protected EligibilityData eligibilityData;
    protected BigDecimal requestedBudgetAmount;
    protected Integer proposalDurationInMonths;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar requestedStartingDate;
    protected Boolean preliminaryProposal;
    protected Boolean isPFU;

    /**
     * Gets the value of the proposalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProposalId() {
        return proposalId;
    }

    /**
     * Sets the value of the proposalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProposalId(String value) {
        this.proposalId = value;
    }

    /**
     * Gets the value of the temporaryProposalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemporaryProposalId() {
        return temporaryProposalId;
    }

    /**
     * Sets the value of the temporaryProposalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemporaryProposalId(String value) {
        this.temporaryProposalId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ProposalStatus }
     *     
     */
    public ProposalStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProposalStatus }
     *     
     */
    public void setStatus(ProposalStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the pi property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPI() {
        return pi;
    }

    /**
     * Sets the value of the pi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPI(Person value) {
        this.pi = value;
    }

    /**
     * Gets the value of the awardeeOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link AwardeeOrganization }
     *     
     */
    public AwardeeOrganization getAwardeeOrganization() {
        return awardeeOrganization;
    }

    /**
     * Sets the value of the awardeeOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link AwardeeOrganization }
     *     
     */
    public void setAwardeeOrganization(AwardeeOrganization value) {
        this.awardeeOrganization = value;
    }

    /**
     * Gets the value of the institution property.
     * 
     * @return
     *     possible object is
     *     {@link Institution }
     *     
     */
    public Institution getInstitution() {
        return institution;
    }

    /**
     * Sets the value of the institution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Institution }
     *     
     */
    public void setInstitution(Institution value) {
        this.institution = value;
    }

    /**
     * Gets the value of the primaryPlaceofPerformanceOrg property.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryPlaceOfPerfomanceOrganization }
     *     
     */
    public PrimaryPlaceOfPerfomanceOrganization getPrimaryPlaceofPerformanceOrg() {
        return primaryPlaceofPerformanceOrg;
    }

    /**
     * Sets the value of the primaryPlaceofPerformanceOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryPlaceOfPerfomanceOrganization }
     *     
     */
    public void setPrimaryPlaceofPerformanceOrg(PrimaryPlaceOfPerfomanceOrganization value) {
        this.primaryPlaceofPerformanceOrg = value;
    }

    /**
     * Gets the value of the submissionType property.
     * 
     * @return
     *     possible object is
     *     {@link SubmissionType }
     *     
     */
    public SubmissionType getSubmissionType() {
        return submissionType;
    }

    /**
     * Sets the value of the submissionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmissionType }
     *     
     */
    public void setSubmissionType(SubmissionType value) {
        this.submissionType = value;
    }

    /**
     * Gets the value of the submitTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmitTimeStamp() {
        return submitTimeStamp;
    }

    /**
     * Sets the value of the submitTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmitTimeStamp(XMLGregorianCalendar value) {
        this.submitTimeStamp = value;
    }

    /**
     * Gets the value of the fundingOpportunity property.
     * 
     * @return
     *     possible object is
     *     {@link FundingOpportunity }
     *     
     */
    public FundingOpportunity getFundingOpportunity() {
        return fundingOpportunity;
    }

    /**
     * Sets the value of the fundingOpportunity property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundingOpportunity }
     *     
     */
    public void setFundingOpportunity(FundingOpportunity value) {
        this.fundingOpportunity = value;
    }

    /**
     * Gets the value of the fundingMechanism property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundingMechanism() {
        return fundingMechanism;
    }

    /**
     * Sets the value of the fundingMechanism property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundingMechanism(String value) {
        this.fundingMechanism = value;
    }

    /**
     * Gets the value of the nsfUnitofConsideration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nsfUnitofConsideration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNsfUnitofConsideration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnitOfConsideration }
     * 
     * 
     */
    public List<UnitOfConsideration> getNsfUnitofConsideration() {
        if (nsfUnitofConsideration == null) {
            nsfUnitofConsideration = new ArrayList<UnitOfConsideration>();
        }
        return this.nsfUnitofConsideration;
    }

    /**
     * Gets the value of the eligibilityData property.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityData }
     *     
     */
    public EligibilityData getEligibilityData() {
        return eligibilityData;
    }

    /**
     * Sets the value of the eligibilityData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityData }
     *     
     */
    public void setEligibilityData(EligibilityData value) {
        this.eligibilityData = value;
    }

    /**
     * Gets the value of the requestedBudgetAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRequestedBudgetAmount() {
        return requestedBudgetAmount;
    }

    /**
     * Sets the value of the requestedBudgetAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRequestedBudgetAmount(BigDecimal value) {
        this.requestedBudgetAmount = value;
    }

    /**
     * Gets the value of the proposalDurationInMonths property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProposalDurationInMonths() {
        return proposalDurationInMonths;
    }

    /**
     * Sets the value of the proposalDurationInMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProposalDurationInMonths(Integer value) {
        this.proposalDurationInMonths = value;
    }

    /**
     * Gets the value of the requestedStartingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestedStartingDate() {
        return requestedStartingDate;
    }

    /**
     * Sets the value of the requestedStartingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestedStartingDate(XMLGregorianCalendar value) {
        this.requestedStartingDate = value;
    }

    /**
     * Gets the value of the preliminaryProposal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getPreliminaryProposal() {
        return preliminaryProposal;
    }

    /**
     * Sets the value of the preliminaryProposal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreliminaryProposal(Boolean value) {
        this.preliminaryProposal = value;
    }

    /**
     * Gets the value of the isPFU property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsPFU() {
        return isPFU;
    }

    /**
     * Sets the value of the isPFU property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPFU(Boolean value) {
        this.isPFU = value;
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
