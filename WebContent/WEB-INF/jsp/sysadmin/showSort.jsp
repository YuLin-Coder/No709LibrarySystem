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
    <script>
    	$(function(){
    		var errorMsg='${errorMsg}';
    		if(errorMsg!=null && errorMsg!=''){
    			alert(errorMsg);
    		}
    	});
    </script>
</head>
<body>
	<form class="form-inline definewidth m20"
		action="<%=request.getContextPath()%>/sort/findBySname" method="post">
		图书类别： 
		<input type="text" name="sname" class="abc input-default" placeholder="类别名称" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button> &nbsp;&nbsp; 
		<a type="button" class="btn btn-primary" href="<%=request.getContextPath()%>/sort/toAddSort">
			增加类别
		</a>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>序号</th>
				<th>图书类别</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${sorts }" var="sort" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${sort.sname}</td>
				<td>
					<a type="button" class="btn btn-success" 
						href="<%=request.getContextPath()%>/sort/findById?id=${sort.id}">修改</a>
					<a type="button" class="btn btn-danger" 
						href="<%=request.getContextPath()%>/sort/remove?id=${sort.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>