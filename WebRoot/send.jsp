<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="sendMessage.action" method="post"  enctype="multipart/form-data">
							
							主题:<input type="text" name="subject" size="20" id="subject"/><br>
						    正文:<input type="text" name="text" size="20" id="text"/><br>
						    收件人:<input type="text" name="toAddress" size="20" id="toAddress"/><br>
						    附件:<input type="file"  name=" shangchuan" size="20" /><br>
						    
							
							<input type="submit" value="上传" size="20" /><br>
							
							
						</form>
  </body>
</html>
