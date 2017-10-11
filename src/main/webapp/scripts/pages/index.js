$(function() {
    //注册页面的打勾选项--用户是否接收消息推送的选项
    $('.form-box').find('.slt-warp').each(function(){
        $(this).on('click','input,lable',function(){
            if($(this).parents('.slt-warp').find('input').is(':checked')){
                $(this).parents('.slt-warp').find('.chk').addClass('chked');
            }else{
                $(this).parents('.slt-warp').find('.chk').removeClass('chked');
            }
        });
    });

    //左边单选框
    $('.form-box-new').find('.slt-warp-new').each(function(){
        $(this).on('click','input,lable',function(){
            if($(this).parents('.slt-warp-new').find('input').is(':checked')){
                $(this).parents('.slt-warp-new').find('.chk-new').addClass('chked');
                $(this).parent().parent().parent().parent().siblings('tr').find(".chk-new").removeClass('chked')
            }else{
                $(this).parents('.slt-warp-new').find('.chk-new').removeClass('chked');
            }
            //算哈价格
            caculatePrice();
            updateOrderInfo();
        });
    });

    //右边多选框
    $('.form-box-new-right').find('.slt-warp-new-right').each(function(){
        $(this).on('click','input,lable',function(){
            if($(this).parents('.slt-warp-new-right').find('input').is(':checked')){
                $(this).parents('.slt-warp-new-right').find('.chk-new-right').addClass('chked');
            }else{
                $(this).parents('.slt-warp-new-right').find('.chk-new-right').removeClass('chked');
            }
            //算哈价格
            caculatePrice();
            updateOrderInfo();
        });
    });

    //注册--弹框
    $('#formLogin').on('click','.sign',function(){
        $('#formLogin').hide();
        $('#formSign').fadeIn();
    });

    $('#formSign').on('click','.sign',function(){
        $('#formSign').hide();
        $('#formLogin').fadeIn();
    });

    //注册
    $('#formSign').on('click','.form-btn',function(){
        var email = $('#formSign .email').val();
        var psw1 = $('#formSign .psw1').val();
        var psw2 = $('#formSign .psw2').val();
        //用户是否勾选接收公司的活动信息
        var isReceiveInfo = $(".chk-warp span").attr("class");
        if("chk chked" == $(".chk-warp span").attr("class")) {
            isReceiveInfo = 1;
        }else if("chk" == $(".chk-warp span").attr("class")) {
            isReceiveInfo = 0;
        }

        var isValidate = true;
        if (email.length == 0) {
            isValidate = false;
            $('.inp-warp .error').html('');
            $('#formSign .email').siblings('.error').css('visibility',' visible').html('Please enter your e-mail');
            return false;
        } else {
            if (!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(email)) {
                isValidate = false;
                $('#formSign .email').siblings('.error').css('visibility',' visible').html('Please enter the correct E-mail address');
                return false;
            }
        }

        if (psw1.length == 0) {
            isValidate = false;
            $('.inp-warp .error').html('');
            $('#formSign').find('.psw-error1').css('visibility',' visible').html('Please enter a password');
            $('.form-box .slt-warp1').css({'margin-top':'40px'});
            return false;
        }else {
            if (!/\w{8,}/.test(psw1)) {
                isValidate = false;
                $('.inp-warp .error').html('');
                $('#formSign').find('.psw-error').css('visibility',' visible').html("The password can only contain English characters，numbers and underscores (_) of free combination but the minimum length should be 8 characters");
                $('.form-box .slt-warp1').css({'margin-top':'60px'});
            }
        }

        if (psw2.length == 0) {
            isValidate = false;
            $('.inp-warp .error').html('');
            $('#formSign').find('.psw-error').css('visibility',' visible').html('Please enter a password');
            $('.form-box .slt-warp1').css({'margin-top':'40px'});
        } else {
            if (psw2 != psw1) {
                isValidate = false;
                $('.inp-warp .error').html('');
                $('#formSign').find('.psw-error').css('visibility',' visible').html('Confirm password must match with previous entry');
                $('.form-box .slt-warp1').css({'margin-top':'40px'});
            }
        }

        if(!isValidate){
            return;
        }

        //前端校验无误的情况下
        $.ajax({
            type: "POST",
            url: "/register",
            dataType: "json",
            data: {
                "regisEmail": email,
                "regisPsw": psw1,
                "regisPsw2": psw2,
                "isReceiveInfo": isReceiveInfo
            },
            success: function (data) {
                if(1 == data) {
                    alertConfirm("Sign up successfully!", function() {
                        window.location.href="/index";
                    })
                }else if(0 == data) {
                    $('#formSign .email').siblings('.error').css('visibility',' visible').html('This email has been registered');
                }else if(-1 == data) {
                    $('#formSign .email').siblings('.error').css('visibility',' visible').html('Please enter the correct E-mail address');
                }else if(-2 == data) {
                    $('#formSign').find('.psw-error').css('visibility',' visible').html("The password can only contain English characters，" +
                        "numbers and underscores (_) of free combination but the minimum length should be 8 characters");
                }
            },
            error: function (e) { //服务器响应失败处理函数
                console.log(e);
            }
        });
    });

    //忘记密码--弹窗展示
    $('.mask-box').css('marginTop', -($('.mask-box').height()) / 2);
    $('#formLogin,#formSign').on('click', '.forget', function () {
        $('.mask-bg').show();
        $('#forget').fadeIn();
    });

    //忘记密码-弹窗关闭
    $("#forget .close").on("click", function() {
        $('.mask-bg').hide();
        $('#forget').fadeOut();
    });

    //忘记密码--提交
    $(".inp-email-warp .btn").on("click", function() {
        forgetpassword();
    });

    //使用点击enter忘记密码
    $(document).on('keydown', function(e){
        e = e || window.event;
        if(e.keyCode == 13){
            forgetpassword();
        }
    })

    function forgetpassword(){
        var email = $("#email").val();
        var captchaStr = $("#captchaStr").val();
        var psw = $("#psw").val();
        var psw2 = $("#psw2").val();

        if($.string.isNullOrEmpty(email)){
            $('.error').css('visibility','hidden');
            $("#email").next('span').css('visibility',' visible').html('Please enter your e-mail');
            return false;
        }
        if (!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(email)) {
            $('.error').css('visibility','hidden');
            $("#email").next('span').css('visibility','visible').html('Please enter your correct email');
            return false;
        }
        if($.string.isNullOrEmpty(captchaStr)){
            $('.error').css('visibility','hidden');
            $("#captchaStr").next().next('span').css('visibility','visible').html('Please enter the verification code');
            return false;
        }
        if($.string.isNullOrEmpty(psw)) {
            $('.error').css('visibility','hidden');
            $("#psw").next('span').css('visibility','visible').html('Please enter the password');
            return false;
        }
        if(!/\w{8,}/.test(psw)) {
            $('.error').css('visibility','hidden');
            $("#psw").next('span').css('visibility','visible').html('The password can only contain English characters，numbers and underscores(_) of free combination but the minimum length should be 8 characters');
            return false;
        }
        if(psw != psw2){
            $('.error').css('visibility','hidden');
            $("#psw").next('span').css('visibility','visible').html('Confirm password must match with previous entry');
            return false;
        }else{
            $('.error').css('visibility','hidden');
        }

        if(!$.string.isNullOrEmpty(email) && !$.string.isNullOrEmpty(captchaStr)
            && !$.string.isNullOrEmpty(psw) && !$.string.isNullOrEmpty(psw2) && psw == psw2) {
            $.ajax({
                type: "POST",
                url: "/submitInfo",
                dataType: "json",
                data: {
                    "email" : email,
                    "captchaStr" : captchaStr,
                    "psw" : psw,
                    "psw2" : psw2
                },
                success: function (data) {
                    if(1 == data) {
                        alertConfirm("Modify password successfully!", function() {
                            window.location.href="/index";
                        })
                    }else if(0 == data) {
                        alertInfo("Update password failed");
                    }else if(-1 == data) {
                        $("#captchaStr").next().next('span').css('visibility','visible').html('Wrong verification code');
                    }else if(-2 == data) {
                        $("#email").next('span').css('visibility',' visible').html('邮箱不存在，请注册');
                    }
                },
                error: function (e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });
        }
    }

    //点击验证码图片--更换验证码
    $('#captchaImage').click(function() {
        $('#captchaImage').attr("src", "captcha?timestamp=" + (new Date()).valueOf());
    });

    //标签切换
    $('#main .title-list').on('click','li',function(){
        $('#main .title-list li').removeClass('on');
        $('#main .main-list').hide();

        $(this).addClass('on');
        $('#main .main-list').eq($(this).index()).show();
    });
    var second = 60;
    //发送验证码到邮箱
    $("#btn-code").on("click", function() {
        var email = $("#email").val();
        var timer = null;
        if($.string.isNullOrEmpty(email)) {
            //alertInfo("请输入邮箱");
            alertInfo("Please enter your email address.");
            return false;
        }
        $('#btn-code').html("Send verification code");
        $('.mask-ipt').show();
        $('.mask-ipt').show();
        timer=setInterval(function(){
            second--;
            $('#loaderGif span').html(second)
            if(second==0){
                clearInterval(timer);
                $('.mask-ipt').hide();
                second=60;
                $('#btn-code').html("Resend verification code");
            }
        },1000)
        //$('.mask-bg').show();
        $("#loaderGif").show();

        $.ajax({
            type: "POST",
            url: "/captcha",
            dataType: "json",
            async: false,
            success: function(data) {
                alertInfo(data);
            },
            error: function(e) { //服务器响应失败处理函数
                console.log(e);
            }
        });

        $.ajax({
            type: "POST",
            url: "/sendCaptchaStr",
            dataType: "json",
            data: {
                "email": email
            },
            success: function(data) {
                if(1 == data) {
                    //alertInfo("发送验证码成功");
                    //$("#loaderGif").hide();
                    alertInfo("Verification code has been sent to your <br/>email. ");
                }
            },
            error: function(e) { //服务器响应失败处理函数
                console.log(e);
            }
        });
    });
});


//进度条
$(function(){
	$('.progressbar').on('click',function(){
		clearInterval(timer);
		var timer = null;
		var i = 0;
		timer=setInterval(function(){			
			i+=1;
			$('.progressbarNew').width(i);
			var allLength = $('.progressbar').width();
			var nowLength = $('.progressbarNew').width();			
			var myNum = ((nowLength/allLength)*100).toFixed(2)+"%";
			$('.myNumNow').html(myNum);
			$('.progressbar span').css({"left":i})
		},50)
		
		
	})
})


$(function(){
	//鼠标放上效果
	$('.myp2-middle-right-main h5 img').on('mouseenter',function(){
		$('.appearMessage').fadeIn(1000);
	})
	//鼠标移开
	$('.myp2-middle-right-main h5 img').on('mouseleave',function(){
		$('.appearMessage').fadeOut(1000);
	})
	
	//获取高度
	var orderLeftHeight = $('.myPart2-order-left').height();
//	console.log(orderLeftHeight);
	$('.myPart2-order-right').height(orderLeftHeight);
	
//	判断定位
	var wantHeight = $('.myPart2-order-left').offset().top;
//	console.log(wantHeight)
//	$(document).scroll(function(){		
//		//var thistTop=$(".Frist-img p").offset().top
//		if($(document).scrollTop()>=wantHeight){
//			$('.myPart2-order-right-main').show();
//		}else{
//			$('.myPart2-order-right-main').hide();
//		}
//	}) 

    //点击上传文件出现弹框
	$('.p2-top-btn-left a').on('click',function(){
	    if(!isLogin()) {
            alertInfo("Please login first.");
            focusElement("loginName");
        }else {
            $('.upload-text').fadeIn(1000)
            $('.mask-bg').css({'display':"block"})
            uploadFile();
        }
	})
	
	$('.upload-text-textBox .close').on('click',function(){
        closePop();
	})
	
    //点击添加URL出现弹框
	$('.p2-top-btn-right a').on('click',function(){
        if(!isLogin()) {
            alertInfo("Please login first.");
            focusElement("loginName");
        }else {
            $('.url-text').fadeIn(1000);
            $('.mask-bg').css({'display':"block"});
        }
	})
	
	$('.url-text-textBox .close').on('click',function(){
		$('.url-text').fadeOut(0)
		$('.mask-bg').css({'display':"none"})	
	})
})

//关闭上传文件弹框--效果实现
function closePop() {
    $('.upload-text').fadeOut(0);
    $('.mask-bg').css({'display':"none"});
}

var orderNo = null;
var timer = null;
//创建一个数组用于存储已上传文件的文件名
var fileNameArray = new Array();
var duplicateFileNameFlag = 0;
//上传文件
function uploadFile() {
    /*init webuploader*/
    var $list=$("#thelist");   //这几个初始化全局的百度文档上没说明，好蛋疼。
    var $filelistTable = $('#fileListTable'); //文件table
    var $btn =$("#ctlBtn");   //开始上传
    var state = 'pending';
    var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档
    var thumbnailHeight = 100;

    var uploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,

        // swf文件路径
        swf: '/jslib/Uploader.swf',

        // 文件接收服务端。
        server: '/file/uploadFile',

        // 参数
        formData: {
            orderNo: '',
        },

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker',
        fileSingleSizeLimit: 500*1024*1024,

        // 只允许选择图片文件。
        // accept: {
        //     title: 'Images',
        //     extensions: 'gif,jpg,jpeg,bmp,png',
        //     mimeTypes: 'image/*'
        // },
        method:'POST',
        duplicate: false
    });
    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {  // webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。
        if(!timer){
            timer = window.setTimeout(function () {
                $btn.trigger('click');
            }, 500);
        }

        var $li = $(
                '<div class="file-item thumbnail">' +
                '<img>' +
                '<div class="info">' + file.name + '</div>' +
                '</div>'
            ),
            $img = $li.find('img');


        // $list为容器jQuery实例
        $list.append( $li );

        if(fileNameArray.length > 0) {
            //判断是否上传同名文件
            for(var i = 0; i < fileNameArray.length; i++) {
                if(fileNameArray[i] == file.name) {
                    alertInfo("Please do not upload files with <br/>identical file name.");
                    duplicateFileNameFlag = 1;
                }
            }
        }

        if(fileNameArray.length == 0 || duplicateFileNameFlag == 0) {
            //添加文件到table
            $filelistTable.find('tbody').append(
                '<tr id ="' + file.id + '">' +
                '<td>' +
                '<div class="fileTextName clearfix">' +
                '<div class="fileTextName-left"><span>●</span><span>' + file.name + '</span><span>' +
                '<a onclick="deleteFile(this)"><img src="/images/myorder/images/close1.png"/></a></span></div>' +
                '<div class="fileTextName-right"><span><span id="fileSize">(?</span><span>mb</span>)</span><span class="lastMart"></span></div>' +
                '</div>' +
                '<p class="clickhere" onclick="showMsgBox(this)">(Click here to add more instructions)</p>' +
                '<div class="myIptBox" style="display: none">' +
                '<div class="myIptBox-main clearfix">' +
                '<input type="text" placeholder="Enter instructions" />' +
                '<span ><a onclick="submitMsg(this)">OK</a></span>' +
                '</div></div>' +
                '<div class="progress-bar-box">' +
                '</div>' +
                '</td>' +
                '</tr>'
            );
            fileNameArray.push(file.name);
            // 添加“文件大小值”
            $( '#'+file.id ).find('#fileSize').html('(' + parseInt(parseInt(file.size) / (1024 * 1024)));
        }

        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader.makeThumb( file, function( error, src ) {   //webuploader方法
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, thumbnailWidth, thumbnailHeight );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress-bar-box .progressbar');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<p class="myNumNow"></p>' +
                '<div class="progressbar">' +
                '<span><em></em></span><div class="progressbarNew"></div></div>').appendTo($li.find('.progress-bar-box')).find('.progressbar');
        }

        // 进度条-效果
        $percent.find('span').css('left',  percentage * 100 + '%');
        $percent.find('.progressbarNew').css('width',  percentage * 100 + '%');
        //进度条-百分数
        $li.find('.progress-bar-box .myNumNow').html(parseInt(percentage * 100) + '%');
    });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on( 'uploadSuccess', function( file, data ) {
        console.log(data);

        var $li = $( '#'+file.id );
        if(data == -1) {
            alertInfo("Please upload files with the right format.");
            $( '#'+file.id ).remove();
        }else if(data == -3) {
            // $( '#'+file.id ).remove();
            // alertInfo("Please do not upload files with <br/>identical file name.");
        }else if(data == -4) {
            $('.mask-bg').css({'display':"block"});
            $('.url-news').fadeIn(500);

            $("#okBtn").on("click", function() {
                var fileLength = $(".url-news .myIptnew").val();
                if(!$.string.isNullOrEmpty(fileLength)) {
                    getOrderIdByOrderNo();
                    var orderId = $("#orderId").val();//密文
                    var fileName = file.name;
                    $.ajax({
                        type: "POST",
                        url: "/file/submitFileLength",
                        dataType: "json",
                        async: false,
                        data: {
                            "orderId": orderId,
                            "fileName": fileName,
                            "fileLength": fileLength
                        },
                        success: function (data) {
                            if(data > 0) {
                                $('.mask-bg').css({'display':"none"});
                                $('.url-news').fadeOut();
                                alertInfo("upload file length successfully.")
                                //添加“completed”和“文件播放时长”
                                $( '#'+file.id ).find('.lastMart').html('completed');
                                $( '#'+file.id ).append('<td>' + data + '</td>');
                                $( '#'+file.id ).append('<td><span>$</span><span>0.00</span></td>');
                                $( '#'+file.id ).addClass('upload-state-done');

                                //传了文件后，算哈价格
                                caculatePrice();
                                //传了文件后，算哈视频长度
                                calculateTotalFileLength();
                                //算了价格后，将单个文件价格传到后台
                                var fileName = file.name;
                                var filePrice = $( '#'+file.id ).find("td:eq(2) span:eq(1)").html();
                                updateFilePrice(fileName, filePrice);
                                updateOrderInfo();
                            }
                        },
                        error: function (e) { //服务器响应失败处理函数
                            console.log(e);
                        }
                    });
                }
            });
        }else {
            getOrderIdByOrderNo();
            //添加“completed”和“文件播放时长”
            $( '#'+file.id ).find('.lastMart').html('completed');
            $( '#'+file.id ).append('<td>' + data + '</td>');
            $( '#'+file.id ).append('<td><span>$</span><span>0.00</span></td>');
            $( '#'+file.id ).addClass('upload-state-done');

            //传了文件后，算哈价格
            caculatePrice();
            //传了文件后，算哈视频长度
            calculateTotalFileLength();
            //算了价格后，将单个文件价格传到后台
            var fileName = file.name;
            var filePrice = $( '#'+file.id ).find("td:eq(2) span:eq(1)").html();
            updateFilePrice(fileName, filePrice);
            updateOrderInfo();
        }
    });

    // 文件上传失败，显示上传出错。
    uploader.on( 'uploadError', function( file ) {
        var $li = $( '#'+file.id ),
            $error = $li.find('div.error');

        // 避免重复创建
        if ( !$error.length ) {
            $error = $('<div class="error"></div>').appendTo( $li );
        }

        $error.text('上传失败');
        alertInfo("Please upload file with size less than 500M.");
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    uploader.on( 'uploadComplete', function( file ) {
        //$( '#'+file.id ).find('.progress').remove();
    });

    $btn.on( 'click', function() {
        if ( state === 'uploading' ) {
            uploader.stop();
        }else {
            console.log("上传...");
            if($.string.isNullOrEmpty($("#orderNo").val())) {
                $("#orderNo").val(encryptedStr(generateOrderNo()));
                orderNo = $("#orderNo").val();
            }else {
                orderNo = $("#orderNo").val();
            }
            uploader.options.formData.orderNo = orderNo;
            timer = null;
            uploader.upload();
            console.log("上传成功");
        }
        //关闭弹框
        closePop();
    });
};

/**
 * 生成订单编号
 * @returns {String}
 */
function generateOrderNo() {
    return "MD" + new Date().Format("yyyyMMddhhmmssSSS") + Math.floor(Math.random()*9000000+999999);
}

//打开文件下的文本框
var flag = 0;
function showMsgBox(data) {
    if(flag == 0) {
        $(data).parents('tr').find('.myIptBox').show();
        flag = 1;
    }else if(flag == 1) {
        $(data).parents('tr').find('.myIptBox').hide();
        flag = 0;
    }
}

//提交文本框内容
function submitMsg(data) {
    var fileName = $(data).parents('tr').find('.fileTextName-left span:eq(1)').html();
    var instructions = $(data).parents('.myIptBox-main').find('input').val();
    var orderId = $("#orderId").val();//密文

    function closeMsgInput() {
        $(data).parents('tr').find('.myIptBox').hide();
    }
    function addEditBox() {
        $(data).parents('tr').find('td:eq(0) .fileTextName.clearfix').after(
            '<div class="myEdit clearfix">' +
            '<span class="myEdit-name">' + instructions + '</span><span class="myEdit-now"><a onclick="showMsgInput()">Edit</a></span>' +
            '</div>');
    }

    function showMsgInput() {
        $(data).parents('tr').find('.myIptBox').show();
    }

    $('.myp2-table tbody').on('click','.myEdit-now a',function(){
        showMsgInput();
        $(data).parents('tr').find(".myEdit.clearfix").hide();
    })

    $.ajax({
        type: "POST",
        url: "/file/submitFileInstructions",
        dataType: "json",
        data: {
            "orderId": orderId,
            "fileName": fileName,
            "instructions": instructions
        },
        success: function (data) {
            if(data == 1) {
                alertInfo("submit success", function() {
                    layer.closeAll('dialog');
                    closeMsgInput();
                    addEditBox();
                });
            }else if(data == -1) {
                alertInfo("submit fail");
            }
        },
        error: function (e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
};

//为价格选择框的两个table设置默认服务选项
$(function() {
    $(".form-box-new .formTable tr").each(function() {
        if($(this).find("td:eq(1)").html().trim() == "Budget (A flexible deadline)") {
            $(this).find('.chk-new').addClass("chked")
        }
    });

    $(".form-box-new-right .formTable tr").each(function() {
        if($(this).find("td:eq(1)").html().trim() == "Caption as .doc file") {
            $(this).find('.chk-new-right').addClass("chked")
        }
    });
})

/**
 * 计算价格
 * 说明：计算单个文件的价格和总价，将结果值写到页面
 */
function caculatePrice() {
    var priceRate = 0;
    $(".form-box-new .formTable tr").each(function() {
        if($(this).find('.chk-new').hasClass("chked")) {
            priceRate = priceRate + Number($(this).find("td:eq(2) span").html());
            var turnaroundTimeFlag = $(this).find('input').val();
            getDeliveryDate(turnaroundTimeFlag);
        }
    });

    $(".form-box-new-right .formTable tr").each(function() {
        if($(this).find('.chk-new-right').hasClass("chked")) {
            priceRate = priceRate + Number($(this).find("td:eq(2) span").html());
        }
    });

    var totalPrice = 0;
    $("#fileListTable tbody tr").each(function() {
        var singleFilePrice = (Number($(this).find("td:eq(1)").html().split("m")[0]) * Number(priceRate)).toFixed(2);
        totalPrice = Number(totalPrice) + Number(singleFilePrice);
        totalPrice = Number(totalPrice).toFixed(2);
        //写入单个文件的价格
        $(this).find("td:eq(2) span:eq(1)").html(singleFilePrice);
    });
    //在ORDER SUMMARY中写入订单总价
    $("#totalPrice").html(totalPrice);
    //在文件列表下的汇总栏中写入订单总价
    $(".myFoottr2 td:eq(2) span").html(totalPrice);
}

/**
 * 计算所有上传文件的播放时长汇总
 * 说明：汇总结果写到汇总栏和ORDER SUMMARY中
 */
function calculateTotalFileLength() {
    var totalLength = 0;
    //文件个数
    var fileNums = 0;
    $("#fileListTable tbody tr").each(function() {
        var singleFileLength = (Number($(this).find("td:eq(1)").html().split("m")[0]));
        totalLength = Number(totalLength) + Number(singleFileLength);
        fileNums = fileNums + 1;
    });
    $(".myFoottr2 td:eq(1)").html(totalLength + "m");
    $("#orderSummaryTable tbody tr td:eq(1) span:eq(1)").html(totalLength);
    //文件总个数写入ORDER SUMMARY
    $("#orderSummaryTable tbody tr td:eq(1) span:eq(0)").html(fileNums);
}

/**
 * 根据生成的orderNo从后台获取orderId值，回写到页面
 */
function getOrderIdByOrderNo() {
    //回填orderId到页面隐藏域
    $.ajax({
        type: "POST",
        url: "/order/getOrderIdByOrderNo",
        dataType: "json",
        async: false,
        data: {
            "orderNo" : orderNo
        },
        success: function (data) {
            if(data != -1) {
                $("#orderId").val(encryptedStr(data));
            }
        },
        error: function (e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
}

/**
 * 提交单个文件的价格到后台
 */
function updateFilePrice(fileName, filePrice) {
    var orderId = $("#orderId").val();
    $.ajax({
        type: "POST",
        url: "/order/updateFilePrice",
        dataType: "json",
        data: {
            "orderId": orderId,
            "fileName": fileName,
            "filePrice": filePrice
        },
        success: function (data) {
            console.log(data);
        },
        error: function (e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
}

/**
 * 提交url
 */
function submitUrl() {

    var url = $(".url-input textarea").val();
    var length = $(".url-input input").val();
    if(fileNameArray.length > 0) {
        //判断是否上传同名文件
        for(var i = 0; i < fileNameArray.length; i++) {
            if(fileNameArray[i] == url) {
                alertInfo("Please do not upload files with <br/>identical file name.");
                duplicateFileNameFlag = 1;
            }
        }
    }

    if(fileNameArray.length == 0 || duplicateFileNameFlag == 0) {
        $("#fileListTable").find('tbody').append(
            '<tr id ="' + url + '">' +
            '<td>' +
            '<div class="fileTextName clearfix">' +
            '<div class="fileTextName-left"><span>●</span><span>' + url + '</span><span>' +
            '<a onclick="deleteFile(this)"><img src="/images/myorder/images/close1.png"/></a></span></div>' +
            '<div class="fileTextName-right"><span class="lastMart">completed</span></div>' +
            '</div>' +
            '<p class="clickhere" onclick="showMsgBox(this)">(Click here to add more instructions)</p>' +
            '<div class="myIptBox" style="display: none">' +
            '<div class="myIptBox-main clearfix">' +
            '<input type="text" placeholder="Enter instructions" />' +
            '<span ><a onclick="submitMsg(this)">OK</a></span>' +
            '</div></div>' +
            '<div class="progress-bar-box">' +
            '</div>' +
            '</td>' +
            '<td>' + length + 'm</td>' +
            '<td><span>$</span><span>0.00</span></td>' +
            '</tr>'
        );
        caculatePrice();
        fileNameArray.push(url);

        //生成orderNo并且回写orderId
        if($.string.isNullOrEmpty($("#orderNo").val())) {
            $("#orderNo").val(encryptedStr(generateOrderNo()));
            var orderNo = $("#orderNo").val();

            $.ajax({
                type: "POST",
                url: "/file/submitUrlNewOrder",
                async: false,
                dataType: "json",
                data: {
                    "orderNo": orderNo,
                    "url": url,
                    "length": length
                },
                success: function (data) {
                    if(data != -1) {
                        $("#orderId").val(encryptedStr(data));
                        $('.url-text').fadeOut(0)
                        $('.mask-bg').css({'display':"none"})
                    }else {
                        alertInfo("submit fail");
                    }
                },
                error: function (e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });
        }else {
            var orderNo = $("#orderNo").val();
            $.ajax({
                type: "POST",
                url: "/file/submitUrl",
                dataType: "json",
                async: false,
                data: {
                    "orderNo": orderNo,
                    "url": url,
                    "length": length
                },
                success: function (data) {
                    if(data != -1) {
                        console.log("submit url success");
                        $('.url-text').fadeOut(0)
                        $('.mask-bg').css({'display':"none"})
                    }else {
                        alertInfo("submit fail");
                    }
                },
                error: function (e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });
        }

        calculateTotalFileLength();
        //算了价格后，将单个文件价格传到后台
        var fileName = url;
        var filePrice = $( '#'+fileName ).find("td:eq(2) span:eq(1)").html();
        updateFilePrice(fileName, filePrice);
        updateOrderInfo();
    }
}

function isLogin() {
    var loginFlag = $("#z_user .z_login span").html();
    if($.string.isNullOrEmpty(loginFlag)) {
        return false;
    }else {
        return true;
    }
}

$(function() {
    /**
     * 提交优惠码
     */
    $("#submitPromoCodeBtn").on("click", function() {
        var promoCode = $("#promoCodeInput").val();
        var orderId = $("#orderId").val();//密文
        var price = Number($("#totalPrice").html());
        if(!$.string.isNullOrEmpty(price) && price != 0.00) {
            $.ajax({
                type: "POST",
                url: "/order/calculatePriceByPromoCode",
                dataType: "json",
                data: {
                    "orderId": orderId,
                    "price": price,
                    "promoCode": promoCode
                },
                success: function (data) {
                    console.log(data);
                    if(-1 == data) {
                        alertInfo("Invalid promo code!");
                    }else {
                        console.log(data);
                        $(".myIptBox-main-1").hide();
                        $(".PromoCode").hide();
                        alertInfo("Thanks for using promo code!");
                        // $("#totalPrice").css("text-decoration", "line-through");
                        // $(".hasred").append(" " + Number(data).toFixed(2));
                        $("#totalPrice").html(Number(data).toFixed(2));
                    }
                },
                error: function (e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });
        }else {
            alertInfo("Please upload file or add URL first.");
        }
    });
});

/**
 * 删除文件
 * @param data
 */
function deleteFile(data) {
    $(data).parents("tr").remove();
    caculatePrice();
    calculateTotalFileLength();
    var orderId = $("#orderId").val();
    var fileName = $(data).parents('tr').find('.fileTextName-left span:eq(1)').html();
    $.ajax({
        type: "POST",
        url: "/file/deleteFile",
        dataType: "json",
        data: {
            "orderId": orderId,
            "fileName": fileName
        },
        success: function (data) {
            if(data == 1) {
                alertInfo("Delete successfully.");
                deleteValueFromArray(fileNameArray, fileName);
                updateOrderInfo();
            }
        },
        error: function (e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
}

//获取当前时间
// $(function(){
//     var myDate = new Date();
//     var myYear = myDate.getFullYear();
//     var myMoth = (myDate.getMonth())*1+1;
//     var myDay = myDate.getDate();
//     var myDayNow = myYear +"-"+myMoth+"-"+myDay;
//     $('.needline td').eq(1).html(myDayNow);
// })


/**
 * 预览详情
 * @param orderId
 */
function viewFullQuote(orderNo){
	if(!isLogin()) {
	     alertInfo("Please login first.");
	 } else {
		 var fileNums = $("#orderSummaryTable tbody tr td:eq(1) span:eq(0)").html();
		 if(fileNums <= 0){
			 alertInfo("Please upload file or add URL first.");
		 } else {
			 var turnaroundTime = "";
	         var deliveryDate = $(".needline td:eq(1)").html();
	         $(".form-box-new .formTable tr").each(function() {
	        	 if($(this).find('.chk-new').hasClass("chked")) {
	        		 turnaroundTime = $(this).find('input').val();
	        	 }
	         });
	         var otherServices = "";
             $(".form-box-new-right .formTable tr").each(function() {
                if($(this).find('.chk-new-right').hasClass("chked")) {
                    otherServices = otherServices + $(this).find('input').val() + ",";
                }
             });
             otherServices = otherServices.substr(0, otherServices.length - 1);
             
			 $("#orderNoVFQF").val($("#orderNo").val());
			 $("#turnaroundTimeVFQF").val(turnaroundTime);
			 $("#otherServicesVFQF").val(otherServices);
			 $("#deliveryDateVFQF").val(deliveryDate);
			 $("#remarkVFQF").val($("#remarks").val());
			 $("#priceVFQF").val($("#totalPrice").html());
			
			 $("#viewFullQuoteForm").submit();
			 layer.closeAll();
		 }
	 }
}

$(function() {
    //支付
    $("#payBtn").on("click", function() {
        var fileNums = $("#orderSummaryTable tbody tr td:eq(1) span:eq(0)").html();

        if(fileNums <= 0){
            alertInfo("Please upload file or add URL first.");
        } else {
            var orderId = $("#orderId").val();
            var totolPrice = $("#totalPrice").html();
            var filesCount = fileNums;
            var turnaroundTimeFlag = "";
            var otherServicesFlag = "";
            var remarks = $("#remarks").val();
            var deliveryDate = $(".needline td:eq(1)").html();

            $(".form-box-new .formTable tr").each(function() {
                if($(this).find('.chk-new').hasClass("chked")) {
                    turnaroundTimeFlag = $(this).find('input').val();
                }
            });

            $(".form-box-new-right .formTable tr").each(function() {
                if($(this).find('.chk-new-right').hasClass("chked")) {
                    otherServicesFlag = otherServicesFlag + $(this).find('input').val() + ",";
                }
            });
            otherServicesFlag = otherServicesFlag.substr(0, otherServicesFlag.length - 1);

            $.ajax({
                type: "POST",
                url: "/placeOrder/handleOrderInfo",
                dataType: "json",
                //async: false,
                data: {
                    "orderId": orderId, //订单id：orderid
                    "totolPrice": totolPrice,
                    "filesCount": filesCount,
                    "turnaroundTimeFlag": turnaroundTimeFlag,
                    "otherServicesFlag": otherServicesFlag,
                    "deliveryDate": deliveryDate,
                    "remarks": remarks
                },
                success: function(data) {
                    console.log(data);
                    if(1 == data) {
                        //新开支付页面
                        //window.open("/order/gotoPaypal?orderid=" + orderid);
                        $("#payForm").submit();
                    }
                },
                error: function(e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });
        }
    });
});

/**
 * 实时更新订单信息
 */
function updateOrderInfo() {
    var fileNums = $("#orderSummaryTable tbody tr td:eq(1) span:eq(0)").html();

    var orderId = $("#orderId").val();
    var totolPrice = $("#totalPrice").html();
    var filesCount = fileNums;
    var turnaroundTimeFlag = "";
    var otherServicesFlag = "";
    var remarks = $("#remarks").val();
    var deliveryDate = $(".needline td:eq(1)").html();

    $(".form-box-new .formTable tr").each(function() {
        if($(this).find('.chk-new').hasClass("chked")) {
            turnaroundTimeFlag = $(this).find('input').val();
        }
    });

    $(".form-box-new-right .formTable tr").each(function() {
        if($(this).find('.chk-new-right').hasClass("chked")) {
            otherServicesFlag = otherServicesFlag + $(this).find('input').val() + ",";
        }
    });
    otherServicesFlag = otherServicesFlag.substr(0, otherServicesFlag.length - 1);

    $.ajax({
        type: "POST",
        url: "/placeOrder/handleOrderInfo",
        dataType: "json",
        //async: false,
        data: {
            "orderId": orderId, //订单id：orderid
            "totolPrice": totolPrice,
            "filesCount": filesCount,
            "turnaroundTimeFlag": turnaroundTimeFlag,
            "otherServicesFlag": otherServicesFlag,
            "deliveryDate": deliveryDate,
            "remarks": remarks
        },
        success: function(data) {
            console.log(data);
        },
        error: function(e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
}

function getDeliveryDate(turnaroundTimeFlag) {
    var orderId = $("#orderId").val();
    $.ajax({
        type: "POST",
        url: "/order/getDeliveryDate",
        dataType: "json",
        data: {
            "turnaroundTimeFlag": turnaroundTimeFlag
        },
        success: function (data) {
            if(-1 != data) {
                $(".needline td:eq(1)").html(data);
            }
        },
        error: function (e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
}



