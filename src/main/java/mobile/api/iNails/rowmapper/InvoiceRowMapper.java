package mobile.api.iNails.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mobile.api.iNails.domain.Artist;
import mobile.api.iNails.domain.ArtistImpl;
import mobile.api.iNails.domain.Customer;
import mobile.api.iNails.domain.CustomerImpl;
import mobile.api.iNails.domain.Invoice;
import mobile.api.iNails.domain.InvoiceImpl;
import mobile.api.iNails.domain.Order;
import mobile.api.iNails.domain.OrderImpl;
import mobile.api.iNails.domain.Status;
import mobile.api.iNails.domain.StatusImpl;

public class InvoiceRowMapper implements RowMapper<Invoice> {

	@Override
	public Invoice mapRow(ResultSet rs, int row) throws SQLException {
		Invoice invoice = new InvoiceImpl();
		
		Status status = new StatusImpl();
		status.setName(rs.getString("Status"));
		
		Customer customer = new CustomerImpl();
		customer.setName(rs.getString("Customer"));
		customer.setPhone(rs.getString("CustomerPhone"));
		
		Artist artist = new ArtistImpl();
		artist.setName(rs.getString("Artist"));
		
		Order order = new OrderImpl();
		order.setOrderID(rs.getInt("o.OrderID"));
		order.setOrderDate(rs.getDate("o.Date"));
		
		
		invoice.setDuration(rs.getInt("Duration"));
		invoice.setTotalPayment(rs.getDouble("TotalPayment"));
		invoice.setServices(rs.getString("Services"));
		invoice.setArtist(artist);
		invoice.setCustomer(customer);
		invoice.setOrder(order);
		invoice.setStatus(status);
		
		return invoice;
	}

}
