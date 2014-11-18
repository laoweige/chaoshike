<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh-cn">
<head>
    <title>产品列表 - 智联招聘自助产品中心</title>
    <jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body class="page-product-list">

<jsp:include page="../include/menu.jsp"/>
<div class="g-container">
    <div class="g-main g-cont">
        <div class="col_main">
            <div class="col_main_wrap">
                <div class="g-md-box g-md-tab">
                    <div class="hd">
                        <ul>
                            <li class="tab-index-0 active"><a>产品列表</a></li>
                            <li class="tab-index-1"><a href="./orders.do">我的订单</a></li>
                            <li class="tab-index-2"><a href="./questions.do">常见问题</a></li>
                        </ul>
                    </div>
                    <div class="bd">
                        <h2>自助产品</h2>
                        <div class="g-md-product-list">
                            <ul>
                                <c:forEach var="item" items="${products}">
                                    <li class="item">
                                        <div class="product-item">
                                            <div class="g-md-img">
                                                <a href="/products/${item.id}/detail.do" >
                                                    <img src="${item.snapshot}" alt=""/>
                                                </a>
                                            </div>
                                            <h3>${item.name}</h3>
                                            <a class="link-detail" href="/products/${item.id}/detail.do">详情</a>
                                            <c:if test="${NeedRedirectToRd}">
                                            <a href="http://rd2.zhaopin.com/s/vacainfo/PositionManage.asp?pid=${item.id}" target="_blank" class="g-btn btn-order">立即下单<i class="fz"><i class="fz"></i></i></a>
                                            </c:if>
                                            <c:if test="${!NeedRedirectToRd}">
                                            <a href=".${item.orderUrl}" class="g-btn btn-order">立即下单<i class="fz"><i class="fz"></i></i></a>
                                            </c:if>
                                        </div>

                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../include/sub-col.jsp"></jsp:include>
    </div>

</div>

<jsp:include page="../include/footer.jsp"></jsp:include>


</body>
</html>
