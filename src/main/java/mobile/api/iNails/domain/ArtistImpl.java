package mobile.api.iNails.domain;

public class ArtistImpl implements Artist{
    private int artistID;
    private String name;
    private String phone;
    private String avatar;
	public ArtistImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArtistImpl(int artistID, String name, String phone, String avatar) {
		super();
		this.artistID = artistID;
		this.name = name;
		this.phone = phone;
		this.avatar = avatar;
	}
	public int getArtistID() {
		return artistID;
	}
	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
    
    
}
