
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for SuggestedReviewers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SuggestedReviewers">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}Section">
 *       &lt;sequence>
 *         &lt;element name="prefferedReviewers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notPrefferredReviewers" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuggestedReviewers", propOrder = {
    "prefferedReviewers",
    "notPrefferredReviewers"
})
public class SuggestedReviewers
    extends Section
{

    protected String prefferedReviewers;
    protected String notPrefferredReviewers;

    /**
     * Gets the value of the prefferedReviewers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefferedReviewers() {
        return prefferedReviewers;
    }

    /**
     * Sets the value of the prefferedReviewers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefferedReviewers(String value) {
        this.prefferedReviewers = value;
    }

    /**
     * Gets the value of the notPrefferredReviewers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotPrefferredReviewers() {
        return notPrefferredReviewers;
    }

    /**
     * Sets the value of the notPrefferredReviewers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotPrefferredReviewers(String value) {
        this.notPrefferredReviewers = value;
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
