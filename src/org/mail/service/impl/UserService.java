package org.mail.service.impl;


import org.mail.DAO.IUserDAO;
import org.mail.service.IUserService;
import org.mail.vo.User;

public class UserService implements IUserService{
	private IUserDAO userDAO;
	

	public IUserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Override
	public User hasUser(String username, String password) {
		// TODO Auto-generated method stub
	  return userDAO.hasUser(username, password);
	}


	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return userDAO.register(user);
	}
	
	public User getUserById(Integer id)
	{
		return userDAO.getUserById(id);
	}
	

}
