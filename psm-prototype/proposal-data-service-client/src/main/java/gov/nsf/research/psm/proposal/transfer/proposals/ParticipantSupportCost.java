
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ParticipantSupportCost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParticipantSupportCost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="supportDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="travelDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="subsistenceDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="otherSupportDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="numberOfParticipants" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticipantSupportCost", propOrder = {
    "supportDollars",
    "travelDollars",
    "subsistenceDollars",
    "otherSupportDollars",
    "numberOfParticipants"
})
public class ParticipantSupportCost {

    protected BigDecimal supportDollars;
    protected BigDecimal travelDollars;
    protected BigDecimal subsistenceDollars;
    protected BigDecimal otherSupportDollars;
    protected Integer numberOfParticipants;

    /**
     * Gets the value of the supportDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSupportDollars() {
        return supportDollars;
    }

    /**
     * Sets the value of the supportDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSupportDollars(BigDecimal value) {
        this.supportDollars = value;
    }

    /**
     * Gets the value of the travelDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTravelDollars() {
        return travelDollars;
    }

    /**
     * Sets the value of the travelDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTravelDollars(BigDecimal value) {
        this.travelDollars = value;
    }

    /**
     * Gets the value of the subsistenceDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubsistenceDollars() {
        return subsistenceDollars;
    }

    /**
     * Sets the value of the subsistenceDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubsistenceDollars(BigDecimal value) {
        this.subsistenceDollars = value;
    }

    /**
     * Gets the value of the otherSupportDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherSupportDollars() {
        return otherSupportDollars;
    }

    /**
     * Sets the value of the otherSupportDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherSupportDollars(BigDecimal value) {
        this.otherSupportDollars = value;
    }

    /**
     * Gets the value of the numberOfParticipants property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * Sets the value of the numberOfParticipants property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberOfParticipants(Integer value) {
        this.numberOfParticipants = value;
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
