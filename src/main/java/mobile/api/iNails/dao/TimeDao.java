package mobile.api.iNails.dao;

import org.springframework.stereotype.Service;

import mobile.api.iNails.domain.Time;

@Service
public interface TimeDao {
	public int createTime(Time timeReservation);
    public int getLastInsert();
}
