package org.mail.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mail.DAO.ISendDAO;
import org.mail.mailServer.Send;
import org.mail.service.ISendService;

import org.mail.util.FileUtil;
import org.mail.vo.SendModel;
import org.mail.vo.User;

public class SendService implements ISendService{
    Send send;
    ISendDAO sendDAO;
    FileUtil fu;
    
	public ISendDAO getSendDAO() {
		return sendDAO;
	}

	public void setSendDAO(ISendDAO sendDAO) {
		this.sendDAO = sendDAO;
	}

	public Send getSend() {
		return send;
	}

	public void setSend(Send send) {
		this.send = send;
	}
	

	public FileUtil getFu() {
		return fu;
	}

	public void setFu(FileUtil fu) {
		this.fu = fu;
	}

	@Override
	public void sendMessage(SendModel sm) throws Exception {
		// TODO Auto-generated method stub
		send.sendMessage(sm);
		
	}

	@Override
	public boolean saveSendMessage(SendModel sm) {
		// TODO Auto-generated method stub
		
		return sendDAO.saveSendMessage(sm);
				
	}

	public void saveFileByRequest(HttpServletRequest request,SendModel sm) throws Exception {
		// TODO Auto-generated method stub
		
		 fu.saveFileByRequest(request,sm);
	}

	@Override
	public List<SendModel> getAllSendMessage(User user) {
		// TODO Auto-generated method stub
		return sendDAO.getAllSendMessage(user);
	}

	@Override
	public void deleteSendModel(SendModel sendModel) {
		// TODO Auto-generated method stub
	      sendDAO.deleteSendModel(sendModel);
	}

}
