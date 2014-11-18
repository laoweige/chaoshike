<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.zhaopin.com/taglib" prefix="zp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <title>出错了 - 智联招聘自助产品中心</title>
    <jsp:include page="./include/resource.jsp"></jsp:include>
</head>
<body class="page-error">

<jsp:include page="./include/menu.jsp"/>

<div class="g-container">

    <div class="g-container">
        <div class="g-main g-cont">
            <div class="g-md-box">
                <div class="bd">
                    <p>出错了，请返回后，重新操作。</p>
                    <%--请勿去掉注释<p>错误原因：${errorMsg}</p>--%>
                    <div class="g-md-btncont">
                        <a href="javascript:history.back()" class="g-btn btn-prev">返回上一页</a>
                        <a href="./../../products.do" class="g-btn btn-prev">返回产品列表</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<jsp:include page="./include/footer.jsp"></jsp:include>

</body>
</html>
