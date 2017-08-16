package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mobile.api.iNails.domain.Artist;
import mobile.api.iNails.rowmapper.ArtistRowMapper;

@Repository
public class ArtistDaoImpl implements ArtistDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Artist> findAllArtists() {
		String sql = "SELECT * FROM Artist";
		RowMapper<Artist> rm = new ArtistRowMapper();
		try {
			List<Artist> list = jdbcTemplate.query(sql, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("No status found cause "+ e);
			return null;
		}
	}

	@Override
	public Artist findArtist(int artistID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createArtist(Artist artist) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateArtist(Artist artist) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArtist(int artistID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
