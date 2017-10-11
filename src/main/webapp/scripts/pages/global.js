/**
 * Created by Administrator on 2016/12/12.
 */
//加载公用头部 尾部
$('footer').load('../html/footer.html');
//$("header").load("../html/header.html");

$('.header-top').load('../html/header-top.html');
$('.mobileview').load('../html/mobileview.html');


$(function() {
    $('#navList').on('mouseenter', '.nav-item', function () {
        $('#navList .nav-item').removeClass('active');
        $('#subMenuWarp .sub-menu').stop().slideUp(500);
        $('.mobile-search').stop().slideUp(500);       
        var num=$(this).index()*1;
        if(num==6){
        	
        }else{
        	$(this).addClass('active');
        }
        if(num==6||num==2){
        	
        }else{
        	$('#subMenuWarp .sub-menu').eq($(this).index()).stop().slideDown(500);
        }
        
    });

	
    $('#subMenuWarp').on('mouseleave', function () {
    	
        $('#subMenuWarp .sub-menu').stop().slideUp(500);
    });

    $('#navList').on('mouseenter', '.nav-item-last', function () {
        $('.mobile-search').stop().slideDown(500);
    });

    $('#section5').on('mouseenter', '.section5-left', function () {
        $(this).find('.bg').stop().animate({opacity: 0}, 1000);
        $('#section5 .section5-right').find('.bg').stop().animate({opacity: 1}, 1000);
    });
    $('#section5').on('mouseleave', '.section5-left,.section5-right', function () {
        $(this).find('.bg').stop().animate({opacity: 1}, 1000);
    });
    $('#section5').on('mouseenter', '.section5-right', function () {
        $(this).find('.bg').stop().animate({opacity: 0}, 1000);
        $('#section5 .section5-left').find('.bg').stop().animate({opacity: 1}, 1000);
    });

    $('#section8').on('mouseenter', '.inner-txt', function () {
        $(this).addClass('active');
    });
    $('#section8').on('mouseleave', '.inner-txt', function () {
        $(this).removeClass('active');
    });

    $('#section9').on('mouseenter', '.news-box li', function () {
        $('#section9 .news-box li').removeClass('active');
        $(this).addClass('active');
    });
	
	$(function(){
		var i=0;
		$('#mobileBtn').on('click', function () {
			i++;
			if(i%2==0){
				$('#mobileWarp').find('.mobile-menu').stop().slideUp(500);
		        $('#mobileWarp').on('click', '.mobile-search-btn', function () {
		            $('#mobileWarp').find('.mobile-menu').stop().show();
		            $('#mobileWarp .mobile-search').stop().slideUp(500);
		        });
			}else{
				$('#mobileWarp').find('.mobile-menu').stop().slideDown(500);
		        $('#mobileWarp').on('click', '.mobile-search-btn', function () {
		            $('#mobileWarp').find('.mobile-menu').stop().hide();
		            $('#mobileWarp .mobile-search').stop().slideDown(500);
		        });
			}
        
    });
		
	})
    

//  $('#mobileWarp').on('mouseleave',function(){
//      $('#mobileWarp').find('.mobile-menu').stop().slideUp();
//  });

    $('.mobile-search').on('mouseleave', function () {
        $(this).stop().slideUp(500);
    });

    $('#section6 .img-list').on('mouseenter', 'li', function () {
        $(this).find('.img-list-txt').stop().animate({'opacity': 1}, 500);
    });
    $('#section6 .img-list').on('mouseleave', 'li', function () {
        $(this).find('.img-list-txt').stop().animate({'opacity': 0}, 500);
    });


    $('#partLinkGroup').on('mouseenter','.part-divide',function(){
        $('#partLinkGroup .part-divide').find('.bg').stop().animate({opacity: 1}, 1000);
        $(this).find('.bg').stop().animate({opacity: 0}, 1000);
        $(this).find('.part-link').addClass('active');
    });
    $('#partLinkGroup').on('mouseleave', '.part-divide', function () {
        $(this).find('.bg').stop().animate({opacity: 1}, 1000);
        $(this).find('.part-link').removeClass('active');
    });


    var index = 0;
    var mg = $("#brandList li");
    var txt = $('#txtList li');
    var len = mg.length;
    function play(n){
        mg.eq(n).find('.b-show').fadeOut(500).parents('li').siblings('li').find('.b-show').fadeIn(500);
        txt.removeClass('on');
        txt.eq(n).addClass('on');
    }
    setInterval(function(){
        mg.find('img').removeClass('on');
        play(index);
        index++;
        if(index==len){
            index=0;
        }
    },2000);

    $('#slideList .slide-inner').css('height',$('#slideList .img-list').height());

    var imgIndex = 0;
    var imgList =  $("#slideList .img-list");
    var length = imgList.length;
    function autoPlay(n){
        imgList.eq(n).fadeIn(500).siblings('li').fadeOut(500);
    }
    setInterval(function(){
        autoPlay(imgIndex);
        imgIndex++;
        if(imgIndex==length){
            imgIndex=0;
        }
    },2000);
});

//发送邮箱
$(function(){
	$('.order-now').on('click',function(){
		var emaliText = $('.inp-warp .inp').val();
		var reg= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(!reg.test(emaliText)){
			$('.inp-warp .inp').val("");
			$('.shade').css({'display':'block'});
			$('.point').css({'display':'block'});
			$('.point ul li').eq(0).css({'display':'block'}).siblings().css({'display':'none'});
			return false;
		}else{
			getEmail()
			function getEmail(){
			var  val={
				userMail:emaliText,
			};
			$.ajax({			
				type:"post",
				url:"http://www.transn.com:58080/global/userMailNotify",
				async:true,
				data:val,
				dataType:'jsonp', 
				jsonp:'jsonpcallback',
				success:function(data){
					console.log(data.state);
					switch (data.state){
					case "1":
					$('.shade').css({'display':'block'});
					$('.point').css({'display':'block'});
					$('.point ul li').eq(1).css({'display':'block'}).siblings().css({'display':'none'});
					$('.inp-warp .inp').val("");
						break;
						case "-1":
					$('.shade').css({'display':'block'});
					$('.point').css({'display':'block'});
					$('.point ul li').eq(2).css({'display':'block'}).siblings().css({'display':'none'});
					$('.inp-warp .inp').val("");
						break;
					default:
						break;
				}
				},
				error:function(data){
					console.log(data);
					return false;
				}
			});
			}
			
		}
	})
	
})

//点击确认按钮
$(function(){
	$('.shade-btn').on('click',function(){
		$('.section1-inner-right .inp-warp .inp').val("");
		$('.shade').css({'display':'none'});
		$('.point').css({'display':'none'});
	})
})




//判断页面在那个路径 下在 给相应的active
var src= window.location.href
var selectText=src.split("/")[3];
//console.log(src)
//console.log(selectText);
	switch(selectText){
		case "product":
		$('.nav-list li').eq(0).addClass('active');
		break;
		case "solutions":
		$('.nav-list li').eq(1).addClass('active');
		break;
		case "home":
		$('.nav-list li').eq(6).addClass('active');
		break;		
		case "about":
		$('.nav-list li').eq(3).addClass('active');
		break;
		case "contact-us":
		$('.nav-list li').eq(4).addClass('active');
		break;
		case "join-us":
		$('.nav-list li').eq(5).addClass('active');
		break;
	}

//自动获取nav高度
$(function(){
	var navHeight = $('.header').height();	
	$('.nav-box').height(navHeight);
	//屏幕宽度变化时
	window.onresize=function(){
		navHeight=0;
		var navHeight = $('.header').height();
		$('.nav-box').height(navHeight);
	}
})


myfunction($('.mybotton1'),$('.myipt-one'),$('.myipt-two'),$('.myipt-there'));
myfunction($('.mybotton2'),$('.myipt-one1'),$('.myipt-two2'),$('.myipt-there3'));

//封装一个函数
function myfunction(myarm,iptone,ipttwo,iptthere){
	$(function(){
	myarm.on('click',function(){
		var iptVal1 = iptone.val();
		var iptVal2 = ipttwo.val();
		var iptVal3 = iptthere.val();
		var myReg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var myReg1 = /^[0-9]*$/;

	if(iptVal1==''){
		iptone.attr({'placeholder':'Need not be empty'})
		$('.shade').css({'display':'block'});
		$('.point').css({'display':'block'});
		$('.point ul li').eq(1).css({'display':'block'}).siblings().css({'display':'none'});
		$('.foot-right-top p').html('Name cannot be empty');
		return false;
	}
	
	if(iptVal2==''){
		ipttwo.attr({'placeholder':'Need not be empty'})
		$('.shade').css({'display':'block'});
		$('.point').css({'display':'block'});
		$('.point ul li').eq(1).css({'display':'block'}).siblings().css({'display':'none'});
		$('.foot-right-top p').html('Phone can not be empty');		
		return false;
	}
	if(!myReg1.test(iptVal2)){
		ipttwo.attr({'placeholder':'Format error'})
		$('.shade').css({'display':'block'});
		$('.point').css({'display':'block'});
		$('.point ul li').eq(1).css({'display':'block'}).siblings().css({'display':'none'});
		$('.foot-right-top p').html('Phone format is not correct');
		return false;
	}
	
	if(!myReg.test(iptVal3)){
		iptthere.attr({'placeholder':'Format error'});
		$('.shade').css({'display':'block'});
		$('.point').css({'display':'block'});
		$('.point ul li').eq(1).css({'display':'block'}).siblings().css({'display':'none'});
		$('.foot-right-top p').html('Mailbox format is not correct');
		return false;
	}
	
	$.ajax({
    // url: "/global/UserInfoSend/priceQuoteUser",
    type: "POST",
    url: "http://www.transn.com:58080/global/UserInfoSend",
    dataType:'jsonp',
    jsonp:'jsonpcallback',
    data: {
      "username": iptVal1,
      "phone": iptVal2,
      "email": iptVal3
    },
    success: function (data) {
      console.log(data);
      window.location.href="contact-us/free-translation-quote.html";
    }
  });
	})
})
}
