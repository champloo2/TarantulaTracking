package dmacc.attributes;

import java.util.List;

import dmacc.beans.Molt;

public class MoltAttribute {
	
	private long appID;
	private List <Molt> maneuverList;
	
	public MoltAttribute(long appID, List<Molt> maneuverList) {
		super();
		this.appID = appID;
		this.maneuverList = maneuverList;
	}

	public long getAppID() {
		return appID;
	}

	public void setAppID(long appID) {
		this.appID = appID;
	}

	public List<Molt> getManeuverList() {
		return maneuverList;
	}

	public void setManeuverList(List<Molt> maneuverList) {
		this.maneuverList = maneuverList;
	}
	
	
	
	
	
	

}
