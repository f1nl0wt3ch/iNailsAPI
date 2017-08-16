package mobile.api.iNails.domain;

public class StatusImpl implements Status {
    private int statusID;
    private String name;
	public StatusImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatusImpl(int statusID, String name) {
		super();
		this.statusID = statusID;
		this.name = name;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
