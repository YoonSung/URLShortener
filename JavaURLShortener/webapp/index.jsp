<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URLShortener</title>
<style>
@import
	url(http://fonts.googleapis.com/css?family=Open+Sans|Francois+One);

body {
	color: white;
	background-color: black;
	font-family: 'Open Sans', sans-serif;
}

#wrapper {
	margin: 0 auto;
	width: 700px;
}

h1 {
	text-align: center;
	font-family: 'Francois One', sans-serif;
	font-size: 2.5em;
	font-weight: normal;
}

#inputfield {
	border-radius: 10px;
	border: none;
	height: 40px;
	padding: 10px;
	color: #e800d5;
	outline: none;
	width: 535px;
	font-family: 'Open Sans', sans-serif;
	font-size: 1.7em;
	margin-right: 10px;
}

.button {
	width: 135px;
	background-color: #e800d5;
	color: white;
	border: none;
	height: 60px;
	padding: 10px;
	border-radius: 10px;
	font-family: 'Francois One', sans-serif;
	font-size: 1.3em;
	outline: none;
}

.button:hover {
	cursor: pointer;
	background-color: #cd02bc;
}

#result {
	margin-top: 40px;
	font-size: 130px;
	width: 100%;
	background-color: lightseagreen;
	position: absolute;
	left: 0;
	text-align: center;
	margin-top: 40px;
	opacity: 0;
	-webkit-transition: all 3s ease;
	-moz-transition: all 3s ease;
	-ms-transition: all 3s ease;
	-o-transition: all 3s ease;
	transition: all 3s ease;
}

#result.on {
	opacity: 1;
}
</style>
</head>
<body>
	<div id="wrapper">
		<h1>Paste Your Long URL Here :)</h1>
		<div>
			<form action="#">
				<input type="text" id="inputfield" /><input class="button"
					type="submit" value="shorten URL" />
			</form>
		</div>
		<div id="result">testest</div>
	</div>
</body>
<script>
	
	//test code
	setTimeout(function() {
		var result = document.querySelector("#result");
		result.classList.add("on");
	}, 1000);
</script>
</html>