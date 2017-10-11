/**
 * 定义对象集合
 */
var vt = vt || {};

/**
 * 更改easyui加载panel时的提示文字
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 */
$.extend($.fn.panel.defaults, {
    loadingMessage : '加载中....'
});

/**
 * 更改easyui加载grid时的提示文字
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 */
$.extend($.fn.datagrid.defaults, {
    loadMsg : '数据加载中....'
});

$.extend($.fn.window.defaults,{
	/**
	 * window显示时渲染金额格式化组件
	 */
	onOpen : function(){
	    // 解决改变窗口大小，弹出框无法选择的问题
		if ($("#framecenter", top.document).height()){ 
	        var frameHeight = $("#framecenter", top.document).height();
	        if (frameHeight < 400) {
	            $(this).window("resize", {
	                height : (frameHeight - 10)
	            });
	        } else {
	            $(this).window("resize", {
	                height : "auto"
	            });
	        }
		}
		$(this).find('.amtField').each(function(index, field) {
				if(!$(field).hasAmtfield()){
					$(field).amtfield();
					var hiddenid='#' + $(field).attr('id').substring(0,$(field).attr('id').length-5);
					$(hiddenid).change();
				}
				
			});
	}
});
/**
 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 * 
 */
$.extend($.fn.panel.defaults, {
	
    onBeforeDestroy : function() {
        var frame = $('iframe', this);
        try {
            if (frame.length > 0) {
                for (var i = 0; i < frame.length; i++) {
                    frame[i].src = '';
                    frame[i].contentWindow.document.write('');
                    frame[i].contentWindow.close();
                }
                frame.remove();
                if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
                    try {
                        CollectGarbage();
                    } catch (e) {
                    }
                }
            }
        } catch (e) {
        }
    }
});

/**
 * 防止panel/window/dialog组件超出浏览器边界
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 */
vt.onMove = {
    onMove : function(left, top) {
        var leftValue = left;
        var topValue = top;
        if (leftValue < 1) {
            leftValue = 1;
        }
        if (topValue < 1) {
            topValue = 1;
        }
        var width = parseInt($(this).parent().css('width')) + 14;
        var height = parseInt($(this).parent().css('height')) + 14;
        var right = leftValue + width;
        var buttom = topValue + height;
        var browserWidth = $(window).width();
        var browserHeight = $(window).height();
        if (right > browserWidth) {
            leftValue = browserWidth - width;
        }
        if (buttom > browserHeight) {
            topValue = browserHeight - height;
        }
        $(this).parent().css({/* 修正面板位置 */
            left : leftValue,
            top : topValue
        });
    }
};
//$.extend($.fn.dialog.defaults, vt.onMove);
//$.extend($.fn.window.defaults, vt.onMove);
//$.extend($.fn.panel.defaults, vt.onMove);

/**
 * 
 * 通用错误提示
 * 
 * 用于datagrid/treegrid/tree/combogrid/combobox/form加载数据出错时的操作
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 */
vt.onLoadError = {
    onLoadError : function(XMLHttpRequest) {
        if (parent.$ && parent.$.messager) {
            parent.$.messager.progress('close');
            parent.$.messager.alert('错误', XMLHttpRequest.responseText);
        } else {
            $.messager.progress('close');
            $.messager.alert('错误', XMLHttpRequest.responseText);
        }
    }
};
/**
 * $.extend($.fn.datagrid.defaults, vt.onLoadError); $.extend($.fn.treegrid.defaults, vt.onLoadError);
 * $.extend($.fn.tree.defaults, vt.onLoadError); $.extend($.fn.combogrid.defaults, vt.onLoadError);
 * $.extend($.fn.combobox.defaults, vt.onLoadError); $.extend($.fn.form.defaults, vt.onLoadError);
 */

/**
 * 扩展tree，添加新的功能
 * 
 * @author tiger.wang
 * 
 * @requires jQuery,EasyUI
 */
$.extend($.fn.tree.methods, {
    getCheckedExt : function(jq) {// 获取checked节点(包括实心)
        var checked = $(jq).tree("getChecked");
        var checkbox2 = $(jq).find("span.tree-checkbox2").parent();
        $.each(checkbox2, function() {
            var node = $.extend({}, $.data(this, "tree-node"), {
                target : this
            });
            checked.push(node);
        });
        return checked;
    },
    getSolidExt : function(jq) {// 获取实心节点
        var checked = [];
        var checkbox2 = $(jq).find("span.tree-checkbox2").parent();
        $.each(checkbox2, function() {
            var node = $.extend({}, $.data(this, "tree-node"), {
                target : this
            });
            checked.push(node);
        });
        return checked;
    }
});

/**
 * 扩展tree和combotree，使其支持平滑数据格式
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 * 
 */
vt.loadFilter = {
    loadFilter : function(data, parent) {
        var opt = $(this).data().tree.options;
        var idField, textField, parentField;
        if (opt.parentField) {
            idField = opt.idField || 'id';
            textField = opt.textFiled || 'text';
            parentField = opt.parentField || 'pid';
            var i, l, treeData = [], tmpMap = [];
            for (i = 0, l = data.length; i < l; i++) {
                tmpMap[data[i][idField]] = data[i];
            }
            for (i = 0, l = data.length; i < l; i++) {
                if (tmpMap[data[i][parentField]] && data[i][idField] != data[i][parentField]) {
                    if (!tmpMap[data[i][parentField]]['children'])
                        tmpMap[data[i][parentField]]['children'] = [];
                    data[i]['text'] = data[i][textField];
                    tmpMap[data[i][parentField]]['children'].push(data[i]);
                } else {
                    data[i]['text'] = data[i][textField];
                    treeData.push(data[i]);
                }
            }
            return treeData;
        }
        return data;
    }
};
$.extend($.fn.combotree.defaults, vt.loadFilter);
$.extend($.fn.tree.defaults, vt.loadFilter);

/**
 * 扩展treegrid，使其支持平滑数据格式
 * 
 * @author tiger.wang
 * 
 * @requires jQuery,EasyUI
 * 
 */
$.fn.treegrid.defaults.loadFilter = function(data, parentId) {
    var opt = $(this).data().treegrid.options;
    var idFiled, textFiled, parentField;

    if (opt.parentField) {
        idFiled = opt.idField || 'id';
        textFiled = opt.textFiled || 'text';
        parentField = opt.parentField;
        var i, l, treeData = [], tmpMap = [];
        for (i = 0, l = data.length; i < l; i++) {
            tmpMap[data[i][idFiled]] = data[i];
        }
        for (i = 0, l = data.length; i < l; i++) {
            if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
                if (!tmpMap[data[i][parentField]]['children'])
                    tmpMap[data[i][parentField]]['children'] = [];
                data[i]['text'] = data[i][textFiled];
                tmpMap[data[i][parentField]]['children'].push(data[i]);
            } else {
                data[i]['text'] = data[i][textFiled];
                treeData.push(data[i]);
            }
        }
        return treeData;
    }
    return data;
};

/**
 * 扩展tree，使其支持左键点击描述自动展开/折叠节点
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 * 
 */
(function($, undefined) {

    $.extend($.fn.tree.defaults, {
        // 扩展 easyui-tree 的自定义属性，表示当左键点击带有子节点的条目时，是否自动展开/折叠相应节点。
        // Boolean 类型，默认为 false。
        // 备注：该功能不会影响到 easyui-tree 的原生事件 onClick。
        toggleOnClick : false
    });

    /**
     * 绑定点击事件
     */
    function initAutoToggle(treeObj, opts) {
        var exts = opts._extensions ? opts._extensions : opts._extensions = {};
        if (exts._initialized) {
            return;
        }
        exts.onClickBak = opts.onClick;
        opts.onClick = function(node) {
            if ($.isFunction(exts.onClickBak)) {
                exts.onClickBak.apply(this, arguments);
            }
            if (opts.toggleOnClick) {
                treeObj.tree("toggle", node.target);
            }
        };
        exts._initialized = true;
    }

    /**
     * 扩展Tree默认loader事件
     */
    vt.loader = {
        loader : function(param, success, error) {
            var treeObj = $(this);
            var opts = treeObj.tree("options");
            initAutoToggle(treeObj, opts);
            if (!opts.url) {
                return false;
            }
            $.ajax({
                type : opts.method,
                url : opts.url,
                data : param,
                dataType : "json",
                success : function(data) {
                    success(data);
                },
                error : function() {
                    error.apply(this, arguments);
                }
            });
        }
    };

    $.extend($.fn.tree.defaults, vt.loader);

})(jQuery);

/**
 * 扩展combobox，使其有默认选项
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 * 
 */
(function($, undefined) {

    // 给数据添加默认选项
    function unshiftData(data, opts) {
        if (data.length > 0) {
            var tempArray = new Array();
            var defaultJson = {};
            var defaultValue = "请选择";
            if (vt.comboboxDefaultValueKey) {
                defaultValue = getMessage(vt.comboboxDefaultValueKey);
            }
            eval("defaultJson." + opts.valueField + " = ''");
            eval("defaultJson." + opts.textField + " = '" + defaultValue + "'");
            tempArray.push(defaultJson);
            data = tempArray.concat(data);
        }
        return data;
    }

    $.extend($.fn.combobox.defaults, {
        // 扩展 easyui-combobox 的自定义属性，表示是否使用默认值。
        // Boolean 类型，默认为 true。
        useDefault : true
    });

    vt.loadFilter = {
        loadFilter : function(data) {
            data = $.extend(true, [], data);
            var opts = $(this).combobox('options');
            var valueField = opts.valueField;
            var textField = opts.textField;
            if (vt.defaultCcyValueField == valueField && vt.defaultCcyTextField == textField) {
                // opts.useDefault = false;
                if ($.string.isNullOrEmpty($(this).combobox("getValue"))) {
                    $(this).combobox("setValue", vt.defaultCcyid);
                }
            }
            if (opts.useDefault) {
                data = unshiftData(data, opts);
            }
            return data;
        }
    };

    $.extend($.fn.combobox.defaults, vt.loadFilter);

})(jQuery);

/**
 * 创建一个模式化的dialog
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 * 
 */
vt.modalDialog = function(options) {
    var opts = $.extend({
        title : '&nbsp;',
        width : 640,
        height : 480,
        modal : true,
        onClose : function() {
            $(this).dialog('destroy');
        }
    }, options);
    opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数

    if (options.url) {
        opts.content = '<iframe id="" src="'
                + options.url
                + '" allowTransparency="true" scrolling="auto" width="100%" height="98%" frameBorder="0" name=""></iframe>';
    }
    return $('<div/>').dialog(opts);
};

$.modalDialog = function(options) {
    if ($.modalDialog.handler == undefined) {// 避免重复弹出
        var opts = $.extend({
            title : '',
            width : 840,
            height : 680,
            modal : true,
            onClose : function() {
                $.modalDialog.handler = undefined;
                $(this).dialog('destroy');
            },
            onOpen : function() {

            }
        }, options);
        opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
        return $.modalDialog.handler = $('<div/>').dialog(opts);
    }
};

/**
 * 等同于原form的load方法，但是这个方法支持{data:{name:''}}形式的对象赋值
 */
$.extend($.fn.form.methods, {
    loadData : function(jq, data) {
        return jq.each(function() {
            load(this, data);
        });

        function load(target, data) {
            if (!$.data(target, 'form')) {
                $.data(target, 'form', {
                    options : $.extend({}, $.fn.form.defaults)
                });
            }
            var opts = $.data(target, 'form').options;

            if (typeof data == 'string') {
                var param = {};
                if (opts.onBeforeLoad.call(target, param) == false) {
                    return;
                }

                $.ajax({
                    url : data,
                    data : param,
                    dataType : 'json',
                    // cache : false,
                    success : function(data) {
                        _load(data);
                    },
                    error : function() {
                        opts.onLoadError.apply(target, arguments);
                    }
                });
            } else {
                _load(data);
            }

            function _load(data) {
                var form = $(target);
                var formFields = form.find("input[name],select[name],textarea[name]");
                formFields.each(function() {
                    var name = this.name;
                    var value = jQuery.proxy(function() {
                        try {
                            return eval('this.' + name);
                        } catch (e) {
                            return "";
                        }
                    }, data)();
                    // 如果json中未定义对应字段，则不作赋值
                    if (value == undefined) {
                        return;
                    }
                    var rr = _checkField(name, value);
                    if (!rr.length) {
                        var f = form.find("input[numberboxName=\"" + name + "\"]");
                        if (f.length) {
                            f.numberbox("setValue", value);
                        } else {
                            $("input[name=\"" + name + "\"]", form).val(value).change();
                            $("textarea[name=\"" + name + "\"]", form).val(value).change();
                            $("select[name=\"" + name + "\"]", form).val(value).change();
                        }
                    }
                    _loadCombo(name, value);
                });
                opts.onLoadSuccess.call(target, data);
                $(target).form("validate");
            }

            function _checkField(name, val) {
                var rr = $(target).find(
                        'input[name="' + name + '"][type=radio], input[name="' + name + '"][type=checkbox]');
                rr._propAttr('checked', false);
                rr.each(function() {
                    var f = $(this);
                    // 兼容逗号拼接的checkbox值,mod by oscar 2016-8-19 14:07:59
                    if ($.string.isString(val) && val.contains(",")) {
                        val = val.split(",");
                    }
                    if (f.val() == String(val) || ($.isArray(val) && $.inArray(f.val(), val) >= 0)) {
                        f._propAttr('checked', true);
                    }
                });
                return rr;
            }

            function _loadCombo(name, val) {
                var form = $(target);
                var cc = [ 'combobox', 'combotree', 'combogrid', 'datetimebox', 'datebox', 'combo', 'searchbox' ];
                var c = form.find('[comboName="' + name + '"]');
                if (c.length) {
                    for (var i = 0; i < cc.length; i++) {
                        var type = cc[i];
                        if (c.hasClass(type + '-f')) {
                            if (c[type]('options').multiple) {
                                c[type]('setValues', val);
                            } else {
                                c[type]('setValue', val);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
});

/**
 * 扩展jQuery easyui datagrid增加动态改变列编辑的类型
 * 为password字段添加一个editor
 * $("#gridId").datagrid('addEditor', {
        field : 'password',
        editor : {
            type : 'validatebox',
            options : {
                required : true
            }
        }
    });
 * 删除password的editor
 * $("#gridid").datagrid('removeEditor', 'password');
 * 注：两个方法，第二个参数都可以传递数组。                 
 */
$.extend($.fn.datagrid.methods, {
    addEditor : function(jq, param) {
        if (param instanceof Array) {
            $.each(param, function(index, item) {
                var e = $(jq).datagrid('getColumnOption', item.field);
                e.editor = item.editor;
            });
        } else {
            var e = $(jq).datagrid('getColumnOption', param.field);
            e.editor = param.editor;
        }
    },
    removeEditor : function(jq, param) {
        if (param instanceof Array) {
            $.each(param, function(index, item) {
                var e = $(jq).datagrid('getColumnOption', item);
                e.editor = {};
            });
        } else {
            var e = $(jq).datagrid('getColumnOption', param);
            e.editor = {};
        }
    },
    // 显示遮罩
    loading : function(jq) {
        // return jq.each(function(){
        // $(this).datagrid("getPager").pagination("loading");
        // var opts = $(this).datagrid("options");
        // var wrap = $.data(this,"datagrid").panel;
        // if(opts.loadMsg) {
        // $("<div
        // class=\"datagrid-mask\"></div>").css({display:"block",width:wrap.width(),height:wrap.height()}).appendTo(wrap);
        // $("<div
        // class=\"datagrid-mask-msg\"></div>").html(opts.loadMsg).appendTo(wrap).css({display:"block",left:(wrap.width()-$("div.datagrid-mask-msg",wrap).outerWidth())/2,top:(wrap.height()-$("div.datagrid-mask-msg",wrap).outerHeight())/2});
        // }
        // });
    },
    // 隐藏遮罩
    loaded : function(jq) {
        // return jq.each(function(){
        // $(this).datagrid("getPager").pagination("loaded");
        // var wrap = $.data(this,"datagrid").panel;
        // wrap.find("div.datagrid-mask-msg").remove();
        // wrap.find("div.datagrid-mask").remove();
        // });
    }
});

/**
 * easyUI 中的datagrid 默认只支持以下几种类型的editor： text、textarea、checkbox、numberbox、validatebox、datebox、combobox、combotree。
 * 扩展datagrid中支持类型
 */
$.extend($.fn.datagrid.defaults.editors, {
    wdatebox : {
        init : function(container, options) {
            var input = $('<input type="text" class="inputTextM Wdate" onfocus="javascript:Wdate();" />').appendTo(
                    container);
//            options.onChange && input.change(options.onChange);
//            options.onBlur && input.blur(options.onBlur);
//            input.focus(function() { 
//            	WdatePicker(options); 
//        	});
            //options.id && input.attr('id', id);
            return input;
        },
        destroy : function(target) {
            $(target).remove();
        },
        getValue : function(target) {
            return $(target).val();
        },
        setValue : function(target, value) {
            if (!$.string.isNullOrWhiteSpace(value)) {
                value = $.date.format(value);
            }
            $(target).val(value);
        },
        resize : function(target, width) {
            $(target)._outerWidth(width);
        }
    },
    amtbox : {
        init : function(container, options) {
            var input = $('<input type="text" class="inputText amtText" />').appendTo(container);
            return input;
        },
        destroy : function(target) {
            $(target).remove();
        },
        getValue : function(target) {
            return $(target).val();
        },
        setValue : function(target, value) {
            $(target).val(value);
        },
        resize : function(target, width) {
            $(target)._outerWidth(width);
        }
    },
    radiobox : {
        init : function(container, options) {
            var resource = options.data;
            if ($.string.isNullOrEmpty(resource)) {
                resource = options.url;
            }
            var html = createRadioHtml(resource, '', options.name + '' + Math.random(), '', 0, options.valueField,
                    options.textField);
            var input = $(html).appendTo(container);
            return input;
        },
        destroy : function(target) {
            $(target).remove();
        },
        getValue : function(target) {
            var value = $(target).parent().find(":radio:checked").val();
            if ($.string.isNullOrEmpty(value)) {
                value = "";
            }
            return value;
        },
        setValue : function(target, value) {
            $(target).parent().find(":radio[value=" + value + "]").attr("checked", true);
        },
        resize : function(target, width) {
            $(target)._outerWidth(width);
        }
    }
});

/**
 * 扩展DataGrid的默认属性
 */
$.extend($.fn.datagrid.defaults,{
	pageList:[15,20,50,80,100,200]
});

/**
 * 更换主题
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 * 
 * @param themeName
 *            更换的主题代号
 */
vt.changeTheme = function(themeName) {
    var $easyuiTheme = $('#easyui_theme');
    var $easyuiLinkbutton = $('#easyui_linkbutton');
    var themeUrl = $easyuiTheme.attr('href');
    //var linkbuttonUrl = $easyuiLinkbutton.attr('href');
    var themeHref = themeUrl.substring(0, themeUrl.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
    // var linkbuttonHref = linkbuttonUrl.substring(0,linkbuttonUrl.indexOf('themes')) + 'themes/' + themeName + '/linkbutton.css';
    $easyuiTheme.attr('href', themeHref);
    // $easyuiLinkbutton.attr('href', linkbuttonHref);

    var $iframe = $('iframe');
    if ($iframe.length > 0) {
        for (var i = 0; i < $iframe.length; i++) {
            var ifr = $iframe[i];
            try {
                $(ifr).contents().find('#easyui_theme').attr('href', themeHref);
                // $(ifr).contents().find('#easyui_linkbutton').attr('href',
                // linkbuttonHref);
            } catch (e) {
                try {
                    ifr.contentWindow.document.getElementById('easyui_theme').href = themeHref;
                    // ifr.contentWindow.document.getElementById('easyui_linkbutton').href
                    // = linkbuttonHref;
                } catch (e) {
                }
            }
        }
    }

    $.cookie('theme', themeName, {
        expires : 7,
        path : '/' // 默认系统全路径
    });
};

/**
 * 设置datagrid默认属性
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 * 
 */
vt.setDatagrid = function() {
    var defaults = {
        rownumbers : true,
        height : 'auto',
        //fitColumns : true,
        striped : true,
        remoteSort : true,
        multiSort : true,
        collapsible : false,
        singleSelect : true,
        checkOnSelect : true,
        onLoadSuccess : function() {
            // 优化性能，当存在需要权限控制的资源时才处理
            var suffixUrl = $("a[suffix]");
            if (suffixUrl != null && suffixUrl.length > 0) {
                TraversalBtns();// 权限控制
            }
            // 当页面调用viewModel()方法时，datagrid不开启编辑状态
            if (!vt.VIEW_MODEL) {
            	// 优化性能，当存在编辑框时才处理
                var hasEditor = false;
                var editors = $(this).find("th[data-options*='editor']");
                if (null != editors && editors.length > 0) {
                    hasEditor = true;
                }
                // 解决从js构建datagrid的方式
                if (!hasEditor) {
                    var columns = $(this).datagrid("options").columns[0];
                    for (var index = 0; index < columns.length; index++) {
                        var column = columns[index];
                        if (column.editor) {
                            hasEditor = true;
                        }
                    }
                }
                if (hasEditor) {
                    var rows = $(this).datagrid('getRows');
                    for (var rowIndex = 0; rowIndex < rows.length; rowIndex++) {
                        $(this).datagrid('beginEdit', rowIndex);
                        $(this).datagrid('options')['onEachRowLoad'](rowIndex);
                    }
                }
            }
            // this function will be called after onLoadSuccess
            $(this).datagrid('options')['onLoadSuccessCustom']();
        },
        onEachRowLoad : function() {
            // this function will be called after onLoadSuccess
        },
        onLoadSuccessCustom : function() {
            // this function will be called after onLoadSuccess
        }
    };
    return defaults;
};

/**
 * 设置datagrid默认属性(默认不打开编辑模式)
 * 
 * @author oscar.yu
 * 
 * @requires jQuery,EasyUI
 * 
 */
vt.setNoOpenEditorDatagrid = function() {
    var defaults = {
        rownumbers : true,
        height : 'auto',
        fitColumns : true,
        striped : true,
        remoteSort : true,
        multiSort : true,
        collapsible : false,
        singleSelect : true,
        checkOnSelect : true,
        onLoadSuccess : function() {
            TraversalBtns();// 权限控制
            // this function will be called after onLoadSuccess
            $(this).datagrid('options')['onLoadSuccessCustom']();
        },
        onEachRowLoad : function() {
            // this function will be called after onLoadSuccess
        },
        onLoadSuccessCustom : function() {
            // this function will be called after onLoadSuccess
        }
    };
    return defaults;
};

/**
 * 在DataGrid中生成一个空的radio框
 */
vt.createRadio = function(value, rowData, rowIndex) {
    var html = '';
    html += "<input type=\"radio\" name=\"blankRadio\" value=\"\"  ";
    html += "></input>";
    return html;
};

/** ******Datagrid 格式化 Begin************* */
/**
 * 格式化日期
 */
vt.formatDate = function(value, rowData, rowIndex) {
    if (value == "" || value == null) {
        return;
    }
    return $.date.format(value, 'yyyy-MM-dd');
};

/**
 * 格式化日期带时间
 */
vt.formatLongDate = function(value, rowData, rowIndex) {
    if (value == "" || value == null) {
        return;
    }
    return $.date.format(value, 'yyyy-MM-dd HH:mm:ss');
};

/**
 * 格式化数字 将数字格式化成金额
 * 
 * @value 值(原始值)
 * @rowData 当前行数据
 * @rowIndex 当前行索引(从0开始) 12345格式化为12,345.00 12345.6格式化为12,345.60 12345.67格式化为 12,345.67
 */
vt.formatNumber = function(value, rowData, rowIndex) {
    if (isNaN(value)) {
        return "0";
    }
    return applyPattern(value, '###,###,###,##0.00');
};

/**
 * 格式化数字 将数字格式化成金额
 * 
 * @value 值(原始值)
 * @rowData 当前行数据
 * @rowIndex 当前行索引(从0开始) 12345格式化为12,345.00 12345.6格式化为12,345.60 12345.67格式化为 12,345.67
 */
vt.formatNumberByCcyId = function(value, rowData, rowIndex, ccyid) {
    if (isNaN(value)) {
        return "0";
    }
    return getAmtDsipFmtByValue(ccyid, value);
};

/**
 * 格式化比例字段(字段为真实值)
 * 
 * @param value
 * @param rowData
 * @param rowIndex
 * @returns {Number} 真实值*100
 */
vt.formatPercent = function(value, rowData, rowIndex) {
	if (($.string.isNullOrEmpty(value)) || (!$.string.isNumeric(value))) {
        return "";
    }
    return applyPattern(value * 100, '###########0.00') + '%';
};

/**
 * 根据指定格式格式化比例字段(字段为真实值)
 * 
 * @param value
 * @param rowData
 * @param rowIndex
 * @returns {Number} 真实值*100
 */
vt.formatPercentByPattern = function(value, rowData, rowIndex, pattern) {
	if (($.string.isNullOrEmpty(value)) || (!$.string.isNumeric(value))) {
        return "";
    }
    return applyPattern(value * 100, pattern) + '%';
};

/**
 * 格式化比例字段(字段为真实值*100)
 * 
 * @param value
 * @param rowData
 * @param rowIndex
 * @returns {Number}
 */
vt.formatPagePercent = function(value, rowData, rowIndex) {
	if (($.string.isNullOrEmpty(value)) || (!$.string.isNumeric(value))) {
        return "";
    }
    return applyPattern(value, '###########0.00') + '%';
};

/** ******Datagrid 格式化 End************* */

/**
 * 解决IE10 required
 */
(function($, undefined) {
    $.fn.isRequired = function() {
        var required;
        if (true) {
            required = $(this).attr("required");
            if (required === undefined || required === false) {
                return undefined;
            }
            return "required";
        } else { // IE6, IE7
            var outer = $(this).get(0).outerHTML, part = outer.slice(0, outer.search(/\/?['"]?>(?![^<]*<['"])/));
            return /\srequired\b/i.test(part) ? "required" : undefined;
        }
    };
})(jQuery);
$(".amtText").isRequired(); // required或undefined

/**
 * 扩展combox属性，不能编辑、不能多选 自适应高度
 */
vt.comboboxDefault = {
    editable : false,
    multiple : false,
    panelHeight : 'auto'
};
$.extend($.fn.combobox.defaults, vt.comboboxDefault);
