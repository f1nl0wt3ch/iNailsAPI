package mobile.api.iNails.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mobile.api.iNails.domain.Time;
import mobile.api.iNails.rowmapper.TimeRowMapper;

@Repository
public class TimeDaoImpl implements TimeDao{
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int createTime(Time timeReservation) {
		String sql = "INSERT INTO Time(Time,ArtistID_FK,Date) VALUES (:time,:artistID,:date)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("time", timeReservation.getTime());
		paramMap.addValue("artistID", timeReservation.getArtist().getArtistID());
		paramMap.addValue("date", timeReservation.getDate());
		try {
			 int row = jdbcTemplate.update(sql, paramMap);
			 System.out.println("row "+ row);
			 return row;
		} catch (DataAccessException e) {
			System.out.println("Cannot insert new time cause "+e);
			return 0;
		}
	}

	@Override
	public int getLastInsert() {
		String sql = "SELECT * FROM Time ORDER BY TimeID DESC LIMIT 1";
		RowMapper<Time> rm = new TimeRowMapper();
		return jdbcTemplate.query(sql, rm).get(0).getTimeID();
	}


}
