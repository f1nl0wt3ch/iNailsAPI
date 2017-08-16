package mobile.api.iNails.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import mobile.api.iNails.domain.Status;

@Service
public interface StatusDao {
    public List<Status> findAllStatus();
    public Status findStatus(int statusID);
    public int createStatus(Status status);
    public int updateStatus(Status status);
    public int deleteStatus(int statusID);
}
