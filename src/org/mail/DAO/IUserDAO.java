package org.mail.DAO;

import java.security.NoSuchAlgorithmException;

import org.mail.vo.User;

public interface IUserDAO {
	public User hasUser(String username,String password);
	public boolean register(User user) ;
	public User getUserById(Integer id);
	
}
