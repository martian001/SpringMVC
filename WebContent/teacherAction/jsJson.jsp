<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function createAjaxObj() {
		var req;
		//根据不同浏览器来创建AJAX的核心对象XMLHttpRequest,这个对象是在浏览器里面的
		if (window.XMLHttpRequest) { //如果是非IE
			req = new XMLHttpRequest();
		} else {//如果是IE
			req = new ActiveXObject("Msxml2.XMLHTTP"); //ie
		}
		return req;
	}

	function sendAjaxReq() {
		var req = createAjaxObj();
		//向浏览器打开请求,为了避免缓存,每次请求后面都加上随机数或者日期时间
		req.open("get", "testAjaxJson.do?a=" + Math.random());

		//如果向服务器发送AJAX请求,并且返回类型是json格式,那么一般要加上下面的头标记
		req.setRequestHeader("accept", "application/json");

		//Ajax一定要设置回调函数,方便服务器返回后来调用
		req.onreadystatechange = function() {
			//加了对Ajax状态码的判断,只有完全成功了,才执行下面的代码
			if (req.readyState == 4 && req.status == 200) {
				//得到从服务器上面的返回数据
				var result = eval(req.responseText);//转换成数组
				//遍历
				for ( var i in result) {
					alert(result[i].name)
				}
			}
		}
		//真正的发送请求 
		req.send(null);
	}
	$(function() {
		$("#testJquery").click(function() {
			var url = "testAjaxJson.do";
			var args = {};
			$.getJSON(url, args, function(date) {
				alert(date);
				$.each(date.items, function(i, item) {
					alert(i)
				});
			})
		})
	})
</script>
</head>
<body>
 <a href="javascript:void(0);" onclick="sendAjaxReq();">js返回json</a>
 <br />
 <a href="javascript:void(0);" id="testJquery">jQuery返回json</a>
 <div id="div1"></div>
</body>
</html>