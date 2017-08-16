package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import mobile.api.iNails.domain.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Cart> findAllCarts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> findCartsByOrderNumber(int orderID) {
		return null;
	}

	@Override
	public Cart findCart(int cartID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createCart(Cart cart) {
		String sql = "INSERT INTO Cart(ServiceID_FK, OrderID_FK) VALUES (:serviceID, :orderID)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("serviceID", cart.getService().getServiceID());
		paramMap.addValue("orderID", cart.getOrder().getOrderID());
		try {
			int result = jdbcTemplate.update(sql, paramMap);
			return result;
		} catch (DataAccessException e) {
			System.out.println("Cannot create new cart cause "+ e);
			return 0;
		}
	}

	@Override
	public int updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCart(int orderID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
