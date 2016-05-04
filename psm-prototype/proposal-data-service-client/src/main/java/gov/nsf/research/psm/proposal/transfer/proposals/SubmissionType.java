
package gov.nsf.research.psm.proposal.transfer.proposals;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubmissionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubmissionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LETTER_OF_INTENT"/>
 *     &lt;enumeration value="PRELIMINARY_PROPOSAL"/>
 *     &lt;enumeration value="FULL_PROPOSAL"/>
 *     &lt;enumeration value="RENEWAL"/>
 *     &lt;enumeration value="RENEWAL_ABR"/>
 *     &lt;enumeration value="COLLABORATIVE_LEAD"/>
 *     &lt;enumeration value="COLLABORATIVE_NON_LEAD"/>
 *     &lt;enumeration value="AWARD_SUPPLEMENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SubmissionType")
@XmlEnum
public enum SubmissionType {

    LETTER_OF_INTENT,
    PRELIMINARY_PROPOSAL,
    FULL_PROPOSAL,
    RENEWAL,
    RENEWAL_ABR,
    COLLABORATIVE_LEAD,
    COLLABORATIVE_NON_LEAD,
    AWARD_SUPPLEMENT;

    public String value() {
        return name();
    }

    public static SubmissionType fromValue(String v) {
        return valueOf(v);
    }

}
