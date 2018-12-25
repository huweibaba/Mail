package org.mail.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mail.DAO.IDraftDAO;
import org.mail.mailServer.Send;
import org.mail.service.IDraftService;
import org.mail.util.FileUtil;
import org.mail.vo.Draft;
import org.mail.vo.SendModel;
import org.mail.vo.User;

public class DraftService implements IDraftService{
  IDraftDAO draftDAO;
  FileUtil fu;
  Send send;
  
  
	

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



	public IDraftDAO getDraftDAO() {
	return draftDAO;
}



public void setDraftDAO(IDraftDAO draftDAO) {
	this.draftDAO = draftDAO;
}



	@Override
	public void saveDraft(Draft d) {
		// TODO Auto-generated method stub
		draftDAO.saveDraft(d);
	}



	@Override
	public void saveFileByRequest(HttpServletRequest request, Draft d) throws Exception {
		// TODO Auto-generated method stub
		SendModel sm=new SendModel();
		fu.saveFileByRequest(request, sm);
		d.setAttachmentLink(sm.getAttachmentLink());
		d.setAttachmentName(sm.getAttachmentName());
		d.setSubject(sm.getSubject());
		d.setText(sm.getText());
		d.setToAddress(sm.getToAddress());
	}



	@Override
	public void deleteDraft(Draft d) {
		// TODO Auto-generated method stub
		draftDAO.deleteDraft(d);
	}



	@Override
	public void sendDraft(Draft d) throws Exception {
		// TODO Auto-generated method stub
		SendModel sm=new SendModel();
	    d=draftDAO.getSingleDraft(d);
	    sm.setAttachmentLink(d.getAttachmentLink());
	    sm.setAttachmentName(d.getAttachmentName());
	    sm.setFromAddress(d.getFromAddress());
	    sm.setSize(d.getSize());
	    sm.setSubject(d.getSubject());
	    sm.setText(d.getText());
	    sm.setToAddress(d.getToAddress());
	    sm.setDate(new Timestamp(new Date().getTime()));
	    draftDAO.deleteDraft(d);
	    send.sendMessage(sm);
	
	}



	@Override
	public List<Draft> getAllDraft(User u) {
		// TODO Auto-generated method stub
		return draftDAO.getAllDraft(u);
	}	

}
