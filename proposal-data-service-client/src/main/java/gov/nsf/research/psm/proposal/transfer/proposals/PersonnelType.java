
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonnelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PersonnelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PI"/>
 *     &lt;enumeration value="CO_PI"/>
 *     &lt;enumeration value="SR_PERSONNEL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PersonnelType")
@XmlEnum
public enum PersonnelType {

    PI,
    CO_PI,
    SR_PERSONNEL;

    public String value() {
        return name();
    }

    public static PersonnelType fromValue(String v) {
        return valueOf(v);
    }

}
