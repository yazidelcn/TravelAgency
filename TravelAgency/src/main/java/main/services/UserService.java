package main.services;

import main.models.User;

public interface UserService {
	
	public void createNewAccount(User user);
	public boolean loginExists(String login);
	
	
}
