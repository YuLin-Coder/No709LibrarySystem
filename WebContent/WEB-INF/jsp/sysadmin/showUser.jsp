<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }
        @media (max-width: 980px) {
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
    
</head>
<body>
	<form class="form-inline definewidth m20" action="<%=request.getContextPath()%>/sysadmin/showUser" method="post">    
    用户名称：
    <input type="text" name="uname" id="username"class="abc input-default" placeholder="用户姓名" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
 <a type="button" class="btn btn-primary" href="<%=request.getContextPath()%>/sysadmin/toAddUser">增加用户</a>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户名称</th>
        <th>用户账号</th>
        <th>用户密码</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${users }" var="user">
    	<tr>
            <td>${user.uname}</td>
             <td>${user.code}</td>
            <td>${user.password}</td>
            <td>
              <a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/sysadmin/selUserById?id=${user.id}">修改</a>
               <a type="button" class="btn btn-danger" href="<%=request.getContextPath()%>/sysadmin/deleteUser?id=${user.id}">删除</a>
            </td>
        </tr>	
    </c:forEach>
</table>

</body>
</html>