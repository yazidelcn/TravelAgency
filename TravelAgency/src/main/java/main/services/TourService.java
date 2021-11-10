package main.services;

import java.util.List;

import main.models.Tour;

public interface TourService {
	public List<Tour> findAll();
	public Tour getById(Long id);
	public void saveOrUpdate(Tour tour);
	public void delete(Long id);
	public void addTourDetailsIfNotExist(Tour tour);
	public Tour tourByIdWithComments(Long id);

}
