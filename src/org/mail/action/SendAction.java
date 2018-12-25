package org.mail.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.mail.service.ISendService;
import org.mail.service.impl.ReceiveService;
import org.mail.vo.SendModel;
import org.mail.vo.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport{
	private SendModel sm;
    private ISendService sendService;
    
	public ISendService getSendService() {
		return sendService;
	}

	public void setSendService(ISendService sendService) {
		this.sendService = sendService;
	}

	public SendModel getSm() {
		return sm;
	}

	public void setSm(SendModel sm) {
		this.sm = sm;
	}
	
	public void sendMessage() throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		Map session=ServletActionContext.getContext().getSession();
		User user=(User)session.get("user");
		sm.setFromAddress(user.getAddress());
		sendService.saveFileByRequest(request,sm);
		
	    sendService.saveSendMessage(sm);
	    sendService.sendMessage(sm);
		
	}
	
	public void getAllSendMessage() throws IOException
	{HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	response.setHeader("Access-Control-Allow-Credentials", "true");
	response.setContentType("text/plain; charset=utf-8");
	Map session=ServletActionContext.getContext().getSession();
	PrintWriter out = response.getWriter();
	ObjectMapper objectMapper = new ObjectMapper();
	User user=(User)session.get("user");
	List<SendModel> list=sendService.getAllSendMessage(user);
	String responseJson=objectMapper.writeValueAsString(list);
	out.write(responseJson);
		
	}
	
	public void deleteSendMessage()
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		Map session=ServletActionContext.getContext().getSession();
	    SendModel sendModel=new SendModel();
	    sendModel.setSendid(new Integer(request.getParameter("id")));
	    sendService.deleteSendModel(sendModel);
	}

}
