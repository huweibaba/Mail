package org.mail.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mail.vo.SendModel;
import org.mail.vo.User;

public interface ISendService {
	public void sendMessage(SendModel sm) throws Exception;
	public boolean saveSendMessage(SendModel sm);
	public void saveFileByRequest(HttpServletRequest request,SendModel sm) throws Exception;
	public List<SendModel> getAllSendMessage(User user);
	public void deleteSendModel(SendModel sendModel);
}
