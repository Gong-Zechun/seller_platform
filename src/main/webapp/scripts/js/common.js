/**
 * 页面查看模式
 */
function viewModel() {
    $("input:radio").attr("disabled", "disabled");
    $("input:text").attr("disabled", "disabled");
    $("input:checkbox").attr("disabled", "disabled");
    $("select").attr("disabled", "disabled");
    $("textarea").attr("disabled", "disabled");
    $(":button").attr("disabled", "disabled");
    $(":file").attr("disabled", "disabled");
    $(".easyui-combobox").combobox("disable");// 禁用combobox
    // $(".searchbox-button").attr("disabled", "disabled");// 禁用searchbox
    $(".searchbox-button").unbind();// 禁用searchbox
    $(".clear-button").hide();
    // 修改页面只读标识
    vt.VIEW_MODEL = true;
}

/**
 * 页面编辑模式
 */
function editModel() {
    $("input:radio").removeAttr("disabled");
    $("input:text").removeAttr("disabled");
    $("input:checkbox").removeAttr("disabled");
    $("select").removeAttr("disabled");
    $("textarea").removeAttr("disabled");
    $(":button").removeAttr("disabled");
    $(":file").removeAttr("disabled");
    $(".easyui-combobox").combobox("enable");// 启用combobox
    // $(".searchbox-button").removeAttr("disabled");// 启用combobox
    $(".clear-button").show();
    // 修改页面只读标识
    vt.VIEW_MODEL = false;
}

/**
 * 根据控件ID判断是否为easyui combobox
 * 
 * @param elementId
 */
function isEasyuiCombobox(elementId) {
    if ($("#" + elementId).hasClass("easyui-combobox")) {
        return true;
    } else {
        return false;
    }
}

/**
 * 设置searchbox为不可输入状态
 */
function viewSearchbox() {
    $(".searchbox-text").attr("readonly", "readonly");
}

/**
 * 设置searchbox为可输入状态
 */
function editSearchbox() {
    $(".searchbox-text").removeAttr("readonly");
}

/**
 * 绑定清楚按钮事件
 */
function bindClearBtn() {
    $.each($('.clear-button'), function(index, btn) {
        var span = $(this).parent().find('span.searchbox');
        span.css('width', '');
        span.append(this);
    });
    $(".clear-button").bind("click", function() {
        $(this).parent().parent().children().each(function() {
            if ($(this).hasClass("easyui-searchbox")) {
                $(this).searchbox("setValue", "");
            }
            if ($(this).is(":hidden")) {
                $(this).val("");
            }
        });
    });
}

/**
 * 处理暂存档修改数据
 * 
 * @param data
 */
function handleTModData(data) {
    return JSON.stringify(data);
}


/** *********Tab标签控制Begin**************** */
/**
 * 隐藏tab页面
 */
function hideTab(tabName, tabId) {
    $("#" + tabId).tabs('getTab', tabName).panel('options').tab.hide();
}

/**
 * 显示tab页面
 */
function showTab(tabName, tabId) {
    $("#" + tabId).tabs('getTab', tabName).panel('options').tab.show();
}

/**
 * 选中tab页面
 */
function selectTab(tabName, tabId) {
    $("#" + tabId).tabs('getTab', tabName).panel('options').tab.click();
}
/** *********Tab标签控制End**************** */


/** ********* 附件上传 Begin**************** */
/**
 * 插入行
 * 
 * @param tableid
 *            目标table
 * @param first
 *            模板行号
 * @param last
 *            最后行数
 */
function insertRowforfile(tableid, first, last) {
    var rowNum = $("#" + tableid + " tr").length;
    var tempTr = $("#" + tableid + " tr:eq(" + first + ")").html();
    $("#" + tableid + " tr:eq(" + (rowNum - 1 - last * 1) + ")").after("<tr>" + tempTr + "</tr>");
    $("#" + tableid + " tr:eq(" + (rowNum - last * 1) + ") input").each(function() {
        $(this).attr("name", $(this).attr("name") + rowNum);
        if ($(this).attr("data") == "number") {
            $(this).val("0");
        } else {
            $(this).val("");
        }
    });
    $("#" + tableid + " tr:eq(" + (rowNum - last * 1) + ") select").each(function() {
        $(this).attr("name", $(this).attr("name") + rowNum);
        // $(this).val("");
    });

    $("#" + tableid + " tr:eq(" + (rowNum - last * 1) + ") span").each(function() {
        // $(this).html("0");
    });
    $("#" + tableid + " tr:eq(" + (rowNum - last * 1) + ") div").each(function() {
        // $(this).html("0");
    });
}

/**
 * 删除行
 * 
 * @param tableid
 * @param obj
 * @param first
 * @param last
 */
function removeRowforfile(tableid, obj, first, last) {
    var rowsnum = $("#" + tableid + " tr").length;
    var trobj = obj.parentNode.parentNode;
    if (rowsnum * 1 > (first * 1 + last * 1 + 1)) {
        $(trobj).remove();
    }
}
/** ********* 附件上传 End**************** */

/** ** EasyUI DataGrid Table中增减行 Begin*** */
var editIndex = undefined;
var lastTableId = null;
/**
 * 判断某一行是否已结束编辑状态
 * 
 * @param tableId
 *            Table Id
 * @returns {Boolean}
 */
function endEditing(tableId) {
    tableId = '#' + tableId;
    if (editIndex == undefined) {
        return true;
    }
    if ($(tableId).datagrid('validateRow', editIndex)) {
        $(tableId).datagrid('getEditor', {
            index : editIndex
        });
        $(tableId).datagrid('endEdit', editIndex);
        editIndex = undefined;
        return true;
    } else {
        return false;
    }
}

/**
 * 选中某一行
 * @param rowIndex
 *            当前行的索引(从0开始)
 */
function onClickRow(rowIndex) {
    var tableId = $(this).attr('id');
    onClickRowByTableId(tableId, rowIndex);
}

/**
 * 选中某一行
 * 
 * @param rowIndex
 *            当前行的索引(从0开始)
 */
function onClickRowByTableId(tableId, rowIndex) {
    if (!$.string.isNullOrEmpty(lastTableId) && !$.string.isNullOrEmpty(editIndex) && lastTableId != tableId) {
        endEditDatagrid(lastTableId);
    }
    lastTableId = tableId;
    if (endEditing(tableId)) {
        tableId = '#' + tableId;
        $(tableId).datagrid('beginEdit', rowIndex);
        editIndex = rowIndex;
    } else {
        $(tableId).datagrid('selectRow', rowIndex);
    }
}

/**
 * 追加一行
 * 
 * @param tableId
 *            Table ID
 * @param jsonData
 *            新增的JSON格式的数据
 */
function append(tableId, jsonData) {
    if (endEditing(tableId)) {
        tableId = '#' + tableId;
        if (!jsonData) {
            jsonData = {};
        }
        $(tableId).datagrid('appendRow', jsonData);
        editIndex = $(tableId).datagrid('getRows').length - 1;
        $(tableId).datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
    }
}

/**
 * 修改某一行
 * 
 * @param tableId
 *            Table Id
 * @param rowIndex
 *            要修改行的索引(从0开始)
 * @param jsonData
 *            修改后的JSON格式的数据
 */
function update(tableId, rowIndex, jsonData) {
    if (endEditing(tableId)) {
        tableId = '#' + tableId;
        if (!jsonData) {
            jsonData = {};
        }
        var updateData = {
            index : rowIndex,
            row : jsonData
        };
        $(tableId).datagrid('updateRow', updateData);
        editIndex = rowIndex;
    }
}

/**
 * 删除DataGrid中的某一行
 * 
 * @param tableId
 *            Table Id
 */
function removeit(tableId) {
    if (editIndex == undefined) {
        return;
    }
    tableId = '#' + tableId;
    $(tableId).datagrid('cancelEdit', editIndex).datagrid('deleteRow', editIndex);
    editIndex = undefined;
}

/**
 * 结束指定Datagrid的编辑状态
 * 
 * @param tableId
 */
function endEditDatagrid(tableId) {
    tableId = '#' + tableId;
    var row = $(tableId).datagrid('getSelected');
    var index = $(tableId).datagrid('getRowIndex', row);
    $(tableId).datagrid('endEdit', index);
}

/**
 * 结束指定Datagrid的所有行的编辑状态
 * @param tableId
 */
function endAllEditingRows(tableId) {
    tableId = '#' + tableId;
    var rows = $(tableId).datagrid('getRows');
    if (rows != null && rows.length > 0) {
        for (var index = 0; index < rows.length; index++) {
            $(tableId).datagrid('endEdit', index);
        }
    }
}

/**
 * 开始指定Datagrid的所有行的编辑状态
 * @param tableId
 */
function beginAllEditingRows(tableId) {
    tableId = '#' + tableId;
    var rows = $(tableId).datagrid('getRows');
    if (rows != null && rows.length > 0) {
        for (var index = 0; index < rows.length; index++) {
            $(tableId).datagrid('beginEdit', index);
        }
    }
}
/** ** EasyUI DataGrid Table中增减行 End*** */

/** *********消息框定义Begin**************** */
// 信息框
function alertInfo(message, callback) {
    if ($.string.isNullOrEmpty(message)) {
        message = "操作成功!";
    }
    var sameSetting = {
        icon : 1,
        shadeClose : true,
//        title : "提示信息"
        title : "Info",
        btn:"OK"
    };
    alertCommon(message, sameSetting, callback);
}

// 错误提示框
function alertError(message, callback) {
    var sameSetting = {
        icon : 2,
        shadeClose : true,
//        title : "错误信息"
        title : "Error"
    };
    alertCommon(message, sameSetting, callback);
	//关闭遮罩层
	ajaxLoadEnd();
}

// 警告框
function alertWarn(message, callback) {
    var sameSetting = {
        icon : 0,
        shadeClose : true,
//        title : "警告信息"
        title : "Warning"
    };
    alertCommon(message, sameSetting, callback);
	//关闭遮罩层
	ajaxLoadEnd();
}

/**
 * 弹出框公共方法
 * @param message
 * @param sameSetting
 * @param callback
 */
function alertCommon(message, sameSetting, callback) {
    if ($.util.isString(callback)) {
        top.layer.alert(message, sameSetting, function() {
            if (!$.string.isNullOrEmpty(callback)) {
                window.location.href = callback;
            }
        });
    } else if (typeof callback == "function") {
        top.layer.alert(message, sameSetting, callback);
    } else {
        top.layer.alert(message, sameSetting);
    }
}

// 确认框
function alertConfirm(message, yescallback, cancelcallback) {
    layer.confirm(message, {
//        btn : [ "确认", "取消" ] // 按钮
        btn : [ "OK", "Cancel" ] // 按钮
    }, function() {
        if ($.util.isString(yescallback)) {
            window.location.href = yescallback;
        } else if (typeof yescallback == "function") {
            return yescallback();
        }
    }, function() {
        if ($.util.isString(cancelcallback)) {
            window.location.href = cancelcallback;
        } else if (typeof cancelcallback == "function") {
            return cancelcallback();
        }
    });
}

$(function() {
    $('form').on('submit', function() {
        ajaxLoading();
    });
});

var ajaxLoadIndex = 0;
function ajaxLoading() {
    // 使用LayerUI来实现提示层
    ajaxLoadIndex = layer.load(1, {
        shade : [ 0.5, '#fff' ] // 0.5透明度的白色背景
    });
}
function ajaxLoadEnd() {
    layer.close(ajaxLoadIndex);
}
/** *********消息框定义End**************** */

/**
 * 触发 focus 事件
 * @param field
 */
function focusElement(element) {
    var elementId = element;
    if (!element.startsWith("#")) {
        elementId = "#" + element;
    }
    var elementObj = $(elementId);
    if (elementObj == undefined || elementObj.length == 0) {
        elementObj = $("[name='" + element + "']");
    }
    if (elementObj != undefined && elementObj.length > 0) {
        elementObj.focus();
    }
}

/** **********渲染填充Form Begin************ */

/**
 * 根据JSON对象填充指定区域的HTML
 * @param data
 * @param tplTableId
 */
function fillFormByHtml(data, tplTableId) {
    tplTableId = tplTableId.startsWith("#") ? tplTableId : "#" + tplTableId;
    var gettpl = $(tplTableId).html();
    laytpl(gettpl).render(data, function(html) {
        $(tplTableId).html(html);
    });
}

/**
 * 根据JSON对象及模板填充指定区域的HTML
 * @param data
 * @param tplTableId
 * @param tableId
 */
function fillFormByTpl(data, tplTableId, tableId) {
    tplTableId = tplTableId.startsWith("#") ? tplTableId : "#" + tplTableId;
    tableId = tableId.startsWith("#") ? tableId : "#" + tableId;
    var gettpl = $(tplTableId).html();
    laytpl(gettpl).render(data, function(html) {
        $(tableId).html(html);
    });
}
/** **********渲染填充Form End******* */



/** **********JS实现精确加减乘除 begin********** */
/**
 * 两数据加法运算
 */
function accAdd(arg1,arg2){  
    var r1,r2,m;
    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}  
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}  
    m=Math.pow(10,Math.max(r1,r2))  
    return (arg1*m+arg2*m)/m  
}
/**
 * 两数据减法运算
 */
function accSub(arg1,arg2){      
    return accAdd(arg1,-arg2);  
}
/**
 * 两数据乘法运算
 */
function accMul(arg1,arg2){  
    var m=0,s1=arg1.toString(),s2=arg2.toString();  
    try{m+=s1.split(".")[1].length}catch(e){}  
    try{m+=s2.split(".")[1].length}catch(e){}  
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)  
}
/**
 * 两数据除法运算
 */
function accDiv(arg1,arg2){  
    var t1=0,t2=0,r1,r2;  
    try{t1=arg1.toString().split(".")[1].length}catch(e){}  
    try{t2=arg2.toString().split(".")[1].length}catch(e){}  
    with(Math){  
        r1=Number(arg1.toString().replace(".",""))  
        r2=Number(arg2.toString().replace(".",""))  
        return (r1/r2)*pow(10,t2-t1);  
    }  
}


/**
 * JS金额计算方法 <summary>四则运算,基本思路：转整计算然后恢复小数位</summary> <par>operator运算符</par> <result>计算结果</result>
 */
function arithmetic(arg1, operator, arg2) {
    var r1, r2;
    var mul = 0, size = 0;
    try {
        r1 = arg1.toString().split(".")[1].length;
    } catch (e) {
        r1 = 0;
    }
    try {
        r2 = arg2.toString().split(".")[1].length;
    } catch (e) {
        r2 = 0;
    }
    size = Math.max(r1, r2);
    switch (operator) {
        case "+":
        case "-":
            mul = size;
            break;
        case "*":
            mul = 2 * size;
            break;
        case "/":
            mul = 0;
            break;
    }
    return eval("(" + (arg1 * Math.pow(10, size)).toFixed(0) + ")" + operator + "(" + (arg2 * Math.pow(10, size)).toFixed(0) + ")")
            / Math.pow(10, mul);
}
/** **********JS实现加减乘除 end********** */

/** **********JS加密 begin********** */
/**
 * 获取RSA密钥对
 */
function genKey(){
	var rsa_m = "9e020efe95e3251fc99db658d99dc7a2d11eef3f3c5ed9909c797556c6bf02c9c13f9a15796aa6b2ee8e62b4a5f2671fc7c7737ce4b6a36dca95db69fed97fbddbd5b7175396813b034062fc72d6f4ccf2790eb675e6e397f56edd53a5c3dbfbb3abbed200b998f9e378eb991896f16c4ead5d11320dbdb0d65e5a22b0bda911";
    var rsa_e = "10001";
    setMaxDigits(130); //131 => n的十六进制位数/2+3
    return new RSAKeyPair(rsa_e, '', rsa_m); //e,m是从Java代码中获取的
}

/**
 * 对字符串加密
 * @param orgStr 原始字符串
 * @return RSA加密后的字符串
 */
function encryptedStr(orgStr){
	var key = genKey();
    return encryptedString(key, orgStr+"");//对数据加密
}

/** **********JS加密 end********** */

/**
 * 获取url中的参数
 */
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) 
    	return unescape(r[2]); 
    return null; //返回参数值
}


/** **********输入框验证 Begin********** */
/**
 * 验证文本框输入是否为空，并弹窗
 * @param id
 * @returns {Boolean}
 */
function validateTextIsNull(id){
	if($.string.isNullOrWhiteSpace($("#"+id).val())){
		alertWarn($("#"+id).parent().prev().find("span").text()+"不能为空"); 
		return true;
	} 
}

/**
 * 验证文本框是否输入为数字，并弹窗
 * @param id
 * @returns {Boolean}
 */
function validateTextIsNum(id){
	if(!jQuery.number.isNumber($("#"+id).val())){
		alertWarn($("#"+id).parent().prev().find("span").text()+"必须是数字"); 
		return true;
	} 
}
/**
 * 验证文本框输入的数字是否大于0，并弹窗
 * @param id
 * @returns {Boolean}
 */
function validateTextIsGrZero(id){
	if(jQuery.number.isNumber($("#"+id).val()) && parseInt($("#"+id).val())<0){
		alertWarn($("#"+id).parent().prev().find("span").text()+"必须为正数"); 
		return false;
	}
	return true;
}
/** **********输入框验证 End********** */

/** ***********浮层效果 Begin********************** */
//禁止提交按钮多次提交
$(function() {
 $('form').on('submit', function() {
     ajaxLoading();
 });
});

function ajaxLoading() {
 $("<div class=\"datagrid-mask\"></div>").css({
     display : "block",
     width : "100%",
     height : $(document.body).outerHeight(true)
 }).appendTo("body");
 $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理请稍候").appendTo("body").css({
     display : "block",
     left : ($(document.body).outerWidth(true) - 190) / 2,
     top : ($(window).height() - 45) / 2
 });
}
function ajaxLoadEnd() {
 $(".datagrid-mask").remove();
 $(".datagrid-mask-msg").remove();
}
/** ***********浮层效果 End********************** */

/**
 * 设置searchbox为不可输入状态
 */
function viewSearchbox() {
    $(".searchbox-text").attr("readonly", "readonly");
}

/**
 * 设置searchbox为可输入状态
 */
function editSearchbox() {
    $(".searchbox-text").removeAttr("readonly");
}


/**
 * 绑定清楚按钮事件
 */
function bindClearBtn() {
    $.each($('.clear-button'), function(index, btn) {
        var span = $(this).parent().find('span.searchbox');
        span.css('width', '');
        span.append(this);
    });
    $(".clear-button").bind("click", function() {
        $(this).parent().parent().children().each(function() {
            if ($(this).hasClass("easyui-searchbox")) {
                $(this).searchbox("setValue", "");
            }
            if ($(this).is(":hidden")) {
                $(this).val("");
            }
        });
    });
}


/** ***********日期格式化 Begin********************** */
/**
 * 格式化日期(yyyy-MM-dd)
 * 
 * @param value
 * @returns
 */
function formatDate(value) {
    return formatDateByFormatter(value, 'yyyy-MM-dd');
}

/**
 * 格式化日期带时间(yyyy-MM-dd HH:mm:ss)
 * 
 * @param value
 * @returns
 */
function formatDateTime(value) {
    return formatDateByFormatter(value, 'yyyy-MM-dd HH:mm:ss');
}

/**
 * 按指定格式字符串格式日期
 * 
 * @param value
 * @param formatter
 * @returns
 */
function formatDateByFormatter(value, formatter) {
    if (value == "" || value == null) {
        return;
    }
    return $.date.format(value, formatter);
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S+": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
/** **********格式化日期时间 end********** */

/** **********数据格式化 Begin********** */
/**
 * 格式化整数
 * @param value
 */
function formatInteger(value) {
    if (isNaN(value)) {
        return "0";
    }
    return formatNumberByFormatter(value, "###,###,###,###");
}

/**
 * 格式化数字
 * @param value
 */
function formatNumber(value){
    if (isNaN(value)) {
        return "0";
    }
    return formatNumberByFormatter(value, "###,###,###,##0.00");
}

/**
 * 按指定格式字符串格式数字
 * @param value
 * @param formatter
 * @returns
 */
function formatNumberByFormatter(value, formatter) {
    if (value == "" || value == null) {
        return;
    }
    return applyPattern(value, formatter);
}

/**
 * <summary>浮点数精度处理</summary> <par> accuracy小数位精度</par> <bug>由于toPrecision是从第一个不为0的值开始处理精度， 所以暂不考虑0.00000X(<0.01)的情况</bug>
 */
function formatByAccuracy(val, accuracy) {
    if (val) {
        if (accuracy == 0 && parseFloat(val) < 1) {
            return parseFloat(val).toPrecision();
        } else {
            val = Number(val).toString();
            index = val.indexOf('.');
            // len整数位精度
            len = index == -1 ? val.length : (val.substr(0, index) == '0' ? index - 1 : index);
            accuracy = parseInt(len, 10) + parseInt(accuracy, 10);
            // toPrecision最大支持21位处理
            accuracyaccuracy = accuracy > 21 ? 21 : accuracy;
            return parseFloat(val).toPrecision(accuracy);
        }
    } else {
        return val;
    }
}
/** **********数据格式化 End********** */
/**
 * 从数据字典数组中获取字典项名称
 */
function findDictLabel(jsonArray,value){
	jsonArray = eval(jsonArray);
	for(var p in jsonArray){//遍历json数组时，这么写p为索引，0,1
		if(jsonArray[p].value == value){
			return jsonArray[p].label;
		}
	}
	return "";
}

/**
 * 表格中字段过长鼠标放上去显示提示信息
 * @param value
 * @param row
 * @param index
 * @returns {String}
 */
function tipView(value, row, index) {
	var content = '';
	var abValue = value + '';
	if (value != undefined && !$.string.isNullOrEmpty(value)) {
		if (value.length >= 15) {
			abValue = value.substring(0, 12) + "...";
			content = '<span href="javascript:;"  title="' + value
					+ '" class="easyui-tooltip">' + abValue + '</span>';
		} else {
			content = '<span href="javascript:;"  title="' + abValue
					+ '" class="easyui-tooltip">' + abValue + '</span>';
		}
	}
	return content;
}

/** **********实现Java Set数据库结构 Begin********** */
function Set() {
    this.elements = new Array();
    //获取Set元素个数
    this.size = function() {
        return this.elements.length;
    }

    //判断Set是否为空
    this.isEmpty = function() {
        return (this.elements.length < 1);
    }

    //清除Set
    this.clear = function() {
        this.elements = new Array();
    }
    //增加一个元素，不重复
    this.add = function(value) {
        //alert(this.containsKey(_key));
        if(this.containsValue(value)){
            this.remove(value);
        }
        this.elements.push(value);
    }
    //移除一个值
    this.remove = function(value) {
        var bln = false;
        try {

            for (i = 0; i < this.elements.length; i++) {

                if (this.elements[i] == value) {

                    this.elements.splice(i, 1);

                    return true;
                }
            }
        } catch (e) {
            bln = false;
        }
        return bln;
    }

    //移除一个值,索引
    this.kill=function (index){
        this.remove(this.get(index));
    }

    //得到一个值,索引
    this.get = function(_index) {
        if (_index < 0 || _index >= this.elements.length) {
            return null;
        }
        return this.elements[_index];
    }

    //查看是否包含一个值
    this.containsValue = function(value) {
        var bln = false;
        try {
            for (i = 0; i < this.elements.length; i++) {
                if (this.elements[i] == value) {
                    bln = true;
                }
            }
        } catch (e) {
            bln = false;
        }
        return bln;
    }
}
/** **********实现Java Set数据库结构 End********** */

/**
 * 根据formId获取页面form数据
 * @param formId
 * @returns
 */
function getFormData(formId) {
    return $("#" + formId).serializeObject();// 序列化表单
}

/**
 * 转换参数值成中文描述
 * @param currentValue 当前值
 * @param allDictItems 数据字典所有值
 */
function getParmNameByVal(currentValue, allDictItems){
	if(currentValue == null || currentValue == ""){
		return "";
	}
	var parmValue = "";
	var types = currentValue.split(",");
	for(var j=0; j<types.length; j++){
	    $.each(allDictItems, function(i, json) {
	        if (json.value == types[j]) {
	            parmValue = parmValue+"<br>"+json.desc+" $"+json.label+"/min";
	        }
	    });
	}
    if(parmValue.length > 0){
    	parmValue = parmValue.substring(4, parmValue.length);
    }
    return parmValue;
}

/**
 * 删除数组中某一特定元素
 * @param array 数组
 * @param value 值为value的某一特定元素
 */
function deleteValueFromArray(array, value) {
    for(var i = 0; i < array.length; i++) {
        if(array[i] == value) {
            array.splice(i, 1);
            break;
        }
    }
}

/**
 * null转成字符串
 */
$.nullToEmpty = function(value){
	if(value==null){
		return "";
	}
	return value;
	
}