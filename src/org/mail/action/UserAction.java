package org.mail.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.mail.service.IUserService;
import org.mail.vo.SendModel;
import org.mail.vo.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private IUserService userService;
    private SendModel sm;
    
    
	

	public SendModel getSm() {
		return sm;
	}

	public void setSm(SendModel sm) {
		this.sm = sm;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void getUserMessage() throws IOException {
	    System.out.println(sm);
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
        //response.setHeader("Access-Control-Allow-Origin", request.getHeader("*"));
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("text/plain; charset=utf-8");
		Map session=ServletActionContext.getContext().getSession();
        PrintWriter out = response.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		User user = userService.hasUser(address, password);
		if(user!=null)
		{
			session.put("user", user);
			
		}
		String responseJson = objectMapper.writeValueAsString(user);
	    System.out.println("完成用户信息查询，返回："+responseJson);
		out.write(responseJson);
		
		

	}
	
	public void register() throws IOException, NoSuchAlgorithmException
	{HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	response.setHeader("Access-Control-Allow-Credentials", "true");
	response.setContentType("text/plain; charset=utf-8");
	Map session=ServletActionContext.getContext().getSession();
	PrintWriter out = response.getWriter();
	ObjectMapper objectMapper = new ObjectMapper();
	System.out.println("在注册中打印收到的address和sex:  "+request.getParameter("address")+"  "+request.getParameter("sex"));
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String address=request.getParameter("address");
    Integer sex=new Integer(request.getParameter("sex"));
    Integer age=new Integer(request.getParameter("age"));
    User user=new User();
    user.setAddress(address);
    user.setUsername(username);
    user.setPassword(password);
    user.setAge(age);
    user.setSex(sex);
  
    if(userService.register(user))
    	out.write("1");
    else
    	out.write("0");
		
	System.out.println("完成注册");
	}
	
	public void getUserById() throws IOException
	{HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	response.setHeader("Access-Control-Allow-Credentials", "true");
	response.setContentType("text/plain; charset=utf-8");
	Map session=ServletActionContext.getContext().getSession();
	
	PrintWriter out = response.getWriter();
	ObjectMapper objectMapper = new ObjectMapper();
	Integer userid=new Integer(request.getParameter("userid"));
	System.out.println(userid);
	User user=userService.getUserById(userid);
	String responseJson = objectMapper.writeValueAsString(user);
	System.out.println("在getbyid中打印返回的userid和json:  "+userid+"   "+responseJson);
	out.write(responseJson);
	System.out.println("通过id查询到用户信息："+responseJson);
	}
	
	

}
