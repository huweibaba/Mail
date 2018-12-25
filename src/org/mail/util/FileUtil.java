package org.mail.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.mail.vo.SendModel;

public class FileUtil {
	
	public static void saveFileByRequest(HttpServletRequest request,SendModel sm) throws Exception
	{
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB

		List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
		
		
		Iterator<FileItem> i = items.iterator();
	
		while (i.hasNext()) {
		FileItem fi = (FileItem) i.next();
		String fileName = fi.getName();
			
			if ((fileName != null)&&(!fileName.equals(""))) {
			
				File fullFile = new File(new String(fi.getName().getBytes(), "utf-8")); // 解决文件名乱码问题
			
				File savedFile = new File("/home/huwei/Desktop/Mail/WebRoot/fujian",fullFile.getName());
				fi.write(savedFile);
				sm.setAttachmentName(fullFile.getName());
				sm.setAttachmentLink("fujian/"+fullFile.getName());
				
			}
			else
			{
				if(fi.getFieldName().equals("toAddress"))
					sm.setToAddress(fi.getString("utf-8"));
				else if(fi.getFieldName().equals("subject"))
					sm.setSubject(fi.getString("utf-8")); 
				else if(fi.getFieldName().equals("text"))
					sm.setText(fi.getString("utf-8"));
			
			}
		
		}
		
	   
    
		
		
		
		
	}

}
