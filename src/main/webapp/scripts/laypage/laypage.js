/** 
 laytpl.js
 @Name：laytpl-v1.1 精妙的js模板引擎 
 @Author：贤心 - 2014-08-16
 @Site：http://sentsin.com/layui/laytpl 
 @License：MIT license
 */
;!function(){"use strict";var f,b={open:"{{",close:"}}"},c={exp:function(a){return new RegExp(a,"g")},query:function(a,c,e){var f=["#([\\s\\S])+?","([^{#}])*?"][a||0];return d((c||"")+b.open+f+b.close+(e||""))},escape:function(a){return String(a||"").replace(/&(?!#?[a-zA-Z0-9]+;)/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/'/g,"&#39;").replace(/"/g,"&quot;")},error:function(a,b){var c="Laytpl Error：";return"object"==typeof console&&console.error(c+a+"\n"+(b||"")),c+a}},d=c.exp,e=function(a){this.tpl=a};e.pt=e.prototype,e.pt.parse=function(a,e){var f=this,g=a,h=d("^"+b.open+"#",""),i=d(b.close+"$","");a=a.replace(/[\r\t\n]/g," ").replace(d(b.open+"#"),b.open+"# ").replace(d(b.close+"}"),"} "+b.close).replace(/\\/g,"\\\\").replace(/(?="|')/g,"\\").replace(c.query(),function(a){return a=a.replace(h,"").replace(i,""),'";'+a.replace(/\\/g,"")+'; view+="'}).replace(c.query(1),function(a){var c='"+(';return a.replace(/\s/g,"")===b.open+b.close?"":(a=a.replace(d(b.open+"|"+b.close),""),/^=/.test(a)&&(a=a.replace(/^=/,""),c='"+_escape_('),c+a.replace(/\\/g,"")+')+"')}),a='"use strict";var view = "'+a+'";return view;';try{return f.cache=a=new Function("d, _escape_",a),a(e,c.escape)}catch(j){return delete f.cache,c.error(j,g)}},e.pt.render=function(a,b){var e,d=this;return a?(e=d.cache?d.cache(a,c.escape):d.parse(d.tpl,a),b?(b(e),void 0):e):c.error("no data")},f=function(a){return"string"!=typeof a?c.error("Template not found"):new e(a)},f.config=function(a){a=a||{};for(var c in a)b[c]=a[c]},f.v="1.1","function"==typeof define?define(function(){return f}):"undefined"!=typeof exports?module.exports=f:window.laytpl=f}();
/*!
 laypage.js
 @Name : layPage v1.2 - 分页插件
 @Author: 贤心
 @Site：http://sentsin.com/layui/laypage
 @License：MIT
 */
;!function(){
"use strict";

function laypage(options){
    var skin = 'laypagecss';
    laypage.dir = 'dir' in laypage ? laypage.dir : Page.getpath.replace("/jslib", "") + 'css/all.css';
    new Page(options);
    if(laypage.dir && !doc[id](skin)){
        // 已全局引入all.css
        // Page.use(laypage.dir, skin);
    }
}

laypage.v = '1.2';

var doc = document, id = 'getElementById', tag = 'getElementsByTagName';
var index = 0, Page = function(options){
    var that = this;
    var conf = that.config = options || {};
    conf.item = index++;
    that.render(true);
};

Page.on = function(elem, even, fn){
    elem.attachEvent ? elem.attachEvent('on'+ even, function(){
        fn.call(elem, window.even); //for ie, this指向为当前dom元素
    }) : elem.addEventListener(even, fn, false);
    return Page;
};

Page.getpath = (function(){
    var js = document.scripts, jsPath = js[js.length - 1].src;
    return jsPath.substring(0, jsPath.lastIndexOf("/") + 1);
}())

Page.use = function(lib, id){
    var link = doc.createElement('link');
    link.type = 'text/css';
    link.rel = 'stylesheet';
    link.href = laypage.dir;
    id && (link.id = id);
    doc[tag]('head')[0].appendChild(link);
    link = null;
};

//判断传入的容器类型
Page.prototype.type = function(){
    var conf = this.config;
    if(typeof conf.cont === 'object'){
        return conf.cont.length === undefined ? 2 : 3;
    }
};

//分页视图
Page.prototype.view = function(item){
    var that = this, conf = that.config, view = [], dict = {};
    conf.pages = conf.pages|0;
    conf.allCount = conf.allCount|0;
    conf.curr = (conf.curr|0) || 1;
    conf.groups = 'groups' in conf ? (conf.groups|0) : 5;
    conf.first = 'first' in conf ? conf.first : 1;
    conf.last = 'last' in conf ? conf.last : conf.pages;
    conf.prev = 'prev' in conf ? conf.prev : '\u4e0a\u4e00\u9875';
    conf.next = 'next' in conf ? conf.next : '\u4e0b\u4e00\u9875';
    
    if(conf.options.newView){
    	 var pageAllCount = conf.pages;
		 var currentPage = conf.options.currPage;
		 if(currentPage > pageAllCount){
			 currentPage = pageAllCount;
		 }
    	return '<div class="page-list"><ul><li id="top" class="btn prev" onclick="topclick(\''+JSON.stringify(conf.options).replace(/"/g,"&"+"#34")+'\')"></li><a id="newPage">'+currentPage+'</a>/<a id="allPages">'+pageAllCount+'</a><div class="temp" id="temp" style="display:none"><ul id="pageForSelected"></ul></div></li><li id="down" class="btn next" onclick="downclick(\''+JSON.stringify(conf.options).replace(/"/g,"&"+"#34")+'\')"></a></li></ul></div>';
    }
    
    if(conf.groups > conf.pages){
        conf.groups = conf.pages;
    }
    
    //计算当前组
    dict.index = Math.ceil((conf.curr + ((conf.groups > 1 && conf.groups !== conf.pages) ? 1 : 0))/(conf.groups === 0 ? 1 : conf.groups));
    
    //当前页非首页，则输出上一页
    if(conf.curr > 1 && conf.prev){
        view.push('<a href="javascript:;" class="laypage_prev" data-page="'+ (conf.curr - 1) +'">'+ conf.prev +'</a>');
    }
    
    //当前组非首组，则输出首页
    if(dict.index > 1 && conf.first && conf.groups !== 0){
        view.push('<a href="javascript:;" class="laypage_first" data-page="1"  title="\u9996\u9875">'+ conf.first +'</a><span>\u2026</span>');
    }
    
    //输出当前页组
    dict.poor = Math.floor((conf.groups-1)/2);
    dict.start = dict.index > 1 ? conf.curr - dict.poor : 1;
    dict.end = dict.index > 1 ? (function(){
        var max = conf.curr + (conf.groups - dict.poor - 1);
        return max > conf.pages ? conf.pages : max;
    }()) : conf.groups;
    if(dict.end - dict.start < conf.groups - 1){ //最后一组状态
        dict.start = dict.end - conf.groups + 1;
    }
    for(; dict.start <= dict.end; dict.start++){
        if(dict.start === conf.curr){
            view.push('<span class="laypage_curr" '+ (/^#/.test(conf.skin) ? 'style="background-color:'+ conf.skin +'"' : '') +'>'+ dict.start +'</span>');
        } else {
            view.push('<a href="javascript:;" data-page="'+ dict.start +'">'+ dict.start +'</a>');
        }
    }
    
    //总页数大于连续分页数，且当前组最大页小于总页，输出尾页
    if(conf.pages > conf.groups && dict.end < conf.pages && conf.last && conf.groups !== 0){
         view.push('<span>\u2026</span><a href="javascript:;" class="laypage_last" title="\u5c3e\u9875"  data-page="'+ conf.pages +'">'+ conf.last +'</a>');
    }
    
    //当前页不为尾页时，输出下一页
    dict.flow = !conf.prev && conf.groups === 0;
    if(conf.curr !== conf.pages && conf.next || dict.flow){
        view.push((function(){
            return (dict.flow && conf.curr === conf.pages) 
            ? '<span class="page_nomore" title="\u5df2\u6ca1\u6709\u66f4\u591a">'+ conf.next +'</span>'
            : '<a href="javascript:;" class="laypage_next" data-page="'+ (conf.curr + 1) +'">'+ conf.next +'</a>';
        }()));
    }
    
    return '<div name="laypage'+ laypage.v +'" class="laypage_main laypageskin_'+ (conf.skin ? (function(skin){
        return /^#/.test(skin) ? 'molv' : skin;
    }(conf.skin)) : 'default') +'" id="laypage_'+conf.item +''+ item +'">'+ view.join('') + function(){
        return conf.skip 
        ? '<span class="laypage_total"><label>\u7b2c</label><input type="number" min="1" onkeyup="this.value=this.value.replace(/\\D/, \'\');" class="laypage_skip"><label style="padding-right:20px;">\u9875</label>'
        		
        + '每页<select style="margin:0px 10px;" name="'+conf.options.selectPage+'" onChange="onSelectPage(this, \''+JSON.stringify(conf.options).replace(/"/g,"&"+"#34")+'\')"><option value="5">5</option><option value="10">10</option><option value="20">20</option><option value="30">30</option><option value="50">50</option><option value="100">100</option><option value="200">200</option></select>条<button type="button" class="laypage_btn">\u786e\u5b9a</button>'+ '<em style="font-style:normal;font-weight:normal;padding-left:20px;">共'+conf.allCount+'条</em>'+'</span>' 
        : '' ;
    }() +'</div>';
};

//跳页
Page.prototype.jump = function(elem){
    var that = this, conf = that.config, childs = elem.children;
    var btn = elem[tag]('button')[0];
    var input = elem[tag]('input')[0];
    for(var i = 0, len = childs.length; i < len; i++){
        if(childs[i].nodeName.toLowerCase() === 'a'){
            Page.on(childs[i], 'click', function(){
                var curr = this.getAttribute('data-page')|0;
                conf.curr = curr;
                that.render();
                
            });
        }
    }
    if(btn){
        Page.on(btn, 'click', function(){
            var curr = input.value.replace(/\s|\D/g, '')|0;
            if(curr && curr <= conf.pages){
                conf.curr = curr;
                that.render();
            }
        });
    }
};

//渲染分页
Page.prototype.render = function(load){
    var that = this, conf = that.config, type = that.type();
	for(var i=0;i<conf.cont.length;i++){
		var view = that.view(i);
		doc[id](conf.cont[i]).innerHTML = view;
	}
	 if(conf.options.newView){
		 return;
	 }
    conf.jump && conf.jump(conf, load);
    //支持显示多个分页
	for(var i=0;i<conf.cont.length;i++){
		that.jump(doc[id]('laypage_' +conf.item +''+ i));
	}
    
    if(conf.hash && !load){
        location.hash = '!'+ conf.hash +'='+ conf.curr;
    }
};

//for 页面模块加载、Node.js运用、页面普通应用
"function" === typeof define ? define(function() {
    return laypage;
}) : "undefined" != typeof exports ? module.exports = laypage : window.laypage = laypage;

}();
function onSelectPage(o, options){
	var params = JSON.parse(options);
	$("#"+params.searchFormName).attr("from","searchButton");
	$("#"+params.pageSizeInputName).val($(o).val());
	$("#"+params.searchFormName).pageSearch(params);
}


(function($) {    
	/**
	 * 参数是一个json对象
	 * tplid:显示模板ID
	 * tableid:列表显示的ID
	 * 
	 */
	$.fn.pageSearch = function(options) {
		var layerObject = layer.load('加载中');
		options = $.extend(true,{},options);
		options.form=this;
		/**
		options = $.extend(true, {
				tplid:  "tpl_list_table",
		        tableid: "list_table",
		        tablepageid: "list_table_page",
		        tablepageid1: "list_table_page1"
		}, options);*/
		options.pageNum=options.form.find("input[id='"+options.pageNumInputName+"']");
		//如果不是点击分页的那么就是查询框的，查询框需要将page改为1
    	if(options.form.attr("from")=="searchButton"){
    		options.pageNum.val("1");
    		$("#"+options.tablepageid).attr("loaded","");
    	}
    	if(!options.pageNum.val()){
    		layer.close(layerObject);
    		return;
    	}
    	
    	var submitForm = options.form;
    	submitForm = $.extend(true,{},submitForm);
    	//submitForm = deepClone(options.form);
    	submitForm = processForm(submitForm, options);
    	var url = $(submitForm).attr('action');
    	$.ajax({
    		type : "POST",
    		url : url,
    		processData : false,
    		dataType:'json',
    		contentType : 'application/json',
    		data : JSON.stringify($(submitForm).serializeObject()),
    		success : function(result) {
				//查询成功后回调
				layer.close(layerObject);
				options.form.attr("from","");
				var pageOptions =   {tplid:  options.tplid,
				        			 tableid: options.tableid,
				        			 tablepageid: options.tablepageid,
				        			 pageNumInputName:options.pageNumInputName,
				        			 pageSizeInputName:options.pageSizeInputName,
						        	 orderBy:options.orderBy,
				        			 selectPage:options.selectPage,
				        			 newView:options.newView,
				        			 currPage:result.pageNumber,
						    	     searchFormName:options.form.attr("id")}
				 if(result.resultList==null){
					 $("#"+options.tableid).html("");
					 $("#"+options.tablepageid).html("");
					 return;
				 } else if(options.newView){
					 var pageAllCount = getPageAllCount(result.rowCount, result.pageSize);
					 var currentPage = result.pageNumber;
					 if(currentPage > pageAllCount){
						 currentPage = pageAllCount;
					 }
					 $("#"+options.tablepageid).html('<div class="page-list"><ul><li id="top" class="btn prev" onclick="topclick(\''+JSON.stringify(pageOptions).replace(/"/g,"&"+"#34")+'\')"></li><a id="newPage">'+currentPage+'</a>/<a id="allPages">'+pageAllCount+'</a><div class="temp" id="temp" style="display:none"><ul id="pageForSelected"></ul></div></li><li id="down" class="btn next" onclick="downclick(\''+JSON.stringify(pageOptions).replace(/"/g,"&"+"#34")+'\')"></a></li></ul></div>');
				 }
				var gettpl = $("#"+options.tplid).html();
				laytpl(gettpl).render(result, function(html){
					   $("#"+options.tableid).html(html);
				});
				//表格行，鼠标放上去变色
				$(".tr:odd").css("background", "#fff");
				$(".tr:odd").each(function(){
					$(this).hover(function(){
						$(this).css("background-color", "#e7edf6");
					}, function(){
						$(this).css("background-color", "#fff");
					});
				});
				$(".tr:even").each(function(){
					$(this).hover(function(){
						$(this).css("background-color", "#e7edf6");
					}, function(){
						$(this).css("background-color", "#fff");
					});
				}); 
				$(".list_table").colResizable({
				        liveDrag:true,
				        gripInnerHtml:"<div class='grip'></div>", 
				        draggingClass:"dragging", 
				        minWidth:30
			    });
				//添加排序
				//tplHeadSort();
				if(result.totalPages!=0){
					//如果没有总页数,那么就新增分页组件,以后就要不在新增了 
					// if($("#"+options.tablepageid).attr("loaded")!="1"){ 
					var pageAllCount = getPageAllCount(result.rowCount, result.pageSize); 
					laypage({
						cont: [options.tablepageid/*,options.tablepageid1*/], //支持显示多个分页，容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div> 
						pages: pageAllCount, //总页数 
						allCount: result.rowCount, 
						curr: result.pageNumber, //当前页 
						groups: 7, //连续显示分页数 
						options: pageOptions, 
						skip: true, //是否开启跳页 
						jump: function(obj, first){ //触发分页后的回调 
							if(!first){ // 点击跳页触发函数自身，并传递当前页：obj.curr 
								options.pageNum.val(obj.curr); 
								if($("#"+options.tablepageid).attr("loaded")=="1"){ 
									//$(options.btnObject).attr("from","page"); 
									//$(options.btnObject).click(); 
									options.form.pageSearch(options); 
								}
							}
						}
					}); 
					//已加载分页 
					$("#"+options.tablepageid).attr("loaded","1"); 
					// }

					$("select[name="+options.selectPage+"]").each(function(i){
		    			$(this).val($("#"+options.pageSizeInputName).val());
		    		});
				}else{
					$("#"+options.tablepageid).html("");
					$("#"+options.tablepageid1).html("");
				}
			}
    	});
	};     
})(jQuery);
function getPageAllCount(totalCount, pageSize){
	var pagenumcount = parseInt(totalCount/pageSize);
	if(totalCount%pageSize>0){
		pagenumcount ++;
	}
	return pagenumcount;
}
(function($){
	// 对Date的扩展，将 Date 转化为指定格式的String   
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
	// 例子：   
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
	Date.prototype.format = function(fmt)   
	{ //author: meizz   
	  var o = {   
	    "M+" : this.getMonth()+1,                 //月份   
	    "d+" : this.getDate(),                    //日   
	    "H+" : this.getHours(),                   //小时   
	    "m+" : this.getMinutes(),                 //分   
	    "s+" : this.getSeconds(),                 //秒   
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
	    "S"  : this.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	    if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;   
	}  
	
	$.getUrlParam = function(name){
		 var aQuery = window.location.href.split("?");//取得Get参数
         if(aQuery.length > 1)
         {
             var aBuf = aQuery[1].split("&");
             for(var i=0, iLoop = aBuf.length; i<iLoop; i++)
             {
                 var aTmp = aBuf[i].split("=");//分离key与Value
                 if(aTmp.length==2){
                	 if(aTmp[0]==name){
                		 return aTmp[1];
                	 }
                 }
             }
         }
         return "";
	}
	$.nullToEmpty = function(value){
		if(value==null){
			return "";
		}
		return value;
		
	}
	// 格式化输出日期，value是一个long型的毫秒
	$.dateF = function(value,f){
		if( value == null || value == ""){
			return "";
		}
		if(f == null || f=="") {
			f="yyyy-MM-dd HH:mm:ss";
		}
		var myDate=new Date();
		myDate.setTime(value);
		return myDate.format(f);
	}
	
	/** 
	 * 将数值四舍五入(保留2位小数)后格式化成金额形式 
	 * 
	 * @param num 数值(Number或者String) 
	 * @return 金额格式的字符串,如'1,234,567.45' 
	 * @type String 
	 */
	$.formatCurrency = function(num){  
	    num = num.toString().replace(/\$|\,/g,'');  
	    if(isNaN(num))  
	    num = "0";  
	    sign = (num == (num = Math.abs(num)));  
	    num = Math.floor(num*100+0.50000000001);  
	    cents = num%100;  
	    num = Math.floor(num/100).toString();  
	    if(cents<10)  
	    cents = "0" + cents;  
	    for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)  
	    num = num.substring(0,num.length-(4*i+3))+','+  
	    num.substring(num.length-(4*i+3));  
	    return (((sign)?'':'-') + num + '.' + cents);  
	}  
	
	//从json对象数组中查找，value值等于v 的json对象
	//js 文件和对象说明 <script type="text/javascript" src="/static/core/data/gn_cs.js?v="></script>
//>>>>jsonArray  对象名称                    需要引入的js文件 
	
	//国际机场               _gjcity      gj_city.js
	//国内机场               _gncity      gn_city.js
	//国内城市               _gncs        gn_cs.js
	//国航空公司             _gnhkgs     gnhkgs.js
	//所有航空公司          _hkgs       hkgs.js
	//国际城市               _sf          sf.js
	
	//例子 得到CA对应的航空公司名称   $.findJson(_hkgs,"CA").mc;
	$.findJson = function(jsonArray,v){
		jsonArray = eval(jsonArray);
		var result=v.split(",");
		var returnStr = "";
		for(var p in jsonArray){//遍历json数组时，这么写p为索引，0,1
			if(result.length > 1){
				for(var i=0; i<result.length; i++){
					if(jsonArray[p].value == result[i]){
						returnStr=returnStr+","+jsonArray[p].name;
					}
				}
			} else {
				if(jsonArray[p].value == v){
					return jsonArray[p].name;
				}
			}
		}
		if(returnStr.length>0){
			return returnStr.substring(1,returnStr.length);
		}
		return "";
	}
	//截取字符串超过len长度的字符，并在title中展示
	$.cut = function(str,len){
		if(str == null || str == ""){
			return "";
		}
		if(str.length > len +2){
			return "<span title='" + str + "'>" + str.substring(0, len) + "...</span>";
		}else{
			return  str;
		}
	}
	
	//截取公司字符串，中间*号显示
	$.cutCompany = function(str){
		var len = 7;
		if(str == null || str == ""){
			return "";
		}
		if(str.length >= len ){
			return "<span>" + str.substring(0, 2)+"***"+str.substring(5, 7) + "***</span>";
		}else if (str.length>=5 && str.length<len){
			return "<span>" + str.substring(0, 2)+ "***</span>";
		}else{
			return  str;
		}
	}
	
	/*
	 返回字符串的字节数 一个汉字是2个字节   
	 */
	$.validateStrBytes =function(varStr) {
	    var count=0; 
	    for (var i = 0; i< varStr.length; i++) {     
		     if (varStr.charCodeAt(i) > 127 || varStr.charCodeAt(i) == 94) { 
		        count=count+2;   
		        } 
		     else { 
		        count=count+1;
		     }
	    } 
	    return count;
	} 

})(jQuery);
/**
 * 动态添加和删除行
 */
(function($){
	$.fn.dynTable = function(options) {
	options = $.extend(true, {
			tplid:  "",
			onBeforeDel:function(){
				return true;
			},
			onBeforeAdd:function(){
				return true;
			},
			onAfterDel:function(){
			},
			onAfterAdd:function(){
			}
	}, options);
	this.on('click',".addButton,.addRow",function(){
		var otr = $(this).parents("tr");
		if(options.onBeforeAdd()){
			otr.after($("#"+options.tplid).html());
			options.onAfterAdd();
		}
		
		
	});
	this.on('click',".delButton,.delRow",function(){
		var otr = $(this).parents("tr");
		if(options.onBeforeDel()){
			$(otr).remove();
			options.onAfterDel();
		}
	
		
	});
};
})(jQuery);
//合并display的表头
(function($){
	$.mergeTable=function (tableid,mergeobj){
	 	//mergeobj = [{col:'2,3,4,5',title:'合并'},{col:'6,7,8,9,10',title:'合并2'}];
		tableid=document.getElementById(tableid);;
		if(tableid && tableid.rows.length>0){
			var iColumns = tableid.rows[0].cells.length;
			var start=0;
			var th="";
			var delcell="";
			for(var i=0;i<mergeobj.length;i++){
				hbcol = mergeobj[i].col;
				if(hbcol!=""){
					hbtitle = mergeobj[i].title;
					stcol = hbcol.split(",")[0];
					colcount = hbcol.split(",").length;
					for(;start<stcol;start++){
						th=th+"<th rowspan=2>"+tableid.rows[0].cells[start].innerHTML+"</th>";
						delcell+=start+",";
					}
					th=th+"<th colspan="+colcount+">"+hbtitle+"</th>";
					start+=colcount;
		 		}
		 	}
			for(;start<iColumns;start++){
				th=th+"<th rowspan=2>"+tableid.rows[0].cells[start].innerHTML+"</th>";
				delcell+=start+",";
			}
			var tr = "<tr>"+th+"</tr>";
			//删除cell
			var delcell_ = delcell.split(",");
			for(var i=delcell_.length -1 ;i>=0;i--){
			  	if(delcell_[i]!=""){
			  		tableid.rows[0].removeChild(tableid.rows[0].cells[delcell_[i]]);//支持火狐、谷歌
			  		//tableid.rows[0].cells[delcell_[i]].removeNode();//removeNode 支持IE
			  	}
			}
			//new Insertion.Before(tableid.getElementsByTagName("tr")[0], tr); 
			$(tableid.getElementsByTagName("tr")[0]).before(tr);
		}
	}
})(jQuery);
/*
*用来实现displaytag中,鼠标经过一行,该行变色
*/  
var pre;
function highlightTableRows(tableId) {   
    var previousClass = null;   
    var table = document.getElementById(tableId);
    if(table==null||table==undefined||table==""){return;}
    var tbody = table.getElementsByTagName("tbody")[0];   
    if (tbody == null) {   
         rows = table.getElementsByTagName("tr");   
    } else {   
         rows = tbody.getElementsByTagName("tr");   
    }   
    for (i=0; i < rows.length; i++) {   
        rows[i].onmouseover = function() { 
        	if(this.style.backgroundColor!='#b8dcff' && this.style.backgroundColor!='#fdf5c7'){
        		this.style.backgroundColor="#fdf5c7";
        	}  
        };   
        rows[i].onmouseout = function() { 
	         if(this.style.backgroundColor!='#b8dcff' && this.style.backgroundColor!='#fdf5c7'
	        	&& this.style.backgroundColor!='rgb(184, 220, 255)'){
	        	 this.style.backgroundColor="";
	         }
         };   
        rows[i].onclick = function() { 
	        if(pre!=null){
	        	pre.style.backgroundColor="#fdf5c7"
	        }
	        pre=this;  
	        this.style.backgroundColor="#b8dcff";   
	        }   
    }   
}

//得到两个日期相关天数
$.dateDiff = function(ksrq,jsrq){
	var aDate, oDate1, oDate2, iDays;
    aDate = jsrq.split("-");
    oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);  //转换为12-18-2002格式
    aDate = ksrq.split("-");
    oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
    iDays = (oDate1 - oDate2) / 1000 / 60 / 60 /24;  //把相差的毫秒数转换为天数
    return iDays;
};


/**
 * 列标题排序
 * 使用方法：
 * 1、增加<thead id="tplSortHead"> ，
 * 2、在排序行增加 <th class="tpl-th-sort"><span class="tpl-sort" sortName="mc">标题名称</span></th>
 * 3、只能在searchForm的表单查询中使用
 * 4、如果原来页面上有orderBy，则必须加ID标记
 * 5、示例：
 * <table width="98%" border="0" cellpadding="0" cellspacing="0" class="list_table" align="center">
	<thead id="tplSortHead">
	<tr class="ls_table_th">
  		<th width="60">序号</th>
  		<th width="80">操作</th>
  		<th class="tpl-th-sort"><span class="tpl-sort" sortName="mc">名称</span></th>
  	</tr> 
  	</thead>
  	6、tplSortHead这个ID固定
 */
function tplHeadSort(){
	if(!$("#tplSortHead")){
		return;
	}
	
	var sort = $("#tplSortHead").attr("pagesort");
	var oldsortname = "";
	//判断有没有放orderBy
	var orderbyobj = $("#orderBy");
	var oldsort = "";
	var sortname = "";
	if(orderbyobj){
		sortname = $.trim($("#orderBy").val());
		if(sortname=="" || sortname.indexOf(" ")<0){
			//空着，不处理
		}else{
			var lastindex = sortname.lastIndexOf(" ");
			oldsort = $.trim(sortname.substring(lastindex).toLowerCase());
			var firstindex = sortname.indexOf(" ");
			oldsortname = sortname.substring(0,firstindex).toLowerCase();
		}
	}else{
		//在当前查询FORM表单中增加一个orderby隐藏域
		$("#searchForm" ).append("<input type='hidden' name='orderBy' id='orderBy'>");
	}
	
     $(".tpl-sort").each(function() {
		var mename = ($(this).attr("sortName")).toLowerCase();
		if(oldsortname == mename) {
			$(this).addClass("tpl-sort-" + oldsort);
		}
	}); 
     
    //绑定单击事件
    $("#tplSortHead").find(".tpl-th-sort").each(function() {
			var newsortname = $(this).find(".tpl-sort").attr("sortName");
			var newsort = (oldsort=="asc" ? "desc" : "asc" );
			$(this).click(function() {
				$("#orderBy").val(newsortname +" " + newsort);
				$("#searchForm").attr("from","searchButton");
				$("#searchForm").pageSearch();
			});
		});
}

function checkAll(checkallbox, checkbox_td){
	   if(checkallbox.checked){
		   $('input[type="checkbox"][name="'+checkbox_td+'"]').each(function(){
			   $(this).attr("checked",true);
		   });
	   }else{
		   $('input[type="checkbox"][name="'+checkbox_td+'"]').each(function(){
			   $(this).attr("checked",false);
		   });
	   }
}
function ifCheckAll(onechkx, checkbox_th){
	   var total = onechkx.length;
	   var checkedLen = 0;
	   if(onechkx.checked){
		   $(onechkx).each(function(){
			   if($(this).prop("checked")){
				   checkedLen++;
			   }
		   });
		   if(total==checkedLen){
			   $("#"+checkbox_th).attr("checked",true);
		   }else{
			   $("#"+checkbox_th).attr("checked",false);
		   }
	   }else{
		   $("#"+checkbox_th).attr("checked",false);
	   }
}

function getCheckedVal(checkbox_td){
	var str="";
	$('input[type="checkbox"][name="'+checkbox_td+'"]').each(function(){
		if($(this).prop("checked")){
			str += $(this).val()+",";
		}
	});
	if(str){
		str = str.substring(0,str.length-1);
	}
	return str;
}

//深度克隆对象
function deepClone(obj){
    var result,oClass=isClass(obj);
        //确定result的类型
    if(oClass==="Object"){
        result={};
    }else if(oClass==="Array"){
        result=[];
    }else{
        return obj;
    }
    for(key in obj){
        var copy=obj[key];
        if(isClass(copy)=="Object"){
            result[key]=arguments.callee(copy);//递归调用
        }else if(isClass(copy)=="Array"){
            result[key]=arguments.callee(copy);
        }else{
            result[key]=obj[key];
        }
    }
    return result;
}
//返回传递给他的任意对象的类
function isClass(o){
    if(o===null) return "Null";
    if(o===undefined) return "Undefined";
    return Object.prototype.toString.call(o).slice(8,-1);
}

/*
 * 同一页面多个form， 同一修改查询页数及每页个数
 */
function processForm(form, options){
	form.pageNum = $(form).find("input[id='"+options.pageNumInputName+"']");
	form.pageSize = $(form).find("input[id='"+options.pageSizeInputName+"']");
	if(form.pageNum){
		form.pageNum.attr("name", "pageNum");
	}
	if(form.pageSize){
		form.pageSize.attr("name", "pageSize");
	}
	return form;
}

//////////////////////////////////另外一种分页//////////////////
//分页的显示与隐藏
function selectOnePage(options){
	$("#pageForSelected").empty();
	$("#temp").toggle();
	//显示出的一共多少页
	var uljia=$("#pageForSelected");
	var page=parseInt($("#newPage").html());//获取当前的页数
	var pages=parseInt($("#allPages").html());//获取当前的总页数
	for(var i=1;i<=pages;i++){
		var H="<li  onclick='setPage("+i+","+pages+")'>"+i+"</li>";//添加一共多少页和点击事件
		uljia.append(H);
	}
	scrolltop(page);
	loadPage(page, options);
}
//点击分页显示的方法
function setPage(p1,p2){
	//var p=p1;
	$("#newPage").empty();
	$("#newPage").html(p1);//给显示的页数赋值
}
//分页的的上一页和下一页
function topclick(options){
	var v=document.getElementById("newPage");
	var num=v.innerHTML;
	if(num>1){
		num--;
		v.innerHTML=num;
		var hei=25*num-25;
		$("#temp").scrollTop(hei);
	}
	loadPage(num, options);
}
function downclick(options){
	var pages=parseInt($("#allPages").html());//获取当前的总页数
	var v=$("#newPage");
	var num=parseInt(v.html());
	if(num < pages){
		num = ++num;
		v.html(num);
		scrolltop(num);
	}
	loadPage(num, options);
}
//分页的的首页
function firstPage(options){
	var v=document.getElementById("newPage");
	v.innerHTML=1;
	scrolltop(v.innerHTML);
	loadPage(1, options);
}
//分页的的最后页
function lastPage(options){
	var v=document.getElementById("newPage");
	var l=document.getElementById("allPages");
	v.innerHTML=l.innerHTML;
	scrolltop(v.innerHTML);
	loadPage(l.innerHTML, options);
}
//滚动条
function scrolltop(top){
	var hei=25*top-25;
	$("#temp").scrollTop(hei);
}
//加载分页页面
function loadPage(currentPage, options){
	var params = JSON.parse(options);
	$("#"+params.pageNumInputName).val(currentPage);
	$("#"+params.pageSizeInputName).val($("#"+params.pageSizeInputName).val());
	$("#"+params.searchFormName).pageSearch(params);
}