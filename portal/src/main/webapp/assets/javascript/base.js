    function addFavorite() {

        var sURL = location.href;
        var sTitle = document.title;

            try {
                window.external.addFavorite(sURL, sTitle);
            } catch (e) {
                try {
                    window.sidebar.addPanel(sTitle, sURL, "");
                } catch (e) {
                    // var c = "ctrl";
                    // if (navigator.platform.match(/mac/i)) {
                    //     c = "command"
                    // }

                    if(window.XMLHttpRequest){

                        if( window.navigator.userAgent.indexOf("Chrome") !== -1 ){
                            alert("您的浏览器不支持加入收藏功能，请按Ctrl+D进行手动添加");    
                        }

                    }else{
                        alert("您的浏览器不支持加入收藏功能，请按Ctrl+D进行手动添加");    
                    }
                    
                    /*
                    try{
                        createShortcut();//Chrome无法自动收藏，用创建快应用程序的捷方式来替代。
                    } catch(e){
                        console.log(e);
                        
                    }
                    */
                    
                }
            }
            //return false;


    }


//智能浮动层

var $smartFloat = function(elements) {

    var position = function(element) {

        var top = element.getPosition().y, pos = element.getStyle("position");

        window.addEvent("scroll", function() {

            var scrolls = this.getScroll().y;

            if (scrolls > top) {

                if (window.XMLHttpRequest) {

                    element.setStyles({

                        position: "fixed",

                        top: 0

                    });    

                } else {

                    element.setStyles({

                        top: scrolls

                    });    

                }

            }else {

                element.setStyles({

                    position: "relative",

                    top: 0

                });

            }                       

        });

    };

    if ($type(elements) === "array") {

        return elements.each(function(items) {

            position(items);                         

        });

    } else if ($type(elements) === "element") {

        position(elements);    

    }

};



//智能浮动层
 
var $floatbar = function(elements) {

    var position = function(element) {

        var ext_h = 100;
        var init_scrolls = window.getScroll().y;
        var _top = parseInt(init_scrolls)+parseInt(ext_h);
		element.setStyles({
        	top: _top
        });


        window.addEvent("scroll", function() {
            var scrolls = this.getScroll().y;
            var _top = parseInt(scrolls)+parseInt(ext_h)
            element.setStyles({
                top: _top
            });    
        });

    };


    var smartfloor = function(element){
    	
    	var all_floor = $$('.float-index');
    	//创建并插入楼层标识
    	if(all_floor.length>0){
    		var target = $('floor-indicator').getElement('ul');
    		all_floor.each(function(item){

    			item.pos_y = item.getPosition().y; 

    			var tmp_href=item.get('name');
    			var tmp_index=item.get('data-index');

    			if(tmp_href && tmp_index){
	    			new Element('li',{
	    				'id':'ind'+tmp_href,
	    				'class':'indicator-item',
	    				'html':'<a href="#'+tmp_href+'">'+tmp_index+'F</a>'
	    			}).inject(target);
    			}
    		})


    		//滚动时,识别楼层
    		 window.addEvent("scroll", function() {
            	var scrolls = this.getScroll().y;
            	var goloop = true;
            	var fixed = 100; //fixed floor height
            	all_floor.each(function(item){
            		if(scrolls<item.pos_y+fixed && goloop){
            			goloop=false;
            			var rel_indicator_id = 'ind'+item.get('name');
            			var rel_indicator = $(rel_indicator_id);
            			if(rel_indicator && !rel_indicator.hasClass('active')){
            				rel_indicator.addClass('active').getSiblings('.indicator-item').removeClass('active');
            			}

            		}
            	});

             })

    		 //有楼层时启用(即只在首页启用)
             element.setStyle('display','block')
    	}

    }


    elements.addEvents({
    	'mouseenter:relay(#hdl-service)':function(){
    		$('float-main').addClass('show');
    	},
    	'click:relay(.close)':function(){
    		$('float-main').removeClass('show');
    	},
    	'click:relay(#hdl_gotop)':function(){
    		window.scrollTo(0,0);
    	}
    })


    position(elements); 
    smartfloor(elements);  

};

var theme_tools = {

		initCategory:function(){/*全部商品分类*/



			var tar = $('category')?$('category'):$('seller-category');



			var is_index = $('show_category')?true:false;


			if(tar && !is_index){//非首页时启用菜单折叠功能

				tar.addEvents({

					'mouseenter':function(){

						this.addClass('show')

					},

					'mouseleave':function(){

						this.removeClass('show');

					}

				})

			}



			



			if(tar && tar.getElements('li.lv1') && tar.getElements('li.lv1').length>0){



				var lv1 = tar.getElements('li.lv1');



				lv1.addEvents({

					'mouseenter':function(){

						this.addClass('hov');

					},

					'mouseleave':function(){

						this.removeClass('hov');

					}

				})

			}

		},

		enbleCatPath:function(){

			var tar = $('catgory-path');

			var els = tar.getElements('dl');

			els.addEvents({

				'mouseenter':function(){

					this.addClass('show');

				},

				'mouseleave':function(){

					this.removeClass('show');

				}

			});

		},

		makeHover:function(els){

			if(!els)return;

			els.addEvents({

				'mouseenter':function(){

					this.addClass('show').getSiblings().removeClass('show');

				},

				'mouseleave':function(){

					//this.removeClass('show')

				}

			})

		},

		initMyZone:function(){

			if($('myZoneWrap')){

				$('myZoneWrap').addEvents({

					'mouseenter':function(){

						this.addClass('show')

					},

					'mouseleave':function(){

						this.removeClass('show')

					}

				})

			}

		},

		initSiteBar:function(){

			$('site-bar') && $$('#site-bar .history,#site-bar .app').addEvents({

				'mouseenter':function(){

					this.addClass('show')

				},

				'mouseleave':function(){

					this.removeClass('show');

				}

			})





			$('site-bar') && $$('#site-bar .icon') && $$('#site-bar .icon').addEvent('click',function(){


				var sname = document.title.replace(/\s/ig,'');

				var surl = location.href;

				document.getElementById('createshortcuts').furl.value = surl;

				document.getElementById('createshortcuts').fname.value = sname;

				document.getElementById('createshortcuts').submit();

			})

		},

		circleSwitch:{//商圈与城市联动

			init:function(){

				var self = this;

				var city = $('delivery-area-main');

				var circle = $('delivery_circle_wrap');

				if(city && circle){

					

					if(self.getRemoteCircleData()){	//若获取到了商圈数据







						self.fillCity(self.circleData,true);	//填充城市列表并填充默认城市





						//hover事件

						circle.addEvents({

							'click:relay(.item)':function(){

								self.changeCircle(this);

							},

							'mouseenter':function(){

								this.addClass('show');

							},

							'mouseleave':function(){

								if(this.hasClass('hold')){

									//用户还没有选择商圈



								}else{

									this.removeClass('show');

								}

							}

						})



						city.addEvents({

							'click:relay(.item)':function(){

								self.changeCity(this);

							},

							'mouseenter':function(){

								this.addClass('show');

							},

							'mouseleave':function(){

								this.removeClass('show');

							}

						})



					}





					

				}



			},

			fillCity:function(cityData,init){	//填充城市列表

				var self = this;

				var html = '';

				var el_cur_city = $('hdl_delivery_area').getElement('.label');

				var tmp_city = '<li class="item" data-region="{region_id}">{local_name}</li>';

				var tmp_def_city = '<li class="item default current" data-region="{region_id}">{local_name}</li>';



				cityData.each(function(item,i){

					if(init && i==0){//初始化时,填充默认城市

						html += tmp_def_city.substitute(item);

						el_cur_city.set('text',item.local_name);

						self.lastCity = item.region_id;	//设置最后一次成功选择的城市id

						self.fillCircle(item.circles,true)	//设置默认城市的商圈列表,并设置默认商圈

					}else{

						html += tmp_city.substitute(item);

					}

				})

				$('area_list').set('html',html)



			},

			fillCircle:function(circleData,init){



				var self = this;

				var html = '';

				var el_cur_circle = $('delivery_circle_wrap').getElement('.label');

				var tmp_circle = '<li class="item" data-region="{city}" data-url="{url}">{circle_name}</li>';

				var tmp_def_circle = '<li class="item default current" data-region="{city}" data-url="{url}">{circle_name}</li>';



				circleData.each(function(item,i){

					//if(init && i==0){//初始化时,填充默认商圈
					if(init && item.selected){
						html += tmp_def_circle.substitute(item);

						el_cur_circle.set('text',item.circle_name);

					}else{

						html += tmp_circle.substitute(item);

					}	

				})
 


				if(!init){

					$('delivery_circle_wrap').addClass('show hold');// 切换城市时,用户必须选择任意一个商圈进行跳转,否则弹出框不会消失

					

					/*document.addEvent('click',function(){

						if($('delivery_circle_wrap').hasClass('hold')){

							alert('还没有选择商圈')

						}

					})*/

				}
				$('circle_list').set('html',html)



			},

			

			changeCity:function(el){

				var self = this;

				var tar_region_id = el.get('data-region');

				$('hdl_delivery_area').getElement('.label').set('text',el.get('text'));

				$('delivery-area-main').removeClass('show');

				self.circleData.each(function(item){

					if(item.region_id==tar_region_id){

						self.fillCircle(item.circles);

					}

				})

			},

			changeCircle:function(el){

				window.location.href = el.get('data-url');

			},

			getRemoteCircleData:function(){	//从服务器获取商圈与地区的关联数据

				var self = this,

					remove_url = $('remote_circledata_url').value,

					hasData = false;

					new Request({

						url:remove_url,

						method:'get',

						async:false,

						onRequest:function(){



						},

						onSuccess:function(rsp){

							if(rsp){

								self.circleData = JSON.decode(rsp);

								hasData = true;

							}						

						},

						onFailure:function(){



						},

						onTimeout:function(){



						}

					}).send()



				return hasData;



			},
			lastCity:null,
			circleData:null

		},
		enbleMixSearch:function(){

			var tar = $('search-form');

			tar && tar.addEvents({
				'submit':function(e){
					e.stop();
				},
				'click:relay(.search_btn)':function(){
					$('val_search_type').value="circle";
					tar.submit();
				},
				'click:relay(.search-btn-sel)':function(){
					$('val_search_type').value="seller";
					tar.submit();
				}
			})

		}

		

}



window.addEvent('domready',function(){  

	theme_tools.initCategory();
 
	theme_tools.initMyZone();

	theme_tools.initSiteBar();

	theme_tools.circleSwitch.init();

	theme_tools.enbleMixSearch();

})