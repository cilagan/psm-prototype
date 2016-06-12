
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ProjectSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProjectSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}UploadableSection">
 *       &lt;sequence>
 *         &lt;element name="projSummaryText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intellectualMerit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="broaderImpacts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specialCharPDF" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProjectSummary", propOrder = {
    "projSummaryText",
    "intellectualMerit",
    "broaderImpacts",
    "specialCharPDF"
})
public class ProjectSummary
    extends UploadableSection
{

    protected String projSummaryText;
    protected String intellectualMerit;
    protected String broaderImpacts;
    protected Boolean specialCharPDF;

    /**
     * Gets the value of the projSummaryText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjSummaryText() {
        return projSummaryText;
    }

    /**
     * Sets the value of the projSummaryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjSummaryText(String value) {
        this.projSummaryText = value;
    }

    /**
     * Gets the value of the intellectualMerit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntellectualMerit() {
        return intellectualMerit;
    }

    /**
     * Sets the value of the intellectualMerit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntellectualMerit(String value) {
        this.intellectualMerit = value;
    }

    /**
     * Gets the value of the broaderImpacts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBroaderImpacts() {
        return broaderImpacts;
    }

    /**
     * Sets the value of the broaderImpacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBroaderImpacts(String value) {
        this.broaderImpacts = value;
    }

    /**
     * Gets the value of the specialCharPDF property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getSpecialCharPDF() {
        return specialCharPDF;
    }

    /**
     * Sets the value of the specialCharPDF property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSpecialCharPDF(Boolean value) {
        this.specialCharPDF = value;
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
