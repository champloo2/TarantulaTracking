package dmacc.attributes;

import java.util.List;

import dmacc.beans.Molt;

public class MoltAttribute {
	
	private long appID;
	private List <Molt> moltList;
	
	public MoltAttribute(long appID, List<Molt> moltList) {
		super();
		this.appID = appID;
		this.moltList = moltList;
	}

	public long getAppID() {
		return appID;
	}

	public void setAppID(long appID) {
		this.appID = appID;
	}

	public List<Molt> getmoltList() {
		return moltList;
	}

	public void setmoltList(List<Molt> moltList) {
		this.moltList = moltList;
	}
	
	
	
	
	
	

}
