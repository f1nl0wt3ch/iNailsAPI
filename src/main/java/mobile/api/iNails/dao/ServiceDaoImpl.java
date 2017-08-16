package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mobile.api.iNails.domain.Service;
import mobile.api.iNails.rowmapper.ServiceRowMapper;

@Repository
public class ServiceDaoImpl implements ServiceDao {
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Service> findAllService() {
		String sql = "SELECT * FROM Service";
		RowMapper<Service> rm = new ServiceRowMapper();
		try {
			List<Service> list = jdbcTemplate.query(sql, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("No service found cause "+ e);
			return null;
		}
	}

	@Override
	public Service findService(int serviceID) {
		String sql = "SELECT * FROM Service WHERE ServiceID = :serviceID";
		RowMapper<Service> rm = new ServiceRowMapper();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("serviceID", serviceID);
		try {
			Service service = jdbcTemplate.queryForObject(sql, paramMap, rm);
			return service;
		} catch (DataAccessException e) {
			System.out.println("No service found cause "+e);
			return null;
		}
	}

	@Override
	public int createService(Service service) {
		String sql = "INSERT INTO Service(Name, CategoryID_FK, Time, Price) values (:name, :categoryID_FK, :time, :price)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", service.getName());
		paramMap.addValue("categoryID_FK", service.getCategory().getCategoryID());
		paramMap.addValue("time", service.getTime());
		paramMap.addValue("price", service.getPrice());
		try {
			int result = jdbcTemplate.update(sql, paramMap);
			return result;
		} catch (DataAccessException e) {
			System.out.println("Cannot create new service cause "+ e);
			return 0;
		}
	}

	@Override
	public int updateService(Service service) {
		String sql = "UPDATE Service SET Name = :name, CategoryID_FK = :categoryID_FK, Time = :time, price = :price WHERE ServiceID = :serviceID";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", service.getName());
		paramMap.addValue("CategoryID_FK", service.getCategory().getCategoryID());
		paramMap.addValue("time", service.getTime());
		paramMap.addValue("price", service.getPrice());
		paramMap.addValue("ServiceID", service.getServiceID());
		try {
			int result = jdbcTemplate.update(sql, paramMap);
			return result;
		} catch (DataAccessException e) {
			System.out.println("Cannot update service cause "+e);
			return 0;
		}
	}

	@Override
	public int deleteService(int serviceID) {
		String sql = "DELETE FROM Service WHERE ServiceID = :serviceID";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("serviceID", serviceID);
		try {
			int result = jdbcTemplate.update(sql, paramMap);
			return result;
		} catch (DataAccessException e) {
			System.out.println("Cannot delete service cause "+e);
			return 0;
		}
		
	}

	@Override
	public List<Service> findServicesByCategory(int categoryID) {
		String sql = "SELECT * FROM Service WHERE CategoryID_FK = :categoryID";
		RowMapper<Service> rm = new ServiceRowMapper();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("categoryID", categoryID);
		try {
			List<Service> list = jdbcTemplate.query(sql, paramMap, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("No service found cause "+ e);
			return null;
		}
	}
}
