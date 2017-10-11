/**
 * 支付并翻译完毕后确认
 */
function confirm(){
	var completeTime = $("#completeTime").val();
	alertConfirm("Would you like to CONFIRM the translation after checking all the content?" +
		"<br> When you click on CONFIRM, no further changes can be made in this translation. We will certify (and notarize) the confirmed copy. You can collect all the documents after " +
		"" +completeTime + ".",
			function(){
        layer.closeAll('dialog');
        var url = $("#confirmForm").attr('action');
    	$.ajax({
    		type : "POST",
    		url : url,
    		processData : false,
    		dataType:'json',
    		contentType : 'application/json',
    		data : JSON.stringify($("#confirmForm").serializeObject()),
    		success : function(result) {
    			if(result == '1'){
    				alertInfo("Confirmed Sucessully!", function(){
    					 layer.closeAll('dialog');
    					 window.location.href="/order/myOrders";
    				});
    			} else {
    				alertInfo("Confirmed error!");
    			}
    		}
    	});
	});
}

/**
 * 下载已翻译过的订单文件
 * @param fileId
 */
function downloadFile(fileId){
	window.location.href = "downloadOrderFile?fileId=" + encryptedStr(fileId);
}