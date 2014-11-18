'use strict';

Tc.Module.Pager = Tc.Module.extend({
    on: function (callback) {
        var self = this,
            $ctx = this.$ctx,
            maxPage = parseInt($('.next-page-num',$ctx).text()),
            $form = $('form',$ctx);


        var viewModel = {
            pagerJump : ko.observable(),
            submitDisable : ko.observable(true),
            checkInput : function(self,event){
                var lastValue  = parseInt(event.target.value) || 0;
                var char = String.fromCharCode(event.which);

                if(event.which === 13 && !self.submitDisable() ){
                    $form.submit();
                }
                if(char>=0 && char <=9){
                    if(lastValue*10+parseInt(char) <= maxPage && lastValue*10+parseInt(char) > 0){
                        return true;
                    }
                }
            },
            enableBtn : function(self,event){
                var value  = event.target.value;
                self.submitDisable(!$.trim(value));
            }
        };


        var init = function () {

            ko.applyBindings(viewModel, $ctx[0]);

        };

        init();

        callback();
    }
});