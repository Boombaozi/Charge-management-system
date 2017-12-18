package service;

import domain.User;

public interface UserService {

	
	public void register(User user) throws Exception;
	
	
	
	
	public User login(User user)throws Exception;
	
	
	
	
	public boolean finduserbyname(String id)throws Exception;
	
	
}
