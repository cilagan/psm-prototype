
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for EligibilityData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EligibilityData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="priorNSFAwards" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numOfProposalSubmittedByPI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numOfProposalSubmittedByOrganization" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EligibilityData", propOrder = {
    "priorNSFAwards",
    "numOfProposalSubmittedByPI",
    "numOfProposalSubmittedByOrganization"
})
public class EligibilityData {

    protected Integer priorNSFAwards;
    protected Integer numOfProposalSubmittedByPI;
    protected Integer numOfProposalSubmittedByOrganization;

    /**
     * Gets the value of the priorNSFAwards property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriorNSFAwards() {
        return priorNSFAwards;
    }

    /**
     * Sets the value of the priorNSFAwards property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriorNSFAwards(Integer value) {
        this.priorNSFAwards = value;
    }

    /**
     * Gets the value of the numOfProposalSubmittedByPI property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumOfProposalSubmittedByPI() {
        return numOfProposalSubmittedByPI;
    }

    /**
     * Sets the value of the numOfProposalSubmittedByPI property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumOfProposalSubmittedByPI(Integer value) {
        this.numOfProposalSubmittedByPI = value;
    }

    /**
     * Gets the value of the numOfProposalSubmittedByOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumOfProposalSubmittedByOrganization() {
        return numOfProposalSubmittedByOrganization;
    }

    /**
     * Sets the value of the numOfProposalSubmittedByOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumOfProposalSubmittedByOrganization(Integer value) {
        this.numOfProposalSubmittedByOrganization = value;
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
