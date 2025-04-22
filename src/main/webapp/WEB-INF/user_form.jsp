<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>使用者資料表</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		
	</head>
	<body style="padding: 20px">
		<div>
			<h2>使用者資料表單</h2>
			<form class="pure-form" method="POST" action="/JavaWeb/user">
				<fieldset>
					<legend>User Form</legend>
					<label>姓名:</label>
					<input name="userName" type="text" required />
					<p />
					<label>姓別:</label>
					<input name="gender" type="radio" value="male" checked>&nbsp;男
					<input name="gender" type="radio" value="female">&nbsp;女
					<p />
					<label>年齡:</label>
					<input name="age" type="number" min="1" max="150" required />
					<p />
					<label>身高 (cm):</label>
					<input name="height" type="number" min="1" max="300" step="0.1" required />
					
					<label>體重 (kg):</label>
					<input name="weight" type="number" min="0.1" max="1000" step="0.1" required />
					<p />
					<button type="submit" class="pure-button pure-button-primary">送出</button>
					
				</fieldset>
			
			</form>
		</div>
	</body>
</html>








