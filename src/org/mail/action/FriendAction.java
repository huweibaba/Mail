package org.mail.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.mail.service.IFriendService;
import org.mail.vo.Friend;
import org.mail.vo.Receive;
import org.mail.vo.User;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FriendAction {
	IFriendService friendService;

	public IFriendService getFriendService() {
		return friendService;
	}

	public void setFriendService(IFriendService friendService) {
		this.friendService = friendService;
	}
	
	public void addFriend()
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		Map session = ServletActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Friend f=new Friend();
		f.setUserAddress(user.getAddress());
		f.setFriendAddress(request.getParameter("friendAddress"));
		f.setFriendName(request.getParameter("friendName"));
		friendService.addFriend(f);
	}
	
	public void deleteFriend()
	{

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		Map session = ServletActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Friend f=new Friend();
		f.setUserAddress(user.getAddress());
		f.setFriendAddress(request.getParameter("friendAddress"));
		f.setFriendName(request.getParameter("friendName"));
		friendService.deleteFriend(f);
	}
	
	public void getAllFriend() throws IOException
	{HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	response.setHeader("Access-Control-Allow-Credentials", "true");
	response.setContentType("text/plain; charset=utf-8");
	Map session = ServletActionContext.getContext().getSession();
	PrintWriter out = response.getWriter();
	ObjectMapper objectMapper = new ObjectMapper();
	User user = (User) session.get("user");
	List<Friend> list=friendService.getAllFriend(user);
	String responseJson=objectMapper.writeValueAsString(list);
	out.write(responseJson);
		
	}

}
