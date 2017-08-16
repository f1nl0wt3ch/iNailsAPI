package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.Cart;
import mobile.api.iNails.domain.CartImpl;
import mobile.api.iNails.domain.OrderImpl;
import mobile.api.iNails.domain.ServiceImpl;

public class CartRowMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int row) throws SQLException {
        Cart cart = new CartImpl();
        
        ServiceImpl service = new ServiceImpl();
        service.setServiceID(rs.getInt("ServiceID_FK"));
        OrderImpl order = new OrderImpl();
        order.setOrderID(rs.getInt("OrderID_FK"));
        
        cart.setService(service);
        cart.setOrder(order);
		return cart;
	}

}
