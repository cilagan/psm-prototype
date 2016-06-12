package gov.nsf.research.psm.model;

public enum FindingLevel {

	INFO,
	WARNING,
	ERROR;
	
	public static FindingLevel getFindingLevel(String input){
		if(INFO.name().equals(input)){
			return FindingLevel.INFO;
		} else if(WARNING.name().equals(input)){
			return FindingLevel.WARNING;
		} else if(ERROR.name().equals(input)){
			return FindingLevel.ERROR;
		} else {
			return null;
		}
	}
}
