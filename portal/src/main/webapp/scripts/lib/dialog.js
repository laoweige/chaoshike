Handlebars.registerHelper('dialog', function(data) {
    var out = '<div class="modal-dialog">';
            out += '<div class="modal-hd">' + data.title + '</div>';
            out += '<div class="modal-bd">' + data.body +
                '</div>';
        if(data.close){
            out += '<a class="close" title="关闭">关闭</a>';
        }
        out += '</div>';
    if(data.backdrop){
        out += '<div class="modal-backdrop"></div>';
    }
    return  new Handlebars.SafeString(out);
});

var Dialog = function(setting){
    var boxTemp = '<div class="g-modal">{{dialog dialogData}}</div>';

    var isIe6 = function(){
        var isIe6 = false;
        if (/msie/.test(navigator.userAgent.toLowerCase())) {
            if (jQuery.browser && jQuery.browser.version && jQuery.browser.version == '6.0') {
                isIe6 = true
            } else if (!$.support.leadingWhitespace) {
                isIe6 = true;
            }
        }
        return isIe6;
    };

    this.option =$.fn.extend({
        title : null,
        width : 300 ,
        height : null ,
        cls : null,
        left : 0,
        top : 0,
        body : null ,
        foot : "" ,
        backdrop : true,
        close : true ,
        button : [],
        cont : 'body',
        addtype : 'append',
        oninit : function(){},
        onmove : function(){},
        onclose : function(){}
    },setting);

    var _o = this.option,
        self = this;

    this.init = function(){

        var add = function(a,b){
            if(_o.addtype == 'prepend'){
                a.prependTo(b)
            }else{
                a.appendTo(b)
            }
        };

        var boxTemplate = Handlebars.compile(boxTemp);

        this.box  = $(boxTemplate({
            "dialogData":{
                'title' : _o.title,
                'body' : _o.body,
                'backdrop' : _o.backdrop,
                'close' : _o.close
            }
        })).addClass(_o.cls);

        add(this.box,_o.cont);


        if( _o.backdrop && isIe6()){
            if($('.g-loader').length){
                this.loader = $('.g-loader').show();
            }else{
                this.loader = $('<div class="g-loader"><div>').height($('body').height()).appendTo('body');
            }
        }

        this.bind();
        _o.oninit.call(self);
    };
    this.bind = function () {
        var $b = self.box;
        $(document).unbind('keyup');

        if (_o.button != []) {
            $.each(_o.button, function (i, o) {
                $('.btns button', self.box).eq(i).addClass(o.cls).bind('click', function (e) {
                    o.func.call(self, e)
                })
            })
        }

        $('.close,.cancel',this.box).on('click',function(){
            self.close();
        });

        if (_o.close){

            $(document).keyup(function (e) {
                var key = e.which;
                if (key == 27) {
                    self.close();
                }
            });
        }
    };
    this.close = function(){
        self.box.fadeOut(400,function(){
            self.box.remove();
        });
        if(self.loader){
            self.loader.fadeOut(400);
        }
        _o.onclose();
        delete self;
    };
    this.init();
};