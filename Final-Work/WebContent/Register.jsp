<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript">
window.onload = function() {
	//通过id获取页面button的onclick点击事件
	    	document.getElementById("checkUsername").onclick = function() {
	        var username = document.getElementById("username").value;
	        //1.创建ajax对象
	        var xhr = ajaxFunction();
	        xhr.onreadystatechange = function() {
	            //处理后台返回的数据
	            if(xhr.readyState == 4) {
	                if(xhr.status == 200) {
	                    var data= xhr.responseText;
	                    document.getElementById("divcheck").innerHTML = data;
	                }
	            }
	        }
	    //规定发送数据的形式（post/get），url，以及传输方式(同步/异步)
	        xhr.open("post","./RegisterServlet?timeStamp="+new Date().getTime(),true);
	        //post方式需要加下边这句，get方式不需要
	        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	        //将页面输入数据发送到后台
	        xhr.send("username="+username);
	    }
	}

	function ajaxFunction() {
	    var xmlHttp;
	    try {
	        xmlHttp = new XMLHttpRequest();
	    } catch(e) {
	        try {
	            xmlHttp = new ActiveXObject("Msxm12.XMLHTTP");
	        } catch(e) {
	            try {
	                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	            } catch(e) {}
	        }
	    }
	    return xmlHttp;
	}      
</script>
</head>
<body>
注册界面:<br>
<form action="RegisterServlet" method="post" enctype="application/x-www-form-urlencoded">
	
	<%
		String smg1 =(String)request.getAttribute("smg1");
		String smg2 =(String)request.getAttribute("smg2");
    	String smg3 = (String)request.getAttribute("smg3");
    	String smg4 = (String)request.getAttribute("smg4");
    	String smg5 = (String)request.getAttribute("smg5");
		if(smg5!=null){
 			out.print(smg5+"<br>");
 		}
		if(smg4!=null){
 			out.print(smg4+"<br>");
 		}
    	
    	if(smg1 != null){
     		System.out.println(smg1+"<br>");
     	}
     	if(smg2 != null){
     		out.print(smg2+"<br>");
     	}
     	if(smg3!=null){
     		out.print(smg3+"<br>");
     	}
	%> 
	
	
	请输入用户名：<input type="text" id="username"/><input type="button" value="检查" id="checkUsername">
	
	<br> 
	请输入密码：<input type="password"/>
	
	<br>
	请输入邮箱：<input type="text"/>
	
	<br>
	<input type="button" value="注册">
</form>


</body>
</html>