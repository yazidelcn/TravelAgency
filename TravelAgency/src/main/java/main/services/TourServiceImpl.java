package main.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.Tour;
import main.models.User;
import main.repository.TourRepository;
import main.repository.UserRepository;
@Service
@Transactional
public class TourServiceImpl implements TourService{
	@Autowired
	private TourRepository tourRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public List<Tour> findAll() {
		return tourRepository.findAll();
	}

	@Override
	public Tour getById(Long id) {
		return tourRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		tourRepository.save(tour);
		
	}

	@Override
	public void delete(Long id) {
		tourRepository.deleteById(id);
	}

	
	@Override
	public Tour tourByIdWithComments(Long id) {
		return  tourRepository.tourByIdWithComments(id);
		}
	
	@Override
	public void addUserToTour(Long tourId, Long userId) {
		Tour tour = getById(tourId);
		if(tour.getUsers() == null) {
			tour.setUsers(new ArrayList<>());
		}
		
		User user = userRepository.findById(userId).get();
		if(user != null) {
		tour.getUsers().add(user);
		saveOrUpdate(tour);
		}
	}
	
	@Override
	public List<Tour> getAllForNextMonth() {
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.MONTH, 1);
		return tourRepository.findByDateBetween(currentDate, calendar.getTime());
	}

}
