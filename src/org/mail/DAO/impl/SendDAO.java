package org.mail.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mail.DAO.ISendDAO;
import org.mail.vo.SendModel;
import org.mail.vo.User;

public class SendDAO extends BaseDAO implements ISendDAO {

	@Override
	public boolean saveSendMessage(SendModel sm) {
		// TODO Auto-generated method stub
		try
		{Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(sm);
		tx.commit();
		session.close();
		return true;
		}
		catch(Exception e)
		{   e.printStackTrace();
			return false;
		}
		
	}

	public List <SendModel> getAllSendMessage(User user) {
		// TODO Auto-generated method stub
		String fromAddress=user.getAddress();
		String sql="from SendModel s where s.fromAddress=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,fromAddress);
		
		List<SendModel> list=query.list();
		return list;
	}
	
	public void deleteSendModel(SendModel sendModel)
	{
		
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		String hql = "Delete FROM SendModel d Where d.sendid=?" ;     
        Query query = session.createQuery(hql) ;   
        query.setParameter(0,sendModel.getSendid());
       
        query.executeUpdate();
		tx.commit();
		session.close();
	}
	
	

}
