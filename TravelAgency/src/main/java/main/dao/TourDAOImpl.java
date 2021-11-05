package main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.models.Tour;
@Repository
public class TourDAOImpl implements TourDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Tour> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Tour t", Tour.class).list();
	}

	@Override
	@Transactional
	public Tour getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Tour.class, id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Tour tour) {
		Session session = sessionFactory.getCurrentSession();
		session.save(tour);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Tour selectedTour= getById(id);
		session.delete(selectedTour);
	}

}
