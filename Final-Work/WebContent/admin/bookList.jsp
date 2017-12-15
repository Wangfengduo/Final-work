<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：商品列表</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="someOneBook.action">
	         <span>书名：</span>
	         <input type="text" name="bookName" value="根据书名查找" class="text-word" id="textfield" style="color:#999;font-style:italic;" 
	             onFocus="if (value =='根据书名查找'){value =''}" onBlur="if (value ==''){value='根据书名查找'}">
	         <input type="submit" value="查询" class="text-but">
	         </form>
         </td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top"> 
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
         <th align="center" valign="middle" class="borderright">书名</th>
         <th align="center" valign="middle" class="borderright">价格</th>
         <th align="center" valign="middle" class="borderright">作者</th>
         <th align="center" valign="middle" class="borderright">简介</th>
         <th align="center" valign="middle" class="borderright">操作</th>
      </tr>
      <c:forEach items="${booklist}" var="book" >
		 <tr class="bggray" onMouseOut="this.style.backgroundColor='#f9f9f9'" onMouseOver="this.style.backgroundColor='#edf5ff'">
			<td align="center" valign="middle" class="borderright borderbottom">${book.bookName }</td>
			<td align="center" valign="middle" class="borderright borderbottom">${book.bookPrice }</td>
			<td align="center" valign="middle" class="borderright borderbottom">${book.bookAuthor }</td>
			<td align="center" valign="middle" class="borderright borderbottom">${book.bookDescription }</td>
			<td align="center" valign="middle" class="borderright borderbottom"><a href="deleteBook.action?bookId=${book.id}">删除</a></td>
		</tr>
	</c:forEach>
    </table>
    </td>
  </tr> 
  <tr>
    <td colspan="6" align="center" >共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页<br><br>  
        <a href="booklist.action?pageNo=${page.topPageNo }"><input type="button" name="fristPage" value="首页" /></a>
        <c:choose>
          <c:when test="${page.pageNo!=1}">          
              <a href="booklist.action?pageNo=${page.previousPageNo }"><input type="button" name="previousPage" value="上一页" /></a>        
          </c:when>
          <c:otherwise>         
              <input type="button" disabled="disabled" name="previousPage" value="上一页" />          
          </c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${page.pageNo != page.totalPages}">
            <a href="booklist.action?pageNo=${page.nextPageNo }"><input type="button" name="nextPage" value="下一页" /></a>
          </c:when>
          <c:otherwise>           
              <input type="button" disabled="disabled" name="nextPage" value="下一页" />            
          </c:otherwise>
        </c:choose>
        <a href="booklist.action?pageNo=${page.bottomPageNo }"><input type="button" name="lastPage" value="尾页" /></a>
    </td>
    </tr>
</table>
</body>
</html>