package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.Category;
import mobile.api.iNails.domain.CategoryImpl;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int row) throws SQLException {
		Category category = new CategoryImpl();
		category.setCategoryID(rs.getInt("CategoryID"));
		category.setName(rs.getString("Name"));
		return category;
	}

}
