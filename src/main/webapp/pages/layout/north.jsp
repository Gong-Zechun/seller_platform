<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="language" value="${cookie.LocaleLanguage.value}"/>
<script type="text/javascript" src="../../scripts/pages/layout/north.js"></script>
<div id="header" class="header">
    <div id="logo" class="headerTable">
        <div class="headerRow">
            <div class="headerLogo">
                <img src="../../images/logo_transn_bi.png"/>
            </div>
            <div class="headerLoginInfo">
            	<c:if test="${empty sysUser}">
            		<span><font color="red">您还没有登录，请先<a href="">登录</a>再访问页面！</font></span>
            	</c:if>
            	<c:if test="${not empty sysUser}">
			   		<span>用户名</span>：<span id="userName">${sysUser.loginName }</span>
			    </c:if>
			</div>
        </div>
    </div>
	<div id="toolBar" class="panel-header panel-header-noborder top-toolbar">
		<div class="header-left">
		</div>
		<div class="header-setting">
			<a href="javascript:goHome();" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-house'"><span>主页</span></a>
			<!-- <a id="editPassword" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-cog'"><span>修改密码</span></a> -->
            <a href="logout" class="easyui-linkbutton" id="logoutButton" data-options="plain:true,iconCls:'ext-icon-disconnect'"><span>退出系统</span></a>			
			<a href="#" class="easyui-menubutton" data-options="menu:'#skin',iconCls:'ext-icon-rainbow'"><span>更换皮肤</span></a>
			<a onclick="launchFullscreen(document.documentElement);" class="easyui-linkbutton" data-options="plain:true,iconCls:'ext-icon-full_screen'"></a>
			<a id="btnHideNorth" class="easyui-linkbutton" data-options="plain: true, iconCls: 'layout-button-up'"></a>
			<a id="btnShowNorth" class="easyui-linkbutton" data-options="plain: true, iconCls: 'layout-button-down'" style="display:none"></a>
		</div>
	</div>
</div>
<div id="skin">
	<div id="default" class="settingSkin">天空蓝(默认)</div>
	<div id="gray" class="settingSkin">灰色</div>
	<div id="black" class="settingSkin">金属黑</div>
	<div id="metro" class="settingSkin">磁铁(标准)</div>
	<div id="bootstrap" class="settingSkin">银色</div>
</div>
