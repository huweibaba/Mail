package org.mail.service;

import java.util.List;

import org.mail.model.ReceiveModel;
import org.mail.vo.User;

public interface IReceiveService {
	public List<ReceiveModel> getReceiveModelList(String host, String username, String password) throws Exception;
	public List<ReceiveModel> getNoReadMessage(User user) throws Exception;
	public void changeTag(String fromAddress,String toAddress,String sendtime);

}
