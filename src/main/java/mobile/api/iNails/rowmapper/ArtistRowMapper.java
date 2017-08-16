package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.Artist;
import mobile.api.iNails.domain.ArtistImpl;

public class ArtistRowMapper implements RowMapper<Artist> {

	@Override
	public Artist mapRow(ResultSet rs, int row) throws SQLException {
		Artist artist = new ArtistImpl();
		artist.setArtistID(rs.getInt("ArtistID"));
        artist.setName(rs.getString("Name"));
        artist.setPhone(rs.getString("Phone"));
        artist.setAvatar(rs.getString("Picture"));
		return artist;
	}

}
