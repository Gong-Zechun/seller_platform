<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>主页</title>
	<%@ include file="../common/include.jsp"%>
	<%-- 引入EasyUI Portal插件 --%>
	<link rel="stylesheet" href="../../jslib/jquery-easyui-portal/portal.css" type="text/css">
	<script type="text/javascript" src="../../jslib/jquery-easyui-portal/jquery.portal.js" charset="utf-8"></script>
	<script type="text/javascript" charset="utf-8">
		var portalLayout;
		var portal;
		$(function() {
			portalLayout = $('#portalLayout').layout({
				fit : true
			});
			
			$(window).resize(function() {
				portalLayout.layout('panel', 'center').panel('resize', {
					width : 1,
					height : 1
				});
			});
	
			panels = [ {
				id : 'p1',
				title : '我的工作台',
				height : 600,
				width:800,
				collapsible : true,
				href : '${path}/pages/portal/mywork.jsp'
			}, {
				id : 'p2',
				title : '统计监控',
				height : 225,
				collapsible : true,
				href : '${path}/pages/portal/warning.jsp'
			}, {
				id : 'p3',
				title : '系统公告栏',
				height : 225,
				collapsible : true,
				href : '${path}/pages/portal/notice.jsp'
			} ];
	
			portal = $('#portal').portal({
				border : false,
				fit : true,
				onStateChange : function() {
					$.cookie('portal-state', getPortalState(), {
						expires : 7
					});
				}
			});
			//var state = $.cookie('portal-state');
			var state = null;
			if (!state) {
				//state = 'p1:p2,p3';/*冒号代表列，逗号代表行*/
				state = 'p1';
			}
			addPortalPanels(state);
			portal.portal('resize');
		});
	
		// 根据id获取panel
		function getPanelOptions(id) {
			for ( var i = 0; i < panels.length; i++) {
				if (panels[i].id == id) {
					return panels[i];
				}
			}
			return undefined;
		}
		
		// 获取Portal中的panel状态
		function getPortalState() {
			var aa = [];
			for ( var columnIndex = 0; columnIndex < 2; columnIndex++) {
				var cc = [];
				var panels = portal.portal('getPanels', columnIndex);
				for ( var i = 0; i < panels.length; i++) {
					cc.push(panels[i].attr('id'));
				}
				aa.push(cc.join(','));
			}
			return aa.join(':');
		}
		
		// 按照规则添加panel到Portal中
		function addPortalPanels(portalState) {
			var columns = portalState.split(':');
			for ( var columnIndex = 0; columnIndex < columns.length; columnIndex++) {
				var cc = columns[columnIndex].split(',');
				for ( var j = 0; j < cc.length; j++) {
					var options = getPanelOptions(cc[j]);
					if (options) {
						var p = $('<div/>').attr('id', options.id).appendTo('body');
						p.panel(options);
						portal.portal('add', {
							panel : p,
							columnIndex : columnIndex
						});
						//禁用拖拽
						portal.portal('disableDragging',p);
					}
				}
			}
		}
	</script>
	<style type="text/css">
	.li {
	  margin-top: 10px;
	}
	a:link{text-decoration:none;}
	a:hover{text-decoration:underline;color: #C20C0C;}
	</style>
</head>
<body>
	<div id="portalLayout">
		<div data-options="region:'center',border:false">
			<div id="portal" style="position: relative">
				<div></div>
				<div></div>
			</div>
		</div>
	</div>
</body>
</html>