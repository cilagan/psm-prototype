
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FundingMechanismType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FundingMechanismType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RAPID"/>
 *     &lt;enumeration value="EAGER"/>
 *     &lt;enumeration value="CONFERENCES_SYMPOSIA_WORKSHOPS"/>
 *     &lt;enumeration value="EQUIPMENT"/>
 *     &lt;enumeration value="INTERNATIONAL_TRAVEL"/>
 *     &lt;enumeration value="RESEARCH"/>
 *     &lt;enumeration value="FACILITIES_CENTERS"/>
 *     &lt;enumeration value="FELLOWSHIPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FundingMechanismType")
@XmlEnum
public enum FundingMechanismType {

    RAPID,
    EAGER,
    CONFERENCES_SYMPOSIA_WORKSHOPS,
    EQUIPMENT,
    INTERNATIONAL_TRAVEL,
    RESEARCH,
    FACILITIES_CENTERS,
    FELLOWSHIPS;

    public String value() {
        return name();
    }

    public static FundingMechanismType fromValue(String v) {
        return valueOf(v);
    }

}
