package org.mail.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.mail.service.IDraftService;
import org.mail.vo.Draft;
import org.mail.vo.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class DraftAction extends ActionSupport{
	IDraftService draftService;

	public IDraftService getDraftService() {
		return draftService;
	}

	public void setDraftService(IDraftService draftService) {
		this.draftService = draftService;
	}
	
	public void saveDraft() throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		
		System.out.println("成功进入存草稿"+request.getAttribute("subject"));
		Map session = ServletActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Draft d=new Draft();
		d.setFromAddress(user.getAddress());
		draftService.saveFileByRequest(request, d);
		d.setDate(new Timestamp(new Date().getTime()));
		draftService.saveDraft(d);
		System.out.println("成功保存草稿");
	}
	
	public void deleteDraft()
	{HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	response.setHeader("Access-Control-Allow-Credentials", "true");
	response.setContentType("text/plain; charset=utf-8");
	Map session = ServletActionContext.getContext().getSession();
	User user=(User)session.get("user");
	Draft d1=new Draft();
	d1.setWrittingid(new Integer(request.getParameter("id")));
	draftService.deleteDraft(d1);
    System.out.println("成功删除草稿");
	}
	
	public void sendDraft() throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		Map session = ServletActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Draft d2=new Draft();
		d2.setFromAddress(user.getAddress());
		d2.setToAddress(request.getParameter("toAddress"));
		d2.setDate(Timestamp.valueOf(request.getParameter("date")));
		draftService.sendDraft(d2);
	}
	
	public void getAllDraft() throws IOException
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		Map session = ServletActionContext.getContext().getSession();
		PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		User user = (User) session.get("user");
		List<Draft> list=draftService.getAllDraft(user);
		String responseJson=objectMapper.writeValueAsString(list);
		out.write(responseJson);
	    System.out.println("成功得到所有草稿"+responseJson);
	}
	

}
