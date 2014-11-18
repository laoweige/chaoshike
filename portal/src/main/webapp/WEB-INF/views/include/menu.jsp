<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<div class="g-head">
    <div class="g-main">
        <h1 class="logo">
            <a href="/products.do">智联推广售卖平台</a>
            <sub>Beta版<i class="g-mk-triangle"></i></sub>
        </h1>

        <div class="ft">
            欢迎您 <c:if test="${!empty companyName}">, </c:if><strong><c:out value="${companyName}"></c:out></strong><a href="http://zhaopin.com" target="_blank">智联首页</a>
            <%--<a href="#">退出登录</a>--%>
        </div>
    </div>
</div>