<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>-</title>
    <link rel="stylesheet" href="/phone/jquery.mobile-1.4.5.min.css" />
    <script type="text/javascript" src="/phone/jquery.min.js"></script>
    <script type="text/javascript" src="/phone/jquery.mobile-1.4.5.min.js"></script>

</head>
<body>
        <div data-role="page">
        <jsp:include page="./include/header.jsp"></jsp:include>
    <div data-role="content">
        <div class="ui-body-a ui-body">
            <a href="index.mob" class="ui-btn ui-corner-all ui-btn-inline ui-icon-back" data-rel="back">返回</a>
          
        </div>
    </div>

<jsp:include page="./include/footer.jsp"></jsp:include>
</div>
</body>
</html>