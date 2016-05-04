
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for OtherDirectCost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OtherDirectCost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="materialsSuppliesDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="publicationDocumentationDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="consultantServicesDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="computerServicesDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="subcontractsDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="otherDirectCostDollars" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherDirectCost", propOrder = {
    "materialsSuppliesDollars",
    "publicationDocumentationDollars",
    "consultantServicesDollars",
    "computerServicesDollars",
    "subcontractsDollars",
    "otherDirectCostDollars"
})
public class OtherDirectCost {

    protected BigDecimal materialsSuppliesDollars;
    protected BigDecimal publicationDocumentationDollars;
    protected BigDecimal consultantServicesDollars;
    protected BigDecimal computerServicesDollars;
    protected BigDecimal subcontractsDollars;
    protected BigDecimal otherDirectCostDollars;

    /**
     * Gets the value of the materialsSuppliesDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaterialsSuppliesDollars() {
        return materialsSuppliesDollars;
    }

    /**
     * Sets the value of the materialsSuppliesDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaterialsSuppliesDollars(BigDecimal value) {
        this.materialsSuppliesDollars = value;
    }

    /**
     * Gets the value of the publicationDocumentationDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPublicationDocumentationDollars() {
        return publicationDocumentationDollars;
    }

    /**
     * Sets the value of the publicationDocumentationDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPublicationDocumentationDollars(BigDecimal value) {
        this.publicationDocumentationDollars = value;
    }

    /**
     * Gets the value of the consultantServicesDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getConsultantServicesDollars() {
        return consultantServicesDollars;
    }

    /**
     * Sets the value of the consultantServicesDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setConsultantServicesDollars(BigDecimal value) {
        this.consultantServicesDollars = value;
    }

    /**
     * Gets the value of the computerServicesDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getComputerServicesDollars() {
        return computerServicesDollars;
    }

    /**
     * Sets the value of the computerServicesDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setComputerServicesDollars(BigDecimal value) {
        this.computerServicesDollars = value;
    }

    /**
     * Gets the value of the subcontractsDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubcontractsDollars() {
        return subcontractsDollars;
    }

    /**
     * Sets the value of the subcontractsDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubcontractsDollars(BigDecimal value) {
        this.subcontractsDollars = value;
    }

    /**
     * Gets the value of the otherDirectCostDollars property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherDirectCostDollars() {
        return otherDirectCostDollars;
    }

    /**
     * Sets the value of the otherDirectCostDollars property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherDirectCostDollars(BigDecimal value) {
        this.otherDirectCostDollars = value;
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
