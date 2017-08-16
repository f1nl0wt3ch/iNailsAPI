package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.CategoryImpl;
import mobile.api.iNails.domain.Service;
import mobile.api.iNails.domain.ServiceImpl;

public class ServiceRowMapper implements RowMapper<Service> {

	@Override
	public Service mapRow(ResultSet rs, int row) throws SQLException {
		Service service = new ServiceImpl();
		CategoryImpl category = new CategoryImpl();
		category.setCategoryID(rs.getInt("CategoryID_FK"));
		service.setCategory(category);
		service.setServiceID(rs.getInt("ServiceID"));
		service.setName(rs.getString("Name"));
		service.setTime(rs.getDouble("Time"));
		service.setPrice(rs.getDouble("Price"));
		return service;
	}

}
