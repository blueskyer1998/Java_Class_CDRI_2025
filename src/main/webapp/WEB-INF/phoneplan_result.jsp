<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>手機方案資料結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<div class="pure-form">
			<h2>手機方案資料結果</h2>
			<fieldset>
				<legend>PhonePlanCoffee Result</legend>
				類型: ${ phoneplanType.phoneplanType }<p />
				通話分鐘數 (分鐘): ${ phoneplanType.callDurationInMinutes }<p />
				上網流量 (GB): ${ phoneplanType.dataUsageInGB }<p />
 }<p />
				<a href="/JavaWeb/phoneplan" class="pure-button pure-button-primary">返回</a>
			</fieldset>
		</div>
	</body>
</html>