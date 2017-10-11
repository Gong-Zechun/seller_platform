<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="language" value="${cookie.LocaleLanguage.value}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<title>传神决策分析系统-登录</title>
	<%@ include file="pages/common/include.jsp"%>
	<link href="jslib/login/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
	<link href="jslib/login/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="css/login.css" />
	<script type="text/javascript" src="jslib/login/js/jquery.SuperSlide.js" charset="utf-8"></script>
	<script type="text/javascript" src="scripts/js/login.js" charset="utf-8"></script>
	<script>
	$(function(){
		var winH = $(window).height();
		$(".login").height(winH);
	});
	</script>
</head>

<body>
	<div>
	    <c:if test="${not empty param.error}">
	        <div class="errorblock" id="showErrorMes" style="display: none">
	            ${SPRING_SECURITY_LAST_EXCEPTION}
	        </div>
	    </c:if>
	</div>
	<div class="login">
		<div class="login-bg areaheart">
		<div class="error-box"></div>
			<div class="login-form">
				<form id="login" name="loginForm" class="registerform" method="post" action="/j_spring_security_check">
				<div class="txtbox">
					<span>用户名:</span>
					<input type="text" id ="username" name="j_username" placeholder="请输入用户名"/>
				</div>
				<div class="txtbox">
					<span>密码:</span>
					<input type="password" id ="password" name="j_password" placeholder="请输入密码"/>
				</div>
				<div class="txtbox code fm-item">
					<span>验证码:</span>
					<input type="text" id="validateCode" name="validateCode" value="" class="i-text" placeholder="请输入验证码"/>
					<img id="imgCode" align="absmiddle" style="width: 84px;height: 30px;"/>
				</div>
				<div class="txtbox fm-item">
					 <input id="loginButton" type="button" tabindex="4" id="send-btn" style="width:220px;height:36px;color:#fff;  background:#0081cf; border:none; margin: 0 auto; margin-left:60px; margin-top:10px;" value="登录"/> 
				</div>
				</form>
			</div>
			
		    <div class="copyright"><span><font color="black">Copyright 2007~2017©传神语联网网络科技股份有限公司 版权所有</font></span></div>
		</div>

	</div>
</body>
</html>