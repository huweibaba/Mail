package org.mail.DAO;

import java.util.List;

import org.mail.vo.Receive;
import org.mail.vo.User;

public interface IReceiveDAO {
	public List<Receive> getAllSavedMessage(User user);
	public void saveNewMessage(Receive re);
	public void changeTag(String fromAddress,String toAddress,String sendtime);

}
