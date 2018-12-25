package org.mail.service.impl;

import java.util.List;

import org.mail.DAO.IFriendDAO;
import org.mail.service.IFriendService;
import org.mail.vo.Friend;
import org.mail.vo.User;

public class FriendService implements IFriendService{
  IFriendDAO friendDAO;
  
	
	public IFriendDAO getFriendDAO() {
	return friendDAO;
}

public void setFriendDAO(IFriendDAO friendDAO) {
	this.friendDAO = friendDAO;
}

	@Override
	public void addFriend(Friend f) {
		// TODO Auto-generated method stub
		friendDAO.addFriend(f);
	}

	@Override
	public void deleteFriend(Friend f) {
		// TODO Auto-generated method stub
		friendDAO.deleteFriend(f);
	}

	@Override
	public List<Friend> getAllFriend(User user) {
		// TODO Auto-generated method stub
		return friendDAO.getAllFriend(user);
	}

}
