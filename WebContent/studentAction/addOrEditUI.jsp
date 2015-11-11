<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="studentAction_saveOrUpdate.do">
  名字：<input type="text"  name="name" value="${requestScope.student.name }"/><br/>
  年龄：<input type="text" name="age" value="${requestScope.student.age }"/><br/>
  <input type="hidden" name="id" value="${requestScope.student.id }"/>
  <input type="submit" value="保存" />
 </form>
</body>
</html>