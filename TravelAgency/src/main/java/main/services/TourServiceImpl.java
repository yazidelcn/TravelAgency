package main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDAO;
import main.models.Tour;
import main.models.TourDetails;
@Service
@Transactional
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

	@Override
	public void addTourDetailsIfNotExist(Tour tour) {
		if (tour.getTourDetails() == null) {
			tour.setTourDetails(new TourDetails());
			tourDAO.saveOrUpdate(tour);
		}
	}
	
	@Override
	public Tour tourByIdWithComments(Long id) {
		return tourDAO.tourByIdWithComments(id);
	}

}
