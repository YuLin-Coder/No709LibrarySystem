<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书借阅</title>
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
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>图书名称</th>
        <th>图书类别</th>
        <th>作者</th>
        <th>出版社</th>
        <th>版本</th>
        <th>申请时间</th>
        <th>借书状态</th>
    </tr>
    </thead>
    <c:forEach items="${borrows }" var="borrow">
    	<tr>
            <td>${borrow.bname}</td>
            <td>${borrow.sname}</td>
            <td>${borrow.author}</td>
            <td>${borrow.birth}</td>
            <td>${borrow.edition}</td>
           	<td><fmt:formatDate  value="${borrow.startTime}" type="time" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>
				<button type="button" class="btn btn-default disabled" disabled>
					<c:if test="${borrow.status==0}">待确认</c:if>
					<c:if test="${borrow.status==1}">审批通过</c:if>
					<c:if test="${borrow.status==2}">审批未通过</c:if>
				</button>
			</td>
        </tr>	
    </c:forEach>
</table>

</body>
</html>