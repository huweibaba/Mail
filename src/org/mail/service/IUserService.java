package org.mail.service;

import org.mail.vo.User;

public interface IUserService {
	public User hasUser(String username,String password);
	public boolean register(User user);
	public User getUserById(Integer id);
	

}
