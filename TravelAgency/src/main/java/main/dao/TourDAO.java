package main.dao;

import java.util.List;

import main.models.Tour;

public interface TourDAO {
	public List<Tour> findAll();
	public Tour getById(Long id);
	public void saveOrUpdate(Tour tour);
	public void delete(Long id);
	public Tour tourByIdWithComments(Long id);
}
