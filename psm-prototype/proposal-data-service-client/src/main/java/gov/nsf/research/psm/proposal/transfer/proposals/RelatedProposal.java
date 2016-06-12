
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RelatedProposal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelatedProposal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="proposalId" type="{Proposal-V1.0}ProposalIdType" minOccurs="0"/>
 *         &lt;element name="temporaryProposalId" type="{Proposal-V1.0}TemporaryProposalIdType"/>
 *         &lt;element name="submissionType" type="{Proposal-V1.0}SubmissionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatedProposal", propOrder = {
    "proposalId",
    "temporaryProposalId",
    "submissionType"
})
public class RelatedProposal {

    protected String proposalId;
    @XmlElement(required = true)
    protected String temporaryProposalId;
    @XmlElement(required = true)
    protected SubmissionType submissionType;

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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.MULTI_LINE_STYLE);
    }

}
