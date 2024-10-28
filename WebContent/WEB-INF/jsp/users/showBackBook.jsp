<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书归还</title>
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
            /* Enable use of floated navbar text */
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
				<th>作者</th>
				<th>出版社</th>
				<th>版本</th>
				<th>申请时间</th>
				<th>还书状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${backs }" var="back">
			<tr>
				<td>${back.bname}</td>
				<td>${back.author}</td>
				<td>${back.birth}</td>
				<td>${back.edition}</td>
				<td>
					<fmt:formatDate value="${back.startTime}" type="time" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td>
					<c:if test="${back.status==0}">
						<button type="button" class="btn btn-default disabled" disabled>未归还</button>
					</c:if> 
					<c:if test="${back.status==1}">
						<button type="button" class="btn btn-default disabled" disabled>待确认</button>
					</c:if> 
					<c:if test="${back.status==2}">
						<button type="button" class="btn btn-default disabled" disabled>已归还</button>
					</c:if>
				</td>
				<td>
					<c:if test="${back.status==0}">
						<a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/user/backBooks?id=${back.id}">归还</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>