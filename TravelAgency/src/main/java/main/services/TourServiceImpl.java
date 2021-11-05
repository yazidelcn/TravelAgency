package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDAO;
import main.models.Tour;
@Service
public class TourServiceImpl implements TourService{
	@Autowired
	private TourDAO tourDAO;
	
	@Override
	public List<Tour> findAll() {
		return tourDAO.findAll();
	}

	@Override
	public Tour getById(Long id) {
		return tourDAO.getById(id);
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		tourDAO.saveOrUpdate(tour);
		
	}

	@Override
	public void delete(Long id) {
		tourDAO.delete(id);
	}

}
