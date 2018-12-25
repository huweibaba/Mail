package org.mail.mailServer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.struts2.ServletActionContext;
import org.mail.model.ReceiveModel;

public class GetReceiveModel {
	public List<ReceiveModel> getReceiveModelList(String host, String username, String password) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.store.protocol", "pop3");
		prop.setProperty("mail.pop3.host", host);
      
		Session mailSession = Session.getDefaultInstance(prop, null);
		mailSession.setDebug(false);
		Store store = mailSession.getStore("pop3");
		store.connect(host, username, password);
		Folder folder = store.getFolder("inbox");
		Map session=ServletActionContext.getContext().getSession();
		session.put("store",store);
		session.put("folder",folder);
		folder.open(Folder.READ_WRITE);
		List<ReceiveModel> list=new ArrayList<ReceiveModel>();
		Message[] messages = folder.getMessages();// 得到邮箱帐户中的所有邮件
		Pattern p=Pattern.compile("<|>");
		
		
		for (int i=0;i<messages.length;i++) {
			Message message=messages[i];
			ReceiveModel rm = new ReceiveModel();
			rm.setSubject(message.getSubject());// 获得邮件主题
			String fromAddress=((Address) message.getFrom()[0]).toString();
			fromAddress=p.split(fromAddress)[0];
			rm.setFromAddress(fromAddress);// 获得发送者地址
			rm.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.getSentDate()));
			rm.setSize(message.getSize()/1024);
			rm.setText(getText(message));
			
			rm.setId(i);
			rm.setAttachmentName(getAttachmentName(message));
			
			rm.setAttachmentLink(getAttachmentLink(message,i));
			list.add(rm);
			
		}

		return list;

	}

	public String getAttachmentName(Message m) throws Exception {
		if (!m.isMimeType("multipart/mixed"))
			return null;
		else {
			Multipart mp = (Multipart) m.getContent();
			int bodynum = mp.getCount();
			for (int i = 0; i < bodynum; i++) {
				BodyPart bp = mp.getBodyPart(i);
				
				if (bp.getDisposition() != null) {
					String filename = bp.getFileName();
					  filename = MimeUtility.decodeText(filename);
					return filename;
				}
			}
        return null;
		}

	}
	
	
	public String getAttachmentLink(Message m,int msgnum) throws UnsupportedEncodingException, MessagingException, IOException
	{
		
		if (m.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) m.getContent();

            for (int i = 0; i < mp.getCount(); i++) {
                BodyPart bp = mp.getBodyPart(i);

                // 如果该BodyPart对象包含附件，则应该解析出来
                if (bp.getDisposition() != null) {
                    String filename = bp.getFileName();
                    
                    
                    if (filename.startsWith("=?")) {
                        // 把文件名编码成符合RFC822规范
                        filename = MimeUtility.decodeText(filename);
                    }

                    // 生成打开附件的超链接
                  
                    return "handleAttach.action?msgnum=" + msgnum+ "&&bodynum=" + i + "&&filename=" + filename;
                }
            }
        }
		return null;
	}
	
	public String getText(Message msg)
	{
		try {
          
            // 邮件类型不是mixed时，表示邮件中不包含附件，直接输出邮件内容
            if (!msg.isMimeType("multipart/mixed")) {
            	
            	if(!(msg.getContent() instanceof String))
            	 {MimeMultipart m=(MimeMultipart) msg.getContent();
               return (String)m.getBodyPart(0).getContent();}
            	else 
            		return  (String) msg.getContent();
            } else {
                // 查找并输出邮件中的邮件正文
                Multipart mp = (Multipart) msg.getContent();
                int bodynum = mp.getCount();
                for (int i = 0; i < bodynum; i++) {
                    BodyPart bp = mp.getBodyPart(i);
                    /*
                     * MIME消息头中不包含disposition字段， 并且MIME消息类型不为mixed时，
                     * 表示当前获得的MIME消息为邮件正文
                     */
                    if (!bp.isMimeType("multipart/mixed") && bp.getDisposition() == null) {
                    	if(bp.getContent() instanceof String)
                    		return (String)bp.getContent();
                    	else
                    	 {MimeMultipart m=(MimeMultipart) bp.getContent();
                        
                         return (String)m.getBodyPart(0).getContent();
                    	 }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return "";
	}
	
	

}
