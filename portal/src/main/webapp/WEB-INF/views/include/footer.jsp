<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="g-foot">
    <div class="g-main">
        <p><a href="http://special.zhaopin.com/sh/2009/aboutus/about.html" target="_blank" >智联介绍</a> | <a href="http://www.zhaopin.com/sitemap.html" target="_blank" >网站地图</a> | <a href="http://special.zhaopin.com/sh/2009/aboutus/join.html" target="_blank" >加入智联</a> | <a href="http://special.zhaopin.com/sh/2009/aboutus/law.html" target="_blank" >法律声明</a> | <a href="http://special.zhaopin.com/sh/2009/aboutus/secrecy.html" target="_blank" >保密承诺</a> | <a href="http://special.zhaopin.com/sh/2009/aboutus/contact.html" target="_blank" >联系方式</a> | <a href="http://jobseeker.zhaopin.com/zhaopin/faq/question.html" target="_blank" >常见问题</a> | <a href="http://ir.zhaopin.com" target="_blank">Investor Relations</a>
        您对 Zhaopin.com 有任何建议或意见请 <a href="#" onclick="openFeedback('http://interact.zhaopin.com/feedback/feedback.asp');return false;">联系我们</a></p>
        <p>未经 Zhaopin.com 同意，不得转载本网站之所有招聘信息及作品 智联招聘网版权所有© 1997-2014</p>
        <p>京ICP备12025925号 电信业务审批[2001]字第233号函 京公网安备110105000322</p>
    </div>
    <div class="footerLicense">
        <div><img src="http://img02.zhaopin.cn/2012/img/badge1.png"><a href="http://www.hd315.gov.cn/beian/view.asp?bianhao=0102000103000045" target="_blank">经营性网站备案信息</a></div>
        <div><img src="http://img02.zhaopin.cn/2012/img/badge2.png"><a href="http://www.bj.cyberpolice.cn/index.jsp" target="_blank">网络110报警服务</a></div>
        <div><img src="http://img02.zhaopin.cn/2012/img/badge1.png"><a href="http://images.zhaopin.com/new2011/bottom/license.html" target="_blank">电子营业执照</a></div>
        <div><a id="___szfw_logo___" href="https://search.szfw.org/cert/l/CX20111222001262001306" target="_blank"><img width="112" height="40" src="http://images.zhaopin.com/2012/img/cert.png" style="margin-top:2px;"></a></div>
        <div><a href="https://ss.knet.cn/verifyseal.dll?sn=e14032711010547573rieg000000&amp;ct=df&amp;a=1&amp;pa=500267" tabindex="-1" id="urlknet" target="_blank"> <img alt="可信网站" name="CNNIC_seal" border="true" src="http://img02.zhaopin.cn/2012/img/knetSealLogo.png" oncontextmenu="return false;" onclick="CNNIC_change('urlknet')" style="margin-top:2px;"> </a> </div>
    </div>
</div>
<c:if test="${helpJsEnabled}">
    <c:if test="${companyId!=null}">
        <c:choose>
            <c:when test="${RDUserID==null}">
                <div style="position: fixed;right:0;bottom:100px;_position: absolute;_bottom:auto;_top:300px;" id="live15"></div>
                    <script language="javascript" src="http://service.zhaopin.com/live800/chatClient/staticButton.js?companyID=8899&configID=26&codeType=steady&live800_ud_ipin=live800_ud_ipin&${userInfo}"></script>
                    <script id='write' language="javascript">
                        var data = {};
                        function writehtml() {
                            var temptext = StaticIcon_generate();
                            document.getElementById('live15').innerHTML = temptext;
                            setTimeout('write.src', 9000);
                        }
                        writehtml();
                    </script>
            </c:when>
            <c:otherwise>
                <div style="position: fixed;right:0;bottom:100px;_position: absolute;_bottom:auto;_top:300px;" id="live20"></div>
                    <script language="javascript" type="text/javascript" src="http://service.zhaopin.com/live800/chatClient/staticButton.js?companyID=8899&configID=25&codeType=steady&${userInfo}"></script>
                    <script language="javascript" type="text/javascript" id='write'>
                        function writehtml() {
                            var temptext = StaticIcon_generate();
                            document.getElementById('live20').innerHTML = temptext;
                            setTimeout('write.src', 9000);
                        }
                        writehtml();
                    </script>
            </c:otherwise>
        </c:choose>
    </c:if>
</c:if>