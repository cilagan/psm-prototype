package gov.nsf.research.psm.model.wrapper;

import java.util.ArrayList;
import java.util.List;

import gov.nsf.research.psm.model.AbstractTransferObject;
import gov.nsf.research.psm.model.ServiceNotification;

public class BaseRequest extends AbstractTransferObject{

	private static final long serialVersionUID = -1492342891054193934L;
	
	private List<ServiceNotification> snList;

	public BaseRequest() {
		super();
		snList = new ArrayList<ServiceNotification>();
	}

	/**
	 * @return the snList
	 */
	public List<ServiceNotification> getSnList() {
		return snList;
	}

	/**
	 * @param snList the snList to set
	 */
	public void setSnList(List<ServiceNotification> snList) {
		this.snList = snList;
	}

}
