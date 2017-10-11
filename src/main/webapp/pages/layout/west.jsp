<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function() {
	    // showMenutree();
	    // 默认显示所有菜单
	    showAllMenutree();
	});
	
	//刷新菜单
	function showMenutree(){
	    $("#menutree").tree({
			animate : true,
			lines : true,
			parentField : "pid",
			//buttonFlag=0 加载菜单时无需抓取按钮
			url : "services/sec/resource/getSonsByFunid?funid=" + vt.clickFunid+"&buttonFlag=0",
			method : "get",
			toggleOnClick : true, //自定义属性，表示当左键点击带有子节点的条目时，是否自动展开/折叠相应节点
			onClick : function(node) {
				if (node.attributes != null) {
				    if(node.attributes.url){
				        refreshCenter(node.attributes.url);
				    }
					if(node.attributes.position){
					    refreshPosition(node.attributes.position);
					}
				}
			}
		});
	}
	
	//刷新center区域内容
	function refreshCenter(url){
	    //$(".center").panel({region : 'center',href : url}); 
	    //$(".center").panel('refresh'); 
	    $("#home").attr("src", url);
	}
	
	//刷新center所在位置内容
	function refreshPosition(position){
	    //$(".center").panel("setTitle",getMessage("所在位置") + "：" + node.attributes.position); 
	    $("#framecenter").panel("setTitle",getMessage("所在位置") + "：" + getMessage(position));
	}
	
</script>
<div class="west" style="overflow:visible">
	<ul id="menutree"></ul> 
</div>