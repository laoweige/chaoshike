'use strict';



Tc.Module.OrderSuccessDialog = Tc.Module.extend({
    on: function(callback) {

        var self = this,
            $ctx = this.$ctx,
            $form = $('#order-form'),
            dialogHandler = $ctx.data('dialog-handler');


        var viewModel = {
            posted : ko.observable(false),
            paymentUrl : ko.observable(),
            payed : ko.observable(false),
            error : ko.observable(false),
            pay : function(that,event){
                window.open(that.paymentUrl());
                that.payed(true);
                event.preventDefault();
                return false;
            }
        };

        var init = function(){
            ko.applyBindings(viewModel,$ctx[0]);
            $.ajax({
                type: 'POST',
                url: $form.attr('action'),
                data: $form.serialize(),
                success: function (response){
                    viewModel.posted(true);
                    viewModel.paymentUrl(
                        $('.btn-pay',$ctx).attr('data-pay-url') + "orderId=" + response + "&bussinessType=2&pass=" + $.md5("orderId=" + response + "&bussinessType=AD")
                    );
                    $ctx.find('.modal-hd').text('下单成功');
                },
                error : function(response){
                    var msgMap={"600":"您提交的职位不符合推广条件，请重新下单！",
                                "601":"对不起，您选择的职位置顶时段已经售完，明天可能空出名额，请您持续关注！",
                                "602":"下单金额出错，请重新下单！",
                                "603":"您还有未付款的订单，请及时付款！",
                                "604":"推广开始时间不正确，请重新下单！",
                                "605":"对不起，此职位在您选择的推广时段已经购买了职位置顶，请选择其他时间！"};
                    var errorCode=response.responseText;
                    viewModel.posted(true);
                    viewModel.error(true);
                    if(msgMap[errorCode]){
                        $ctx.find('.error_def').text(msgMap[errorCode]);
                    }
                }
            });
        };

        init();
        callback();

    }
});

