/* suning.com 1417789153898 */function enterRefShop(e){var t=parseInt(e);window.location.href="http://shop.m.suning.com/"+t+".html"}SNTouch.Detail=function(){this.init.apply(this,arguments)},$.extend(SNTouch.Detail.prototype,{init:function(){var e=this;e.initReviewsTabs=!1,e.hasDetailLoad=!1,e.slider(),e.detailTabs(),e.radioGroup(),e.share(),e.favo(),e.pictrues(),$(".tuanNow").length>0&&e.tuan(),e.fold(),$(".sn-count").each(function(){SUI.UI.ProCounter({uid:$(this)})})},slider:function(){SNTouch.Widget.SNCarousel({hook:".J_detail_slider",slideBox:".sliderBox",effect:"scroll",counter:".navIcon",cycle:0,autoplay:0,asyncLoad:!0,touch:!0})},radioGroup:function(){$(".J_radioGroup").each(function(e,t){var i=$(t).find("input[type='radio']"),o=$(t).find("label");o.on("click mousedown",function(){$(this).not(".disabled").addClass("cur").siblings("label").removeClass("cur")}),i.change(function(e){o.removeClass("cur"),$(e.currentTarget).parent("label").addClass("cur")})})},req:function(e){page[e]++,$.ajax({url:evalurl.replace(/{pageNum}/g,page[e]-1).replace(/{typeFlg}/g,type[e]),dataType:"json",async:!0,cache:!0,timeout:1e5,success:function(t){if(""==t.errorCode){$("#evaluateNum").html("评价("+t.totalRecords+")");var i=new Array(t.goodEvaluate,t.midEvaluate,t.badEvaluate);$(".reviewsTabs>li:eq(0)").find("a").html("好评("+t.goodEvaluate+")"),$(".reviewsTabs>li:eq(1)").find("a").html("中评("+t.midEvaluate+")"),$(".reviewsTabs>li:eq(2)").find("a").html("差评("+t.badEvaluate+")");var o=$("#reviews_tmpl").tmpl(t);if(0==i[e])$(".reviewsList"+e).children("ul").html($("<li class='detail-no-result'>暂无评论</li>"));else{$(".reviewsList"+e).find("ul").append(o);var a=(new Array("goodEvaluate","midEvaluate","badEvaluate"),0);a=1==type[e]?t.goodEvaluate:2==type[e]?t.midEvaluate:t.badEvaluate,parseInt(5*(page[e]-1))<parseInt(a)?($(".reviewsList"+e).find("a").html("点击加载更多"),$(".reviewsList"+e).children("div").css("display","block")):$(".reviewsList"+e).children("div").css("display","none")}}else page[e]--},error:function(){page[e]--}})},reviewsTabs:function(){var e=this;e.initReviewsTabs=!0;var t=$(".reviewsTabs>li");t.bind("tap click",function(i){var o=$(i.currentTarget).index(),a=$(".reviewsList"+o);return a.show().siblings().hide(),t.removeClass("cur"),$(i.currentTarget).addClass("cur"),1==page[o]&&e.req(o),!1}),$(".J_moreReview").bind("click",function(){var t='<div class="sn-html5-loading vm" style="margin:15px auto 0px auto;"><div class="blueball"></div><div class="orangeball"></div></div>';$(this).find("a").html(t),e.req($(this).parent().index())}),t.eq(0).click()},detailTabs:function(){var e=this,t=$(".detailTabs>li"),i=$(".detailContents>li");t.bind("tap click",function(o){var a=$(o.currentTarget).index();return t.removeClass("cur"),$(o.currentTarget).addClass("cur"),i.hide(),i.eq(a).show(),2!=a||e.initReviewsTabs||e.reviewsTabs(),1!=a||e.hasDetailLoad||(e.productDesc(i[a]),e.hasDetailLoad=!0),!1})},productDesc:function(e){if(1==sn.isBook){var t=descurl.replace(/{productId}/g,sn.productId).replace(/&amp;/g,"&"),i=parseInt(document.documentElement.scrollHeight)+1500,o=navigator.userAgent,a='<iframe width="750" class="detail-iframe" frameborder="no" border="0" height="'+i+'" scrolling="0" src="'+t+'"></iframe>',n=document.querySelector(".detail-iframe");$(e).html('<div class="detail-info">'+a+"</div>"),/Android (\d+\.\d+)/.test(o)&&n.contents().find("body").css({"font-size":"36px"})}else $.ajax({url:descurl,type:"GET",async:!0,success:function(t){$(e).html(0==t.trim().length?"暂无数据":t),$(e).find("table").css("width","100%"),$(e).find("object,embed,img").css({maxWidth:"100%",height:"auto"})}})},share:function(){function e(){var e,t;window.innerHeight&&window.scrollMaxY?(e=window.innerWidth+window.scrollMaxX,t=window.innerHeight+window.scrollMaxY):document.body.scrollHeight>document.body.offsetHeight?(e=document.body.scrollWidth,t=document.body.scrollHeight):(e=document.body.offsetWidth,t=document.body.offsetHeight);var i,o;return self.innerHeight?(i=document.documentElement.clientWidth?document.documentElement.clientWidth:self.innerWidth,o=self.innerHeight):document.documentElement&&document.documentElement.clientHeight?(i=document.documentElement.clientWidth,o=document.documentElement.clientHeight):document.body&&(i=document.body.clientWidth,o=document.body.clientHeight),pageHeight=o>t?o:t,pageWidth=i>e?e:i,arrayPageSize=[pageWidth,pageHeight,i,o]}function t(){var e,t;return self.pageYOffset?(t=self.pageYOffset,e=self.pageXOffset):document.documentElement&&document.documentElement.scrollTop?(t=document.documentElement.scrollTop,e=document.documentElement.scrollLeft):document.body&&(t=document.body.scrollTop,e=document.body.scrollLeft),arrayPageScroll=[e,t]}$(".shareBtn").bind("touchstart click",function(){function i(){$(".sina").attr("href","http://v.t.sina.com.cn/share/share.php?url="+_url+"&appkey=400813291&title="+_t+"&pic="+_pict),$(".kaixin").attr("href","http://www.kaixin001.com/rest/records.php?url="+_url+"&style=11&content="+_t+"&pic="+_pict+"&stime=&sig="),$(".douban").attr("href","http://www.douban.com/recommend/?url="+_url+"&title="+_t+"&comment="+encodeURI(_t)),$(".renren").attr("href","http://widget.renren.com/dialog/share?resourceUrl="+_url+"&title="+encodeURI(_url)+"&description="+encodeURI(_t));var e=encodeURI("65e3731f449e42a484c25c668160b355"),t=encodeURI("http://www.suning.com"),i="http://v.t.qq.com/share/share.php?title="+_t+"&url="+_url+"&appkey="+e+"&site="+t+"&pic="+_pict;$(".tengxun").attr("href",i),$(".souhu").attr("href","http://t.sohu.com/third/post.jsp?&url="+_url+"&title="+_t+"&content=utf-8&pic="+_pict);var o={url:_url,desc:"",summary:"",title:_t,site:"苏宁易购",pics:_pict},a=[];for(var n in o)a.push(n+"="+encodeURIComponent(o[n]||""));$(".qzone").attr("href","http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?"+a.join("&"))}$("body").append('<div class="mask"></div>'),$(".shareBox").length>0?$(".shareBox").show():($("body").append($("#shareBox_tmpl").tmpl()),$(".shareBox").find(".closeBtn").bind("touchstart click",function(){$(".shareBox").hide(),$(".mask").remove()}),i());var o=e(),a=t();return $(".shareBox").css({top:a[1]+o[3]/3}),!1}),$(window).scroll(function(){var i=e(),o=t();$(".shareBox").css({top:o[1]+i[3]/3})})},tuan:function(){$("#IwantTuan").find(".J_dateTime").each(function(){var e=$(this);if(parseInt(e.attr("rel"))){var t=e.attr("data-now"),i=e.attr("data-startTime"),o=e.attr("data-endTime");e.attr("rel",0),SUI.UI.timer({obj:e,nowTime:t,startTime:i,endTime:o,endText:"",finishText:"已结束！",finishCallBack:function(){$(".s-tuanNow").hide(),$(".gray-tuanNow").show().html("已结束！")}})}})},favo:function(){function e(t){$.ajax({url:i,dataType:"json",type:"post",async:!1,success:function(e){0==e.returnCode&&(sn.isBookMarked=e.bookmarkFlag,1==sn.isBookMarked?$("#favo").removeClass("favoBtn").addClass("favoBtn-oned"):0==sn.isBookMarked&&$("#favo").removeClass("favoBtn-oned").addClass("favoBtn"))},error:function(){2>t&&(t+=1,e(t))}})}function t(){var e="",t="";1==sn.isBookMarked?(e=base+"/favorite/private/deleteGoodsFavorite.do?shopId="+sn.supplierCode+"&partnumber="+sn.productCode+"&channel=WAP",t="取消收藏"):(e=base+"/favorite/private/addGoodsFavorite.do?shopId="+sn.supplierCode+"&partnumber="+sn.productCode+"&channel=WAP",t="收藏"),$.ajax({url:e,dataType:"json",type:"post",async:!1,success:function(e){if(e.idsIntercepted){var i=window.location.href,o="https://m.suning.com/mts-web/auth?targetUrl="+i;window.location.href="https://passport.suning.com/ids/login?service="+encodeURIComponent(o)+"&loginTheme=wap_new"}else e.errorCode?t+="失败":0==e.returnCode?(1==sn.isBookMarked?(sn.isBookMarked=0,$("#favo").removeClass("favoBtn-oned").addClass("favoBtn")):(sn.isBookMarked=1,$("#favo").removeClass("favoBtn").addClass("favoBtn-oned")),t+="成功"):t+="失败";SUI.Use("AlertBox",{type:"mini",msg:t})},error:function(){SUI.Use("AlertBox",{type:"mini",msg:"收藏失败"})}})}var i=base+"/favorite/private/checkIsFavorite.do?shopId="+sn.supplierCode+"&partnumber="+sn.productCode;e(1),$("#favo").bind("touchstart click",function(){0==sn.isBookMarked.length?$.ajax({url:i,dataType:"json",type:"post",async:!1,success:function(e){if(e.idsIntercepted){var i=window.location.href,o="https://m.suning.com/mts-web/auth?targetUrl="+i;window.location.href="https://passport.suning.com/ids/login?service="+encodeURIComponent(o)+"&loginTheme=wap_new"}else 0==e.returnCode?(sn.isBookMarked=e.bookmarkFlag,t()):SUI.Use("AlertBox",{type:"mini",msg:"收藏失败"})},error:function(){SUI.Use("AlertBox",{type:"mini",msg:"收藏失败"})}}):t()})},fold:function(){$(".J_fold").each(function(e,t){var i=$(t).height(),o=$(t).find("p").height();o>i?($(t).addClass("fold"),$(t).find("i").click(function(){$(t).hasClass("fold")?($(t).addClass("unfold"),$(t).removeClass("fold")):($(t).addClass("fold"),$(t).removeClass("unfold"))})):o>14?($(t).find("i").show(),$(t).css({height:".56rem"})):($(t).find("i").hide(),$(t).height(".28rem"))})},initProductInfo:function(){var e=$.cookie("cityId"),t=$.cookie("districtId"),i=base+"/product/"+sn.productCode+"/"+e+"/"+t+"/"+sn.supplierCode+".html";$.ajax({url:i,dataType:"json",cache:!0,success:function(e){var t=$("#price_tmpl").tmpl(e);$(".priceArea").html(t);var i=$("#ship_tmpl").tmpl(e);$("#shipArea").html(i);var o=e.productInfo.hasStorage,a=e.productInfo.isCShop,n=e.productInfo.isPublished;"false"==n&&"1"!=a||"Z"==o||"N"==o?$("#buyBtn").find("span.gray-detail-disable").show().end().find("a.buyNow").hide().end().find("a.appendToCart").hide():$("#buyBtn").find("a.buyNow").show().end().find("a.appendToCart").show().end().find("span.gray-detail-disable").hide();var s="1",r="1";e.promotion&&(s=e.promotion.promoteFlag,r=e.promotion.activityId),snga=self.snga||{},"Z"==e.productInfo.hasStorage?(snga.productStatus=3,snga.shipOffset=-2):"N"==e.productInfo.hasStorage?(snga.productStatus=2,snga.shipOffset=-1):(snga.productStatus=1,snga.shipOffset=e.productInfo.shipOffset);var d="2",c=e.productInfo.hasStorage;if(d=preOrder(sn.snPrice,c),"1"!=d){if(d="2","Y"==o||""==o){var l=(new Date).getTime(),u=base+"/sale/djhAct_"+sn.snProCode+"_"+sn.supplierCode+"_WAP.html";$.ajax({url:u,dataType:"json",cache:!0,success:function(e){if(1==e.isDjhActive&&1!=e.djhActiveStatus){var t=null==e.gPActivityInfo.gbPrice?"":e.gPActivityInfo.gbPrice,i=e.gPActivityInfo.gbCommNum-e.gPActivityInfo.saleNum;sn.commNum=i,$("#djhCommNum").val(sn.commNum),$("#saleNum").val(e.gPActivityInfo.saleNum);var o="";o+='<div class="m-price"><span class="price orange">￥<b class="priceValue">'+t+'</b></span><del class="o-price">￥<b class="o-priceValue">'+sn.nePrice+"</b></del>",o+='<em class="saleIcons">',o+='    <span class="qiang">大聚惠</span>',o+="</em>",o+="</div>",o+=0==i?'<div class="t-info"><span class="t-discount">已售罄</span></div>':'<div class="t-info"><span class="t-discount">已购买：'+e.gPActivityInfo.saleNum+"</span>件</div>",o+='<div class="group-buy-now">',o+='	<em>剩余时间: </em><span id ="IwantTuan" class="tuanNow s-tuanNow"><span rel="1" class="hd J_dateTime" data-now="'+l+'" data-endTime="'+e.endTime+'" data-startTime="'+e.startTime+'" ></span></span>',o+="</div>",""!=sn.scode_promotion&&(o+='<div class="sCode" id="sCodePromotion"><em></em><span id="sCodePromotionLabel">'+sn.scode_promotion+'</span><a href="javascript:void(0)" onclick = "javascript:bindScode();"><u class="orange">立即绑定</u></a><p class="noCode">没有S码？<a href="javascript:void(0)" onclick="javascript:fetchSCode();"><u class="orange">点此获取</u></a></p></div>'),$("#priceArea").html(o),$("#IwantTuan").find(".J_dateTime").each(function(){var e=$(this);if(parseInt(e.attr("rel"))){var t=e.attr("data-now"),i=e.attr("data-startTime"),o=e.attr("data-endTime");e.attr("rel",0),SUI.UI.timer({obj:e,nowTime:t,startTime:i,endTime:o,endText:"",finishText:"已结束！",startText:"",finishCallBack:function(){$(".s-tuanNow").hide(),$(".gray-tuanNow").show().html("已结束！")}})}}),priceType=4,promotionActiveId=e.gPActivityInfo.grppurId,$("#priceType").val(priceType),sn.djhLimitBuyNum=e.gPActivityInfo.limitBuyNum,$("#djhLimitBuyNum").val(sn.djhLimitBuyNum),$("#limitBuyNum").html("正在促销，每人限购"+sn.djhLimitBuyNum+"件"),$("#favo").hide(),"已结束！"==$("#IwantTuan").find(".J_dateTime").html()?$("#buyBtn").find("span.gray-detail-disable").show().end().find("a.buyNow").hide().end().find("a.appendToCart").hide():$("#buyBtn").find("a.buyNow").show().end().find("a.appendToCart").show().end().find("span.gray-detail-disable").hide(),0==i&&($("#buyBtn").find("span.gray-detail-disable").show().end().find("a.buyNow").hide().end().find("a.appendToCart").hide(),$("#limitBuyNum").html("已售罄"))}else{var a="";1==s?(a="/tuan/gateway/"+r+".html",$(".t-go").attr("href",a)):2==s&&(a="/qiang/"+r+".html",$(".t-go").attr("href",a))}$(".priceArea").show(),$(".sn-block").show()},error:function(){$(".priceArea").show(),$(".sn-block").show()}})}else $(".priceArea").show(),$(".sn-block").show();if(e.productInfo.shopSize){var p=parseInt(e.productInfo.shopSize);if(p>1){$(".recommend").show();var h="/seller/"+(e.productInfo.shopCode||"0000000000")+"_"+e.productInfo.productCode.substring(9)+".html";$(".recommend a").attr("href",h),$("#shopSize").text(p+"家")}else $(".recommend").hide()}else $(".recommend").hide()}}})},pictrues:function(){function e(e){function t(){{var t=SUI.require("position").scrollTop(),i=$(".slide_ul").find("li").eq(e),o=t+$(window).height()/2-i.height()/2;$(document).width()/2-i.width()/2}$(".silder-new-box ").css({position:"absolute",width:"100%",top:o,left:0})}$("body").append('<div class="mask-layers"></div>'),$(".silder-insert-new").show(),$("body").children(".silder-insert-new").addClass("silder-new-box"),$(".mask-layers").show(),$(".mask-layers").height(SUI.require("position").getHeight()),$(".silder-insert-new").children(".sliderBox").children(".slide_ul").css({left:-1*$(window).width()*e}),SNTouch.Widget.SNCarousel({hook:".silder-insert-new",slideBox:".sliderBox",effect:"scroll",counter:".navIcon",cycle:0,autoplay:0,asyncLoad:!0,touch:!0});var i=$(".silder-insert-new").find("li:eq("+e+")").find("img").attr("data-src");$(".silder-insert-new").find("li:eq("+e+")").find("img").attr("src",i),$(".navgator-dot").children("li:eq("+e+")").addClass("cur").siblings("li").removeClass("cur"),t(),$(window).resize(function(){t()}),$("body").children(".silder-new-box").children("h3").find("a").bind("click",function(){$(".silder-insert-new").hide(),$(".mask-layers").remove()})}$(".scroller li").live("click",function(t){var i=$(this).index();t.preventDefault(),t.stopPropagation(),$.ajax({success:function(){e(i)}})})}}),$(function(){var e=self.sn||{};SNTouch.init();var t=new SNTouch.Detail,i=!1;if($.cookie("cityId")){i=!0;var o=e.hasStorage,a=e.isCShop,n=e.isPublished;"false"==n&&"1"!=a||"Z"==o||"N"==o?$("#buyBtn").find("span.gray-detail-disable").show().end().find("a.buyNow").hide().end().find("a.appendToCart").hide():$("#buyBtn").find("a.buyNow").show().end().find("a.appendToCart").show().end().find("span.gray-detail-disable").hide()}t.req(0);var s=parseInt($.cookie("totalProdQtyv3"))||0;if(s>99){var r="<span><em>99<i>+</i></em></span>";$("#cartNum").html(r)}else if(s>0){var r="<span><em>"+s+"</em></span>";$("#cartNum").html(r)}SUI.load.opts.baseUrl=base+"/RES/wap/product/script/";var d={};d.distNo=$.cookie("districtId")||"11365",d.cityNo=$.cookie("cityId")||"9173",d.provinceCode=$.cookie("provinceCode")||"100";var c=new Date;c.setTime(c.getTime()+432e5);var l=!1;$.cookie("provinceCode")&&(l=!0),SUI.load.require("getCity",function(e){e({uid:"#city1",defaultCity:d,firstFlag:l,distShowFlag:!0,getCityIdFirst:function(e){e(d)},done:function(e){$.cookie("cityId",e.cityNo,{path:"/",domain:".suning.com",expires:c}),$.cookie("provinceCode",e.provinceCode,{path:"/",domain:".suning.com",expires:c}),$.cookie("districtId",e.distNo,{path:"/",domain:".suning.com",expires:c}),t.initProductInfo()}})})}),function(){new Object({_getEl:function(e){return document.querySelector(e)},_init:function(){var e=this,t=e._getEl(".detailTabs"),i=t.parentNode,o=i.offsetTop;i.style.height=t.clientHeight+"px",e._supportSticky()||(e._check(o),window.addEventListener("scroll",function(){e._check(o)}),window.addEventListener("orientationchange",function(){e._check(o)}))},_supportSticky:function(){var e=document.createElement("i"),t="-webkit-sticky";e.style.position=t;var i=e.style.position;return e=null,i===t},_check:function(e){this._getEl(".detailTabs").style.cssText=window.scrollY>e?"position:fixed;top:0;left:0;right:0;zIndex:998;":"position:static"}})._init()}(),SUI.timer=function(e){function t(e){this.opts=e||{},this.obj=this.opts.obj,this.nowTime=this.opts.nowTime,this.waitBooksTime=this.opts.waitBooksTime,this.booksStartTime=this.opts.booksStartTime,this.waitBuyTime=this.opts.waitBuyTime,this.buyStartTime=this.opts.buyStartTime,this.waitBooksText=this.opts.waitBooksText||"预约结束：",this.booksStartText=this.opts.booksStartText||"预约结束：",this.waitBuyText=this.opts.waitBuyText||"抢购开始：",this.buyStartText=this.opts.buyStartText||"抢购结束：",this.callback=this.opts.callback||"",this.speed=this.opts.speed||1e3}t.prototype={init:function(){this.timeId=null,this.timer(),this.run()},timer:function(){var e=this,t=[],i=this.nowTime;e.waitBooksTime&&e.waitBooksTime>i?(t=e.parse(e.waitBooksTime-i),e.obj[0].innerHTML=e.waitBooksText+'<div class="wbox-flex tr">'+e.gap(t)+"</div>",e.callback&&"function"==typeof e.callback&&e.callback(e.obj,"waitBooksTime")):e.booksStartTime&&e.booksStartTime>i?(t=e.parse(e.booksStartTime-i),e.obj[0].innerHTML=e.booksStartText+'<div class="wbox-flex tr">'+e.gap(t)+"</div>",e.callback&&"function"==typeof e.callback&&e.callback(e.obj,"booksStartTime")):e.waitBuyTime&&e.waitBuyTime>i?(t=e.parse(e.waitBuyTime-i),e.obj[0].innerHTML=e.waitBuyText+'<div class="wbox-flex tr">'+e.gap(t)+"</div>",e.callback&&"function"==typeof e.callback&&e.callback(e.obj,"waitBuyTime")):e.buyStartTime&&e.buyStartTime>i?(t=e.parse(e.buyStartTime-i),e.obj[0].innerHTML=e.buyStartText+'<div class="wbox-flex tr">'+e.gap(t)+"</div>",e.callback&&"function"==typeof e.callback&&e.callback(e.obj,"buyStartTime")):(clearInterval(e.timeId),e.obj[0].innerHTML="",e.callback&&"function"==typeof e.callback&&e.callback(e.obj,"buyEndTime")),e.nowTime=parseInt(this.nowTime)+1e3},gap:function(e){return"<i>"+e.day.toString().substring(0,1)+"</i><i>"+e.day.toString().substring(1,2)+"</i>天<i>"+e.hour.toString().substring(0,1)+"</i><i>"+e.hour.toString().substring(1,2)+"</i>时<i>"+e.minute.toString().substring(0,1)+"</i><i>"+e.minute.toString().substring(1,2)+"</i>分<i>"+e.second.toString().substring(0,1)+"</i><i>"+e.second.toString().substring(1,2)+"</i>秒"},parse:function(e){var t=this,i=e/t.speed;return t.second=Math.floor(i%60),t.minute=Math.floor(i/60%60),t.hour=Math.floor(i/60/60%24),t.day=Math.floor(i/60/60/24),t.second<10&&(t.second="0"+t.second),t.minute<10&&(t.minute="0"+t.minute),t.hour<10&&(t.hour="0"+t.hour),t.day<10&&(t.day="0"+t.day),{second:t.second,minute:t.minute,hour:t.hour,day:t.day}},run:function(){var e=this;e.timeId=setInterval(function(){e.timer()},1e3)}},new t(e).init()};