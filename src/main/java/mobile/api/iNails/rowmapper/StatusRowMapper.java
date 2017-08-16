package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import mobile.api.iNails.domain.Status;
import mobile.api.iNails.domain.StatusImpl;

public class StatusRowMapper implements RowMapper<Status> {

	@Override
	public Status mapRow(ResultSet rs, int row) throws SQLException {
		Status status = new StatusImpl();
		status.setStatusID(rs.getInt("StatusID"));
		status.setName(rs.getString("Name"));
		return status;
	}

}
