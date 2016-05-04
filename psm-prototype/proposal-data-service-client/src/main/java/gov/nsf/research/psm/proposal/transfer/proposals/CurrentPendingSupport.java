
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CurrentPendingSupport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrentPendingSupport">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}UploadableSection">
 *       &lt;sequence>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="proposalTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceOfSupport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalAwdAmt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="supportType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="calendarMonthCount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="academicMonthCount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="summerMonthCount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="revType" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentPendingSupport", propOrder = {
    "firstName",
    "lastName",
    "proposalTitle",
    "sourceOfSupport",
    "projectLocation",
    "totalAwdAmt",
    "startDate",
    "endDate",
    "supportType",
    "calendarMonthCount",
    "academicMonthCount",
    "summerMonthCount",
    "revType"
})
public class CurrentPendingSupport
    extends UploadableSection
{

    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;
    protected String proposalTitle;
    protected String sourceOfSupport;
    protected String projectLocation;
    protected BigDecimal totalAwdAmt;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    protected String supportType;
    protected BigDecimal calendarMonthCount;
    protected BigDecimal academicMonthCount;
    protected BigDecimal summerMonthCount;
    protected Boolean revType;

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
     * Gets the value of the proposalTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProposalTitle() {
        return proposalTitle;
    }

    /**
     * Sets the value of the proposalTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProposalTitle(String value) {
        this.proposalTitle = value;
    }

    /**
     * Gets the value of the sourceOfSupport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceOfSupport() {
        return sourceOfSupport;
    }

    /**
     * Sets the value of the sourceOfSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceOfSupport(String value) {
        this.sourceOfSupport = value;
    }

    /**
     * Gets the value of the projectLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectLocation() {
        return projectLocation;
    }

    /**
     * Sets the value of the projectLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectLocation(String value) {
        this.projectLocation = value;
    }

    /**
     * Gets the value of the totalAwdAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAwdAmt() {
        return totalAwdAmt;
    }

    /**
     * Sets the value of the totalAwdAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAwdAmt(BigDecimal value) {
        this.totalAwdAmt = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the supportType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportType() {
        return supportType;
    }

    /**
     * Sets the value of the supportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportType(String value) {
        this.supportType = value;
    }

    /**
     * Gets the value of the calendarMonthCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCalendarMonthCount() {
        return calendarMonthCount;
    }

    /**
     * Sets the value of the calendarMonthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCalendarMonthCount(BigDecimal value) {
        this.calendarMonthCount = value;
    }

    /**
     * Gets the value of the academicMonthCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAcademicMonthCount() {
        return academicMonthCount;
    }

    /**
     * Sets the value of the academicMonthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAcademicMonthCount(BigDecimal value) {
        this.academicMonthCount = value;
    }

    /**
     * Gets the value of the summerMonthCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSummerMonthCount() {
        return summerMonthCount;
    }

    /**
     * Sets the value of the summerMonthCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSummerMonthCount(BigDecimal value) {
        this.summerMonthCount = value;
    }

    /**
     * Gets the value of the revType property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getRevType() {
        return revType;
    }

    /**
     * Sets the value of the revType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRevType(Boolean value) {
        this.revType = value;
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
