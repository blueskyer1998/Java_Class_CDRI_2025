<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>🍧冰果店的點餐系統</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
</head>
<body style="padding: 20px">
	<div>
		<h2>🍧冰果店的點餐系統</h2>

		<!-- 顯示 CAPTCHA 錯誤 -->
		<c:if test="${ not empty captchaError }">
			<p style="color:red;">${ captchaError }</p>
		</c:if>

		<form class="pure-form" method="POST" action="/JavaWeb/ice" onsubmit="return checkCaptchaToken()">
			<fieldset>
				<legend>選擇主餐</legend>
				<input type="radio" name="mainDish" value="剉冰" checked>剉冰 🍧 (50元)<p />
				<input type="radio" name="mainDish" value="豆花">豆花 🍮 (40元)<p />
			</fieldset>

			<fieldset>
				<legend>選擇加料(每樣10圓)</legend>
				<input type="checkbox" name="toppings" value="花生"> 花生 🥜<p />
				<input type="checkbox" name="toppings" value="綠豆"> 綠豆 🌱<p />
				<input type="checkbox" name="toppings" value="紅豆"> 紅豆 🍒<p />
				<input type="checkbox" name="toppings" value="芋圓"> 芋圓 🥔<p />
				<input type="checkbox" name="toppings" value="粉圓"> 粉圓 ⚪<p />
				<input type="checkbox" name="toppings" value="煉乳"> 煉乳 🍼<p />
			</fieldset>

			<fieldset>
				<legend>人機驗證（射爆惡魔！）</legend>
				<iframe
					src="https://doom-captcha.vercel.app/"
					width="300"
					height="400"
					frameborder="0"
					id="doomCaptcha"
					onload="attachCaptchaListener()"
				></iframe>
				<input type="hidden" name="captchaToken" id="captchaToken" />
			</fieldset>

			<button type="submit" class="pure-button pure-button-primary">結帳</button>
		</form>
	</div>

	<script>
		function attachCaptchaListener() {
			window.addEventListener("message", function (event) {
				if (event.origin !== "https://doom-captcha.vercel.app") return;
	
				const { success, token } = event.data;
				if (success && token) {
					// ✅ 把 token 放進 hidden input
					document.getElementById("captchaToken").value = token;
					console.log("Doom Captcha 通過 ✅ Token 已寫入表單：", token);
				}
			});
		}

		function checkCaptchaToken() {
			const token = document.getElementById("captchaToken").value;
			if (!token) {
				alert("請先完成 CAPTCHA 驗證！");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>