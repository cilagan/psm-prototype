
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SectionFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SectionFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TEXT"/>
 *     &lt;enumeration value="PDF"/>
 *     &lt;enumeration value="MULTIPLE"/>
 *     &lt;enumeration value="EMPTY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SectionFormat")
@XmlEnum
public enum SectionFormat {

    TEXT,
    PDF,
    MULTIPLE,
    EMPTY;

    public String value() {
        return name();
    }

    public static SectionFormat fromValue(String v) {
        return valueOf(v);
    }

}
