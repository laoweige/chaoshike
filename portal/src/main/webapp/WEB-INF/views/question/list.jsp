<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh-cn">
<head>
    <title>常见问题 - 智联招聘自助产品中心</title>
    <jsp:include page="../include/resource.jsp"></jsp:include>
</head>
<body class="page-question-list">

<jsp:include page="../include/menu.jsp"/>
<div class="g-container">
    <div class="g-main g-cont">
        <div class="col_main">
            <div class="col_main_wrap">
                <div class="g-md-box g-md-tab">
                    <div class="hd">
                        <ul>
                            <li class="tab-index-0"><a href="./products.do">产品列表</a></li>
                            <li class="tab-index-1"><a href="./orders.do">我的订单</a></li>
                            <li class="tab-index-2 active"><a>常见问题</a></li>
                        </ul>
                    </div>
                    <div class="bd mod mod-question-list">

                        <ul class="g-md-question-list">
                            <li class="question-item">
                                <h4 class="question-title">1. 无法购买推广产品？</h4>
                                <div class="question-answer">
                                    <p>当您发现无法购买推广产品时，可能有以下几种情况</p>
                                    <ol>
                                        <li>1、如果您还没有发布职位，请登录智联企业账号，发布新职位</li>
                                        <li>2、职位还未通过审核，请您耐心等待</li>
                                        <li>3、您已经发布的职位即将到期，您可以重新发布职位</li>
                                        <li>4、您想购买的产品当天已经售完，请在下一天提早前来购买</li>
                                    </ol>
                                    <i class="g-mk-triangle tooltip-triangle"></i>
                                    <i class="g-mk-triangle tooltip-triangle-back"></i>
                                </div>
                            </li>
                            <li class="question-item">
                                <h4 class="question-title">2. 智联推广中心的付费方式有哪些？</h4>
                                <div class="question-answer">
                                    <p>您可以通过“支付宝”或“网上银行”付款。</p>
                                    <i class="g-mk-triangle tooltip-triangle"></i>
                                    <i class="g-mk-triangle tooltip-triangle-back"></i>
                                </div>
                            </li>
                            <li class="question-item">
                                <h4 class="question-title">3. 付款失败怎么办？</h4>
                                <div class="question-answer">
                                    <p>当您下单后，有30分钟的时间完成付款，在此时段内，如果付款失败，请返回推广中心“我的订单”页面，找到您的订单，点击“立即付款”可以继续完成付款。如果30分钟之后仍未完成付款，请您重新下单并付款，原订单会自动失效。</p>
                                    <br/>
                                    <p>在付款过程中，如果您遇到问题，可以在线联系客服咨询。</p>
                                    <i class="g-mk-triangle tooltip-triangle"></i>
                                    <i class="g-mk-triangle tooltip-triangle-back"></i>
                                </div>
                            </li>
                            <li class="question-item">
                                <h4 class="question-title">4. 智联招聘自助产品购买提示</h4>
                                <div class="question-answer">
                                    <p>当您在使用智联招聘自助产品服务时，必须遵守智联招聘信息发布的相关规定、中国有关法规、其他有关国家和地区的法律规定以及国际法的有关规定。若您的行为不符合以上提到的规定及法规，智联招聘有权单方面取消您的订单，且已经支付的费用不予返还。
                                    </p>
                                    <br/>
                                    <p>请您保护好自己的账户名和密码，不要随意泄露给他人，在公共场合登陆使用智联账户时注意及时退出，以免账号被盗造成损失。</p>
                                    <i class="g-mk-triangle tooltip-triangle"></i>
                                    <i class="g-mk-triangle tooltip-triangle-back"></i>
                                </div>
                            </li>
                        </ul>

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
