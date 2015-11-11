<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <a href="user.do?method=doGet">Get方法</a>
 <br />
 <a href="user.do?method=getParams&name=martian&age=21">测试通过形参传值</a>
 <br />
 <a href="user.do?method=getParams2&name=martian&age=21">测试传值转换</a>
 <br />
 <a href="user.do?method=forward&name=martian&age=21">测试转发</a>
 <br />
 <a href="user.do?method=redirect&name=martian&age=21">测试重定向</a>
 <form action="user.do?method=doGet" method="post">
  <input type="text" name="name"> <input type="submit" value="post提交">
 </form>
</body>
</html>