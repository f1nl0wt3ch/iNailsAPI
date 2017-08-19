package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.CustomerImpl;
import mobile.api.iNails.domain.Order;
import mobile.api.iNails.domain.OrderImpl;
import mobile.api.iNails.domain.StatusImpl;
import mobile.api.iNails.domain.TimeImpl;

public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int row) throws SQLException {
		Order order = new OrderImpl();
		CustomerImpl customer = new CustomerImpl();
		StatusImpl status = new StatusImpl();
		TimeImpl timeReservation = new TimeImpl();
		customer.setCustomerID(rs.getInt("CustomerID_FK"));
		status.setStatusID(rs.getInt("StatusID_FK"));
		order.setOrderID(rs.getInt("OrderID"));
		timeReservation.setTimeID(rs.getInt("TimeID_FK"));
		
		order.setTimeReservation(timeReservation);
		order.setCustomer(customer);
		order.setStatus(status);
		order.setTimeReservation(timeReservation);
		
		order.setOrderDate(rs.getDate("OrderDate"));
		return order;
	}

}
