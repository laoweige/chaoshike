<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="utf-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<link rel="Shortcut Icon" href="favicon.ico" type="image/x-icon">
<link rel="bookmark" href="favicon.ico" type="image/x-icon">
<c:if test="${!cdnMode}">
    <link rel="stylesheet" href="/styles/main.css">
    <link rel="stylesheet" href="/styles/login_exinter.css">
    <!--[if lt IE 9]>
        <!-- build:js scripts/ie.js -->
        <script src="/scripts/ie/es5-shim.js"></script>
        <!-- endbuild -->
    <![endif]-->
    <!-- build:js scripts/app.js -->
    <script src="/scripts/lib/jquery.js"></script>
    <script src="/scripts/lib/terrific-2.0.2.js"></script>
    <script src="/scripts/lib/jQuery.md5.js"></script>
    <script src="/scripts/lib/knockout-3.1.0.js"></script>
    <script src="/scripts/lib/handlebars-v1.3.0.js"></script>
    <script src="/scripts/lib/dialog.js"></script>
    <script src="/scripts/lib/knockout.validation.js"></script>
    <script src="/scripts/app.js"></script>
    <script src="/scripts/module/pager.js"></script>
    <script src="/scripts/module/order.js"></script>
    <script src="/scripts/module/order-cs.js"></script>
    <script src="/scripts/module/export-dialog.js"></script>
    <script src="/scripts/module/order-success-dialog.js"></script>
    <script src="/scripts/module/question.js"></script>
    <!-- endbuild -->
</c:if>
<c:if test="${cdnMode}">
    <link rel="stylesheet" href="http://img01.zhaopin.cn/2014/money/styles/main.css?version=${releaseVersion}">
    <link rel="stylesheet" href="http://img01.zhaopin.cn/2014/money/styles/login_exinter.css?version=${releaseVersion}">
    <!--[if lt IE 9]>
    <script src="http://img01.zhaopin.cn/2014/money/scripts/ie.js?version=${releaseVersion}"></script>
    <![endif]-->
    <script src="http://img01.zhaopin.cn/2014/money/scripts/app.js?version=${releaseVersion}"></script>
</c:if>
