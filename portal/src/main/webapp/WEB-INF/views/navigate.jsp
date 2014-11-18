<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page
    import="java.util.*,org.springframework.context.ApplicationContext"%>
<%@ page
    import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <title>在线售卖平台login</title>
    <jsp:include page="./include/resource.jsp"></jsp:include>
</head>
<body style="background:#e1e1e1;">
<%
    if(session.getAttribute("companyId") != null){
        response.sendRedirect("/products.do");
    }
%>
<jsp:include page="./include/menu.jsp"/>
	<div class="container">
    	<div class="content">
        	<h2>智联招聘欢迎您！请您选择账户登录</h2>
            <p class="login_style">
            	<a href="http://hr.zhaopin.com/hrclub/index.html" class="rd_login">网聘用户</a>
                <a href="http://99.zhaopin.com" class="ipin_login">I聘用户</a>
            </p>
        </div>
    </div>

<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>
