package org.mail.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mail.DAO.IReceiveDAO;
import org.mail.vo.Receive;
import org.mail.vo.SendModel;
import org.mail.vo.User;

public class ReceiveDAO extends BaseDAO implements IReceiveDAO{

	@Override
	public List<Receive> getAllSavedMessage(User user) {
		
		String toAddress=user.getAddress();
		String sql="from Receive r where r.toAddress=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,toAddress);
		List<Receive> list=query.list();
		return list;
	}

	@Override
	public void saveNewMessage(Receive re) {
		// TODO Auto-generated method stub
		try
		{Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(re);
		tx.commit();
		session.close();
			}
		catch(Exception e)
		{e.printStackTrace();
			
		}
}

	@Override
	public void changeTag( String fromAddress, String toAddress, String sendtime) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		String hql="update Receive re set re.isread=1 where re.fromAddress=? and re.toAddress=? and re.sendtime=? ";
		System.out.println(fromAddress);
		System.out.println(toAddress);
		System.out.println(sendtime);
		Query query=session.createQuery(hql);
		query.setParameter(0,fromAddress);
		query.setParameter(1, toAddress);
		query.setParameter(2,sendtime);
		
		
		
		
		
		query.executeUpdate();
		trans.commit();
		
	}

}
