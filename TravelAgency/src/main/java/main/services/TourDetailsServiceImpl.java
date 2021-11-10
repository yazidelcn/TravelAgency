package main.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.TourDetailsDAO;
import main.models.TourDetails;

@Service
@Transactional
public class TourDetailsServiceImpl implements TourDetailsService {
	@Autowired
	private TourDetailsDAO tourDetailsRepository;

	@Override
	public TourDetails getById(Long id) {
		return tourDetailsRepository.getById(id);
	}

	@Override
	public void saveOrUpdate(TourDetails tourDetails) {
		tourDetailsRepository.saveOrUpdate(tourDetails);
	}

	@Override
	public void delete(Long id) {
		tourDetailsRepository.delete(id);
	}
	
	
	

}
