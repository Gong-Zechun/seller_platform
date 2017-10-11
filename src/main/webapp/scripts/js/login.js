/*******************************************************************************
 * VTeam Login JavaScript
 * 
 * http://www.vteamsystem.com
 * 
 * Copyright (c) 2013 VTeam. All rights reserved.
 */

/**
 * 页面初始化
 */
$(document).ready(function() {
    var localHref = location.href;
    if (window != top || $.string.isNullOrEmpty(localHref) || localHref.indexOf('login.jsp') == -1) {
        top.location.href = vt.basePath + "login.jsp";
    }
    
    $(".i-text").focus(function() {
        $(this).addClass('h-light');
    });

    $(".i-text").focusout(function() {
        $(this).removeClass('h-light');
    });
    
    $("#username").focus(function() {
        var username = $(this).val();
        if ((username == '请输入用户名') || (username == '請輸入用戶名') || (username == 'Please input username')) {
            $(this).val('');
        }
    });
    
    $("#imgCode,#noticeText").click(function() {
    	changeSafeCode();
    });
    
    $('#validateCode').keypress(function(event) {
    	if(event.which == 13) {
    	    $('#loginButton').click();
    	}
    });

    $("#password").focus(function() {
        var password = $(this).val();
        if (password == '输入密码') {
            $(this).val('');
        }
    });
    changeSafeCode();
    $("#loginButton").click(function() {
        if (($.string.isNullOrEmpty($("#username").val()))) {
            alertError("请输入用户名");
            return false;
        }
        if ($.string.isNullOrEmpty($("#password").val())) {
            alertError("请输入密码");
            return false;
        }
        if ($.string.isNullOrEmpty($("#validateCode").val())) {
            alertError("请输入验证码");
            return false;
        }
        // 验证验证码是否正确
        var doGetCode = false;
        var hasCode = false;
        var checkValidateCodeAction = vt.basePath + "/checkValidateCode/check?_T=" + Math.random();
        $.ajax({
            url : checkValidateCodeAction,
            dataType : "text",
            async : false,
            data : {
                "validateCode" : $("#validateCode").val()
            },
            success : function(data, status) {
                doGetCode = true;
                var success = eval("(" + data + ")").success;
                if (success == "failed") {
                    alertError("验证码输入有误");
                    $("#validateCode").val("");
                    changeSafeCode();
                } else {
                    hasCode = true;
                }
            }
        });
        if (!doGetCode || !hasCode) {
            return;
        }
        loginSubmit();
//        $("#login").submit();
    });

    /** ******多语言切换Start********** */
    $("#languageCNButton").click(function() {
        setLanguage('zh_CN');
    });

    $("#languageTWButton").click(function() {
        setLanguage('zh_TW');
    });

    $("#languageUSButton").click(function() {
        setLanguage('en_US');
    });

    /** ******多语言切换End********** */

});

var COOKIE_NAME = 'LocaleLanguage';
/**
 * 设置国际化语言
 * @param language
 */
function setLanguage(language) {
    $.cookie(COOKIE_NAME, null, {
        path : '/'
    });
    $.cookie(COOKIE_NAME, language, {
        expires : 7,
        path : '/' // 默认系统全路径
    });
    window.location.href = 'login.jsp';
}

/**
 * 提交后台验证用户名密码
 */
function loginSubmit() {
	var username=$("#username").val();
	var password=$("#password").val();
	var data={username:username,password:password}; 
	var url="login";
	 $.ajax({
		type: "POST",
		url: "login",
		data: data,
//	    contentType: "application/json",
//		dataType: "json",
		success:function (result) {
            if (result.CODE == "SUCESS") {
            	window.location.href="index";
            } else {
            	alertError(result.MSG);
            	$("#validateCode").val("");
                changeSafeCode();
            }
		}
	});
}

/**
 * 修改验证码
 */
function changeSafeCode(){
	$("#imgCode").attr("src","getValidateCode?Random=" + new Date().getTime());
}

window.onload = function() {
    if (document.all) {// 简单判断是否是IE
        start = setInterval('pageLoad()', 1000);
    } else {
        // 要执行的语句
        ajaxLoadEnd();
    }
    if ($("#showErrorMes")) {
        var value = $("#showErrorMes").html();
        if (value) {
            var values = value.split(":");
            if (values[1].indexOf("Bad credentials") >= 0) {
                alertError('EOR_USERNAME_PASSWORD!');
            } else if (values[1].indexOf("Maximum sessions of 1 for this principal exceeded") >= 0) {
                alertError('当前用户已登陆!');
            } else {
                alertError(values[1]);
            }
        }
    }
};
