package org.mail.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mail.DAO.IFriendDAO;
import org.mail.vo.Friend;
import org.mail.vo.Receive;
import org.mail.vo.User;

public class FriendDAO extends BaseDAO implements IFriendDAO{

	@Override
	public void addFriend(Friend f) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(f);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteFriend(Friend f) {
		// TODO Auto-generated method stub
	
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		String hql = "Delete FROM Friend f Where f.userAddress=? and f.friendAddress=? and f.friendName=?" ;     
        Query query = session.createQuery(hql) ;   
        query.setParameter(0,f.getUserAddress());
        query.setParameter(1,f.getFriendAddress());
        query.setParameter(2,f.getFriendName());
        query.executeUpdate();
		tx.commit();
		session.close();
	}

	@Override
	public List<Friend> getAllFriend(User user) {
		// TODO Auto-generated method stub
		
		String userAddress=user.getAddress();
		String sql="from Friend f where f.userAddress=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,userAddress);
		List<Friend> list=query.list();
		return list;
		
	}

}
