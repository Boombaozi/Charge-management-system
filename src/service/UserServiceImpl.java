package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;


public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		
		
	}





	public User login(User user) {
		User u = null;
		
		try {
			u= userDao.findUser(user);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return u;
	}
	



	public boolean finduserbyname(String id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUserByName(id);
	}
	

	
	
	
}
