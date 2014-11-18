'use strict';

Tc.Module.QuestionList = Tc.Module.extend({
    on: function (callback) {
        var self = this,
            $ctx = this.$ctx,
            $title = $('.question-title',$ctx);


        var init = function () {

            $title.on('click',function(){
                var $item = $(this).parent(),
                    $answer = $('.question-answer',$item);

                $item.toggleClass('active');
                $answer.stop();

                if($item.is('.active')){
                    $answer.slideDown(200);
                }else{
                    $answer.slideUp(200);
                }
            });

        };

        init();

        callback();
    }
});