/* suning.com 1418062596512 */$.fn.extend({toogleChar:function(s){var i=$.extend({},{hideCls:".yg-hide-pass",inputBox:".yg-pass-box"},s);this.click(function(){var s=$(this),e=s.siblings(i.inputBox),t=i.hideCls.replace(".",""),l=e.find("input[type=text]"),n=e.find("input[type=password]");s.hasClass(t)?(s.removeClass(t),n.val(l.val()).show(),l.hide()):(s.addClass(t),l.val(n.val()).show(),n.hide())})},delChar:function(s){var i=$.extend({},{parCls:".wbox-flex",closeCls:".yg-input-close"},s),e=$(this);e.each(function(){var s=$(this),e=s.parents(i.parCls).find(i.closeCls);s.keyup(function(){s.val().length>0?!e.is(":visible")&&e.show():e.hide()})}),e.parents(i.parCls).find(i.closeCls).click(function(){function s(s){var i=t.find("input[type="+s+"]");i.val(""),i.val().length<1&&e.hide()}{var e=$(this),t=e.parents(i.parCls),l=t.find("input[type=text]");t.find("input[type=password]")}s(l.is(":visible")?"text":"password")})},showHistory:function(s){var i=$.extend({},{upCls:".yg-arrow-up",showCls:".yg-record-list"},s);this.click(function(){var s=$(this),e=i.upCls.replace(".","");s.hasClass(e)?(s.removeClass(e),$(i.showCls).hide()):(s.addClass(e),$(i.showCls).show())})}});