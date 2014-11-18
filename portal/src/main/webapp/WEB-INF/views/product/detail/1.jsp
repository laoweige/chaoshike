<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh-cn">
<head>
    <title>职位置顶 - 智联招聘自助产品中心</title>
    <jsp:include page="../../include/resource.jsp"></jsp:include>
    <link rel="stylesheet" href="http://img01.zhaopin.cn/2014/money/styles/product/search/style.css">
</head>
<body class="page-product-list">

<jsp:include page="../../include/menu.jsp"/>
<div class="g-container">

    <div class="g-main g-cont">

        <div class="g-md-box">
            <div class="hd">
                <a href="/products.do">产品列表</a> <span class="division">&gt;</span> 职位置顶-详细介绍
                <a href="/products.do" class="more">返回</a>
            </div>
            <div class="bd">
                <div class="g-md-adimg">
                    <img src="http://img01.zhaopin.cn/2014/money/images/product/search/top-ad.jpg" alt="开通职位置顶" height="170"/>
                </div>

                <div class="md-prod-block md-prod-block-1">
                    <h3 class="block-title"></h3>
                    <div class="block-cont">
                        <ul>
                            <li><i class="icon-tick"></i>职位展示不沉底，推广期间始终靠前</li>
                            <li><i class="icon-tick"></i>橙色<span class="hot"></span>字图标，更多吸引求职者</li>
                            <li><i class="icon-tick"></i>按地区和职位精确投放，不花冤枉钱</li>
                        </ul>
                    </div>
                </div>

                <div class="md-prod-block md-prod-block-2">
                    <h3 class="block-title"></h3>
                    <div class="block-cont">
                        <p>职位搜索列表页是求职者浏览职位的最重要的渠道，在搜索列表中职位排名靠前，就能在第一时间获得求职者关注，有效吸引人才投递。</p>
                        <p>开通职位置顶后，您的职位将固定在置顶区域，置顶职位的前后排列顺序将会进行智能调整，保证每个置顶职位的排序更靠前。</p>
                        <p class="img-cont">
                            <img src="http://img01.zhaopin.cn/2014/money/images/product/search/bg-shot.jpg" alt="置顶示例" height="696"/>
                        </p>
                    </div>
                </div>

                <div class="md-prod-block md-prod-block-3">
                    <h3 class="block-title"></h3>
                    <div class="block-cont">
                        <div class="g-md-process-bar">

                            <span class="process-step process-step-1">
								<span class="step-num">1</span>
								<strong class="step-text">选择置顶职位</strong>
							</span>
							<span class="process-step process-step-2">
								<span class="step-num">2</span>
								<strong class="step-text">设置推广条件</strong>
							</span>
							<span class="process-step process-step-3">
								<span class="step-num">3</span>
								<strong class="step-text">付款</strong>
							</span>
							<span class="process-step process-step-4">
								<span class="step-num">4</span>
								<strong class="step-text">成功推广</strong>
							</span>

                        </div>
                    </div>
                </div>

                <div class="g-md-btncont">
                    <a href="/search/1/positions.do" class="btn btn-order" title="立即下单">立即下单<i class="fz"><i class="fz"></i></i></a>
                </div>

            </div>
        </div>

    </div>

</div>

<script>
    var isIe6 = function(){
        var isIe6 = false;
        if (/msie/.test(navigator.userAgent.toLowerCase())) {
            if (jQuery.browser && jQuery.browser.version && jQuery.browser.version == '6.0') {
                isIe6 = true
            } else if (!$.support.leadingWhitespace) {
                isIe6 = true;
            }
        }
        return isIe6;
    };
    $(function(){
        var $window = $(window);
        var $btncont  = $('.g-md-btncont'),
                btnTop = $btncont.offset().top;

        var stickyStatus = false;

        $btncont.width($btncont.width());

        function updatePosition(){

            var windowHeight = $(window).height(),
                scrollTop = $('body').scrollTop() || $('html').scrollTop();

            if( btnTop > scrollTop  &&  btnTop < windowHeight + scrollTop){

                if(stickyStatus){
                    $btncont.css({'position':'relative','top':0});
                    $btncont.removeClass('sticky-btn');
                    stickyStatus = false;
                }

            }else{

                if(!stickyStatus){
                    if(isIe6()){
                        $btncont.css({ 'position':'absolute' })
                    }else{
                        $btncont.css({
                            'position':'fixed',
                            'bottom' : 0,
                            'top' : 'auto'
                        })
                    }
                    $btncont.addClass('sticky-btn');
                    stickyStatus = true;
                }else if(isIe6()){
                    $btncont.css('top' ,  scrollTop+windowHeight - 165 )
                }
            }

        }

        $window.on('resize',function(){
            updatePosition();
        });

        $window.scroll(updatePosition);
        updatePosition();
    })
</script>

<jsp:include page="../../include/footer.jsp"></jsp:include>


</body>
</html>
