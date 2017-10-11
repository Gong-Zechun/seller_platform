var TURNAROUND_PRICE_LIST, OTHER_SERVICES_LIST;
//选择订单状态
$(function(){
	//初始化参数
	initParams();
	//加载表格数据
	loadGrid();
	$('.order-list .box').on('click',function(){
		var mynum = $(this).attr('data-num');
        mynum++;
        $(this).attr({'data-num':mynum});
        if(mynum%2==0){
            $(this).next().slideUp();
		}else{

            $(this).next().slideDown();
		}

	})
	$('.spinner-box ul li').on('click',function(){
        $('.order-list .box').attr({'data-num':0});
        $('.reason .box').attr({'data-type' :0});
		var state =  $(this).html();
		$(this).parent().parent().prev().find("span").html(state);
		$(this).parent().parent().slideUp();
		var slectedVal = $(this).attr("value");
		$("#orderStatus").val(slectedVal);
		loadGrid();
	})
});

/**
 * 加载必要参数
 */
function initParams(){
	$.getJSON('/sysDict/getSysDictByType?type=1', function( data ) {
		TURNAROUND_PRICE_LIST = data;
	});
	$.getJSON('/sysDict/getSysDictByType?type=2', function( data ) {
		OTHER_SERVICES_LIST = data;
	});
}

/**
 * 获取周转时间
 * @param turnaroundTime
 * @returns
 */
function getTrunronundTime(turnaroundTime){
	return getParmNameByVal(turnaroundTime, TURNAROUND_PRICE_LIST);
}

/**
 * 获取其他服务
 * @param ortherServices
 * @returns
 */
function getOrtherServices(ortherServices){
	return getParmNameByVal(ortherServices, OTHER_SERVICES_LIST);
}

/**
 * 获取评价，回写到页面
 * @param orderId
 */
function getOrderEvaluation(orderId) {
    $.ajax({
        type: "POST",
        url: "/order/getOrderEvaluation",
        dataType: "json",
        data: {
            "orderId": orderId
        },
        success: function(data) {
        	if(!$.string.isNullOrEmpty(data)) {
                $('#evaluate .cmtTxt').val(data.remarks);
                if(data.level == 1) {
                    $("#cmtStar ul li:eq(0)").addClass("star");
                }else if(data.level == 2) {
                    $("#cmtStar ul li:eq(0)").addClass("star");
                    $("#cmtStar ul li:eq(1)").addClass("star");
                }else if(data.level == 3) {
                    $("#cmtStar ul li:eq(0)").addClass("star");
                    $("#cmtStar ul li:eq(1)").addClass("star");
                    $("#cmtStar ul li:eq(2)").addClass("star");
                }
			}
        },
        error: function(e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
}

/**
 * 添加评价
 * @param orderId
 */
function addOrderEvaluation(orderId) {
    //订单星级评价
    var starNum = 0;
    $("#cmtStar ul li").click(function(){
        $("#cmtStar ul li").removeClass("star");
        $(this).addClass("star").prevAll().addClass("star");
        starNum = $(this).index() + 1;
    });

    $('#evaluate .cmtTxt').focus(function(){
        $(this).siblings('p').show().html('');
    });

    //提交评论
    $('#evaluate').on('click','.btn',function(){
        var msg = $('#evaluate .cmtTxt').val();
        if(msg == '' || msg == undefined || msg == null){
            $('#evaluate .cmtTxt').siblings('p').show().html('error');
        }else{
            $.ajax({
                type: "POST",
                url: "/order/addOrderEvaluation",
                dataType: "json",
                data: {
                    "orderId": orderId,
                    "starNum": starNum,
                    "msg": msg
                },
                success: function(data) {
                    if(1 == data) {
                    	alertInfo("Submit successfully!", function() {
                            layer.closeAll('dialog');
                            $('.mask-bg').hide();
                            $('#evaluate').fadeOut();
						})
					}
                },
                error: function(e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });
        }
    });
}

/**
 * 加载订单列表
 */
function loadGrid(){
	var params = { tplid:  "tpl_list_table",
			tableid: "list_table",
			tablepageid: "list_table_page",
		   	pageNumInputName:"page",
		   	pageSizeInputName:"rows",
		   	orderBy:"orderByClause",
	    	selectPage:"selectPage",
	    	newView: true};
	$("#searchForm").pageSearch(params);
}

/**
 * 进入支付确认页面
 */
function showPayBox(isMergePay, orderId){
	if(isMergePay){
		var allCheckedOrderId = encryptedStr(getCheckedVal("checkbox_td"));
		if($.string.isNullOrEmpty(allCheckedOrderId)){
			alertInfo("Please select at least one order!");
			return;
		}
		$("#payOrderId").val(allCheckedOrderId)
	} else {
		$("#payOrderId").val(orderId);
	}
	$('.mask-bg').show();
	$('#payBox').fadeIn();
}

/**
 * 关闭支付确认页面
 */
function closePayBox(){
	$('.mask-bg').hide();
    $('#payBox').fadeOut();
}
/**
 * 跳转到支付页面
 */
function toPaypal(){
	closePayBox();
	$("#paypalForm").submit();
}

/**
 * 点击全选复选框
 * @param checkallbox 当前点击
 * @param checkbox_td 需要选中子复选框名称
 */
function checkAllBox(checkallbox, checkbox_td){
	   if(checkallbox.checked){
		   $(checkallbox).parents('.slt-warp').find('.chk').addClass('chked');
		   $(checkallbox).attr("checked",true);
		   $('input[type="checkbox"][name="'+checkbox_td+'"]').each(function(){
			   if(!$(this).prop("disabled")){
				   $(this).parents('.slt-warp').find('.chk').addClass('chked');
				   $(this).attr("checked",true);
			   }
		   });
	   }else{
		   $(checkallbox).parents('.slt-warp').find('.chk').removeClass('chked');
		   $(checkallbox).attr("checked",false);
		   $('input[type="checkbox"][name="'+checkbox_td+'"]').each(function(){
			   if(!$(this).prop("disabled")){
				   $(this).parents('.slt-warp').find('.chk').removeClass('chked');
				   $(this).attr("checked",false);
			   }
		   });
	   }
}
/**
 * 选中一个复选框
 * @param onechkx 当前选中
 * @param checkbox_th 全选复选框ID
 */
function checkOne(onechkx, checkbox_th){
	   var total = onechkx.length;
	   var checkedLen = 0;
	   if(onechkx.checked){
		   $(onechkx).parents('.slt-warp').find('.chk').addClass('chked');
		   $(onechkx).attr("checked",true);
		   if(isAllChecked(onechkx)){
			   $("#"+checkbox_th).parents('.slt-warp').find('.chk').addClass('chked');
			   $("#"+checkbox_th).attr("checked",true);
		   }else{
			   $("#"+checkbox_th).parents('.slt-warp').find('.chk').removeClass('chked');
			   $("#"+checkbox_th).attr("checked",false);
		   }
	   }else{
		   $(onechkx).parents('.slt-warp').find('.chk').removeClass('chked');
		   $(onechkx).attr("checked",false);
		   $("#"+checkbox_th).parents('.slt-warp').find('.chk').removeClass('chked');
		   $("#"+checkbox_th).attr("checked",false);
	   }
}

/**
 * 检查是否所有复选框全部选中
 * @param onechkx
 * @returns {Boolean}
 */
function isAllChecked(onechkx){
	var isAllChecked = true;
	$('input[type="checkbox"][name="'+$(onechkx).attr("name")+'"]').each(function(){
	   if(!$(this).prop("checked") && !$(this).prop("disabled")){
		   isAllChecked = false;
		   return isAllChecked;
	   }
    });
	return isAllChecked;
}

/**
 * 获取所有选中复选框值
 * @param checkbox_td
 * @returns {String}
 */
function getCheckedVal(checkbox_td){
	var str="";
	$('input[type="checkbox"][name="'+checkbox_td+'"]').each(function(){
		if($(this).prop("checked") && !$(this).prop("disabled")){
			str += $(this).val()+",";
		}
	});
	if(str){
		str = str.substring(0,str.length-1);
	}
	return str;
}

/**
 * 弹出评价页面
 * @param orderId
 */
function showEvaluationBox(orderId){
    $('.mask-bg').show();
    $('#evaluate').fadeIn();
    getOrderEvaluation(orderId);
    addOrderEvaluation(orderId);
}

/**
 * 关闭评价页面
 * @param orderId
 */
function closeEvaluationBox(){
	$('.mask-bg').hide();
	$('#evaluate').fadeOut();
}

/**
 * 取消订单
 * @param orderId
 */
$(function(){
    //选择取消原因
    $('.reason .box').on('click',function(){
        //var mythis = _this;
        var mydatatype = $(this).attr('data-type');
        mydatatype++;
        var mynum=$(this).attr({'data-type' :mydatatype});
        if(mydatatype%2==0){
            $(this).next().hide();
        }else{
            $(this).next().show();
        }
    });
})


/**
 * 取消订单
 * @param orderId
 */
function cancalOrder(orderId) {
    alertConfirm("Do you want to cancel this order?", function(){
        layer.closeAll('dialog');
        //取消原因弹框
        $('.mask-bg').show();
        $('#cancelOrder').fadeIn();
		$("#confirmBtn").on("click",function() {
            var calcalReason = $(".reason .box .state").html();
            $.ajax({
                type: "POST",
                url: "/order/cancalOrder",
                dataType: "json",
                data: {
                    "orderId": orderId,
            		"calcalReason": calcalReason
                },
                success: function(data) {
                	if(data > 0) {
                		alertInfo("Canceled successfully!",function(){
                			layer.closeAll('dialog');
                			$('.mask-bg').hide();
                            $('#cancelOrder').fadeOut();
                    		loadGrid();
                		});
            		}
                },
                error: function(e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });
		});
    },function(){
        return;
    });
}

/**
 * 获取订单状态
	状态		订单状态					支付状态			
	未支付(1)	status	 = 	1-待处理	;	payStatus	 = 	1-未支付	||	4-支付失败	;
	进行中(2)	status	 = 	2-进行中	;	payStatus	 = 	3-支付完成	;		
	未确认(3)	status	 = 	6-已翻译	;	payStatus	 = 	3-支付完成	;		
	已完成(4)	status	 = 	3-已完成	;	payStatus	 = 	3-支付完成	;		
*/
function getOrderStatus(status, payStatus) {
	if (status == 1 && (payStatus == 1 || payStatus == 4)) {
		return 1;
	}
	if (status == 2 && payStatus == 3) {
		return 2;
	}
	if (status == 6 && payStatus == 3) {
		return 3;
	}
	if (status == 3 && payStatus == 3) {
		return 4;
	}
	return -1;
}

/**
 * 获取订单允许的操作：
	操作	订单状态				        支付状态					
	取消(1)	status	 = 	1-待处理	;	    payStatus	 = 	1-未支付	||	4-支付失败	;
	支付(1)	status	 = 	1-待处理	;	    payStatus	 = 	1-未支付	||	4-支付失败	;
	确认(2)	status	 = 	6-已翻译	;	    payStatus	 = 	3-支付完成	;		
	评价(3)	status	 = 	3-已完成	;	    payStatus	 = 	3-支付完成	;		
*/
function getOrderOparation(status, payStatus) {
	if (status == 1 && (payStatus == 1 || payStatus == 4)) {
		return 1;
	}
	if (status == 6 && payStatus == 3) {
		return 2;
	}
	if (status == 3 && payStatus == 3) {
		return 3;
	}
	return -1;
}

/**
 * 获取订单状态名称
 * @orderStatusCode: 订单状态：1-未支付;2-进行中;3-未确认;4-已完成;-1-无状态
 */
function getOrderStatusName(orderStatusCode) {
	if(orderStatusCode == 1){
		return "Unpaid";
	} 
	
	if(orderStatusCode == 2){
		return "Being translated";
	}
	
	if(orderStatusCode == 3){
		return "Unconfirmed";
	}
	
	if(orderStatusCode == 4){
		return "Completed";
	}
	
	return "";
}

//点击订单列表取消按钮 出现弹框下时关掉弹框功能
$(function(){
    $('#cancelOrder .close').on('click',function(){
        $('.mask-bg').hide();
       $(this).parent().hide();
    })
})
