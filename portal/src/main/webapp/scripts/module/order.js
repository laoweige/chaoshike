'use strict';

Tc.Module.OrderStep2 = Tc.Module.extend({
    on: function (callback) {

        var $ctx = this.$ctx,
            $form = $('form',$ctx);

        var viewModel = {
            submitDisable : ko.observable(false),
            submit : function(){
                if(!this.submitDisable()){
                    viewModel.submitDisable(true);
                    $form.submit();
                }
            },
            cancelOrderWarning: function(){
                var dialog = new Dialog({
                    title: "取消订单",
                    body: Handlebars.compile($("#order-cancel-dialog-template").html())()
                })
            }
        };

        var init = function () {
            if($('.order-step-1 input[type="radio"]:not(:disabled)', $ctx).length  == 0){
                viewModel.submitDisable(true);
            }
            ko.applyBindings(viewModel, $ctx[0]);
        };

        init();
        callback();

    }
});

Tc.Module.Order = Tc.Module.extend({
    on: function (callback) {
        var $ctx = this.$ctx;

        var priceMap = {};

        var getStartDate = function () {
            return new Date(parseInt($('.startDate', $ctx).attr("data-startDate")));
        }, getFirstEffectiveDuration = function () {
            return $('.g-md-time-list input', $ctx).not(":disabled").val() || false;
        }, formatDate = function (date) {
            return date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日";
        }, mapPrice = function () {
            $('.g-md-time-list li', $ctx).each(function (index, element) {
                var $input = $('input',element),
                    $discount = $('.g-mk-discount',element),
                    price = parseFloat($input.attr("data-price")),
                    discount = parseFloat($discount.text()) || 10;
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


        var $inputInvoiceType = $('.order-invoice [name="invoice.type"]');

        var userType = $('.order-invoice .info-label-user-type').attr('data-user-type'),
            receiver = $('.order-invoice [name="invoice.receiver"]').val(),
            mobile = $('.order-invoice [name="invoice.mobile"]').val(),
            postAddress = $('.order-invoice [name="invoice.postAddress"]').val(),
            userName = $('.order-invoice [name="invoice.userName"]').val(),
            invoiceId = $('.order-invoice [name="invoice.id"]').val(),
            invoiceType = $inputInvoiceType.filter(":checked").val(),
            postCode = $('.order-invoice [name="invoice.postCode"]').val(),
            orderStatus = parseInt($('.order-invoice [name="orderStatus"]').val());

        $('#mod-voice-en').bind('change',function(event){
           var dom = event.target;
           if(!dom.checked){
               viewModel.invoiceUserType(userType);
               viewModel.invoiceUserName(userName);
               viewModel.invoiceReceiver(receiver);
               viewModel.invoiceMobile(mobile);
               viewModel.invoicePostAddress(postAddress);
               viewModel.invoicePostCode(postCode);
               $inputInvoiceType.filter('[value="'+invoiceType+'"]')[0].checked = true;
           }
        });
        var viewModel = {
            startDate: ko.observable(),
            duration: ko.observable(),
            submitDisable: ko.observable(false),
            isInvoiceActive: ko.observable(false),
            invoiceUserType : ko.observable(userType),
            invoiceReceiver: ko.observable(receiver).extend({
                required: { message: '请输入收件人.' },
                maxLength: { params: 50, message: "收件人最大长度为50个字符" }
            }),
            isNewInvoiceHide : ko.observable(orderStatus == 1 || orderStatus == 3),
            isNewInvoiceEn : ko.observable(false),
            invoiceMobile: ko.observable(mobile).extend({
                required: { message: '请输入手机号.' }
            }).extend({ pattern: {
                message: '请输入正确手机号',
                params: '^[1][0-9]{10}$'
            }}),
            invoicePostAddress: ko.observable(postAddress).extend({
                required: { message: '请输入邮寄地址.' },
                maxLength: { params: 100, message: "邮寄地址最大长度为100个字符" }
            }),
            invoicePostCode: ko.observable($('.order-invoice [name="invoice.postCode"]').val()),
            submit: function () {
                var self = this;
                if (self.isInvoiceActive() && self.errors().length > 0) {
                    self.errors.showAllMessages();
                    return false;
                }

                self.submitDisable(true);

                var dialog = new Dialog({
                    title: "订单生成",
                    body: Handlebars.compile($("#order-dialog-template").html())(),
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
            showContactDialog: function(){
               var self = this;
               var dialog = new Dialog({
                   title: "服务热线",
                   body: Handlebars.compile($("#order-contact-dialog-template").html())(),
                   close: true,
                   cls: 'dialog-order',
                   oninit: function () {
                       this.box.data('dialog-handler',this);
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

        viewModel.invoiceUserName = ko.observable(userName);

        viewModel.invoiceUserName.extend({
            required: {
                message: '请输入单位名称.',
                onlyIf: function() {
                    return viewModel.invoiceUserType() !== 'PERSONAL' && !viewModel.invoiceUserName();
                }
            },
            maxLength: {
                params: 50,
                message: "单位名称最大长度为50个字符",
                onlyIf: function() {
                    return viewModel.invoiceUserType() !== 'PERSONAL';
                }
            }
        });

        viewModel.errors = ko.validation.group(viewModel);

        viewModel.enableUserName = ko.computed(function () {
            return this.invoiceUserType() === 'COMPANY';
        }, viewModel);

        viewModel.isNotEditAble = ko.computed(function(){
            return invoiceId && !this.isNewInvoiceEn();

        },viewModel);

        viewModel.endDate = ko.computed(function () {
            var endDate = getStartDate();
            endDate.setDate(endDate.getDate() + parseInt(this.duration() - 1 || 0));
            return formatDate(endDate);
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

        viewModel.originalPrice = ko.computed(function () {
            var duration = this.duration();
            if (duration) {
                return formatPrice(( priceMap[duration]['original'] ) + caculateInvoicePrice());

            }
        }, viewModel);

        viewModel.totalPrice = ko.computed(function () {
            var duration = this.duration();
            if (duration) {
                return formatPrice(( priceMap[duration]['price'] ) + caculateInvoicePrice() );
            }
        }, viewModel);


        var init = function () {

            mapPrice();
            viewModel.duration(getFirstEffectiveDuration());
            viewModel.startDate(formatDate(getStartDate()));

            ko.applyBindings(viewModel, $ctx[0]);
        };

        init();

        callback();
    }
});

Tc.Module.OrderList = Tc.Module.extend({
    on: function (callback) {
        var self = this,
            $ctx = this.$ctx;

        var viewModel = {
            exportOrder: function (data, event) {
                var dialog = new Dialog({
                    title: "导出订单",
                    cls: 'dialog-export',
                    body: Handlebars.compile($("#export-dialog-template").html())(),
                    oninit: function (o) {
                        this.box.data('dialog',this);
                        application.start(
                            [application.registerModule(this.box, 'ExportDialog')]
                        );
                    }

                });
            },
            pay: function (that, event) {
                var dialog = new Dialog({
                    title: "付款",
                    body: Handlebars.compile($("#order-list-dialog-template").html())(),
                    oninit: function () {

                    }
                });
                var $btn = $(event.target);
                var url = $btn.attr('href')
                var codeString = url.substring(url.indexOf('?') + 1) + "&bussinessType=AD";
                url = url + "&bussinessType=2&pass=" + $.md5(codeString);
                window.open(url);
                return false;
            },
                         cancel: function (that, event) {
                             var $btn = $(event.target);
                             var url = $btn.attr('href');
                             var content = {"href": url};
                             var dialog = new Dialog({
                                 title: "取消订单",
                                 body: Handlebars.compile($("#order-list-cancel-dialog-template").html())(content),
                                 oninit: function () {
                                 }
                             });
                             return false;
                         }
        };

        var init = function () {
            ko.applyBindings(viewModel, $ctx[0]);
//            $('.status-pay',$ctx).closest('.order-item').addClass('active');
        };

        init();

        callback();
    }
})

Tc.Module.ProcessBar = Tc.Module.extend({
    on: function (callback) {
        var self = this,
            $ctx = this.$ctx;

        var width = $ctx.width() - 20,
            init = parseInt($ctx.attr('data-process-init')) || 0,
            total = parseInt($ctx.attr('data-process-total')) || 1;

        for (var i = 1; i <= total; i++) {
            var $processStep;

            if (i <= init) {
                $processStep = $('<span class="process-step-completed"></span>');
            } else {
                $processStep = $('<span class="process-step">' + i + '</span>');
            }

            $ctx.append($processStep);
            $processStep.css({
                'left': width * (i - 1) / (total - 1)
            });
        }

        if (init > 0) {
            var $processCompleted = $('<span class="process-completed"></span>');
            $ctx.append($processCompleted);
            $processCompleted.css({
                'width': width * (init - 1) / (total - 1)
            });
        }

        callback();
    }
});

Tc.Module.RadioList = Tc.Module.extend({
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
