<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.sorted.js"></script>
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
	<form action="${pageContext.request.contextPath }/sysadmin/addUser" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">用户名称</td>
        <td><input type="text" name="uname"/></td>
    </tr>
    <tr>
        <td class="tableleft">用户账号</td>
        <td><input id="code" type="text" name="code" onchange="checkCode()"/>
	       		&nbsp;&nbsp; <span id="showMsg" style="color:red"></span>
        </td>
    </tr>
    <tr>
        <td class="tableleft">用户密码</td>
        <td><input type="text" name="password"/></td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button id="btn" type="submit" class="btn btn-primary" type="button">添加</button> &nbsp;&nbsp;<a type="button" class="btn btn-success" name="backid" id="backid" href="<%=request.getContextPath()%>/sysadmin/showUser">返回列表</a>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script type="text/javascript">
    function checkCode(){
    	var code=$("#code").val();
    	$.ajax({
    		type:"get",
			url:"${pageContext.request.contextPath }/sysadmin/checkCode",
			data:{"code":code}, 
			success:function(data) {
				if(data==1)
				{
					$("#showMsg").html("账户已存在，请重新输入");
					$("#btn").attr("disabled", true);
				}
				else{
					$("#showMsg").html("");
					$("#btn").attr("disabled", false);
				}
			}
		});
    }
</script>