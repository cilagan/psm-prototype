
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ProposalFinding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProposalFinding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="findingCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="findingLevel" type="{ProposalFinding-V1.0}FindingLevel"/>
 *         &lt;element name="findingMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProposalFinding", namespace = "ProposalFinding-V1.0", propOrder = {
    "findingCode",
    "findingLevel",
    "findingMessage"
})
public class ProposalFinding {

    @XmlElement(required = true)
    protected String findingCode;
    @XmlElement(required = true)
    protected FindingLevel findingLevel;
    @XmlElement(required = true)
    protected String findingMessage;

    /**
     * Gets the value of the findingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFindingCode() {
        return findingCode;
    }

    /**
     * Sets the value of the findingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFindingCode(String value) {
        this.findingCode = value;
    }

    /**
     * Gets the value of the findingLevel property.
     * 
     * @return
     *     possible object is
     *     {@link FindingLevel }
     *     
     */
    public FindingLevel getFindingLevel() {
        return findingLevel;
    }

    /**
     * Sets the value of the findingLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindingLevel }
     *     
     */
    public void setFindingLevel(FindingLevel value) {
        this.findingLevel = value;
    }

    /**
     * Gets the value of the findingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFindingMessage() {
        return findingMessage;
    }

    /**
     * Sets the value of the findingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFindingMessage(String value) {
        this.findingMessage = value;
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
