package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import mobile.api.iNails.domain.Invoice;
import mobile.api.iNails.domain.Order;

@Service
public interface OrderDao {
   public List<Order> findAllOrders();
   public Order findOrder(int orderID);
   public Invoice findInvoiceByOrderNumber(int orderID);
   public int createOrder(Order order);
   public int updateOrder(Order order);
   public int deleteOrder(int orderID);
   public int getLastInsert();
}
