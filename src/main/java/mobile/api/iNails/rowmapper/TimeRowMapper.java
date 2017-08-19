package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.ArtistImpl;
import mobile.api.iNails.domain.Time;
import mobile.api.iNails.domain.TimeImpl;

public class TimeRowMapper implements RowMapper<Time> {

	@Override
	public Time mapRow(ResultSet rs, int row) throws SQLException {
		TimeImpl timeReservation = new TimeImpl();
		ArtistImpl artist = new ArtistImpl();
		
		artist.setArtistID(rs.getInt("ArtistID_FK"));
		
		timeReservation.setTimeID(rs.getInt("TimeID"));
		timeReservation.setDate(rs.getDate("Date"));
		timeReservation.setTime(rs.getString("Time"));
		timeReservation.setArtist(artist);
		
		return timeReservation;
	}

}
