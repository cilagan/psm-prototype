
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for Proposal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Proposal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="proposalHeader" type="{Proposal-V1.0}ProposalHeader"/>
 *         &lt;element name="proposalSections" type="{Proposal-V1.0}ProposalSections" minOccurs="0"/>
 *         &lt;element name="relatedProposals" type="{Proposal-V1.0}RelatedProposal" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Proposal", propOrder = {
    "proposalHeader",
    "proposalSections",
    "relatedProposals"
})
public class Proposal {

    @XmlElement(required = true)
    protected ProposalHeader proposalHeader;
    protected ProposalSections proposalSections;
    protected List<RelatedProposal> relatedProposals;

    /**
     * Gets the value of the proposalHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ProposalHeader }
     *     
     */
    public ProposalHeader getProposalHeader() {
        return proposalHeader;
    }

    /**
     * Sets the value of the proposalHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProposalHeader }
     *     
     */
    public void setProposalHeader(ProposalHeader value) {
        this.proposalHeader = value;
    }

    /**
     * Gets the value of the proposalSections property.
     * 
     * @return
     *     possible object is
     *     {@link ProposalSections }
     *     
     */
    public ProposalSections getProposalSections() {
        return proposalSections;
    }

    /**
     * Sets the value of the proposalSections property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProposalSections }
     *     
     */
    public void setProposalSections(ProposalSections value) {
        this.proposalSections = value;
    }

    /**
     * Gets the value of the relatedProposals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedProposals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedProposals().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedProposal }
     * 
     * 
     */
    public List<RelatedProposal> getRelatedProposals() {
        if (relatedProposals == null) {
            relatedProposals = new ArrayList<RelatedProposal>();
        }
        return this.relatedProposals;
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
