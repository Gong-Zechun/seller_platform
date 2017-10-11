<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tfn" uri="http://www.transn.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="scheme" value="${pageContext.request.scheme}"/>
<c:set var="serverName" value="${pageContext.request.serverName}"/>
<c:set var="serverPort" value="${pageContext.request.serverPort}"/>
<c:set var="basePath" value="${scheme }://${serverName}:${serverPort }${path }/"/>
<c:set var="language" value="${cookie.LocaleLanguage.value}"/><%--用户语言--%>
<c:set var="theme" value="${cookie.theme.value}"/><%--EasyUI主题缓存--%>
<c:set var="version" value="201701161420"/>
<c:set var="easyui_version" value="1.5.1"/>
<%--页面元素--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="x-ua-compatible" content="ie=edge, chrome=1" />
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>
<base href="${basePath }" />
<script type="text/javascript">
/**
 * 定义系统参数
 */
var vt = vt || {};
vt.basePath = '${basePath}';
vt.contextPath = '${path}';
vt.pixel_0 = '${path}/image/pixel_0.gif';//0像素的背景，一般用于占位
vt.version = '${version}';
vt.language = '${language}';
if(vt.language == '') {
	vt.language = 'zh_CN';
}
vt.intervalTime = 500;//遮罩关闭等待时间(毫秒)
</script>

<%-- 引入CSS --%>
<link rel="stylesheet" id="common" type="text/css" href="/css/common.css">
<link rel="stylesheet" id="list" type="text/css" href="/css/list.css">
<link rel="stylesheet" id="detail" type="text/css" href="/css/detail.css">
<%-- 引入CSS --%>

<%--引入JS libary--%>
<script type="text/javascript" src="/jslib/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/jslib/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="/jslib/jquery.cookie.js"></script>
<script type="text/javascript" src="/jslib/colResizable-1.6.min.js"></script>
<script type="text/javascript" src="/jslib/webuploader.min.js"></script>
<script type="text/javascript" src="/jslib/layer.js"></script>

<%--引入RSA JS加密 libary--%>
<script type="text/javascript" src="/jslib/Barrett.js"></script>
<script type="text/javascript" src="/jslib/BigInt.js"></script>
<script type="text/javascript" src="/jslib/RSA.js"></script>

<%-- 引入EasyUI --%>
<link rel="stylesheet" id="easyui_theme" type="text/css" href="${path}/jslib/jquery-easyui-${easyui_version}/themes/<c:out value="${theme}" default="default"/>/easyui.css">
<link rel="stylesheet" id="easyui_icon" type="text/css" href="${path}/jslib/jquery-easyui-${easyui_version}/themes/icon.css">
<link rel="stylesheet" id="easyui_icon" type="text/css" href="/css/extendIcon.css">
<script type="text/javascript" src="${path}/jslib/jquery-easyui-${easyui_version}/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/jslib/jquery-easyui-${easyui_version}/locale/easyui-lang-<c:out value="${language}" default="zh_CN"/>.js" charset="utf-8"></script>
<%-- 引入EasyUI扩展 --%>

<%--引入本地JS--%>
<script type="text/javascript" src="/scripts/extendJquery.js"></script>
<script type="text/javascript" src="/scripts/extendEasyUI.js"></script>
<script type="text/javascript" src="/scripts/js/common.js"></script>
<script type="text/javascript" src="/scripts/js/bus-common.js"></script>
<script type="text/javascript" src="/scripts/laypage/laypage.js"></script>
<script type="text/javascript" src="/scripts/amtFormat.js"></script>


<script type="text/javascript" charset="utf-8">	
    //页面加载完成之后关闭遮罩浮层
    var start;
    window.onload = function() {
        //if (document.all) {//简单判断是否是IE
            start = setInterval('pageLoad()', vt.intervalTime);
        //} else {
            //要执行的语句
            //ajaxLoadEnd();
        //}
    }

    //执行IE浏览器的window.onload方法
    function pageLoad() {
        if (document.readyState == 'complete') {
            try {
            	//i18nHtml();
                ajaxLoadEnd();
                clearInterval(start);//执行成功，清除监听
            } catch (err) {
                return true;
            }
        }
    }

    //语言种类
    var language = vt.language;
    //加载资源文件时使用的编码
    var encoding = 'UTF-8';
    //My97DatePicker语言  简体:zh-cn;繁体:zh-tw;英文:en
    var dateLang = 'zh-cn';//(default)
    //日期格式
    var dateFmt = 'yyyy-MM-dd';
    //日期(年月)格式
    var dateYMFmt = 'yyyy-MM';
    //日期时间格式
    var dateTimeFmt = 'yyyy-MM-dd HH:mm:ss';
    if (language == "zh_TW") {
        dateLang = 'zh-tw';
        dateFmt = 'yyyy-MM-dd';
    } else if (language == "en_US") {
        dateLang = 'en';
    }
    //按钮权限
    var authData = '';

    //Tab标记
    var listFlag = 0;
    var appFlag = 0;
    
  	//通用日期框设置信息
    var dateSetting = {
        $dpPath : "jslib/My97DatePicker4.8Beta4/My97DatePicker",
        skin : "whyGreen",
        lang : dateLang,
        oncleared : function() {
            $(this).blur();
        },
        onpicked : function() {
            $(this).blur();
        }
    };

    //日期框
    function Wdate() {
        var mySetting = {
            dateFmt : dateFmt
        };
        $.extend(mySetting, dateSetting);
        WdatePicker(mySetting);
    };

    //日期框(年月)
    function WdateOfYM() {
        var mySetting = {
            dateFmt : dateYMFmt
        };
        $.extend(mySetting, dateSetting);
        WdatePicker(mySetting)
    };

    //日期时间框
    function Wdatetime() {
        var mySetting = {
            dateFmt : dateTimeFmt
        };
        $.extend(mySetting, dateSetting);
        WdatePicker(mySetting)
    };

    //国际化资源文件basename
    var messageFile = "messages";

    /**
     * 加载国际化资源文件
     */
    function loadProperties() {
        $.i18n.properties({
            name : messageFile,
            path : 'i18n/',
            mode : 'both',
            language : language,
            encoding : encoding,
            cache : true,
            version : vt.version
        });
    }

    //缓冲本地国际化描述变量
    var localMessages = {};

    //对页面进行国际化处理
    function i18nHtml() {
        $("span:contains('i18n:')").each(function(i, node) {
            if ($(node).html().substr(0, 5) == 'i18n:') {
                var label = $.i18n.prop($(node).text().substring(5));
                if (label) {
                    $(node).text(label);
                }
            }
        });
    }

    //遍历相应的按钮控件
    function TraversalBtns() {
        for (j = 0; j < authData.length; j++) {
            for (i = 0; i < $("a").length; i++) {
                //$($("a")[i]).css("visibility", "visible");
                var compare = $($("a")[i]).attr('suffix');
                if (compare == authData[j]) {
                    $($("a")[i]).show();
                }
            }
        }
    }
	
    var PRODUCT_STATUS,BUS_TYPE,CUST_LEVE,CUST_AREA,CUST_INDUSTRY,SALESPERSON_DEPT,PROCESS_TYPE;
    //页面初始化
    $(document).ready(function() {
    	//加载字典项
    	initDictItem();
	    //加载国际化资源文件
	    //loadProperties();
	
	    //页面加载开始出现遮罩浮层
	    //ajaxLoading();
	    
        //所有发ajax请求的a标签加上遮罩层
        //禁止ajax执行过程中页面的其他操作
        var ajaxRunNum = 0;
        $("a").click(function() {
            if (ajaxRunNum == 0) {
                ajaxRunNum++;
                $(document).ajaxStart(function() {
                    ajaxLoading();
                }).ajaxComplete(function() {
                    ajaxLoadEnd();
                });
            }
        });

        //处理日期控件
        $("input.Wdate").each(function() {
        	//$(this).focus(Wdate);
        	//$(this).click(Wdate);
        });
        $("input.Wdate").focus(Wdate);
        $("input.Wdate").click(Wdate);
        
        //处理日期控件
        $("input.WdateOfYM").unbind("focus");
        $("input.WdateOfYM").unbind("click");
        $("input.WdateOfYM").focus(WdateOfYM);
        $("input.WdateOfYM").click(WdateOfYM);

        //处理日期时间控件
        $("input.Wdatetime").unbind("focus");
        $("input.Wdatetime").unbind("click");
        $("input.Wdatetime").focus(Wdatetime);
      	$("input.Wdatetime").click(Wdatetime);

        //处理国际化
        //i18nHtml();

        //设置searchbox为不可输入状态
        viewSearchbox();

        //绑定清除按钮事件
        bindClearBtn();

    });
    
    /**
     * 初始化加载数据字典项
     */
    function initDictItem(){
    	CUST_INDUSTRY = '${tfn:toJSON(tfn:getDictByType(1))}';
    	CUST_LEVE = '${tfn:toJSON(tfn:getDictByType(2))}';
    	CUST_AREA = '${tfn:toJSON(tfn:getDictByType(3))}';
    	SALESPERSON_DEPT = '${tfn:toJSON(tfn:getDictByType(4))}';
    	BUS_TYPE = '${tfn:toJSON(tfn:getDictByType(5))}';
    	PRODUCT_STATUS = '${tfn:toJSON(tfn:getDictByType(6))}';
    	PROCESS_TYPE = '${tfn:toJSON(tfn:getDictByType(7))}';
    }
</script>
<html>
<body>
<div class="datagrid-mask-msg" style="position:relative;display:block;top:0px;left:0px;width:2000px;height:2000px">
</div>
</body>
</html>
<script type="text/javascript">
//加载国际化资源文件
//loadProperties();
//页面加载开始出现遮罩浮层
ajaxLoading();
</script>
