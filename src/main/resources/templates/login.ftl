<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="apple-touch-fullscreen" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="keywords" content="">
	<meta name="description" content="。">
	<meta name="author" content="AUI, a-ui.com">
	<title>登录</title>
	<link rel="icon" type="image/x-icon" href="favicon.ico">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/home.css">
    <script  src="/js/jquery1.8.3.min.js"></script>
</head>
<body>

	<!-- logo begin -->
		<div class="aui-head-logo">
			<a href="index.html" title="北京四彩云网络科技有限公司" target="_blank"><img src="img/icon/logo.svg" alt="logo图片"></a>
		</div>
	<!-- logo end -->

	<!-- content begin -->
		<div class="aui-login-box">
			<div class="aui-login-info">
				<form id="loginForm" action="/admin/generateKey.do" method="post">
                    <div class="aui-login-input"><input id="username" name="username" type="text" placeholder="邮箱或手机号"></div>
                    <div class="aui-login-input"><input  id="password" name="password" type="password" placeholder="密码"></div>
                    <div class="aui-login-remember">
                        <label><input type="checkbox" checked="checkbox">记住账户</label>
                        <a href="#">忘记密码</a>
                    </div>
                    <div class="aui-login-btn">
                        <a href="javascript:void(0)" onclick="submit()">登&nbsp;;录</a>

                    </div>
                    <div class="aui-login-register">
                        还没有账号？<a href="register.html">立即注册</a>
                    </div>

				</form>

			</div>
			<div class="aui-p">© 2017 北京四彩云网络科技有限公司 京ICP备15006025号-3 </div>

		</div>
	<!-- content end -->
<script>
	function  submit() {
		$("#loginForm").submit()
    }
</script>
</body>
</html>
