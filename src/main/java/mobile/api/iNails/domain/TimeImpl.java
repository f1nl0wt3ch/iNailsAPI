package mobile.api.iNails.domain;

import java.sql.Date;

public class TimeImpl implements Time{
	private int timeID;
	private String time;
	private Date date;
	private Artist artist;
	public TimeImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TimeImpl(int timeID, String time, Date date, Artist artist) {
		super();
		this.timeID = timeID;
		this.time = time;
		this.date = date;
		this.artist = artist;
	}
	public int getTimeID() {
		return timeID;
	}
	public void setTimeID(int timeID) {
		this.timeID = timeID;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
	

}
