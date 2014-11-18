window.addEvent('domready',function(){













	//首页楼层 绑定切换事件

	var floors = $$('.floor');



	if(floors && floors.length>0){



		floors.each(function(item){



			var aFloor = item;

			var hdl_mark = item.getElements('.mark-item');



			//var con_ad = item.getElements('.floor-mark-img');

			//var hdl_ad = item.getElements('.floor-ad-hdl-item');



			var hdl_g = item.getElements('.swtich-hdl');

			var con_g = item.getElements('.switch-item');





			if(hdl_mark && hdl_mark.length>0){



				hdl_mark.addEvent('mouseenter',function(){



					this.addClass('cur').getSiblings('.mark-item').removeClass('cur');



				})

			}



/*			if(hdl_ad && hdl_ad.length>0){

				hdl_ad.addEvent('mouseenter',function(){

					var tmp_index = hdl_ad.indexOf(this);

					con_ad[tmp_index].setStyle('display','block').getSiblings('.floor-mark-img').setStyle('display','none');

					this.addClass('cur').getSiblings('.floor-ad-hdl-item').removeClass('cur');

				})

			}*/







			if(hdl_g && hdl_g.length >0){



				hdl_g.addEvent('mouseenter',function(){



					var tmp_index = hdl_g.indexOf(this);



					con_g[tmp_index].setStyle('display','block').getSiblings('.switch-item').setStyle('display','none');



					this.addClass('cur').getSiblings('.swtich-hdl').removeClass('cur');



				})



			}







		})



	}



	//首页品牌街

	var brand_street = $$('#brand-street li.item.brand');



	if(brand_street && brand_street.length>0){



		brand_street.each(function(item){



			var mask = item.getElement('a.mask');

			var img = item.getElement('.thumb img');



			img.set('tween', {

				duration:'150',

				transition: 'sine:in:out'

			});





			item.addEvents({

				'mouseenter':function(){



					img.tween('left','-5');



					this.addClass('show');



				},

				'mouseleave':function(){



					img.tween('left','0');

					this.removeClass('show');



				}



			});

		})



	}



















})