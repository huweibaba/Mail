package org.mail.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mail.vo.Draft;
import org.mail.vo.User;

public interface IDraftService {
	public void saveDraft(Draft d) ;
	public void saveFileByRequest(HttpServletRequest request,Draft d) throws Exception;
	public void deleteDraft(Draft d);
	public void sendDraft(Draft d) throws Exception;
	public List<Draft> getAllDraft(User u);
}
