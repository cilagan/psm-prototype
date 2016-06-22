
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for AwardeeOrganization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AwardeeOrganization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="organizationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organizationAddress" type="{Proposal-V1.0}AddressType" minOccurs="0"/>
 *         &lt;element name="dunsNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tinEinNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="forProfit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="smallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="minorityBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="womenOwnedBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AwardeeOrganization", propOrder = {
    "organizationId",
    "organizationName",
    "organizationAddress",
    "dunsNumber",
    "tinEinNumber",
    "forProfit",
    "smallBusiness",
    "minorityBusiness",
    "womenOwnedBusiness"
})
public class AwardeeOrganization {

    protected String organizationId;
    protected String organizationName;
    protected AddressType organizationAddress;
    protected String dunsNumber;
    protected String tinEinNumber;
    protected Boolean forProfit;
    protected Boolean smallBusiness;
    protected Boolean minorityBusiness;
    protected Boolean womenOwnedBusiness;

    /**
     * Gets the value of the organizationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * Sets the value of the organizationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationId(String value) {
        this.organizationId = value;
    }

    /**
     * Gets the value of the organizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationName(String value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the organizationAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getOrganizationAddress() {
        return organizationAddress;
    }

    /**
     * Sets the value of the organizationAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setOrganizationAddress(AddressType value) {
        this.organizationAddress = value;
    }

    /**
     * Gets the value of the dunsNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDunsNumber() {
        return dunsNumber;
    }

    /**
     * Sets the value of the dunsNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDunsNumber(String value) {
        this.dunsNumber = value;
    }

    /**
     * Gets the value of the tinEinNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTinEinNumber() {
        return tinEinNumber;
    }

    /**
     * Sets the value of the tinEinNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTinEinNumber(String value) {
        this.tinEinNumber = value;
    }

    /**
     * Gets the value of the forProfit property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getForProfit() {
        return forProfit;
    }

    /**
     * Sets the value of the forProfit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForProfit(Boolean value) {
        this.forProfit = value;
    }

    /**
     * Gets the value of the smallBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getSmallBusiness() {
        return smallBusiness;
    }

    /**
     * Sets the value of the smallBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSmallBusiness(Boolean value) {
        this.smallBusiness = value;
    }

    /**
     * Gets the value of the minorityBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getMinorityBusiness() {
        return minorityBusiness;
    }

    /**
     * Sets the value of the minorityBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMinorityBusiness(Boolean value) {
        this.minorityBusiness = value;
    }

    /**
     * Gets the value of the womenOwnedBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getWomenOwnedBusiness() {
        return womenOwnedBusiness;
    }

    /**
     * Sets the value of the womenOwnedBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWomenOwnedBusiness(Boolean value) {
        this.womenOwnedBusiness = value;
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
