package main.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDAO;
import main.dao.UserDAO;
import main.models.Tour;
import main.models.TourDetails;
import main.models.User;
@Service
@Transactional
public class TourServiceImpl implements TourService{
	@Autowired
	private TourDAO tourDAO;
	
	@Autowired 
	private UserDAO userDAO;
	
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
	public Tour tourByIdWithComments(Long id) {
		return tourDAO.tourByIdWithComments(id);
	}
	
	@Override
	public void addUserToTour(Long tourId, Long userId) {
		Tour tour = getById(tourId);
		if(tour.getUsers() == null) {
			tour.setUsers(new ArrayList<>());
		}
		
		User user = userDAO.getById(userId);
		if(user != null) {
		tour.getUsers().add(user);
		saveOrUpdate(tour);
		}
	}

}
