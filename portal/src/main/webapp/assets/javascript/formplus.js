var validatorMap = {
    'required': [LANG_formplus['validate']['required'], function(element, v) {
        return v != null && v != '';
    }],
    'number': [LANG_formplus['validate']['number'], function(element, v) {
        return ! isNaN(v) && ! /^\s+$/.test(v);
    }],
    'msn': [LANG_formplus['validate']['msn'], function(element, v) {
        return v == null || v == '' || /\S+@\S+/.test(v);
    }],
    'skype': [LANG_formplus['validate']['skype'], function(element, v) {
        return ! /\W/.test(v) || /^[a-zA-Z0-9]+$/.test(v);
    }],
    'digits': [LANG_formplus['validate']['digits'], function(element, v) {
        return ! /[^\d]/.test(v);
    }],
    'unsignedint': [LANG_formplus['validate']['unsignedint'], function(element, v) {
        return (!/[^\d]/.test(v) && v > 0);
    }],
    'unsigned': [LANG_formplus['validate']['unsigned'], function(element, v) {
        return (!isNaN(v) && ! /^\s+$/.test(v) && v >= 0);
    }],
    'positive': [LANG_formplus['validate']['positive'], function(element, v) {
        return (!isNaN(v) && ! /^\s+$/.test(v) && v > 0);
    }],
    'alpha': [LANG_formplus['validate']['alpha'], function(element, v) {
        return v == null || v == '' || /^[a-zA-Z]+$/.test(v);
    }],
    'alphaint': [LANG_formplus['validate']['alphaint'], function(element, v) {
        return ! /\W/.test(v) || /^[a-zA-Z0-9]+$/.test(v);
    }],
    'alphanum': [LANG_formplus['validate']['alphanum'], function(element, v) {
        return ! /\W/.test(v) || /^[\u4e00-\u9fa5a-zA-Z0-9]+$/.test(v);
    }],
    'unzhstr': [LANG_formplus['validate']['unzhstr'], function(element, v) {
        return ! /\W/.test(v) || ! /^[\u4e00-\u9fa5]+$/.test(v);
    }],
    'date': [LANG_formplus['validate']['date'], function(element, v) {
        return v == null || v == '' || /^(19|20)[0-9]{2}-([1-9]|0[1-9]|1[012])-([1-9]|0[1-9]|[12][0-9]|3[01])$/.test(v);
    }],
    'email': [LANG_formplus['validate']['email'], function(element, v) {
        return v == null || v == '' || /(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test(v);
    }],
    'mobile': [LANG_formplus['validate']['mobile'], function(element, v) {
        return v == null || v == '' || /^0?1[3458]\d{9}$/.test(v);
    }],
    'tel': [LANG_formplus['validate']['tel'], function(element, v) {
        return v == null || v == '' || /^(0\d{2,3}-?)?[23456789]\d{5,7}(-\d{1,5})?$/.test(v);
    }],
    'phone': [LANG_formplus['validate']['phone'], function(element, v) {
        return v == null || v == '' || /^0?1[3458]\d{9}$|^(0\d{2,3}-?)?[23456789]\d{5,7}(-\d{1,5})?$/.test(v);
    }],
    'zip': [LANG_formplus['validate']['zip'], function(element, v) {
        return v == null || v == '' || /^\d{6}$/.test(v);
    }],
    'url': [LANG_formplus['validate']['url'], function(element, v) {
        return v == null || v == '' || /^(http|https|ftp):\/\/([A-Z0-9][A-Z0-9_-]*)(:(\d+))?\/?/i.test(v);
    }],
    'area': [LANG_formplus['validate']['area'], function(element, v) {
        return element.getElements('select').every(function(sel) {
            var selValue = sel.get('value');
            sel.focus();
            return selValue != '' && selValue != '_NULL_';
        });
    }],
    'requiredcheckbox': [LANG_formplus['validate']['requiredonly'], function(element, v, type) {
        type = type || element.get('type');
        var parent = element.getParent();
        var name = element.get('name');
        if (name) element = parent.getElements('input[type=' + type + '][name="' + name + '"]');
        else element = parent.getElements('input[type=' + type + ']');
        return element.some(function(el) {
            return el.checked == true;
        });
    }],
    'requiredradio': [LANG_formplus['validate']['requiredonly'], function(element, v, type) {
        type = type || element.get('type');
        var parent = element.getParent();
        var name = element.get('name');
        if (name) element = parent.getElements('input[type=' + type + '][name="' + name + '"]');
        else element = parent.getElements('input[type=' + type + ']');
        return element.some(function(el) {
            return el.checked == true;
        });
    }],
    'uname': ['请填写正确的用户名', function(element, v) { 
        return v.length <= 20 && v.length >= 6;
    }],
    'password': ['请填写正确的密码', function(element, v) {
        return v.length <= 20 && v.length >= 8;
    }],
    'confirm_password':['两次密码输入不一致', function(element, v) {
        var target = $('reg_passwd');
        return v == target.value;
    }]
};

var validate = function(container) {
    container = container || container === 0 ? document.id(container) : null;
    if (!container) return true;
    var formElements = container.match('form')?container.getElements('[vtype]'):[container];
    var err_log = new Elements(); 
       // console.info(formElements);return false;
        formElements.each(function(element) {

                var vtype = element.get('vtype');
                if (!vtype||!element.isDisplay()) return true;
                var vtypeArr =  vtype.split('&&');
                if (element.get('required')) {
                        vtypeArr = ['required'].combine(vtypeArr.clean());
                }

               var flag = vtypeArr.every(function(key) {

                        var validator = validatorMap[key];
                        if (!validator) return true;
                        var caution = {el:element.getNext('.caution')?element.getNext('.caution'):element.getNext('span') && element.getNext('span').getElement('.caution'),msg:(element.get('caution') || validator[0])}; 
                               validator = validator[1]||function(){return true};

                        if (validator(element, element.get('value'), element.get('type'))) {
                                if(caution.el && !caution.el.hasClass('success')){
                                  if(element.get('data-full')){
                                    caution.el.removeClass('error').addClass('success').empty();
                                  }else{
                                    caution.el.destroy();
                                  }
                                }
                                return true;
                        }else{

                            if(caution.el){
                              caution.el && caution.el.addClass('error').removeClass('comment').removeClass('success').set('html', caution.msg);
                            }else{

                                if(element && element.get('data-full')){

                                }else{
                                  new Element('span', {'class': 'error caution notice-inline'}).inject(element, 'after').set('html', caution.msg);  
                                }
                                

                            }


                            
                            

                            element[['input','select','textarea'].contains(element.get('tag'))?'onblur':'onmouseout'] = function() {validate(this)};
                                return false;
                        }

                    });
              // console.info(flag,element);
                        if(!flag)
                        err_log.include(element);
        });
           
         if(err_log.length){
                    if(container.match('form'))new Fx.Scroll(window,{link:'cancel'}).toElement(err_log.shift());
                    return false;
        }
        return true;
};

//= 验证提示信息框
var formTips = new Class({
  Implements: Options,
  options: {
      form: 'inline',
      type: 'error', // warn, error, notice, success
      'class': 'notice-inline',
      msg: '',
      target: document.body,
      /*where: null,
      single: false,
      store: false,*/
      destroy: false,
      position: ['ct', 'cb'],
      offset: [0,-9],
      intoView: true,
      autohide: 3
  },
  initialize: function(options) {
      this.setOptions(options);
      this.hidden = true;
      // this.toElement();
      return this;
  },
  toElement: function() {
      if(!this.element) {
          var options = this.options;
          this.uid = options.target.get('uid');
          this.uid++;
          var tag = options.form == 'inline' ? 'span' : 'div';
          var id = '_build_tips_' + (options.form ? options.form : '') + '_' + options.type + '_' + this.uid;
          this.element = options.single && document.id(id) ? document.id(id) : new Element(tag, {
              id: id,
              'class': 'caution '+ options.type + ' ' + options['class'],
              'style': 'display:none;',
              'html': '<q class="icon">' + (options.type === 'success' ? '&#x25;' : '&#x21;') + '</q><span class="caution-content"></span>'
          });
          this.element.inject(options.target, options.where);
      }
      return this.element;
  },
  store: function (element) {
      ($(element) || this.options.target).store('tips_instance', this);
      return this;
  },
  eliminate: function (element) {
      ($(element) || this.options.target).eliminate('tips_instance');
      return this;
  },
  position: function(options) {
      if(!this.element) document.id(this);
      var position = {
          target: options.target,
          from: tyeOf(options.position) == 'array' ? options.position[0] : 'cb', //此元素定位基点 --为数值时类似offset
          to: tyeOf(options.position) == 'array' ? options.position[0] : options.position, //定位到目标元素的基点
          offset: options.offset // 偏移量
      }
      return this.element.position(position);
  },
  show: function(msg, options) {
      if(typeOf(msg) == 'object') {
          options = msg;
          msg = options.msg;
      }
      if(!this.hidden) return this;
      options = Object.merge(this.options, options||{});
      if(!this.element) document.id(this);
      if(options.form && options.form != 'inline') this.element.position(options);
      if (options.intoView) try {
          new Fx.Scroll(document, {link:'cancel', duration: 300}).toElementEdge(this.element);
      } catch(e) {}

      if(msg) this.element.getElement('.caution-content').innerHTML = msg;
      this.element.show();
      this.hidden = false;
      if(!isNaN(options.autohide) && options.autohide > 0) {
          clearTimeout(this.timer);
          this.timer = this.hide.delay(options.autohide * 1000, this);
      }
      return this.options.store ? this.store(this.options.store) : this;
  },
  hide: function(destroy) {
      destroy = destroy || this.options.destroy;
      if(this.hidden) return this;
      if(!this.element) document.id(this);
      // if(this.element) {
      if(destroy !== false) {
          this.element.destroy();
          this.element = null;
      }
      else this.element.hide();
      // }
      this.hidden = true;
      return this.eliminate(this.options.store);
  }
}).extend({
  tip: function(element, msg) {
      return new formTips({type:'notice', target: element || document.body, where: 'after', autohide: 0}).show(msg);
  },
  error: function(msg, element, options) {
      return new formTips({type: 'error', target: element || document.body, where: 'after', autohide: 0}).show(msg, options);
  },
  success: function(msg, element, options) {
      return new formTips({type:'success', target: element || document.body, where: 'after', autohide: 0}).show(msg, options);
  },
  warn: function(msg, element, options) {
      return new formTips({type: 'warn', target: element || document.body, where: 'top', autohide: 0, 'class': 'caution-inline', single: true, store: true}).show(msg, options);
  }
});

//=密码强度检测
var passwordStrength = function(value, key, className){
  var lower = /[a-z]/g;
  var upper = /[A-Z]/g;
  var numberic = /\d/g;
  var symbols = /[\W_]/g;
  var repeat = new RegExp('(.{' + parseInt(value.length / 2) + ',})\1', 'g');

  var minLength = 6;
  var maxLength = 20;
  var strength = -1;
  var status = 'poor';

  if(!value || value.length < minLength) {
      strength = -1;
  }
  else {
      strength = parseInt(value.length / minLength) - 1;
  }
  if(value.match(repeat)) {
      strength --;
  }
  if(value.match(lower) || value.match(upper)) {
      strength ++;
  }
  if(value.match(numberic)) {
      strength ++;
  }
  if(value.match(symbols)) {
      strength ++;
  }
  if(value.length > minLength && strength < 2) {
      strength ++;
  }

  switch(strength) {
      case -1:
      case 0:
      case 1:
          status = 'poor';
          break;
      case 2:
          status = 'weak';
          break;
      case 3:
          status = 'good';
          break;
      default:
          status = 'strong';
          break;
  }
  key.className = (className ? className + ' ' : '') + 'password-' + status;
}.extend({
  init: function(element, key) {
      Array.from(element).each(function(el){
          if(!el) return;
          if(key) {
              key = el.getParent().getElement(key);
          }
          else {
              key = el.getNext();
          }
          if(!key) return;
          var className = key.setStyle('visibility', 'visible').className;
          el.addEvent('inputchange', function(e){
              var prev = passwordStrength.prev;
              var value = this.value;
              if(prev !== value) {
                  passwordStrength(value, key, className);
              }
              passwordStrength.prev = value;
          });
      });
  }
});

//点击更换验证码
function changeVerify(element, hasEvent) {
  Array.from(element).each(function(el){
      var url;
      var img;
      if(el.tagName === 'IMG') {
          img = el;
          url = el.getAttribute('src').split('?')[0];
      }
      else if(el.tagName === 'A') {
          img = el.getPrevious('img');
          url = el.getAttribute('href');
      }
      if(hasEvent) el.addEvent('click', changeCode.bind(el, img, url));
      else changeCode(img, url);
  });
}
function changeCode(img, url){
  url = url || img.src.split('?')[0];
  var random = +new Date;
  img.src = url + '?' + random;
  return false;
}
//=全选
function checkAll(el, elements) {
  elements.set('checked', el.checked);
}

//= placeholder兼容性实现
//页面初始化时对所有input做初始化
//Placeholder.init();
//或者单独设置某个元素
//Placeholder.create($('t1'));
var Placeholder = {
  support: (function() {
      return 'placeholder' in document.createElement('input');
  })(),
  //提示文字的样式
  className: 'placeholder',
  init: function() {
      if (!Placeholder.support) {
          Placeholder.create($$('input, textarea'));
      }
  },
  build: function(input, html) {
      var parent = input.getParent();
      if(parent.getStyle('position') == 'static') {
          parent.setStyle('position', 'relative');
      }
      var placeholder = input.getPrevious('.' + this.className) || new Element('span.' + this.className, {
          html: html,
          style: 'visibility:hidden;'
      }).inject(input, 'before')
      .position({target: input, from:'lc', to:'lc', offset:{x:4}, offsetParent:true})
      .addEvent('click', function(e){
          this.setStyle('visibility', 'hidden');
          input.focus();
      });
      return placeholder;
  },
  create: function(inputs) {
      Array.from(inputs).each(function(el){
          if (!Placeholder.support && el.get && el.get('placeholder')) {
              var value = el.get('placeholder');
              var placeholder = Placeholder.build(el, value);
              if(el.value === '') {
                  placeholder.setStyle('visibility', 'visible');
              }
              el.addEvents({
                  'focusin': function(e) {
                      placeholder.setStyle('visibility', 'hidden');
                  },
                  'focusout': function(e) {
                      if (this.value === '') {
                          placeholder.setStyle('visibility', 'visible');
                      }
                  }
              });
          }
      });
  }
};

window.addEvent('domready', function(e){
  var forms = document.forms;
  if(forms.length) {
      //= 自动检测密码强度
      passwordStrength.init($$('form .auto-password-check-handle'));
      //= 自动绑定更换验证码
      changeVerify($$('form .auto-change-verify-handle'), true);
      //= 记住帐号
      $$('form .action-remember-account').each(function(el){
          el.addEvent('change',function(e){
              if(this.checked) {
                  Memory.set('sign.remember', '1', 365);
              }
              else {
                  Memory.set('sign.remember', '0', 365);
              }
          }).fireEvent('change');
      });
      //= 记住密码
      $$('form .action-auto-signin').addEvent('change',function(e){
          if(this.checked) {
             Memory.set('sign.auto', '1', 14);
          }
          else {
              Memory.clean('sign.auto');
          }
      });
  }
  Placeholder.init();
});

(function() {
    var disabled = 'disabled',
        ajaxName = '_ajax',
        attr = 'rel';

    var Sync = this.Sync = new Class({
        Extends: Request.HTML,
        options: {
            syncCache: false,
            disabled: disabled,
            loadtip: 'loading',
            tipCls: '-tip',
            ajaxTip: 'ajax-tip',
            tipHidden: false,
            position: 'before',
            evalScripts: true
        },
        initialize: function(target, options) {
            this.sponsor = target;
            if (target) options = this._getOptions(target, options);
            this.parent(options);
        },
        _getOptions: function(target, options) {
            options = options || {};
            var _options;
            try {
                _options = JSON.decode(target.get('data-ajax-config')) || {};
            } catch(e) {
                _options = {};
            }

            var dataForm, opt, isSubmit = target.type === 'submit' ? true: false;

            if (isSubmit) dataForm = this.dataForm = target.getParent('form') || {};
            if (isSubmit) opt = {
                data: dataForm,
                url: dataForm.action,
                method: dataForm.method || 'post'
            };
            else opt = {
                url: target.get('href'),
                method: 'get'
            };

            _options = Object.merge(opt, options, target.retrieve('_ajax_config', {}), _options);
            return _options;
        },
        _nearText: function(elem) {
            var el = elem,node;
            while (elem) {
                node = elem.lastChild;
                if (typeOf(node) === 'whitespace') node = node.previousSibling;
                if (node && node.nodeType === 3) return $(elem);
                elem = node;
            }
            return el;
        },
        _defaultState: function() {
            this.sponsor && this.sponsor.removeClass(this.options.disabled).retrieve('default:state', function() {})();
            return this;
        },
        onFailure: function() {
            this._defaultState().parent();
        },
        _validate: function(elem) {
            return validate(elem);
        },
        _getCache: function(sponsor) {
            return sponsor.retrieve('ajax:cache', false);
        },
        _clearCache: function(sponsor) {
            sponsor.eliminate('ajax:cache');
        },
        _setCache: function(sponsor, value) {
            sponsor && sponsor.store('ajax:cache', value);
        },
        _progressCache: function(sponsor) {
            var cache = this._getCache(sponsor);
            if (cache) return cache.success(cache.response.data) || true;
        },
        success: function(text, xml) {
            this.response.data = text;
            if ((/text\/jcmd/).test(this.getHeader('Content-type'))) return this._jsonSuccess(text);

            if (['update', 'append', 'filter'].some(function(n) {
                return this.options[n];
            },this)) return this.parent(text, xml);

            this.onSuccess(this.processScripts(text), xml);
        },
        _jsonSuccess: function(text) {
            var json;
            try {
                json = this.response.json = JSON.decode(text);
            } catch(e) {
                json = null;
            }
            this.onSuccess(json);
        },
        onSuccess: function(text) {
            this._defaultState();
            if (this.response.json) this._progress(text);
            this._setCache(this.sponsor, this);
            this.parent(arguments);
        },
        _progress: function(cmd) {
            if (!cmd) return;
            var redirect = cmd['redirect'];
            var m;
            ['error', 'success'].each(function(v, k) {
                m = cmd[v];
                if (this.options.inject && m) {
                    if (v != this.options.tipHidden) return this._injectTip(v, m);
                    this._clearTip(v, m);
                }
            }, this);
            if ((m = cmd['error'])) {
                var state = this.options.progress ? this.options.progress(cmd) : true;
                if (m && state !== false) return Message(m, 'error', function() {
                    if (redirect) {
                        if (redirect == 'back') history.back();
                        else if (redirect == 'reload') location.reload();
                        else location.href = redirect;
                    } else {
                        this._defaultState();
                    }
                }.bind(this));
            } else if ((m = cmd['success'])) {
                return Message(m,'success',function(){
                    if (m && redirect) {
                        if (redirect == 'back') history.back();
                        else if (redirect == 'reload') location.reload();
                        else location.href = redirect;
                    }
                });
            }
        },
        _clearTip: function() {
            if (!this.inject || ! this.tipElem) return;
            this.tipElem.destroy();
        },
        _injectTip: function(cls, html) {
            var options = this.options,
                inject = this.inject = document.id(options.inject),
                position = options.position,
                ajaxTip = options.ajaxTip,
                tipCls = options.tipCls,
                cls = cls + tipCls,
                tipBox;

            if (!inject) return;
            tipBox = inject.getParent();
            if (tipBox && (this.tipElem = tipBox.getElement('.' + ajaxTip))) return this.tipElem.set('html', html);
            new Element('div', {
                'class': cls + ' ' + ajaxTip
            }).set('html', html).inject(inject, position);
        },
        _request: function(sponsor) {
            if (!sponsor) return this;
            sponsor.addClass(this.options.disabled);
            var obj = {
                    'INPUT': 'value',
                    'BUTTON': 'html'
                },
                key,
                btnText,
                btn;
            if (key = obj[sponsor.tagName]) {
                btnText = sponsor.get(key);
                btn = this._nearText(sponsor);
                btn.set(key, this.options.loadtip);
            }
            sponsor.retrieve('default:state') || sponsor.store('default:state', function() {
                sponsor && sponsor.set(key, btnText);
            });
            return this;
        },
        _isCheck: function(elem, options) {
            options = options || {};
            var dataElem = this.dataForm || options.data || this.options.data;

            if (typeOf(dataElem) === 'element' && ! this._validate(dataElem)) return false;
            return true;
        },
        send: function(options) {
            var target = this.sponsor;
            if (target) {
                if (target.hasClass(this.options.disabled) || ! this._isCheck(target, options)) return;
                if (this.options.syncCache && this._progressCache(target)) return;
            }
            this._request(target).parent(options);
        }
    });

    var async = this.async = function(elem, event, _form) {
        if (elem.hasClass(disabled)) return false;

        if (_form) {
            if (!validate(_form)) {
                elem.removeClass(disabled);
                return false;
            }
            if (!elem.get('isDisabled')) return elem.addClass(disabled);
        }
        if (sync = elem.retrieve('ajax:cache', false)) return sync.send();
        sync = new Sync(elem).send();
    };

    var Ex_Event_Group = this.Ex_Event_Group = {
        _request: {
            fn: async
        }
    };

    var nearest = function(elem, type) {
        var i = 3,
            el;
        for (; i; i--) {
            if (!elem || elem.nodeType === 9) return el;
            if (elem.type === 'submit' || ($(elem) && $(elem).get(type))) return elem;
            elem = elem.parentNode;
        }
        return el;
    };

    $(document.documentElement || document.body).addEvent('click', function(e) {
        var target = $(e.target),
            elem;
        if ((elem = nearest(target, attr))) {
            if (elem.type === 'submit' && elem.get(attr) !== '_request') return async(elem, e, elem.getParent('form'));

            var type = elem.get(attr),
                eventType = Ex_Event_Group[type];
            if (eventType) {
                var fn = eventType['fn'],
                    loader = eventType['loader'];

                e.preventDefault();
                if ($(elem).get && $(elem).get(type)) return elem;

                if (loader) {
                    Ex_Loader(type, function() {
                        fn && fn(elem, e);
                    });
                }
                else {
                    fn && fn(elem, e);
                }
            }
        }

    });

})();

