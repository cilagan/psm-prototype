
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for SeniorPersonnelBudget complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SeniorPersonnelBudget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="srFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srMidName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="calMonthCount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="acadMonthCount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="summMonthCount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="requestedDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SeniorPersonnelBudget", propOrder = {
    "srFirstName",
    "srLastName",
    "srMidName",
    "srTitle",
    "calMonthCount",
    "acadMonthCount",
    "summMonthCount",
    "requestedDollars"
})
public class SeniorPersonnelBudget {

    protected String srFirstName;
    protected String srLastName;
    protected String srMidName;
    protected String srTitle;
    protected BigDecimal calMonthCount;
    protected BigDecimal acadMonthCount;
    protected BigDecimal summMonthCount;
    protected BigDecimal requestedDollars;

    /**
     * Gets the value of the srFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrFirstName() {
        return srFirstName;
    }

    /**
     * Sets the value of the srFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrFirstName(String value) {
        this.srFirstName = value;
    }

    /**
     * Gets the value of the srLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrLastName() {
        return srLastName;
    }

    /**
     * Sets the value of the srLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrLastName(String value) {
        this.srLastName = value;
    }

    /**
     * Gets the value of the srMidName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrMidName() {
        return srMidName;
    }

    /**
     * Sets the value of the srMidName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrMidName(String value) {
        this.srMidName = value;
    }

    /**
     * Gets the value of the srTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrTitle() {
        return srTitle;
    }

    /**
     * Sets the value of the srTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrTitle(String value) {
        this.srTitle = value;
    }

    /**
     * Gets the value of the calMonthCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCalMonthCount() {
        return calMonthCount;
    }

    /**
     * Sets the value of the calMonthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCalMonthCount(BigDecimal value) {
        this.calMonthCount = value;
    }

    /**
     * Gets the value of the acadMonthCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAcadMonthCount() {
        return acadMonthCount;
    }

    /**
     * Sets the value of the acadMonthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAcadMonthCount(BigDecimal value) {
        this.acadMonthCount = value;
    }

    /**
     * Gets the value of the summMonthCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSummMonthCount() {
        return summMonthCount;
    }

    /**
     * Sets the value of the summMonthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSummMonthCount(BigDecimal value) {
        this.summMonthCount = value;
    }

    /**
     * Gets the value of the requestedDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRequestedDollars() {
        return requestedDollars;
    }

    /**
     * Sets the value of the requestedDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRequestedDollars(BigDecimal value) {
        this.requestedDollars = value;
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
