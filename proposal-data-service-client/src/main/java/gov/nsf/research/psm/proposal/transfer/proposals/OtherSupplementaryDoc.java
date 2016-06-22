
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for OtherSupplementaryDoc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OtherSupplementaryDoc">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}UploadableSection">
 *       &lt;sequence>
 *         &lt;element name="othSuppTxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suppDocSeq" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherSupplementaryDoc", propOrder = {
    "othSuppTxt",
    "suppDocSeq"
})
public class OtherSupplementaryDoc
    extends UploadableSection
{

    protected String othSuppTxt;
    protected Integer suppDocSeq;

    /**
     * Gets the value of the othSuppTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOthSuppTxt() {
        return othSuppTxt;
    }

    /**
     * Sets the value of the othSuppTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOthSuppTxt(String value) {
        this.othSuppTxt = value;
    }

    /**
     * Gets the value of the suppDocSeq property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSuppDocSeq() {
        return suppDocSeq;
    }

    /**
     * Sets the value of the suppDocSeq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSuppDocSeq(Integer value) {
        this.suppDocSeq = value;
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
