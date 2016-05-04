
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for Institution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Institution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="institutionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institutionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institutionState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institutionZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institutionCtry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institutionTimeZoneId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="institutionTimeZoneName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Institution", propOrder = {
    "institutionId",
    "institutionName",
    "institutionState",
    "institutionZip",
    "institutionCtry",
    "institutionTimeZoneId",
    "institutionTimeZoneName"
})
public class Institution {

    protected String institutionId;
    protected String institutionName;
    protected String institutionState;
    protected String institutionZip;
    protected String institutionCtry;
    protected Integer institutionTimeZoneId;
    protected String institutionTimeZoneName;

    /**
     * Gets the value of the institutionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitutionId() {
        return institutionId;
    }

    /**
     * Sets the value of the institutionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitutionId(String value) {
        this.institutionId = value;
    }

    /**
     * Gets the value of the institutionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * Sets the value of the institutionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitutionName(String value) {
        this.institutionName = value;
    }

    /**
     * Gets the value of the institutionState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitutionState() {
        return institutionState;
    }

    /**
     * Sets the value of the institutionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitutionState(String value) {
        this.institutionState = value;
    }

    /**
     * Gets the value of the institutionZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitutionZip() {
        return institutionZip;
    }

    /**
     * Sets the value of the institutionZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitutionZip(String value) {
        this.institutionZip = value;
    }

    /**
     * Gets the value of the institutionCtry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitutionCtry() {
        return institutionCtry;
    }

    /**
     * Sets the value of the institutionCtry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitutionCtry(String value) {
        this.institutionCtry = value;
    }

    /**
     * Gets the value of the institutionTimeZoneId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInstitutionTimeZoneId() {
        return institutionTimeZoneId;
    }

    /**
     * Sets the value of the institutionTimeZoneId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInstitutionTimeZoneId(Integer value) {
        this.institutionTimeZoneId = value;
    }

    /**
     * Gets the value of the institutionTimeZoneName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitutionTimeZoneName() {
        return institutionTimeZoneName;
    }

    /**
     * Sets the value of the institutionTimeZoneName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitutionTimeZoneName(String value) {
        this.institutionTimeZoneName = value;
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
