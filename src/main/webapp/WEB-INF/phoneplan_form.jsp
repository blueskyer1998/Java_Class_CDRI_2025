<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>手機方案資料</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		
	</head>
	<body style="padding: 20px">
		<div>
			<h2>手機方案資料表單</h2>
			<form class="pure-form" method="POST" action="phoneplan">
				<fieldset>
					<legend>PhonePlan Form</legend>
					<label>通話分鐘數 (分鐘):</label>
					<input name="callDurationInMinutes" type="number" min="0.1" max="10000" step="0.1" required />
					
					<label>上網流量 (GB):</label>
					<input name="dataUsageInGB" type="number" min="0.1" max="10000" step="0.1" required />
					<p />
					<button type="submit" class="pure-button pure-button-primary">送出</button>
					
				</fieldset>
			
			</form>
		</div>
	</body>
</html>








