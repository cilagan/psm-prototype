
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FundingOpportunity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FundingOpportunity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fundingOpportunityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fundingOpportunityType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fundingOpportunityDeadline" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="isGPG" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isCurrentGPGVersion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dateExists13MonthWindow" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="deadlineTypeIdExists" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="deadlineTypeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FundingOpportunity", propOrder = {
    "fundingOpportunityId",
    "fundingOpportunityType",
    "fundingOpportunityDeadline",
    "isGPG",
    "isCurrentGPGVersion",
    "dateExists13MonthWindow",
    "deadlineTypeIdExists",
    "deadlineTypeId"
})
public class FundingOpportunity {

    protected String fundingOpportunityId;
    protected String fundingOpportunityType;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fundingOpportunityDeadline;
    protected Boolean isGPG;
    protected Boolean isCurrentGPGVersion;
    protected Boolean dateExists13MonthWindow;
    protected Boolean deadlineTypeIdExists;
    protected Integer deadlineTypeId;

    /**
     * Gets the value of the fundingOpportunityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundingOpportunityId() {
        return fundingOpportunityId;
    }

    /**
     * Sets the value of the fundingOpportunityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundingOpportunityId(String value) {
        this.fundingOpportunityId = value;
    }

    /**
     * Gets the value of the fundingOpportunityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundingOpportunityType() {
        return fundingOpportunityType;
    }

    /**
     * Sets the value of the fundingOpportunityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundingOpportunityType(String value) {
        this.fundingOpportunityType = value;
    }

    /**
     * Gets the value of the fundingOpportunityDeadline property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFundingOpportunityDeadline() {
        return fundingOpportunityDeadline;
    }

    /**
     * Sets the value of the fundingOpportunityDeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFundingOpportunityDeadline(XMLGregorianCalendar value) {
        this.fundingOpportunityDeadline = value;
    }

    /**
     * Gets the value of the isGPG property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsGPG() {
        return isGPG;
    }

    /**
     * Sets the value of the isGPG property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsGPG(Boolean value) {
        this.isGPG = value;
    }

    /**
     * Gets the value of the isCurrentGPGVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsCurrentGPGVersion() {
        return isCurrentGPGVersion;
    }

    /**
     * Sets the value of the isCurrentGPGVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCurrentGPGVersion(Boolean value) {
        this.isCurrentGPGVersion = value;
    }

    /**
     * Gets the value of the dateExists13MonthWindow property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDateExists13MonthWindow() {
        return dateExists13MonthWindow;
    }

    /**
     * Sets the value of the dateExists13MonthWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDateExists13MonthWindow(Boolean value) {
        this.dateExists13MonthWindow = value;
    }

    /**
     * Gets the value of the deadlineTypeIdExists property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDeadlineTypeIdExists() {
        return deadlineTypeIdExists;
    }

    /**
     * Sets the value of the deadlineTypeIdExists property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeadlineTypeIdExists(Boolean value) {
        this.deadlineTypeIdExists = value;
    }

    /**
     * Gets the value of the deadlineTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeadlineTypeId() {
        return deadlineTypeId;
    }

    /**
     * Sets the value of the deadlineTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeadlineTypeId(Integer value) {
        this.deadlineTypeId = value;
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
