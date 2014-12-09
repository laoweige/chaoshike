<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
        <meta http-equiv="pragma" content="no-cache" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<meta content="telephone=no" name="format-detection" />
	<link rel="stylesheet" type="text/css" href="/phone/wap/product/style/base.css?v=2.4.4">
	<link rel="stylesheet" type="text/css" href="/phone/wap/product/style/yg2.css?v=20140708">

</head>
<body>
<form  name="Logon"  method="post" action="" id="Logon">
	<input type="hidden" name="uuid" value="2406c3c7-f40c-4795-a80d-901dcf0c7cd8" />
	<input type='hidden' id='secPassword' name='secPassword' />
 <!-- 公用头部导航 -->
<div class="sn-nav">
	<div class="sn-nav-back"><a href="javascript:history.back(1)">返回</a></div>
	<div class="sn-nav-title of">用户登录</div>
</div>
<div class="member-wrap mt15">
	<div class="yg-register-item">
		<div class="yg-border-ui yg-bom-n pr">
			<div class="wbox">
				<span class="yg-label"><em class="yg-input-ico yg-usr"></em></span>
				<div class="wbox-flex pr pr30">
					<input name="username" id="username"   type="text" class="sn-input-text-d f12" placeholder="用户名:手机/邮箱/昵称"/>
           			<em class="yg-arrow-down"  style="display:none;"><i class="yg-arrow-hover"></i></em>
				</div>
			</div>
			<ul class="yg-record-list hide">
			</ul>
		</div>
		<div class="yg-border-ui yg-bot-n">
			<div class="wbox ">
				<span class="yg-label"><em class="yg-input-ico yg-pas"></em></span>
				<div class="wbox-flex pr pr65">
					<div class="yg-pass-box">
						<input type="text" id="passwordtext" class="sn-input-text-d f12 hide" maxlength="20"  placeholder="密码"/>
						<input name="password" id="password" type="password"  class="sn-input-text-d f12" maxlength="20"  placeholder="密码"/>
					</div>
					<em id="clearpsd" class="yg-input-close"></em>
					<em class="yg-show-pass"></em>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="pd-c a4">您输入的账号名与密码不匹配</div> -->

	<div id="imageVerifyArea" style="display: none" class="wbox yg-yzm-box mt15">
		<div class="wbox-flex pr yg-input-box">
			<input type="text" name="verifyCode" id="verifyCode" class="sn-input-text-d f12" placeholder="请输入验证码" />
			<em class="yg-input-close"></em>
		</div>
		<div class="yg-yzm-btn">
			<img id="vcodeimg1" src="" onclick="fun_getVcode()" />
			<!-- <span class="gray-bg">获取验证码</span> -->
			<!--	<span class="a3">获取验证码</span>-->
		</div>
	</div>

	<!-- <div class="pd-c a4">您输入的验证码错误</div> -->
	<div class="pd15 mt15">
		<div id="logonbtn" class="sn-btn-f block" ><a href="javascript:void(0);" id="login">登录</a></div>
		<!-- <div class="sn-btn-d block" >登录</div> -->
		<p class="mt10 a3"><a id="register"   href="javascript:void(0)">快速注册</a></p>
	</div>
</div>
</form>

<input type="hidden" id="resourceType" value="wap">
<script src="/phone/jquery.min.js"></script>
	<script src="/phone/wap/product/script/base.js?v=2.4.4"></script>


<script type="text/javascript" src="/phone/wap/product/script/yg.js?v=20140708"></script>

</body>
</html>