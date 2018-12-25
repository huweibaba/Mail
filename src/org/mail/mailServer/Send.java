package org.mail.mailServer;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.struts2.ServletActionContext;
import org.mail.vo.SendModel;
import org.mail.vo.User;



public class Send {
	public MimeMessage createSimpleMessage(SendModel sm,Session session) throws Exception
	{String fromAddress=sm.getFromAddress();
	 String toAddress=sm.getToAddress();
	 String subject=sm.getSubject();
	 String text=sm.getText();
	 MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(fromAddress));
     message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAddress));
     message.setSubject(subject);
     message.setText(text);
   
     message.saveChanges();
     
    return message;
    
  }
	
	
	public MimeMessage createComplexMessage(SendModel sm,Session session) throws Exception
	{String fromAddress=sm.getFromAddress();
	 String toAddress=sm.getToAddress();
	 String subject=sm.getSubject();
	 String text=sm.getText();
	 String attachmentLink="/home/huwei/Desktop/Mail/WebRoot/"+sm.getAttachmentLink();
	 MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(fromAddress));
     message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAddress));
     message.setSubject(subject);
	 MimeMultipart contentMultipart = new MimeMultipart("mixed");
     MimeBodyPart textBodyPart = new MimeBodyPart();
     MimeBodyPart attachmentBodyPart=new MimeBodyPart();
     textBodyPart.setContent(text, "text/plain;charset=utf-8");
     contentMultipart.addBodyPart(textBodyPart);
      FileDataSource fds = new FileDataSource(attachmentLink);
      attachmentBodyPart.setDataHandler(new DataHandler(fds));
      attachmentBodyPart.setFileName(fds.getName());
      contentMultipart.addBodyPart(attachmentBodyPart);
     
      message.setContent(contentMultipart);
      message.saveChanges();
    
     
      return message;
	 }
	
	public void sendMessage(SendModel sm) throws Exception
	{String fromAddress=sm.getFromAddress();
	String toAddress=sm.getToAddress();
	String subject=sm.getSubject();
	String text=sm.getText();
	String host="localhost";
	 Properties props = new Properties();
     props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
     props.setProperty("mail.smtp.host", host); // 发件人的邮箱的 SMTP服务器地址
     props.setProperty("mail.smtp.auth", "true"); // 请求认证，参数名称与具体实现有关

     // 创建Session实例对象
     Session session = Session.getDefaultInstance(props);
     MimeMessage message;
     if(sm.getAttachmentLink()==null)
    	 message=createSimpleMessage(sm,session);
     else
    	 message=createComplexMessage(sm,session);
     sm.setSize(message.getSize());
     session.setDebug(true);
     // 获取Transport对象
     Transport transport = session.getTransport("smtp");
     // 第2个参数需要填写的是QQ邮箱的SMTP的授权码，什么是授权码，它又是如何设置？
     Map httpSession = ServletActionContext.getContext().getSession();
     User user=(User)httpSession.get("user");
     transport.connect(fromAddress,user.getPassword());
     // 发送，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
     transport.sendMessage(message, message.getAllRecipients());
     transport.close();
		
	}
	
	
}
