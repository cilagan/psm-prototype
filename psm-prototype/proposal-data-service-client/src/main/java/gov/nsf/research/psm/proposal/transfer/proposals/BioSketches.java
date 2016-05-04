
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for BioSketches complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BioSketches">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}UploadableSection">
 *       &lt;sequence>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="textLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personnelType" type="{Proposal-V1.0}PersonnelType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BioSketches", propOrder = {
    "firstName",
    "lastName",
    "textLength",
    "text",
    "personnelType"
})
public class BioSketches
    extends UploadableSection
{

    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;
    protected Integer textLength;
    protected String text;
    @XmlElement(required = true)
    protected PersonnelType personnelType;

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the textLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTextLength() {
        return textLength;
    }

    /**
     * Sets the value of the textLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTextLength(Integer value) {
        this.textLength = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the personnelType property.
     * 
     * @return
     *     possible object is
     *     {@link PersonnelType }
     *     
     */
    public PersonnelType getPersonnelType() {
        return personnelType;
    }

    /**
     * Sets the value of the personnelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonnelType }
     *     
     */
    public void setPersonnelType(PersonnelType value) {
        this.personnelType = value;
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
