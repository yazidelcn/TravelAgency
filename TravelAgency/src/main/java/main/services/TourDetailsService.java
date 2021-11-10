package main.services;

import main.models.TourDetails;

public interface TourDetailsService {
	public TourDetails getById(Long id);
	public void saveOrUpdate(TourDetails tourDetails);
	public void delete(Long id);


}
