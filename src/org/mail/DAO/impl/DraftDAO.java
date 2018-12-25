package org.mail.DAO.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mail.DAO.IDraftDAO;
import org.mail.vo.Draft;
import org.mail.vo.User;

public class DraftDAO extends BaseDAO implements IDraftDAO{

	@Override
	public void saveDraft(Draft d) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(d);
		tx.commit();
		session.close();
	}
	
	public void deleteDraft(Draft d)
	{
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		String hql = "Delete FROM Draft d Where d.writtingid=?" ;     
        Query query = session.createQuery(hql) ;   
        query.setParameter(0,d.getWrittingid());
       
        query.executeUpdate();
		tx.commit();
		session.close();
	}

	@Override
	public Draft getSingleDraft(Draft d) {
		// TODO Auto-generated method stub
		Session session=getSession();
		
		String hql = "FROM Draft d Where d.fromAddress=? and d.toAddress=? and d.date=?" ;     
        Query query = session.createQuery(hql) ;   
        query.setParameter(0,d.getFromAddress());
        query.setParameter(1,d.getToAddress());
        query.setParameter(2,d.getDate());
        List<Draft> list=query.list();
        return (Draft)list.get(0);
	}

	@Override
	public List<Draft> getAllDraft(User u) {
		// TODO Auto-generated method stub
		String fromAddress=u.getAddress();
        Session session=getSession();
		
		String hql = "FROM Draft d Where d.fromAddress=?" ;     
        Query query = session.createQuery(hql) ;   
        query.setParameter(0,fromAddress);
       List<Draft> list= query.list();
       return list;
		
		
		
		
		
	}

}
