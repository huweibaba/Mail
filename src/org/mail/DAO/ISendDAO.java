package org.mail.DAO;

import java.util.List;

import org.mail.vo.SendModel;
import org.mail.vo.User;

public interface ISendDAO {
	public boolean saveSendMessage(SendModel sm);
	public List<SendModel> getAllSendMessage(User user);
	public void deleteSendModel(SendModel sendModel);
	

}
