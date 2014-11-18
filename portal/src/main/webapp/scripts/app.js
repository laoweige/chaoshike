'use strict';
(function(window){

    window.adConfig = {
        invoiceFreight : 15
    };

    var Tc = window.Tc;


    Tc.Module.Global = Tc.Module.extend({
        on: function(callback) {
            var self = this,
                $ctx = this.$ctx,
                $main = $('.col_main_wrap .g-md-box',$ctx),
                $sub = $('.col_sub',$ctx);

            function fixColHeight(){
                var mainHeight = $main.height(),
                    subHeight = $sub.height();

                $main.add($sub).css('minHeight',Math.max(600,subHeight,mainHeight));
            }

            fixColHeight();

            callback();
        }
    });

    Tc.Module.Timer = Tc.Module.extend({
        on: function(callback) {
        var self = this,
            $ctx = $(this.$ctx),
            ts = parseInt($ctx.attr('data-timer')) || 0,
            targetDate = new Date().getTime() + ts;

        var checkTime = function(i){
            if (i < 10) {
                i = "0" + i;
            }
            return i;
        };

        function timer(){
            var ts = targetDate - new Date();
            if(ts >= 0 ){
                var dd = parseInt(ts / 1000 / 60 / 60 / 24, 10);
                var hh = parseInt(ts / 1000 / 60 / 60 % 24, 10);
                var mm = parseInt(ts / 1000 / 60 % 60, 10);
                var ss = parseInt(ts / 1000 % 60, 10);
                dd = checkTime(dd);
                hh = checkTime(hh);
                mm = checkTime(mm);
                ss = checkTime(ss);
                if(mm >= 30){
                    $ctx.text("30分00秒");
                }else{
                    $ctx.text( mm + "分" + ss + "秒");
                }

                setTimeout(function(){
                    timer();
                },1000);
            }
        };

        timer();

        callback();
    }
});

Tc.Module.Dropdown = Tc.Module.extend({
    on: function(callback) {
        var self = this,
            $ctx = $(this.$ctx),
            $toggle = $('.dropdown-toggle',$ctx);

        $toggle.on('click',function(){
            $ctx.toggleClass('active');
        });

        callback();
    }
});

})(window);

$(function(){
    var $page = $('body');
    window.application = new Tc.Application($page);
    application.registerModules();
    application.registerModule($page, 'Global');
    application.start();
});

function openFeedback(i) {
    window.open(i, "_blank", "width=1,height=1,left=100,top=60,scrollbars=0,overflow=auto,status=0")
}






