
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RemainderCoverSheet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RemainderCoverSheet">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}Section">
 *       &lt;sequence>
 *         &lt;element name="personnelList" type="{Proposal-V1.0}Personnel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="otherAgenciesSubmittedProposal" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="beginningInvestigatorFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="disclosureOfLobbyingActivitiesFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="proprietyAndPrivilegedInfoFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="historicPlacesFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vertebrateAnimalsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IACUCDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="phsAnimalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="humanSubjectsFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="exemptionSubsection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="irbAppDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="humanSubjectsAssuranceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internationalCooperativeActivitiesFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="internationalCooperativeCountryCodes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="exceptionDeadlineDateFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemainderCoverSheet", propOrder = {
    "personnelList",
    "otherAgenciesSubmittedProposal",
    "beginningInvestigatorFlag",
    "disclosureOfLobbyingActivitiesFlag",
    "proprietyAndPrivilegedInfoFlag",
    "historicPlacesFlag",
    "vertebrateAnimalsFlag",
    "iacucDate",
    "phsAnimalNumber",
    "humanSubjectsFlag",
    "exemptionSubsection",
    "irbAppDate",
    "humanSubjectsAssuranceNumber",
    "internationalCooperativeActivitiesFlag",
    "internationalCooperativeCountryCodes",
    "exceptionDeadlineDateFlag"
})
public class RemainderCoverSheet
    extends Section
{

    protected List<Personnel> personnelList;
    protected List<String> otherAgenciesSubmittedProposal;
    protected Boolean beginningInvestigatorFlag;
    protected Boolean disclosureOfLobbyingActivitiesFlag;
    protected Boolean proprietyAndPrivilegedInfoFlag;
    protected Boolean historicPlacesFlag;
    protected Boolean vertebrateAnimalsFlag;
    @XmlElement(name = "IACUCDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar iacucDate;
    protected String phsAnimalNumber;
    protected Boolean humanSubjectsFlag;
    protected String exemptionSubsection;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar irbAppDate;
    protected String humanSubjectsAssuranceNumber;
    protected Boolean internationalCooperativeActivitiesFlag;
    protected List<String> internationalCooperativeCountryCodes;
    protected Boolean exceptionDeadlineDateFlag;

    /**
     * Gets the value of the personnelList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personnelList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonnelList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Personnel }
     * 
     * 
     */
    public List<Personnel> getPersonnelList() {
        if (personnelList == null) {
            personnelList = new ArrayList<Personnel>();
        }
        return this.personnelList;
    }

    /**
     * Gets the value of the otherAgenciesSubmittedProposal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherAgenciesSubmittedProposal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherAgenciesSubmittedProposal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOtherAgenciesSubmittedProposal() {
        if (otherAgenciesSubmittedProposal == null) {
            otherAgenciesSubmittedProposal = new ArrayList<String>();
        }
        return this.otherAgenciesSubmittedProposal;
    }

    /**
     * Gets the value of the beginningInvestigatorFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getBeginningInvestigatorFlag() {
        return beginningInvestigatorFlag;
    }

    /**
     * Sets the value of the beginningInvestigatorFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBeginningInvestigatorFlag(Boolean value) {
        this.beginningInvestigatorFlag = value;
    }

    /**
     * Gets the value of the disclosureOfLobbyingActivitiesFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDisclosureOfLobbyingActivitiesFlag() {
        return disclosureOfLobbyingActivitiesFlag;
    }

    /**
     * Sets the value of the disclosureOfLobbyingActivitiesFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisclosureOfLobbyingActivitiesFlag(Boolean value) {
        this.disclosureOfLobbyingActivitiesFlag = value;
    }

    /**
     * Gets the value of the proprietyAndPrivilegedInfoFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getProprietyAndPrivilegedInfoFlag() {
        return proprietyAndPrivilegedInfoFlag;
    }

    /**
     * Sets the value of the proprietyAndPrivilegedInfoFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProprietyAndPrivilegedInfoFlag(Boolean value) {
        this.proprietyAndPrivilegedInfoFlag = value;
    }

    /**
     * Gets the value of the historicPlacesFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getHistoricPlacesFlag() {
        return historicPlacesFlag;
    }

    /**
     * Sets the value of the historicPlacesFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistoricPlacesFlag(Boolean value) {
        this.historicPlacesFlag = value;
    }

    /**
     * Gets the value of the vertebrateAnimalsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getVertebrateAnimalsFlag() {
        return vertebrateAnimalsFlag;
    }

    /**
     * Sets the value of the vertebrateAnimalsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVertebrateAnimalsFlag(Boolean value) {
        this.vertebrateAnimalsFlag = value;
    }

    /**
     * Gets the value of the iacucDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIACUCDate() {
        return iacucDate;
    }

    /**
     * Sets the value of the iacucDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIACUCDate(XMLGregorianCalendar value) {
        this.iacucDate = value;
    }

    /**
     * Gets the value of the phsAnimalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhsAnimalNumber() {
        return phsAnimalNumber;
    }

    /**
     * Sets the value of the phsAnimalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhsAnimalNumber(String value) {
        this.phsAnimalNumber = value;
    }

    /**
     * Gets the value of the humanSubjectsFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getHumanSubjectsFlag() {
        return humanSubjectsFlag;
    }

    /**
     * Sets the value of the humanSubjectsFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHumanSubjectsFlag(Boolean value) {
        this.humanSubjectsFlag = value;
    }

    /**
     * Gets the value of the exemptionSubsection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExemptionSubsection() {
        return exemptionSubsection;
    }

    /**
     * Sets the value of the exemptionSubsection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExemptionSubsection(String value) {
        this.exemptionSubsection = value;
    }

    /**
     * Gets the value of the irbAppDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIrbAppDate() {
        return irbAppDate;
    }

    /**
     * Sets the value of the irbAppDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIrbAppDate(XMLGregorianCalendar value) {
        this.irbAppDate = value;
    }

    /**
     * Gets the value of the humanSubjectsAssuranceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHumanSubjectsAssuranceNumber() {
        return humanSubjectsAssuranceNumber;
    }

    /**
     * Sets the value of the humanSubjectsAssuranceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHumanSubjectsAssuranceNumber(String value) {
        this.humanSubjectsAssuranceNumber = value;
    }

    /**
     * Gets the value of the internationalCooperativeActivitiesFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getInternationalCooperativeActivitiesFlag() {
        return internationalCooperativeActivitiesFlag;
    }

    /**
     * Sets the value of the internationalCooperativeActivitiesFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternationalCooperativeActivitiesFlag(Boolean value) {
        this.internationalCooperativeActivitiesFlag = value;
    }

    /**
     * Gets the value of the internationalCooperativeCountryCodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the internationalCooperativeCountryCodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInternationalCooperativeCountryCodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInternationalCooperativeCountryCodes() {
        if (internationalCooperativeCountryCodes == null) {
            internationalCooperativeCountryCodes = new ArrayList<String>();
        }
        return this.internationalCooperativeCountryCodes;
    }

    /**
     * Gets the value of the exceptionDeadlineDateFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getExceptionDeadlineDateFlag() {
        return exceptionDeadlineDateFlag;
    }

    /**
     * Sets the value of the exceptionDeadlineDateFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExceptionDeadlineDateFlag(Boolean value) {
        this.exceptionDeadlineDateFlag = value;
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
