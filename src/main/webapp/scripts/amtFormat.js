/*******************************************************************************
 * Transn Amt JavaScript
 * 
 * http://www.transn.com
 * 
 * Copyright (c) 2017 Transn. All rights reserved.
 */
$().ready(function() {
	$(".amtClass").each(function(fn) {
		// 初始化所有的金额文本框
		amtInit($(this));
	});
	$(".amtClass").change(function() {
		// 值发生变化时
		onchangeAgent($(this));
	});
	$(".amtClass").focus(function() {
		// 金额文本框激活时
		onfocusAgent($(this));
	});
	$(".amtClass").blur(function() {
		onblurAgent($(this));
	});
	$(".amtClass").keypress(function() {
		onkeypressAgent($(this));
	});
	$(".amtRealClass").change(function() {
		initShowObjByHiddenObj($(this));
	});
	$('.amtField').each(function(index, field) {
		$(field).amtfield();
	});
});



var suffix = "_DISP";
// 金额显示控件的默认Class
var dispClass = "amtClass";
var amt_ccy_id = "_CCYID";
/**
 * 金额显示格式后缀(生成JavaScript用)
 */
var amt_ccy_disp_format = "_CCY_DISP_FORMAT";
/**
 * 金额编辑格式后缀(生成JavaScript用)
 */
var amt_ccy_edit_format = "_CCY_EDIT_FORMAT";

/**
 * 金融输入框插件 对于定义了class为amtText的input节点实施转变.
 */
(function($) {
	$.fn.amtfield = function(options, params) {
		if (typeof options == 'string') {
			return $.fn.amtfield.methods[options](this, params);
		}
		if(this.hasAmtfield()){
			return true;
		}
		parseOptions(this, options);

		makeUpHidenField(this);

		addLisenters(this);

		updateAmtByCCY(this);
	};
	
	$.fn.hasAmtfield = function(){
		if($(this).attr('id').indexOf(suffix)>0){
			return true;
		}else{
			return false;
		}
	};

	$.fn.amtfield.methods = {
//		val : function(obj, value) {
//			var amtHidden = $(obj);
//			if (typeof value == 'undefined') {
//				return amtHidden.val();
//			} else {
//				amtHidden.val(value);
//				updateAmtByCCY(obj);
//				return this;
//			}
//		}
	}

	$.fn.amtfield.defaults = {
		styleClass : 'amtText',
		ccyId : 'ccyid'
	};

	/**
	 * 获取某一个设置的值
	 */
	function getOptions(name) {
		if (typeof name == 'undefined') {
			return $.fn.amtfield.defaults;
		} else if (typeof name == 'string') {
			return $.fn.amtfield.defaults[name];
		}
	}

	/**
	 * 解析传入配置
	 */
	function parseOptions(obj, options) {
		options = options || {};
		options.ccyId = (options && options.ccyId) || $(obj).attr('ccyid') || 'ccyid';
		options.ccyDispFormat = $(obj).attr('ccyDispFormat');
		options.ccyEditFormat = $(obj).attr('ccyEditFormat');
		$.fn.amtfield.defaults = $.extend($.fn.amtfield.defaults, options);
	}

	/**
	 * 创建一个隐藏的文本域，保存真实值
	 */
	function makeUpHidenField(field) {
		var options = getOptions();
		var name = $(field).attr('name');
		var id = $(field).attr('id');
		var value = $(field).val();

		if (typeof id == 'undefined') {
			id = 'ID_' + name;
		}
		var hiddenField = $('<input type="hidden" value="'+value+'">').attr('name', name).attr(
				'id', id);
		$(field).parent().append(hiddenField);
		$(field).attr('id', id + suffix);
		$(field).attr('name', 'NAME_' + name);
		if (!$(field).hasClass(options.styleClass)) {
			$(field).addClass(options.styleClass);
		}
	}

	/**
	 * 为文本框添加事件
	 */
	function addLisenters(field) {
		var ccyID = '#' + getOptions().ccyId;
		var ccyComSelector = 'input[id="' + $(ccyID).attr('comboid') + '"]';
		var ccyDispFormat = getOptions().ccyDispFormat;
		var ccyEditFormat = getOptions().ccyEditFormat;
		var hiddenFieldID = '#' + $(field).attr('id').substring(0,$(field).attr('id').length-5);
		var isEasyUi = $(ccyID).hasClass('easyui-combobox');
		$(field).blur(function(e) {
			var _this = $(e.target);
			var amtValue = $(hiddenFieldID).val();
			var amtFmt;
			if($(ccyID).hasClass('easyui-combobox')){
				amtFmt = getAmtDsipFmtByValue2($(ccyID).combobox('getValue'), amtValue,_this.attr('ccyDispFormat'));
			}else{
				amtFmt = getAmtDsipFmtByValue2($(ccyID).val() , amtValue,_this.attr('ccyDispFormat'));
			}

//			if ($.isNumeric(amtFmt)) {
//				$(hiddenFieldID).val(amtFmt);
//			} else {
//				$(hiddenFieldID).val(amtValue);
//			}
			$(field).val(amtFmt);
		});
		$(field).keypress(function(event) {
			var code = event.keyCode || event.which || event.charCode;
			var currKey = String.fromCharCode(code);
			var result = $(this).val() + currKey;
			var regExp = /^-?\d*(\.\d*)?$/;
			var keycode = event.which;// 0-上下左右,8-删除,13-回车
			return keycode == 0 || keycode == 8 || keycode == 13
					|| regExp.test(result);
		});
		$(field).focus(function(e) {
			var _this = $(e.target);
			if($(ccyID).hasClass('easyui-combobox')){
				$(field).val(getAmtEditFmtByValue2( $(ccyID).combobox('getValue'),
							$(hiddenFieldID).val(),_this.attr('ccyEditFormat')));
			}else{
				$(field).val(getAmtEditFmtByValue2($(ccyID).val(),
						$(hiddenFieldID).val(),_this.attr('ccyEditFormat')));
			}
		});
		$(field).change(function(e){
			var _this=$(e.target);
			if($.string.isNumeric(_this.val())) {
				var sp = ".";
				var s = _this.val().toString().split(sp);
				var intStr = trimPerZero(s[0]);
				if (intStr.length > 12) {
					// 输入的金额栏位字符长度不能超过12位!
					alertWarn(getMessage('输入内容超长')+'!');
					amtvalue = '0';
					$(hiddenFieldID).val(0);
				} else {
					$(hiddenFieldID).val(_this.val());
				}
			} else if($.string.isNullOrEmpty(_this.val())) {
				$(hiddenFieldID).val('');
			} else {
				$(hiddenFieldID).val(0);
			}
			if($(ccyID).hasClass('easyui-combobox')){
				$(field).val(getAmtDsipFmtByValue2($(ccyID).combobox('getValue'),
									$(hiddenFieldID).val(),_this.attr('ccyDispFormat')));
			}else{
				$(field).val(getAmtDsipFmtByValue2($(ccyID).val(),
						$(hiddenFieldID).val(),_this.attr('ccyDispFormat')));
			}
		});
		$(hiddenFieldID).change(function(){
			var _this=$(field);
			if($(ccyID).hasClass('easyui-combobox')){
				$(field).val(getAmtDsipFmtByValue2($(ccyID).combobox('getValue'),
							$(hiddenFieldID).val(),_this.attr('ccyDispFormat')));
			}else{
				
				$(field).val(getAmtDsipFmtByValue2($(ccyID).val(),
						$(hiddenFieldID).val(),_this.attr('ccyDispFormat')));
			}
		});
		if( typeof($(field).attr('ccyDispFormat'))=='undefined' && typeof($(field).attr('ccyEditFormat'))=='undefined'){
			if (isEasyUi) {
				
				/*$(ccyID).combobox({onSelect:function(record){
					$('input[ccyid="' + $(this).attr('id') + '"]').each(
						function(index, field) {
							updateAmtByCCY(field);
						});					
				}});*/
				
				var superMethod = $(ccyID).combobox("options")["onSelect"];
				$(ccyID).combobox("options")["onSelect"] = function() {
					superMethod();
					$('input[ccyid="' + $(ccyID).attr('id') + '"]').each(
						function(index, field) {
							updateAmtByCCY(field);
						});
				}
			} else {
//				$(ccyID).change(function() {
//					updateAmtByCCY(hiddenFieldID);
//				});
				
			}
		}
	}

	/**
	 * 更新amtField的值,同时更新隐藏文本域的值 amtField:金额文本域对象
	 */
	function updateAmtByCCY(amtField) {
		var ccyID = '#' + $(amtField).attr('ccyid');
		var ccyComSelector = 'input[name="' + $(ccyID).attr('comboname') + '"]';
		var amtHidden = $('#' + $(amtField).attr('id').substring(0,$(amtField).attr('id').length-5));
		
		$(amtField).val(getAmtDsipFmtByValue($(ccyID).val()
						|| $(ccyComSelector).val(), amtHidden.val()));
		amtHidden.val(getAmtEditFmtByValue($(ccyID).val()
						|| $(ccyComSelector).val(), amtHidden.val()));
	}
})(jQuery);

/** *****初始化币种 Start**** */
// TODO 动态获取
// 初始化币种
var fmt = new Array();
fmt[0] = new Array();
fmt[0][0] = 'LOCAL'; // 本地币
fmt[0][1] = '2'; // 精确小数位数
fmt[0][2] = '###,###,###,##0.00'; // 显示格式
fmt[0][3] = '###########0.00'; // 编缉格式
fmt[1] = new Array();
fmt[1][0] = 'RMB'; // 币种代号
fmt[1][1] = '2'; // 精确小数位数
fmt[1][2] = '###,###,###,##0.00'; // 显示格式
fmt[1][3] = '###########0.00'; // 编缉格式
fmt[2] = new Array();
fmt[2][0] = 'JPY'; // 币种代号
fmt[2][1] = '0'; // 精确小数位数
fmt[2][2] = '###,###,###,###'; // 显示格式
fmt[2][3] = '###########'; // 编缉格式
fmt[3] = new Array();
fmt[3][0] = 'HKD'; // 币种代号
fmt[3][1] = '2'; // 精确小数位数
fmt[3][2] = '###,###,###,##0.00'; // 显示格式
fmt[3][3] = '###########0.00'; // 编缉格式
fmt[4] = new Array();
fmt[4][0] = 'AUD'; // 币种代号
fmt[4][1] = '2'; // 精确小数位数
fmt[4][2] = '###,###,###,##0.00'; // 显示格式
fmt[4][3] = '###########0.00'; // 编缉格式
fmt[5] = new Array();
fmt[5][0] = 'EUR'; // 币种代号
fmt[5][1] = '2'; // 精确小数位数
fmt[5][2] = '###,###,###,##0.00'; // 显示格式
fmt[5][3] = '###########0.00'; // 编缉格式
fmt[6] = new Array();
fmt[6][0] = 'USD'; // 币种代号
fmt[6][1] = '2'; // 精确小数位数
fmt[6][2] = '###,###,###,##0.00'; // 显示格式
fmt[6][3] = '###########0.00'; // 编缉格式
fmt[7] = new Array();
fmt[7][0] = 'GBP'; // 币种代号
fmt[7][1] = '2'; // 精确小数位数
fmt[7][2] = '###,###,###,##0.00'; // 显示格式
fmt[7][3] = '###########0.00'; // 编缉格式
fmt[8] = new Array();
fmt[8][0] = 'CAD'; // 币种代号
fmt[8][1] = '2'; // 精确小数位数
fmt[8][2] = '###,###,###,##0.00'; // 显示格式
fmt[8][3] = '###########0.00'; // 编缉格式
fmt[9] = new Array();
fmt[9][0] = 'CHF'; // 币种代号
fmt[9][1] = '2'; // 精确小数位数
fmt[9][2] = '###,###,###,##0.00'; // 显示格式
fmt[9][3] = '###########0.00'; // 编缉格式
fmt[10] = new Array();
fmt[10][0] = 'SGD'; // 币种代号
fmt[10][1] = '2'; // 精确小数位数
fmt[10][2] = '###,###,###,##0.00'; // 显示格式
fmt[10][3] = '###########0.00'; // 编缉格式
/** *****初始化币种 End**** */

function onchangeAgent(obj) {
	edtOnChange($(obj));
}

function onfocusAgent(obj) {
	$(obj).attr("style", "imeMode:disabled");
	edtOnFocus($(obj));
}

function onblurAgent(obj) {
	edtOnBlur($(obj));
}

function onkeypressAgent(obj) {
	editKeyBoard($(obj), keybDecimal);
}

// 根据币种对象动态显示格式化之后的值
function chgAmtDispFmtByCcyAgent(ccyObj, amtobjid) {
	chgAmtDispFmtByCcy($(ccyObj), amtobjid);
}

var prefix = '';
var intPartLen = 0;
var decimalDigits = 0;

var maskStr = '#';
var radixPoint = '.';
var comma = ',';

var keybYN = new keybEdit('yn', 'Valid values are \'Y\' or \'N\'.');
var keybNumeric = new keybEdit('01234567890', 'Numeric input only.');
var keybAlpha = new keybEdit('abcdefghijklmnopqurstuvwxy ', 'Alpha input only.');
var keybAlphaNumeric = new keybEdit('abcdefghijklmnopqurstuvwxy01234567890 ',
		'Alpha-numeric input only.');
var keybDecimal = new keybEdit('-01234567890.', 'Decimal input only.');
var keybDate = new keybEdit('01234567890/', 'Date input only');
var keybYNNM = new keybEdit('yn');
var keybNumericNM = new keybEdit('01234567890');
var keybAlphaNM = new keybEdit('abcdefghijklmnopqurstuvwxy');
var keybAlphaNumericNM = new keybEdit('abcdefghijklmnopqurstuvwxy01234567890');
var keybDecimalNM = new keybEdit('01234567890.');
var keybDateNM = new keybEdit('01234567890/');

function getPrefix() {
	return this.prefix;
}

function getIntPartLen() {
	return this.intPartLen;
}

function getDecimalDigits() {
	return this.decimalDigits;
}

function getMaskStr() {
	return this.maskStr;
}

function getRadixPoint() {
	return this.radixPoint;
}

function getComma() {
	return this.comma;
}

function parsePattern(patternStr) {
	this.prefix = patternStr.substring(0, patternStr.indexOf(maskStr));
	if (patternStr.indexOf(comma) >= 0) {
		this.intPartLen = patternStr.indexOf(comma)
				- patternStr.indexOf(maskStr);
	} else {
		this.intPartLen = 10000;
	}
	if (patternStr.lastIndexOf(radixPoint) > 0) {
		this.decimalDigits = patternStr.length
				- patternStr.lastIndexOf(radixPoint) - 1;
	} else {
		this.decimalDigits = 0;
	}
}

function keybEdit(strValid, strMsg) {
	var reWork = new RegExp('[a-z]', 'gi');

	if (reWork.test(strValid)) {
		this.valid = strValid.toLowerCase() + strValid.toUpperCase();
	} else {
		this.valid = strValid;
	}

	if ((strMsg == null) || (typeof(strMsg) == 'undefined')) {
		this.message = '';
	} else {
		this.message = strMsg;
	}

	this.getValid = keybEditGetValid;
	this.getMessage = keybEditGetMessage;

	function keybEditGetValid() {
		return this.valid.toString();
	}

	function keybEditGetMessage() {
		return this.message;
	}
}

void function editKeyBoard(objForm, objKeyb) {
	strWork = objKeyb.getValid();
	strMsg = '';

	blnValidChar = false;
	if (!blnValidChar) {
		for (var i = 0; i < strWork.length; i++) {
			if (window.event.keyCode == strWork.charCodeAt(i)) {
				blnValidChar = true;
				break;
			}
		}
	}
	if (!blnValidChar || ($(objForm).val().length >= 18)) {
		window.event.returnValue = false;
		objForm.focus();
	}
};

void function upperCase(obj) {
	obj.value = obj.value.toString().toUpperCase();
};

function FormatNumberic(v, pos) {
	var sp = ".";
	var s = v.toString().split(sp);
	if (s.length == 2) {
		var ts = s[1];
		if (pos == 0) {
			if (ts.charAt(0) >= 5) {
				return (parseInt(trimPerZero(s[0])) + 1).toString();
			} else {
				return trimPerZero(s[0]);
			}
		}
		if (ts.length > pos) {
			if (ts.charAt(pos) >= 5) {
				var result = parseInt(trimPerZero(ts.substring(0, pos))) + 1;

				if (result.toString().length > pos) {
					return (parseInt(trimPerZero(s[0])) + 1).toString() + "."
							+ result.toString().substr(1);
				} else if (result.toString().length == pos) {
					return s[0] + "." + result;
				} else {
					var tss = "";
					for (var i = 0; i < pos - result.toString().length; i++)
						tss = tss + "0";
					return s[0] + "." + tss + result;
				}
			} else {
				return s[0] + "." + ts.substring(0, pos);
			}
		} else {
			while (ts.length < pos)
				ts += "0";
			return s[0] + "." + ts;
		}
	} else {
		return v;
	}
}

function trimPerZero(v) {

	if (v == null || v == '') {
		return '';
	}
	if ((v == '0') || (v == '-')) {
		return '0';
	}
	for (var i = 0; i < v.length; i++) {
		if (v.charAt(0) == "0") {
			v = v.substr(1);
		}
	}
	return v;
}

function applyPattern(amt, pattern) {
	parsePattern(pattern);
	var flag = 0;
	if ($.string.isNullOrEmpty(amt)) {
		amt = '';
		return amt;
	} else {
		if (!$.string.isNumeric(amt)) {
			amt = '0';
		}
	}
	if (amt < 0)
		flag = 1;
	amt = Math.abs(amt);
	amt = FormatNumberic(amt, getDecimalDigits());
	var sp = ".";
	var s = amt.toString().split(sp);
	var intStr = trimPerZero(s[0]);
	if (intStr.length > 18) {
		var inStrLen = intStr.length;
		intStr = intStr.substring(0, 1) + '.'
				+ intStr.substring(1, intStr.length);
		intStr = FormatNumberic(intStr, getDecimalDigits());
		if (flag == 1) {
			return intStr + "-" + 'E' + (parseInt(inStrLen) - 1);
		}
	}
	if (intStr.length == 0) {
		var suffixStr = s[1];
		if (suffixStr == null) {
			suffixStr = '';
			for (var i = 0; i < getDecimalDigits(); i++) {
				suffixStr = suffixStr + '0';
			}
		}
		if (flag == 1) {
			return getPrefix() + "-" + '0' + getRadixPoint() + suffixStr;
		}
	}

	var commaLen = 0;
	commaLen = parseInt(intStr.length / getIntPartLen());

	if (commaLen * getIntPartLen() == intStr.length) {
		commaLen = parseInt(commaLen) - 1;
	}

	for (var i = 0; i < commaLen; i++) {
		var preStr = intStr.substring(0, intStr.length - (i + 1)
						* getIntPartLen() - i);
		var proStr = intStr.substring(intStr.length - (i + 1) * getIntPartLen()
						- i, intStr.length);
		intStr = preStr + getComma() + proStr;
	}

	if (s.length == 2) {
		intStr = intStr + getRadixPoint() + s[1];
		if (flag == 1) {
			return getPrefix() + "-" + intStr;
		} else {
			return getPrefix() + intStr;
		}
	} else if (s.length == 1) {
		var fillStr = '';
		for (var i = 0; i < getDecimalDigits(); i++) {
			fillStr = fillStr + '0';
		}
		if (fillStr == '') {
			if (flag == 1) {
				return getPrefix() + "-" + intStr;
			} else {
				return getPrefix() + intStr;
			}
		} else {
			if (flag == 1) {
				return getPrefix() + "-" + intStr + getRadixPoint() + fillStr;
			} else {
				return getPrefix() + intStr + getRadixPoint() + fillStr;
			}
		}
	} else {
		return '0';
	}
	return amt;
}

/**
 * 根据显示的金额对象和币种ID 格式化成显示金额格式
 * 
 * @param obj
 *            显示的金额对象
 * @param ccy
 *            币种ID
 * @returns {String}
 */
function getAmtDispFmt(obj, ccy) {
	$(obj).attr("style", "textAlign:right");
	var realObjID = $(obj).attr("id").toString().substring(0,
			$(obj).attr("id").length - suffix.length);
	var realObj = document.getElementById(realObjID);
	var dispStr = '';

	var attrCcyID = $(obj).attr("AMT_CCYID");
	if (attrCcyID != null)
		ccy = attrCcyID;
	if (ccy == null || ccy == '') {
		ccy = 'LOCAL';
	}

	var dispPattern = eval(realObjID + amt_ccy_disp_format);
	if (dispPattern == '') {
		dispStr = getAmtDsipFmtByValue(ccy, $(realObj).val());
	} else {
		dispStr = applyPattern($(realObj).val(), dispPattern);
	}

	if (dispStr == null || dispStr == '') {
		dispStr = $(realObj).val();
	}
	return dispStr;
}

/**
 * 根据显示的金额对象和币种ID 格式化成编辑金额格式
 * 
 * @param obj
 *            显示的金额对象
 * @param ccy
 *            币种ID
 * @returns {String}
 */
function getAmtEditFmt(obj, ccy) {
	$(obj).attr("style", "textAlign:left");
	var realObjID = $(obj).attr("id").substring(0,
			$(obj).attr("id").length - suffix.length);
	var realObj = document.getElementById(realObjID);
	var editStr = '';

	var attrCcyID = $(obj).attr("AMT_CCYID");
	if (attrCcyID != null)
		ccy = attrCcyID;

	var editPattern = eval(realObjID + amt_ccy_edit_format);
	if (editPattern == '') {
		editStr = getAmtEditFmtByValue(ccy, $(realObj).val());
	} else {
		editStr = applyPattern($(realObj).val(), editPattern);
	}

	if (editStr == null || editStr == '') {
		editStr = $(realObj).val();
	}
	return editStr;
}

/**
 * 根据币种和金额值得到金额显示格式
 * 
 * @param ccy
 *            币种ID
 * @param amtvalue
 *            金额
 * @returns {String}
 */
function getAmtDsipFmtByValue(ccy, amtvalue) {
	var dispStr = '';
	if ($.string.isNullOrEmpty(ccy)) {
		ccy = 'LOCAL';
	}
	for (var i = 0; i < fmt.length; i++) {
		if (fmt[i][0] == ccy) {
			dispStr = applyPattern(amtvalue, fmt[i][2]);
			break;
		}
	}
	return dispStr;
}

function getAmtDsipFmtByValue2(ccy, amtvalue,ccyDispFormat) {
	var dispStr = '';
	if(typeof(ccyDispFormat)!='undefined'){
		return applyPattern(amtvalue, ccyDispFormat);
	}
	if ($.string.isNullOrEmpty(ccy)) {
		ccy = 'LOCAL';
	}
	for (var i = 0; i < fmt.length; i++) {
		if (fmt[i][0] == ccy) {
			dispStr = applyPattern(amtvalue, fmt[i][2]);
			break;
		}
	}
	return dispStr;
}

/**
 * 根据币种和金额值得到金额编辑格式
 * 
 * @param ccy
 *            币种ID
 * @param amtvalue
 *            金额
 * @returns {String}
 */
function getAmtEditFmtByValue(ccy, amtvalue) {
	var editStr = '';
	if ($.string.isNullOrEmpty(ccy)) {
		ccy = 'LOCAL';
	}
	for (var i = 0; i < fmt.length; i++) {
		if (fmt[i][0] == ccy) {
			editStr = applyPattern(amtvalue, fmt[i][3]);
			break;
		}
	}
	return editStr;
}

function getAmtEditFmtByValue2(ccy, amtvalue,ccyEditFormat) {
	var editStr = '';
	if(typeof(ccyEditFormat)!='undefined'){
		return applyPattern(amtvalue, ccyEditFormat);
	}
	if ($.string.isNullOrEmpty(ccy)) {
		ccy = 'LOCAL';
	}
	for (var i = 0; i < fmt.length; i++) {
		if (fmt[i][0] == ccy) {
			editStr = applyPattern(amtvalue, fmt[i][3]);
			break;
		}
	}
	return editStr;
}

/**
 * 赋真实值
 * 
 * @param obj
 */
function chgFereValue(obj) {
	var realObjID = $(obj).attr("id").toString().substring(0,
			$(obj).attr("id").length - suffix.length);
	var realObj = document.getElementById(realObjID);
	var realValue = '';
	if ($(obj) == null || $(obj).val() == null
			|| (!$.string.isNumeric($(obj).val()))) {
		realValue = '';
	} else {
		realValue = trimPerZero($(obj).val());
	}
	if (realValue.split(getRadixPoint()).length > 2) {
		realValue = '0';
	}
	$(realObj).val(FormatNumberic(realValue, getDecimalDigits()));
}

function edtOnChange(obj) {
	chgFereValue(obj);
}

function edtOnFocus(obj) {
	$(obj).val(getAmtEditFmt(obj, eval(getRealObjId(obj) + amt_ccy_id)));
	obj.select();
}

function edtOnBlur(obj) {
	checkamtvaluelen(obj, eval(getRealObjId(obj) + amt_ccy_id));
	$(obj).val(getAmtDispFmt(obj, eval(getRealObjId(obj) + amt_ccy_id)));
}

/**
 * 去掉尾缀的零
 */
function trimSuffixZero(amtStr) {
	if (amtStr == null || amtStr == '' || amtStr == '0')
		return '0';
	if (amtStr.charAt(".") < 0)
		return amtStr;
	while (amtStr.substring(amtStr.length - 1, amtStr.length) == "0") {
		amtStr = amtStr.substring(0, amtStr.length - 1);
	}
	if (amtStr.length > 0
			&& amtStr.substring(amtStr.length - 1, amtStr.length) == ".") {
		amtStr = amtStr.substring(0, amtStr.length - 1);
	}
	return amtStr;
}

function edtOnFocus_myriad(obj) {
	chgTRClass();
	$(obj).val(trimSuffixZero(getAmtEditFmt(obj, eval(getRealObjId(obj)
					+ amt_ccy_id))));
	obj.select();
}

function edtOnBlur_myriad(obj) {
	recoverTRClass();
	checkamtvaluelen(obj, eval(getRealObjId(obj) + amt_ccy_id));
	$(obj).val(trimSuffixZero(getAmtDispFmt(obj, eval(getRealObjId(obj)
					+ amt_ccy_id))));
}

function chgAmtDispFmtByCcy_myriad(ccySelect, TargetAmtID) {
	var TargetAmtObj = document.getElementById(TargetAmtID + suffix);
	var selCcyID = $(ccySelect).val();
	TargetAmtObj.setAttribute("AMT_CCYID", selCcyID);// _Fere_Obj setting
	// ccyid
	var isExist = false;
	for (var i = 0; i < fmt.length; i++) {
		if (fmt[i][0] == selCcyID) {
			isExist = true;
			break;
		}
	}
	if (isExist) {
		TargetAmtObj.value = trimSuffixZero(getAmtDispFmt(TargetAmtObj,
				selCcyID));
	} else {
		var realObjID = TargetAmtObj.id.toString().substring(0,
				TargetAmtObj.id.length - suffix.length);
		var realObj = document.getElementById(realObjID);
		TargetAmtObj.value = trimSuffixZero(realObj.value);
	}
}

/**
 * 初始化金额文本框
 * 
 * @param obj
 *            显示值对象
 */
function amtInit(obj) {
	// 获取真实值文本框ID
	var objFereID = $(obj).attr("id").substring(0,
			$(obj).attr("id").length - suffix.length);
	var objFere = document.getElementById(objFereID);
	// 给显示值文本框赋值
	$(obj).val(getAmtDispFmt(obj, eval(getRealObjId(obj) + amt_ccy_id)));
	var reg = /[a-zA-Z,]/gi;
	$(objFere).val($(obj).val().replace(reg, ''));
	// 给真实值文本框赋值
	if (objFere.value == null || objFere.value == '') {
		objFere.value = '';
	}
}

/**
 * 根据隐藏值对象初始化显示值对象
 * 
 * @param obj
 *            隐藏值对象
 */
function initShowObjByHiddenObj(obj) {
	// 获取隐藏值文本框ID
	var objShowID = $(obj).attr("id") + suffix;
	var objShow = document.getElementById(objShowID);
	// 给显示值文本框赋值
	$(objShow)
			.val(getAmtDispFmt(objShow, eval($(obj).attr("id") + amt_ccy_id)));
}

function initPage_myriad(obj) {
	var objFereID = $(obj).attr("id").substring(0,
			$(obj).attr("id").length - suffix.length);
	var objFere = document.getElementById(objFereID);
	obj.value = trimSuffixZero(getAmtDispFmt(obj, eval(getRealObjId(obj)
					+ amt_ccy_id)));
	if (objFere.value == null || objFere.value == '')
		objFere.value = '0';
}

/**
 * 检查输入的金额整数位字符长度是否超过12位字符（失去焦点时调用该方法）
 */
function checkamtvaluelen(obj, ccy) {
	var dispStr = '';
	$(obj).attr("style", "textAlign:right");
	var realObjID = $(obj).attr("id").toString().substring(0,
			$(obj).attr("id").length - suffix.length);
	var realObj = document.getElementById(realObjID);
	var amt = Math.abs(realObj.value);
	amt = FormatNumberic(amt, getDecimalDigits());
	var sp = ".";
	var s = amt.toString().split(sp);
	var intStr = trimPerZero(s[0]);

	var attrCcyID = $(obj).attr("AMT_CCYID");
	if (attrCcyID != null)
		ccy = attrCcyID;

	var amtvalue = '';
	if (intStr.length > 12) {
		// 输入的金额栏位字符长度不能超过12位!
		// alertWarn(getMessage('输入内容超长')+'!');
		amtvalue = '0';
		document.getElementById(realObjID).value = '0';// 很重要
	} else {
		amtvalue = amt;
	}
	for (var i = 0; i < fmt.length; i++) {
		if (fmt[i][0] == ccy) {
			dispStr = applyPattern(amtvalue, fmt[i][2]);
			break;
		}
	}
	return dispStr;
}

// 定义页面上金额元素的ID值,多个值之间以逗号隔开
var amtElementId;

/**
 * 根据选择的币种动态调整显示格式
 * 
 * @param ccySelect
 *            币种对象
 * @param TargetAmtID
 *            控件
 */
function chgAmtDispFmtByCcy(ccySelect, TargetAmtID) {
	var TargetAmtObj = document.getElementById(TargetAmtID + suffix);
	var selCcyID;
	if (isEasyuiCombobox($(ccySelect).attr("id"))) {
		selCcyID = $(ccySelect).combobox('getValue');
	} else {
		selCcyID = $(ccySelect).val();
	}
	TargetAmtObj.setAttribute("AMT_CCYID", selCcyID);
	var isExist = false;
	for (var i = 0; i < fmt.length; i++) {
		if (fmt[i][0] == selCcyID) {
			isExist = true;
			break;
		}
	}
	if (isExist) {
		TargetAmtObj.value = getAmtDispFmt(TargetAmtObj, selCcyID);
	} else {
		var realObjID = TargetAmtObj.id.toString().substring(0,
				TargetAmtObj.id.length - suffix.length);
		var realObj = document.getElementById(realObjID);
		TargetAmtObj.value = realObj.value;
	}
}

/**
 * 获取真实金额文本框(隐藏域)的ID
 * 
 * @param obj
 * @returns
 */
function getRealObjId(obj) {
	var objFereID = $(obj).attr("id").substring(0,
			$(obj).attr("id").length - suffix.length);
	return objFereID;
}

/**
 * 根据币种获取对应的小数位数
 * 
 * @param ccyid
 *            币种
 * @returns {Number}
 */
function getPrecision(ccyid) {
	var precision = 2;
	if ($.string.isNullOrEmpty(ccyid)) {
		ccyid = 'LOCAL';
	}
	for (var i = 0; i < fmt.length; i++) {
		if (fmt[i][0] == ccyid) {
			precision = fmt[i][1];
			break;
		}
	}
	return precision;
}