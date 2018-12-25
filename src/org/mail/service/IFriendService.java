package org.mail.service;

import java.util.List;

import org.mail.vo.Friend;
import org.mail.vo.User;

public interface IFriendService {
	public void addFriend(Friend f);
	public void deleteFriend(Friend f);
    public List<Friend> getAllFriend(User user);
}
