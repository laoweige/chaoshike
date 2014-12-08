<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<meta content="telephone=no" name="format-detection" />
	<meta name="keywords" content="黔西网上超市"/>
	<meta name="description" content="黔西网上超市"/>
	<title>全部商品分类_黔西网上超市_超市客手机版</title>
	<link rel="stylesheet" type="text/css" href="/phone/wap/product/style/base.css?v=2.4.4">
	<link rel="stylesheet" type="text/css" href="/phone/wap/product/style/productsList.css?v=2.4.4">

	<script src="/phone/jquery.min.js"></script>
	<script type="text/javascript" src="/phone/wap/product/script/sntouch.js?v=2.4.4"></script>
	<script type="text/javascript" src="/phone/wap/product/script/base.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/wapsearch.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/wapcategory.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/waputils.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/wapsuggest.js?v=2.4.4"></script>
</head>
<body class="topFixed">
<div class="sn-nav focusPrWarp" >
	<a class="goback" href="javascript:void(history.go(-1));"></a>
	<div class="searchWrap pr">
		<input  type="search"  id="wapSearchInput" name="wapSearchInput" oninput="OnInput(event)"class="focusPr wbox-flex" value="" />
		<a id="wapSearchURL" href="javascript:void(0);" class="search-submit"></a>
	</div>
</div>
<div class="sn-h45" ></div>
<script>
$(function(){
	var $wapSearchInput = $("#wapSearchInput");
	//$wapSearchInput.focus();
	$wapSearchInput.attr("value",$("#keyword").val());
	$wapSearchInput.keypress(function(e){
		var key = e.which;
		if(key ==13){
			$(".search-submit").triggerHandler("click");
		}
	});



});

// 监听软键盘 搜索事件
document.onkeydown =function(event){
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if(e && e.keyCode==13){
		$(".search-submit").triggerHandler("click");
	}
};

</script>

<div id="suggestBox" class="suggestBox">
	<ul id="suggestList" class="suggestList">
	</ul>
</div>

<div class="sub-searcher-list">
		<ul class="sub-searchers-items">
		<c:forEach var="channel" items="${categories}">
		    <li class="sub-item-product">
                <a href="javascript:void(0);">
                    <dl>
                        <dt>
                            <img src="/phone/wap/product/icon/category/${channel.id }.png"
                            onerror="this.src='http://script.suning.cn/images/ShoppingArea/Common/blankbg.gif' alt='${channel.name }'"/>
                        </dt>
                        <dd class="seachers-infomation">
                            <h3>${channel.name }</h3>
                            <p>${channel.name }</p>
                        </dd>

                    </dl>
                </a>
            </li>
            <li class="sub-seacher-label">
                 <c:forEach var="category" items="${channel.children}">
                    <h2>${category.name }</h2>
                        <ul class="seacher-label-pare fix">
                            <c:forEach var="subCategory" items="${category.children}">
                                    <li><a href="/products/c-${subCategory.id}.html">${subCategory.name }</a></li>
                            </c:forEach>
                        </ul>
                 </c:forEach>
            </li>
		</c:forEach>
		</ul>
</div>
<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>