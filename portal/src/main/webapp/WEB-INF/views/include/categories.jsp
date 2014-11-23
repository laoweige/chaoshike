<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="market_cookies_main_left common_hide" id="market_cookies_main_left">
    <h2>本店商品分类</h2>
    <c:forEach var="channel" items="${categories}">
    <div class="market_cookies_main_left_item">
        <dl>
            <dd class="market_cookies_main_left_item_ic market_cookies_main_left_item_ic_i${channel.id} market_ga_cookies_vector" content="market_cookies_main_left_item_ic_i${channel.id}_current"></dd>
            <dd class="market_cookies_main_left_item_class">
                <a href="/${current.shop}/c-c${channel.id}.html">${channel.name }</a>
                <!-- <p>&nbsp;</p> -->
            </dd>
            <dt class="common_clear"></dt>
        </dl>
        <div class="market_cookies_main_left_more common_hide" style="width: 0px;">
            <div>
                <div class="inner">
                    <div class="sub-cat-list">
                        <div class="wrap" style="overflow: hidden; position: relative;">
                            <div style="width: 589px; height: 630px; overflow: hidden; float: none; margin: 0px; padding: 0px;">
                                <c:forEach var="category" items="${channel.children}">
                                <dl>
                                    <dt>
                                        <a href="/${current.shop}/c-p${category.id}.html" title="${category.name }">${category.name }</a>
                                    </dt>
                                    <dd>
                                        <c:forEach var="subCategory" items="${category.children}">
                                        <a href="/${current.shop}/c-${subCategory.id}.html" title="${subCategory.name }">${subCategory.name }</a>
                                        </c:forEach>
                                    </dd>
                                </dl>
                                </c:forEach>

                            </div><div class="scroll_zone" style="width: 6px; position: absolute; float: none; margin: 0px; padding: 0px; left: 593px; top: 0px; height: 630px; background: url(http://uisy.shequ001.com/plus!/jquery.linscroll/scroll/scrolltrack.png);"><img class="scroll_down" src="./assets/images/scrollup.png" style="width: 6px; z-index: 1000; position: absolute; top: 0px; float: none; margin: 0px; padding: 0px;"><img class="scroll_bar" src="./assets/images/scrollthumb.png" style="width: 6px; z-index: 1500; position: absolute; float: none; margin: 0px; padding: 0px; height: 60px; top: 9px;"><img class="scroll_down" src="./assets/images/scrolldown.png" style="width: 6px; z-index: 1000; position: absolute; bottom: 0px; float: none; margin: 0px; padding: 0px;"></div>
                        </div>
                    </div>
                    <div class="rel-info">
                        <div class="wrap">
                            <div class="rel-brand">
                                <h4>推荐品牌</h4>
                                <div class="brand-lsit">
                                    <div class="filter">
                                        <!--<a href="/brand.html"><img src="" alt=""></a>-->
                                        <a href="list.html#?-2-.html?scontent=n,"><img src="" alt=""></a>
                                    </div>
                                </div>
                            </div>
                            <div class="rel-art">
                                <!--<h4>热门活动</h4>-->
                                <div class="art-list market_cookies_main_left_more_ads_case">
                                    &nbsp;&nbsp;
                                    <img src="./assets/images/ad_210x340_004.png">
                                </div>
                            </div>
                            <!-- <div class="cat-ad-pic">
                                                  <img src="http://img.shequ001.com/shequ001_web/www/2.0/nopic_228x228.png?1410742371#h" alt="">
                                                </div> -->
                        </div>
                        <a href="javascript:void(0)" class="close"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</c:forEach>







                </div>
                <script>
                                    jQuery('#market_cookies_main_left').ready(function (e) {
                                        var $ = jQuery;
                                        var index = $('#market_cookies_main_left');
                                        /**
                                         左側舌尖部分的滑動效果
                                         */
                                        //基於qui的類
                                        var _qui = new qui();
                                        var request = {};
                                        var set_disobj_style = {width: '800px'};
                                        _qui.slider_pad({ent_obj: index, ent_tag: '.market_cookies_main_left_item', dis_tag: '.market_cookies_main_left_more', set_disobj_style: set_disobj_style});
                                        //hover
                                        index.find('.market_cookies_main_left_item').hover(function () {
                                            var get_obj = $(this).find('.market_cookies_main_left_item_ic');
                                            get_obj.addClass($.trim(get_obj.attr('content')));
                                        }, function () {
                                            var get_obj = $(this).find('.market_cookies_main_left_item_ic');
                                            get_obj.removeClass($.trim(get_obj.attr('content')));
                                        });

                                        //滚动条
                                        index.find(".sub-cat-list").find('.wrap').setScroll(
                                            {img:'http://uisy.shequ001.com/plus!/jquery.linscroll/scroll/scrolltrack.png',width:6},
                                            {img:'http://uisy.shequ001.com/plus!/jquery.linscroll/scroll/scrollup.png',height:6},
                                            {img:'http://uisy.shequ001.com/plus!/jquery.linscroll/scroll/scrolldown.png',height:6},
                                            {img:'http://uisy.shequ001.com/plus!/jquery.linscroll/scroll/scrollthumb.png',height:60}
                                        );
                                    });
                                </script>