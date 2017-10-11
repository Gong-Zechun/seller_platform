/**
 * 页面初始化
 */
$(document).ready(function() {
    // 刷新主题样式
    $(".settingSkin").click(function() {
        vt.changeTheme($(this).attr("id"));
    });

    var mainLayout = $("#mainLayout");
    var toolbar = $("#toolBar");
    var north = mainLayout.layout("panel", "north");
    var panel = north.panel("panel");
    var logo = $("#logo");
    var top = toolbar.css("top");

    // 隐藏头部
    $("#btnHideNorth").click(function() {
        $("#mainLayout").layout("collapse", "north");
        toolbar.insertBefore(panel).css("top", 0);
        $("#btnHideNorth").hide();
        $("#btnShowNorth").show();
    });

    // 显示头部
    $("#btnShowNorth").click(function() {
        $("#mainLayout").layout("expand", "north");
        toolbar.insertAfter(panel).css("top", top);
        $("#btnHideNorth").show();
        $("#btnShowNorth").hide();
    });

    // 修改密码
    $("#editPassword").click(function() {
        parent.$.modalDialog({
            title : "修改密码",
            width : 500,
            height : 300,
            href : "user/editUserInfo",
            buttons : [ {
                text : "修改",
                handler : function() {
                    dosubmit();
                }
            } ]
        });
    });

    // 登出
    $("#logoutButton").click(function() {
        // confirmLogout();
    });

});

// 记录上次点击的funid,用于防止重复加载
var lastFunid = "";
/**
 * 刷新west(左边)菜单
 */
function refreshWestMenu(funid) {
    if (lastFunid == funid) {
        return;
    } else {
        lastFunid = funid;
    }
    // 更新全局变量用于刷新菜单
    vt.clickFunid = funid;
    var opts = $("#west").panel("options");
    if (opts.collapsed) {
        // 展开west菜单
        $("#mainLayout").layout("expand", "west");
    }
    $("#west").panel("refresh", "");
    // showMenutree();
}

/**
 * 修改密码
 */
function dosubmit() {
    if ($.string.isNullOrWhiteSpace($("#oldPassword").val())) {
        alertWarn("原密码不能为空!");
        return false;
    }

    if ($.string.isNullOrWhiteSpace($("#newPassword").val())) {
        alertWarn("新密码不能为空!");
        return false;
    }

    if ($.string.isNullOrWhiteSpace($("#reNewPassword").val())) {
        alertWarn("重复新密码不得为空!");
        return false;
    }

    if ($("#newPassword").val() != $("#reNewPassword").val()) {
        alertWarn("新密码与重复新密码不一致!");
        return false;
    }

    var data = $("#form").serializeObject();
    // 序列化表单;
    var submitdata = JSON.stringify(data);
    submitdata = submitdata.replace(new RegExp(/(data.)/g), "");

    $.ajax({
        type : "POST",
        url : "user/saveUserInfo",
        processData : false,
        data : submitdata,
        dataType : "json",
        contentType : "application/json",
        success : function(data) {
            var url = vt.basePath + "login.jsp";
            alertInfo("", url);
        }
    });
}

/**
 * 刷新首页
 */
function goHome() {
    $("#home").attr("src", "pages/portal/main.jsp");
    $("#framecenter").panel("setTitle", "主页");
}

/**
 * 退出系统提示
 */
function confirmLogout() {
    $.messager.confirm("", "确定要退出系统吗?", function(r) {
        if (r) {
        } else {
        }
    });
}

// 全屏显示
function launchFullscreen(element) {
    if (element.requestFullscreen) {
        element.requestFullscreen();
    } else if (element.mozRequestFullScreen) {
        element.mozRequestFullScreen();
    } else if (element.webkitRequestFullscreen) {
        element.webkitRequestFullscreen();
    } else if (element.msRequestFullscreen) {
        element.msRequestFullscreen();
    } else {
        window.open(document.location, "_blank", "fullscreen=yes");
        opener = null;
        window.close();
    }
}
