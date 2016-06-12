
package gov.nsf.research.psm.proposal.transfer.proposals;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tempPropId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fundOppId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userSession" type="{UserSession-V1.0}UserSession"/>
 *         &lt;element name="proposalFindingList" type="{ProposalFinding-V1.0}ProposalFinding" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tempPropId",
    "fundOppId",
    "userSession",
    "proposalFindingList"
})
@XmlRootElement(name = "saveProposalFindingRequest", namespace = "ProposalService-V1.0")
public class SaveProposalFindingRequest {

    @XmlElement(namespace = "", required = true)
    protected String tempPropId;
    @XmlElement(namespace = "", required = true)
    protected String fundOppId;
    @XmlElement(namespace = "", required = true)
    protected UserSession userSession;
    @XmlElement(namespace = "", required = true)
    protected List<ProposalFinding> proposalFindingList;

    /**
     * Gets the value of the tempPropId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempPropId() {
        return tempPropId;
    }

    /**
     * Sets the value of the tempPropId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempPropId(String value) {
        this.tempPropId = value;
    }

    /**
     * Gets the value of the fundOppId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundOppId() {
        return fundOppId;
    }

    /**
     * Sets the value of the fundOppId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundOppId(String value) {
        this.fundOppId = value;
    }

    /**
     * Gets the value of the userSession property.
     * 
     * @return
     *     possible object is
     *     {@link UserSession }
     *     
     */
    public UserSession getUserSession() {
        return userSession;
    }

    /**
     * Sets the value of the userSession property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserSession }
     *     
     */
    public void setUserSession(UserSession value) {
        this.userSession = value;
    }

    /**
     * Gets the value of the proposalFindingList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proposalFindingList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProposalFindingList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProposalFinding }
     * 
     * 
     */
    public List<ProposalFinding> getProposalFindingList() {
        if (proposalFindingList == null) {
            proposalFindingList = new ArrayList<ProposalFinding>();
        }
        return this.proposalFindingList;
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
