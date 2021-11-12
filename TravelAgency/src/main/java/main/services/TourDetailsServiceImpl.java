package main.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.TourDetails;
import main.repository.TourDetailsRepository;

@Service
@Transactional
public class TourDetailsServiceImpl implements TourDetailsService {
	@Autowired
	private TourDetailsRepository tourDetailsRepository;

	@Override
	public TourDetails getById(Long id) {
		return tourDetailsRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(TourDetails tourDetails) {
		tourDetailsRepository.save(tourDetails);
	}

	@Override
	public void delete(Long id) {
		tourDetailsRepository.deleteById(id);
	}
	
	
	

}
