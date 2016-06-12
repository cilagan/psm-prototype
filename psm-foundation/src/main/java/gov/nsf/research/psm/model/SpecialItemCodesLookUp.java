package gov.nsf.research.psm.model;


/**
 * Contains Special Items Code from Remainder CoverSheet
 * @author cilagan
 *
 */
public enum SpecialItemCodesLookUp {

	BEGINNING_INVESTIGATOR("0"),
	DISCLOSURE_lOBBYING_ACTIVITIES("1"),
	HAS_HISTORIC_PLACES("4"),
	HAS_HUMAN_SUBJECTS("5"),
	HAS_INTERNATIONAL_COOP("6"),
	HAS_PROPRIETY_AND_PRIVILEDGED_INFO("8"),
	HAS_VERTEBRATE_ANIMAL("11"),
	COUNTRY_CODE("XX");
	
	private final String code;
	
	private SpecialItemCodesLookUp(String code){
		this.code = code;
	}
	
	public String getCode(){
		return this.code;
	}
}
