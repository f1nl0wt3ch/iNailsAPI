package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mobile.api.iNails.domain.Category;
import mobile.api.iNails.rowmapper.CategoryRowMapper;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Category> findAllCategories() {
		String sql = "SELECT * FROM Category";
		RowMapper<Category> rm = new CategoryRowMapper();
		try {
			List<Category> list = jdbcTemplate.query(sql, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("No category found cause "+ e);
			return null;

		}
	}

	@Override
	public Category findCategory(int categoryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(int categoryID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
