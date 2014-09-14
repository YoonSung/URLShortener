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

.loading {
	font-family: 'Francois One', sans-serif;
	font-size: 2em;
	padding-top: 30px;
	text-align: center;
}

#searchfield {
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

#results {
	margin-top: 40px;
	padding-left: 59px;
}

#results ul {
	margin: 0;
	padding: 0;
	list-style: none;
}

#results ul li {
	float: left;
}

.round {
	width: 180px;
	height: 180px;
	border-radius: 90px;
	margin-right: 20px;
	background-size: cover;
	background-repeat: no-repeat;
	display: none;
}
</style>
</head>
<body>
	<div id="wrapper">
		<h1>Paste Your Long URL Here :)</h1>
		<div id="search">
			<form action="#" id="flickrSearch">
				<input type="text" id="searchfield" /><input class="button"
					type="submit" value="shorten URL" />
			</form>
		</div>
		<div id="results"></div>
	</div>
</body>
<script>
	
</script>
</html>