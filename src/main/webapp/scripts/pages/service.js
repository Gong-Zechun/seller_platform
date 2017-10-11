//页面回退到uploadFile页面
function backToUploadFilePage() {
    var orderid = $("#orderid").val();
    var orderNo = $("#orderNo").val();
    window.location.href="/placeOrder/uploadFilePage?orderid=" + orderid+"&orderNo="+orderNo;
}

//单选按钮
var notarServiceFlag = 0;
var deliverServiceFlag = 0;
var address = "";
var addressee = "";
var phone = "";

$('#stepUpload').find('.ques-warp').each(function(){
    var _this = $(this);
    $(this).find('.radio-notar').on('click','.chk',function(){
        _this.find('.radio-warp .chk').removeClass('chked');
        $(this).addClass('chked');
        //需要认证服务（加上$40SGD的认证费用）
        if($(".ques-warp .radio-warp span:eq(0)").hasClass("chked") && notarServiceFlag == 0) {
            var price = (Number($("#price").html()) + 40).toFixed(2);
            $("#price").html(price);
            notarServiceFlag = 1;
        //不需要认证服务
        }else if(!$(".ques-warp .radio-warp span:eq(0)").hasClass("chked") && notarServiceFlag == 1) {
            var price = (Number($("#price").html()) - 40).toFixed(2);
            $("#price").html(price);
            notarServiceFlag = 0;
        }
    });

    $(this).find('.radio-deliv').on('click','.chk',function(){
        _this.find('.radio-deliv .chk').removeClass('chked');
        $(this).addClass('chked');

        //挂号邮件
        if($('#deliverySrv .radio-warp:eq(0)').find('.chk').hasClass('chked')){
            $('#deliverySrv .inp-addr').stop().slideDown(600);
            $('#deliverySrv .pick-addr').stop().slideUp(300);
            deliverServiceFlag = 1;
        }

        //自取
        if($('#deliverySrv .radio-warp:eq(1)').find('.chk').hasClass('chked')){
            $('#deliverySrv .pick-addr').stop().slideDown(600);
            $('#deliverySrv .inp-addr').stop().slideUp(300);
            deliverServiceFlag = 0;
        }
    });
    console.log(deliverServiceFlag);
});

//支付
$("#payNow").on("click", function() {
    var leaveMsg = $("#leaveMsg").val();
    var price = $("#price").html();
    var orderid = $("#orderid").val();
    address = $("#address").val();
    addressee = $("#addressee").val();
    phone = $("#phone").val();
    console.log(deliverServiceFlag);

    $.ajax({
        type: "POST",
            url: "/placeOrder/handleServiceInfo",
            dataType: "json",
            //async: false,
            data: {
                "orderid": orderid, //订单id：orderid
                "notarServiceFlag": notarServiceFlag, //1:认证 0：不认证
                "deliverServiceFlag": deliverServiceFlag, //1:挂号邮件 0：自取
                "address": address,
                "addressee": addressee,
                "phone": phone,
                "leaveMsg": leaveMsg,
                "price": price
        },
        success: function(data) {
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
});

/**
 * 
 * @param orderNo
 */
function viewFullQuote(orderNo){
	var leaveMsg = $("#leaveMsg").val();
    var price = $("#price").html();
    address = $("#address").val();
    addressee = $("#addressee").val();
    phone = $("#phone").val();
    
    var notarServiceState;
    if (0 == notarServiceFlag) {
        notarServiceState = "No";
    } else if (1 == notarServiceFlag) {
        notarServiceState = "Yes";
    }

    var fetchType;
    var finalAddress;
    if (0 == deliverServiceFlag) {
        fetchType = "Self pick-up";
        finalAddress = "10 Anson Road #06-16 International Plaza S079903, Tanjong Pagar MRT Exit C.";
    } else if (1 == deliverServiceFlag) {
        fetchType = "Registered Mail";
        finalAddress = address;
    }
    
    $("#ordernoVFQF").val(encryptedStr(orderNo));
    $("#lawyerVFQF").val(notarServiceState);
    $("#fetchTypeVFQF").val(fetchType);
    $("#addrVFQF").val(finalAddress);
    $("#addresseeVFQF").val(addressee);
    $("#phoneVFQF").val(phone);
    $("#remarkVFQF").val(leaveMsg);
    $("#priceVFQF").val(price);

    $("#viewFullQuoteForm").submit();
    layer.closeAll();
}

$(function(){
    var i = 5;
    var timer = null;
    timer = setInterval(function(){
        i--;
        $('.z_pay-timer span').html(i);
        if(i==0){
            clearInterval(timer);
            //window.location.href="###";
        }
    },1000)
});

$(function() {
    //加密orderid和orderNo
    $("#orderid").val(encryptedStr($("#orderid").val()));
    $("#orderNo").val(encryptedStr($("#orderNo").val()));
    //回写快递信息
    var deliver = $("#deliverInput").val();
    if(deliver == "Registered Mail") {
        $(".radio-deliv span:eq(0)").addClass("chked");
        $('#deliverySrv .inp-addr').stop().slideDown(600);
        $('#deliverySrv .pick-addr').stop().slideUp(300);
    }else if(deliver == "Self pick-up") {
        $(".radio-deliv span:eq(2)").addClass("chked");
        $('#deliverySrv .pick-addr').stop().slideDown(600);
        $('#deliverySrv .inp-addr').stop().slideUp(300);
    }
});

//获取当前时间
getNowFormatDate()
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "/";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var strDate1 = date.getDate()*1+1;
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate =  strDate + seperator1 + month + seperator1+ date.getFullYear();

    var currentdate1 =  strDate1 + seperator1 + month + seperator1+ date.getFullYear();
    //return currentdate;
    $('.nowdata').html(currentdate);
    $('.nowdata1').html(currentdate1);
}