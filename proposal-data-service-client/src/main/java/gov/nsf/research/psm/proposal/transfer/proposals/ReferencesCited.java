
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ReferencesCited complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReferencesCited">
 *   &lt;complexContent>
 *     &lt;extension base="{Proposal-V1.0}UploadableSection">
 *       &lt;sequence>
 *         &lt;element name="refCitedTxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferencesCited", propOrder = {
    "refCitedTxt"
})
public class ReferencesCited
    extends UploadableSection
{

    protected String refCitedTxt;

    /**
     * Gets the value of the refCitedTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefCitedTxt() {
        return refCitedTxt;
    }

    /**
     * Sets the value of the refCitedTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefCitedTxt(String value) {
        this.refCitedTxt = value;
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
