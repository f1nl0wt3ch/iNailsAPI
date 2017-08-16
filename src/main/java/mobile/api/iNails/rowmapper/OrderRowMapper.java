package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.ArtistImpl;
import mobile.api.iNails.domain.CustomerImpl;
import mobile.api.iNails.domain.Order;
import mobile.api.iNails.domain.OrderImpl;
import mobile.api.iNails.domain.StatusImpl;

public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int row) throws SQLException {
		Order order = new OrderImpl();
		CustomerImpl customer = new CustomerImpl();
		ArtistImpl artist = new ArtistImpl();
		StatusImpl status = new StatusImpl();
		customer.setCustomerID(rs.getInt("CustomerID_FK"));
		artist.setArtistID(rs.getInt("ArtistID_FK"));
		status.setStatusID(rs.getInt("StatusID_FK"));
		order.setOrderID(rs.getInt("OrderID"));
		order.setArtist(artist);
		order.setCustomer(customer);
		order.setStatus(status);
		order.setOrderDate(rs.getDate("OrderDate"));
		return order;
	}

}
