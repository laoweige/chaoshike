<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<meta content="telephone=no" name="format-detection" />
	<meta name="keywords" content="取暖器,苏宁易购手机版"/>
	<meta name="description" content="苏宁易购手机版为您提供取暖器的最新价格、促销、评论、导购、图片等相关信息。网购取暖器，上苏宁易购！"/>
	<title>取暖器【价格 图片 报价 评价】 - 苏宁易购手机版</title>
	<link rel="stylesheet" type="text/css" href="/phone/wap/product/style/base.css?v=2.4.4">
    	<link rel="stylesheet" type="text/css" href="/phone/wap/product/style/productsList.css?v=2.4.4">
	<link rel="stylesheet" type="text/css" href="/phone/wap/product/style/app_client.css?v=2.4.4">
	<script>
		var oneload =  1;
		var oneload2 = 1;
	</script>
	<script src="/phone/jquery.min.js"></script>
	<script src="/phone/wap/product/script/base.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/waputils.js?v=2.4.4"></script>
	<script type="text/javascript" src="/phone/wap/product/script/sntouch.js?v=2.4.4"></script>
	<script type="text/javascript" src="/phone/wap/product/script/iscroll.js?v=2.4.4"></script>
	<script language="javascript" src="/phone/wap/product/script/getImgUrl.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/wapsuggest.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/wapsearchresultnew.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/wapscrolltouch.js?v=2.4.4"></script>
	<script src="/phone/wap/product/script/getCity.js?v=2.4.4"></script>
</head>
<body class="topFixed">
<input id="keyword" name="keyword" type="text" value="" style="display:none"/>
<input id="categoryId" name="categoryId" type="text" value="20370" style="display:none"/>
<input id="cf" name="cf" type="text" value="" style="display:none"/>
<input id="categoryName" name="categoryName" type="text" value="取暖器" style="display:none"/>
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

</script><div id="suggestBox" class="suggestBox">
	<ul id="suggestList" class="suggestList">
	</ul>
</div>

<div id="productsListArea" class="box productsListArea" >
	<header>
		<ul id="goodSort" class="sortBar">
			<li class="cur"><a href="javascript:void(0);">默认</a></li>
			<li class="down"><a href="javascript:void(0);">销量</a></li>
			<li class="down"><a href="javascript:void(0);">价格</a></li>
		</ul>
	</header>

	<ul id="productsList" class="productsList">
	<c:forEach var="product" items="${products}">
		<li id="p${product.id}" name="/spfs/querySalesShow_103187235_1_9173___WAP_.html?orderInfo=" app-url="http://www.suning.com/emall/sprdpromon_10052_10051_3456874_9173_.html" app-data="">
			<a href="/product_${product.id}.html">
				<div class="pro-list wbox">
					<div class="pro-img"><img src="${product.image}" alt="${product.name}"></div>
					<div class="pro-info wbox-flex">
						<h3>${product.name}</h3>
						<p class="desc">${product.summary}</p>
						<div class="priceInfo">
							<div id="sp3456874" class="m-price">
								<span id="sprice3456874" class="price" >
									<em>&yen;</em>
									${product.salePrice}
								</span>
							</div>
						</div>
					</div>
				</div>
			</a>
		</li>
    </c:forEach>
	</ul>
</div>

<!-- loading 效果 -->

<div id="more_load" class="tc click-load-more">
	<a href="javascript:void(0);">点击加载更多</a>
</div>


<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>