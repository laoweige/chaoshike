/* suning.com 1417789153898 */SNTouch.ProList=function(){this.init.apply(this,arguments)},$.extend(SNTouch.ProList.prototype,{init:function(){var t=this;t.scrollTouch({id:"No_seacher_list",margin:10,hScrollbar:!1,onBeforeScrollStart:function(t){t.preventDefault()}})},scrollTouch:function(t){var i={};$.extend(i,t);for(var e=$(document.getElementById(i.id).firstElementChild).find("li"),n=e.length,o=e.width(),r=i.margin||0,l=n-1;l>0;l--)o+=e.eq(l).width()+r;$(document.getElementById(i.id).firstElementChild).width(o+12);new iScroll(i.id,t)}});