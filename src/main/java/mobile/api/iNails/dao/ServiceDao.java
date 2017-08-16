package mobile.api.iNails.dao;

import java.util.List;

import mobile.api.iNails.domain.Service;

public interface ServiceDao {
   public List<Service> findAllService();
   public List<Service> findServicesByCategory(int categoryID);
   public List<Service> findServicesByCategory(List<Integer> categoryIdList);
   public Service findService(int serviceID);
   public int createService(Service service);
   public int updateService(Service service);
   public int deleteService(int serviceID);
}
