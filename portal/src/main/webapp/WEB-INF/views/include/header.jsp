<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="sellder_com_header_case" class="">
        <div class="com_hi_case" id="com_hi_case">
            <nav class="common_case com_spl_case">
                <div class="com_hi_area" id="com_hi_area">
                    <div class="com_hi_area_text">黔西                <span class="com_hi_area_more_case com_ga_iconv" title="切换城市"></span>  </div>
                    <div class="com_hi_area_more_main common_hide"><a href="http://www.shequ001.com/">北京</a><a href="http://sh.shequ001.com/">上海</a><a href="http://gz.shequ001.com/">广州</a><a href="http://sz.shequ001.com/">深圳</a><a href="http://sy.shequ001.com/">沈阳</a><a href="http://wh.shequ001.com/">武汉</a><a href="http://cq.shequ001.com/">重庆</a><a href="http://nj.shequ001.com/">南京</a><a href="http://tj.shequ001.com/">天津</a><a href="http://fz.shequ001.com/">福州</a><a href="http://dl.shequ001.com/">大连</a><a href="http://hz.shequ001.com/">杭州</a><a href="http://jn.shequ001.com/">济南</a></div>
                </div>
                <div style="color:red; float:left;"></div>
                <div class="com_hi_misc" id="com_hi_misc">
                    <span class="com_hi_misc_login"><a href="#?passport-login.html" title="用户登录">登录</a>/<a href="#?passport-signup.html" title="用户注册">注册</a></span>
                    <div class="com_hi_misc_i1_case" id="com_hi_misc_i1_case">
                        <p class="com_hi_misc_i1_conn"><a href="http://www.shequ001.com/download.php" class="com_hi_misc_i1"><span class="com_ga_iconv"></span>手机版</a></p>
                        <div class="com_hi_misc_i1_mob common_hide">
                            <div class="com_hi_misc_i1_mob_dwapp_l" id="com_hi_misc_i1_mob_dwapp_l">
                                <p class=""><img src="/assets/images/itunes.apple.comcnappshe-qu001id922397424mt=8.png">苹果手机扫码</p>
                                <p class="common_hide">敬请期待</p>
                            </div>
                            <div class="com_hi_misc_i1_mob_dwapp_r" id="com_hi_misc_i1_mob_dwapp_r">
                                <p><a target="_blank" href="https://itunes.apple.com/cn/app/she-qu001/id922397424?mt=8" class="com_hi_misc_i1_mob_dwapp_ga com_hi_misc_i1_mob_dwapp_r_ios com_hi_misc_i1_mob_dwapp_r_ios_current">下载应用</a></p>
                                <p><a href="javascript:void(0);" class="com_hi_misc_i1_mob_dwapp_ga com_hi_misc_i1_mob_dwapp_r_andr">下载应用</a></p>
                            </div>
                            <div class="common_clear"></div>
                        </div>
                    </div>
                    <a href="javascript:void(false);" class="com_hi_misc_i2" rel="sidebar"><span class="com_ga_iconv"></span>添加到收藏夹</a>
                    <div class="com_hi_misc_i1_mob common_hide"></div>

                    <div id="com_hi_misc_i4_case" class="com_hi_misc_i4_case">
                        <p class="com_hi_misc_i4_conn"><a href="#?chaoyang#" class="com_ga_iconv com_hi_misc_i4">微信关注</a></p>
                        <p class="com_hi_misc_i4_code common_hide"><img src="/assets/images/shequ-001.png" width="150" height="150"></p>
                    </div>
                </div>
                <div class="common_clear"></div>
            </nav>
        </div>
        <input type="hidden" id="circle_info" value="/circle-get_aviable_city.html">
        <script>
            jQuery('#com_hi_case').ready(function(e) {
                var $=jQuery;
                var _plus=new dlz_plus();
                /**
                    下拉slider
                */
                var set_style1={ ent_text_style:'com_hi_misc_i4_conn',ent_on_style:'com_hi_misc_i4_conn_hover'};
                com.slider_delivery('com_hi_misc_i4_case','.com_hi_misc_i4_code',set_style1);

                var set_style2={ ent_text_style:'com_hi_misc_i1_conn',ent_on_style:'com_hi_misc_i1_conn_hover'};
                com.slider_delivery('com_hi_misc_i1_case','.com_hi_misc_i1_mob',set_style2);

                var set_style3={ ent_text_style:'com_hi_area_text',ent_on_style:'com_hi_area_text_hover'};
                com.slider_delivery('com_hi_area','.com_hi_area_more_main',set_style3);
                /**
                    tab 子类功能
                */
                _plus.TAB_Slider('com_hi_misc_i1_mob_dwapp_r', 'p', 'com_hi_misc_i1_mob_dwapp_l', 'p', '', '', '','common_hide');
            });
            jQuery('#com_hi_misc').ready(function(e) {
                var $=jQuery;
                var index=$('#com_hi_misc');
                /**
                    添加到桌面
                */
                index.find('.com_hi_misc_i2').click(function(){
                    com.addFavorite();
                });
            });
        </script>

        <script>
            jQuery('#com_menu_case').ready(function(e) {
                var index=jQuery('#com_menu_case');
                var $=jQuery;
                var _plus=new dlz_plus();
                /**
                    动态跟踪显示第一级导航
                */
                //_plus.guideCurrent('com_menu_main','com_menu_main_current','');
                /**
                我的slider
                */
                var set_my_style={ ent_text_style:'com_header_misc_my_link',ent_on_style:'com_header_misc_my_link_current'};
                com.slider_delivery('com_header_misc_my_case','.com_header_misc_my_main',set_my_style);
                /**
                购物车slider
                */
                var set_car_style={ ent_text_style:'com_header_misc_my_link',ent_on_style:'com_header_misc_my_link_current'};
                com.slider_delivery('com_header_misc_car_case','.com_header_misc_my_main',set_car_style);
                /**
                检查用户是否登录
                */
                var user_has_login=$.cookie('UNAME');
                if(user_has_login){
                    var user_has_login_str=user_has_login+'<a href="/passport-logout.html">[退出]</a>';
                    $("#com_header_misc_my_main_login").html(user_has_login_str);
                    $('#com_hi_misc').find('.com_hi_misc_login').html(user_has_login_str);
                }
            });
        </script>
    </div>
    <section class="com_supshop_header_case" id="com_supshop_header_case">

        <div class="common_case com_spl_case">
            <div class="com_supshop_header_left">
                <a href="#?chaoyang#" class="com_supshop_header_left_logo"><img src="/assets/images/lifemarket_logo_bj.png"></a>
                <div class="com_supshop_header_left_misc">
                    <p class="com_supshop_header_left_misc_capp">在黔西</p>
                    <p class="com_supshop_header_left_misc_capp">你逛超市，我跑腿</p>
                </div>
                <div class="common_clear"></div>
            </div>
            <div class="com_supshop_header_right">
                <dl class="com_supshop_header_right_call">
                    <dd class="com_supshop_header_right_call_i com_ga_vector"></dd>
                    <dd class="com_supshop_header_right_call_v">
                        <h5>购物电话</h5>
                        <p>18984726699</p>
                    </dd>
                    <dt class="clear_debug"></dt>
                </dl>
                <div class="com_supshop_header_right_decode"> <img src="/assets/images/sdfdsg.png"> </div>
                <div class="common_clear"></div>
            </div>
            <div class="common_clear"></div>
        </div>
    </section>
    <script>
        jQuery('#com_supshop_header_case').ready(function(e){
            var $=jQuery;
            /**
                送货地点自定义功能
            */
            var set_style={ent_text_style:'com_supshop_header_left_misc_area_text',ent_on_style:'com_supshop_header_left_misc_area_text_hover'};;
            com.slider_delivery('com_supshop_header_left_misc_area','.com_supshop_header_left_misc_area_more',set_style);
        });
    </script>
    <script>
        /**
            特殊尺寸输出
        */
        jQuery('#sellder_com_header_case').ready(function(e) {
            var $=jQuery;
            //
            //只有普通商户才求证尺寸
            //
            var get_type=$.trim($('#sellder_type_bull').val());
            if(get_type=='1'){
                return false;
            }
            //
            // 特殊只存的序列ID
            //
            var sourec=window.location.host;
            $.getJSON('http://update.shequ001.com/bin/ga.php?ga=get_seller_id&sourec='+sourec+'&r='+dlz_utils.getRandom(9999)+'&callback=?',function(onComplete){
                var se_id=onComplete.guide;
                //获取URL
                var get_url=window.location.pathname;
                //遍历查找
                for(var i=0;i<se_id.length;i++){
                    if(get_url.indexOf(se_id[i]) !== -1){
                        //修正所有尺寸
                        $('#com_supshop_header_case').find('.common_case').addClass('com_spl_case');
                        $('#com_hi_case').find('.common_case').addClass('com_spl_case');
                        $('#com_header_case').addClass('com_spl_case');
                        $('#com_menu_case').find('.common_case').addClass('com_spl_case');
                        $('#sellder_com_header_case').removeClass('common_hide');
                    }
                }
            });
        });
        /**
            列表頁折疊菜單
        */
        jQuery('#seller-category').ready(function(e) {
            var $=jQuery;
            var get_obj=$('#seller-category').find('.supshop_smart_menu');
            //檢測是否為要折疊的菜單，避免出錯
            if(get_obj.length>0){
                com.slider_delivery('seller-category','.market_cookies_main_left');
            }
        });
    </script>

    <div id="nav" class="supshop_cookies_menu">
        <div class="all-wrap">
            <div id="main-nav"><ul><li><a href="/index.html" target="_blank">超市首页</a></li><li><a href="#?seller-gallery-2.html?scontent=t,1" target="_blank">天天特价</a></li><li><a href="#?seller-gallery-2-.html?scontent=n,%E8%B4%AD%E7%89%A9%E5%8D%A1" target="_blank">社区购物卡</a></li><li><a href="#?wg" target="_blank">精品超市</a></li><li><a href="#?seller-special-2-night.html" target="_blank">夜间店</a></li><li><a href="#?metro" target="_blank">麦德龙</a></li><li><a href="http://bj.shequ001.com/shop" target="_blank"></a></li></ul></div>
        </div>
    </div>