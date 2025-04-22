<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>咖啡資料</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		
	</head>
	<body style="padding: 20px">
		<div>
			<h2>咖啡資料表單</h2>
			<form class="pure-form" method="POST" action="/JavaWeb/coffee">
				<fieldset>
					<legend>Coffee Form</legend>
					<label>Milk (ml):</label>
					<input name="milk" type="number" min="0.1" max="1000" step="0.1" required />
					
					<label>Coffee (ml):</label>
					<input name="coffee" type="number" min="0.1" max="1000" step="0.1" required />
					<p />
					<button type="submit" class="pure-button pure-button-primary">送出</button>
					
				</fieldset>
			
			</form>
		</div>
	</body>
</html>








