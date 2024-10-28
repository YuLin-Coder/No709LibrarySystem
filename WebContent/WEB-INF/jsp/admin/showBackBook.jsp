<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>归还处理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/jquery.pagination.css" />
 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ckform.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.pagination.min.js"></script>
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
    <script>
		$(function() {
			var cp=<%= request.getAttribute("currentPage")%>;
			var tp=<%= request.getAttribute("totalPage")%>;
			$("#pagination2").pagination({
				currentPage:cp,
				totalPage:tp,
				isShow: false,
				count: 6,
				prevPageText: "< 上一页",
				nextPageText: "下一页 >",
				callback: function(current) {
					/* 给后台传到了Cuttentpage */
					$("#CurrentPage").val(current);
					$("#form").submit();
				}
			});
		});
	</script>
</head>
<body>
	<form id="form" class="form-inline definewidth m20" action="<%=request.getContextPath()%>/admin/backBooks" method="post">
		<input id="CurrentPage" type="hidden" name="currentPage" value="1" />
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>申请人</th>
				<th>图书名称</th>
				<th>作者</th>
				<th>出版社</th>
				<th>版本</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${page.list }" var="backBook">
			<tr>
				<td>${backBook.uname}</td>
				<td>${backBook.bname}</td>
				<td>${backBook.author}</td>
				<td>${backBook.birth}</td>
				<td>${backBook.edition}</td>
				<td>
					<button type="button" class="btn btn-default disabled" disabled>
						<c:if test="${backBook.backStatus==0}">未归还</c:if>
						<c:if test="${backBook.backStatus==1}">待确认</c:if>
						<c:if test="${backBook.backStatus==2}">已归还</c:if>
					</button>
				</td>
				<td>
					<c:if test="${backBook.backStatus==1}">
						<a type="button" class="btn btn-success" href="<%=request.getContextPath()%>/admin/allowBackBook?id=${backBook.id}">确认归还</a>
					</c:if>	
				</td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<div class="box">
			<div id="pagination2" class="page fl"></div>
		</div>
	</center>
</body>
</html>