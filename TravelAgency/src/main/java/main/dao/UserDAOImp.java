package main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.models.User;
@Repository
public class UserDAOImp implements UserDAO {
	 
	@Autowired
	private SessionFactory sessioFactory;

	@Override
	public User getById(Long id) {
		Session session = sessioFactory.getCurrentSession();
		return session.get(User.class, id) ;
	}

}
