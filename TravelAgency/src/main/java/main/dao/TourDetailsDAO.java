package main.dao;

import main.models.TourDetails;

public interface TourDetailsDAO {
	
	public TourDetails getById(Long id);
	public void saveOrUpdate(TourDetails tourDetails);
	public void delete(Long id);

}
