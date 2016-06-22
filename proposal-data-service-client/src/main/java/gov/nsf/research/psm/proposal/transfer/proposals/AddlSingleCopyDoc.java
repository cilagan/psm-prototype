
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for AddlSingleCopyDoc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddlSingleCopyDoc">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}UploadableSection">
 *       &lt;sequence>
 *         &lt;element name="addlSnglCopyTxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addlSnglCopyDocSeq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddlSingleCopyDoc", propOrder = {
    "addlSnglCopyTxt",
    "addlSnglCopyDocSeq"
})
public class AddlSingleCopyDoc
    extends UploadableSection
{

    protected String addlSnglCopyTxt;
    protected Integer addlSnglCopyDocSeq;

    /**
     * Gets the value of the addlSnglCopyTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddlSnglCopyTxt() {
        return addlSnglCopyTxt;
    }

    /**
     * Sets the value of the addlSnglCopyTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddlSnglCopyTxt(String value) {
        this.addlSnglCopyTxt = value;
    }

    /**
     * Gets the value of the addlSnglCopyDocSeq property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAddlSnglCopyDocSeq() {
        return addlSnglCopyDocSeq;
    }

    /**
     * Sets the value of the addlSnglCopyDocSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAddlSnglCopyDocSeq(Integer value) {
        this.addlSnglCopyDocSeq = value;
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
