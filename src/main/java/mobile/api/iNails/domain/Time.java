package mobile.api.iNails.domain;

import java.sql.Date;

public interface Time {
	public int getTimeID();
	public void setTimeID(int timeID);
	public String getTime();
	public void setTime(String time);
	public Date getDate();
	public void setDate(Date date);
	public Artist getArtist();
	public void setArtist(Artist artist);

}
