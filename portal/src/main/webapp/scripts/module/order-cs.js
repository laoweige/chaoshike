'use strict';

Tc.Module.OrderCs = Tc.Module.extend({
    on: function (callback) {
        var $ctx = this.$ctx;
        var oneDayMill = 24 * 60 * 60 *1000;
        var priceMap = {};

        var getStartDate = function () {
            return new Date(parseInt($('.startDate', $ctx).attr("data-startDate")));
        }, getFirstEffectiveDuration = function () {
            return $('.g-md-time-list input', $ctx).not(":disabled").val() || false;
        }, formatDate = function (date) {
            return (date.getFullYear() || '--') + "年" + (date.getMonth() + 1 || '--') + "月" + (date.getDate() || '--') + "日";
        }, mapPrice = function () {
            
            $('.g-md-time-list li', $ctx).each(function (index, element) {
                var $input = $('input',element),
                    $discount = $('.g-mk-discount',element),
                    price = parseFloat($input.attr("data-price")),
                    discount = parseFloat($discount.text()) || 10;
                    if(isNaN(price) || isNaN(discount)){
                        price = 0;
                        discount = 10;
                    }
                priceMap[$input.val()] = {
                    price : price,
                    original : price/discount*10
                };
            })
        }, formatPrice = function (price) {
            if (price > 0) {
                return price.toFixed(1);
            } else {
                return 0;
            }
        };
        var startTime = $('[name="startTime"]').val(),
        outMessage = '';

        var setDatePrice = function(){
            var obj = getDiffDate();
            var isOutRange = obj.isOutRange,
            outMessage = obj.outMessage,
            millTime = obj.millTime;
            if(!isNaN(millTime)){
                $("#day-more").val(millTime);
                $('[name="defDuration"]').val(millTime);
            }

            if(isOutRange){
                viewModel.outDuration(true);
                viewModel.dateOutMessage(outMessage);
                viewModel.duration(false);
                viewModel.defDuration(false);
            }else{
                viewModel.startTimeInput($('#J_DepDate', $ctx).val());
                viewModel.dateOutMessage(outMessage);
                viewModel.outDuration(false);
                viewModel.defDuration(true);
                viewModel.duration(millTime);
            }
        }
        var getDiffDate = function(){
            var endD =  + new Date($('#J_EndDate', $ctx).val());
            var startD = + new Date($('#J_DepDate', $ctx).val());
            var nowD = + new Date();
            var millTime180 = oneDayMill * 180;
            var millTime = (endD - startD) / oneDayMill;
            var isOutRange = false;
            outMessage = '';
            if(isNaN(millTime)){
                isOutRange = true;
                outMessage = '请选择预定起止日期';
            }else{
                millTime++;
                if(millTime < 0){
                    isOutRange = true;
                    outMessage = '结束日期不能晚于开始日期';
                }
                if(millTime < 21 || millTime > 63){
                    isOutRange = true;
                    outMessage = '选择日期范围应在21至63天之内'
                }
                if(endD - nowD >= millTime180){
                    isOutRange = true;
                    outMessage = '选择日期不能超过从当前日期开始起180天';
                }
            }
            return {
                isOutRange : isOutRange,
                outMessage : outMessage,
                millTime : millTime
            };
        };
        var showDateSelector = function(isShow){
            var dateSelector = $('.date-container');
            if(isShow){
                dateSelector.addClass('date-select-visible');
            }else{
                dateSelector.removeClass('date-select-visible');
            }
        }
        var validDateRange = function(){
            var dateSelector = $('.date-container');
            var  message = '';
            if(dateSelector.hasClass('date-select-visible')){
                message = getDiffDate().outMessage;
            }
            return  message;
        }
        var validActualPrice = function(){
            var actualPrice = $('.order-price-cs [name="actualPrice"]').val();
            var re = /^(([1-9]\d*)|0)(\.\d{1,2})?$/;
            var message = '';
            if(actualPrice == ''){
                message = '请输入实际售价';
            }else if (!re.test(actualPrice)){
                message = '实际售价格式不正确，实际售价是两位小数的数字';
            };
            return message;
        }
        var validContractNumber = function(){
            var contractNumber = $('.order-price-cs [name="contractNumber"]').val();
            var  message = '';
            var re = /^\S{2}\d{11}$/;

            if(contractNumber.replace(/^[\s\xa0\u3000]+|[\s\xa0\u3000]+$/g, "") == ''){
                message = '请输入合同编号';
            }else if(!re.test(contractNumber)){
                message = '请输入两位字母和11位数字组成的合同编号';
            }
            return message;
        }
        var validOrderRemark = function(){
            var orderRemark = $('.order-price-cs [name="orderRemark"]').val();
            var len = orderRemark.replace(/[^\x00-\xff]/g, "aa").length;
            var message = '';
            if(len > 400){
                message = '备注最大长度不能超过400个字符';
            }
            return message;
        }
        var validateForm = function(){
            var message = validDateRange() || validActualPrice() || validContractNumber() || validOrderRemark() ;
            if(message == ''){
                return true;
            }else{
                var dialog = new Dialog({
                    title: "输入错误",
                    body: Handlebars.compile($("#order-cs-error-template").html())(),
                    close: false,
                    cls: 'dialog-order',
                    oninit: function () {
                        //this.box.data('dialog-handler',this);
                        $('.order_cs_valid_error').html(message);
                        /*application.start(
                            [application.registerModule(this.box, 'OrderValidErrorDialog')]
                        );*/
                    }
                });
                return false;
            }
        }
        var viewModel = {
            startDate: ko.observable(),
            duration: ko.observable(),
            startTimeInput : ko.observable(),
            defDuration: ko.observable(false),
            outDuration : ko.observable(false),
            submitDisable: ko.observable(false),
            isInvoiceActive: ko.observable(false),
            isNewInvoiceHide : ko.observable(true),
            isNewInvoiceEn : ko.observable(false),
            submit: function () {
                var self = this;
                if(!validateForm()){
                   return false;
                }

                self.submitDisable(true);

                var dialog = new Dialog({
                    title: "订单生成",
                    body: Handlebars.compile($("#order-cs-dialog-template").html())(),
                    close: false,
                    cls: 'dialog-order',
                    oninit: function () {
                        this.box.data('dialog-handler',this);
                        application.start(
                            [application.registerModule(this.box, 'OrderSuccessDialog')]
                        );
                    }
                });
            },
            cancelOrderWarning: function(){
                var dialog = new Dialog({
                    title: "取消订单",
                    body: Handlebars.compile($("#order-cancel-dialog-template").html())()
                })
            }
        };

        $('.date-container li input').attr("afterSelectedCall","afterSelectedCall");

        window.afterSelectedCall = function(optionDom,date){
            setDatePrice();
        }
        viewModel.dateOutMessage = ko.observable(outMessage);

        viewModel.errors = ko.validation.group(viewModel);
        viewModel.endDate = ko.computed(function () {
            var endDate = getStartDate();
            if(isNaN(this.duration()) || (this.duration() > 20 && this.duration() < 64)){
                showDateSelector(true);
                var endD =   new Date($('#J_EndDate', $ctx).val());
                var startD =  new Date($('#J_DepDate', $ctx).val());
                this.startDate(formatDate(startD));
                return formatDate(endD);
            }else if(this.duration()){
                $('#J_EndDate', $ctx).val('');
                $('#J_EndDate', $ctx).val('');
                this.defDuration(false);
                showDateSelector(false);
                this.startTimeInput(startTime);
                this.startDate(formatDate(getStartDate()));
                endDate.setDate(endDate.getDate() + parseInt(this.duration() - 1 || 0));
                return formatDate(endDate);
            }
        }, viewModel);
        function caculateInvoicePrice() {
            if(viewModel.isNewInvoiceHide()){
                if(viewModel.isNewInvoiceEn() && viewModel.isInvoiceActive()){
                    return adConfig.invoiceFreight
                }
            }else{
              if(viewModel.isInvoiceActive()){
                  return adConfig.invoiceFreight;
              }
            }
            return  0;
        }
        var getDefTotalPrice = function(){
            var url = '/products/1/price.do';
            var duration = viewModel.duration();
            if(typeof duration != "number"){
                return ;
            }
            var region = $('input').filter("[name$=region]").val();
            var position =  $('input').filter("[name$=position]").val();
            var price = 0;
            $.ajax({
                async: true,
                type: "GET",
                url: url,
                data: "duration=" + duration + "&region=" + region+ "&position=" + position,
                success: function (data) {
                    var obj = eval(data);
                    price = obj.price;
                    viewModel.defTotalPrice(price);
                },
                error : function(){
                    price = 0 ;
                }
            });
            return price;
        }
        viewModel.defTotalPrice = ko.observable();

        viewModel.totalPrice = ko.computed(function () {
            var duration = this.duration();
            if (duration) {
                if(duration < 21){
                    return formatPrice(( priceMap[duration]['price'] ) + caculateInvoicePrice() );
                }else{
                    return formatPrice(getDefTotalPrice());
                }
            }
        }, viewModel);


        var init = function () {
            mapPrice();
            var _duration = getFirstEffectiveDuration();
            viewModel.duration(_duration);
            viewModel.outDuration(!_duration);

            viewModel.startDate(formatDate(isNaN(_duration) ? new Date('') :getStartDate()));
            ko.applyBindings(viewModel, $ctx[0]);
        };

        init();

        callback();
    }
});

Tc.Module.RadioListCs = Tc.Module.extend({
    on: function (callback) {
        var self = this,
            $ctx = this.$ctx,
            $radios = $('input[type="radio"]', $ctx);

        var checkedClass = 'checked';

        function setChecked(self) {
            self.closest('li').addClass(checkedClass).siblings().removeClass(checkedClass);
        }

        $radios.on('change', function (e) {
            setChecked($(this));

        });

        var init = function () {
            $radios.not(":disabled").eq(0).attr("checked", "checked");
            $('li:odd', $ctx).addClass('odd');

            var $checkedRadio = $radios.filter(":checked"),
                $disabledRadio = $radios.filter(":disabled")

            if ($checkedRadio.length){
                setChecked($checkedRadio);
            }

            if ($disabledRadio.length) {
                $disabledRadio.closest('li').addClass('disabled');
            }

        };

        init();
        callback();
    }
});