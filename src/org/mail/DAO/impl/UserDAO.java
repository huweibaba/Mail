package org.mail.DAO.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mail.DAO.IUserDAO;
import org.mail.util.Encrypt;
import org.mail.vo.User;
import org.mail.vo.Users;

public class UserDAO extends BaseDAO implements IUserDAO{
	

	@Override
	public User hasUser(String address, String password) {
		// TODO Auto-generated method stub
		
		String sql="from User u where u.address=? and u.password=?";
		Session session=getSession();
		System.out.println(1);
		Query query=session.createQuery(sql);
		System.out.println(2);
		query.setParameter(0,address);
		System.out.println(3);
		query.setParameter(1,password);
		System.out.println(4);
		List users=query.list();
		System.out.println(5);
		if(users.size()!=0)
		{
			User user=(User)users.get(0);
			return user;
		}
		System.out.println(6);
		session.close();
		return null;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		System.out.println("在userdao中打印收到信息："+user.getAddress()+"  "+user.getPassword()+"  "+user.getUsername()+"  "+user.getAge()+"  "+user.getSex());
		Users users=new Users();
		try {
			String encryptPassword=Encrypt.digestString(user.getPassword(),"SHA");
			System.out.println("在userdao中打印加密后密码："+encryptPassword);
			Pattern p=Pattern.compile("@"); 
			users.setUsername(p.split(user.getAddress())[0]);
			users.setPwdHash(encryptPassword);
			users.setPwdAlgorithm("SHA");
			users.setUseForwarding((short) 0);
			users.setUseAlias((short) 0);
			
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
		try
		{Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		session.save(users);
		tx.commit();
		session.close();}
		catch(Exception e)
		{e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		
		String sql="from User u where u.userid=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0,id);
		
		List users=query.list();
		if(users.size()!=0)
		{
			User user=(User)users.get(0);
			return user;
		}
		session.close();
		return null;
	}
	
	

}
