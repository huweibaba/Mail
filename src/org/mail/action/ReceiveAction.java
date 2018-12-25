package org.mail.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.mail.model.ReceiveModel;
import org.mail.service.IReceiveService;
import org.mail.vo.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class ReceiveAction extends ActionSupport {
	private IReceiveService receiveService;

	public IReceiveService getReceiveService() {
		return receiveService;
	}

	public void setReceiveService(IReceiveService receiveService) {
		this.receiveService = receiveService;
	}

	public void getAllReceiveMessage() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		Map session = ServletActionContext.getContext().getSession();
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		User user = (User) session.get("user");
		Pattern p = Pattern.compile("@");
		String host = p.split(user.getAddress())[1];
		String username = p.split(user.getAddress())[0];
		String password = user.getPassword();
		List<ReceiveModel> list = receiveService.getReceiveModelList(host, username, password);
		String responseJson = objectMapper.writeValueAsString(list);
		out.write(responseJson);
		System.out.println("成功得到所有邮件信息："+responseJson);
	}

	public void handleAttach() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");

		Map session = ServletActionContext.getContext().getSession();
		PrintWriter out = response.getWriter();
		int msgnum = Integer.parseInt(request.getParameter("msgnum")) + 1;
		int bodynum = Integer.parseInt(request.getParameter("bodynum"));
		String filename = request.getParameter("filename");
		Folder folder = (Folder) session.get("folder");
		
		try {
			Message msg = folder.getMessage(msgnum);

			// 将消息头类型设置为附件类型
			response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" + filename);

			Multipart multi = (Multipart) msg.getContent();
			BodyPart bodyPart = multi.getBodyPart(bodynum);

			InputStream is = bodyPart.getInputStream();
			int c = 0;
			while ((c = is.read()) != -1) {
				out.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getNoReadMessage() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");

		Map session = ServletActionContext.getContext().getSession();
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		User user=(User)session.get("user");
		List<ReceiveModel> list=receiveService.getNoReadMessage(user);
	    String responseJson=objectMapper.writeValueAsString(list);
	    out.write(responseJson);
	}
	
	public void changeTag()
	{HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	response.setHeader("Access-Control-Allow-Credentials", "true");

	Map session = ServletActionContext.getContext().getSession();
	
	User user=(User)session.get("user");
	String fromAddress=request.getParameter("fromAddress");
	
	String toAddress=user.getAddress();
	String sendtime=request.getParameter("sendtime");
	receiveService.changeTag(fromAddress, toAddress, sendtime);
		
	}

}
