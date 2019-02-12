<head>
<style>
#link {
	color: #E45635;
	display: block;
	font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
	text-align: center;
	text-decoration: none;
}

#link:hover {
	color: #CCCCCC
}

#link, #link:hover {
	-webkit-transition: color 0.5s ease-out;
	-moz-transition: color 0.5s ease-out;
	-ms-transition: color 0.5s ease-out;
	-o-transition: color 0.5s ease-out;
	transition: color 0.5s ease-out;
}

/** BEGIN CSS **/
body {
	background: #333333;
}

@keyframes rotate-loading { 
	0% {
		transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
	}
	
	100% {
		transform: rotate(360deg);
		-ms-transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		-o-transform: rotate(360deg);
		-moz-transform: rotate(360deg);
	}
}

@-moz-keyframes rotate-loading { 
	0% {
		transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
	}
	
	100% {
		transform: rotate(360deg);
		-ms-transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		-o-transform: rotate(360deg);
		-moz-transform: rotate(360deg);
	}
}

@-webkit-keyframes rotate-loading { 
	0% {
		transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
	}
	
	100% {
		transform: rotate(360deg);
		-ms-transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		-o-transform: rotate(360deg);
		-moz-transform: rotate(360deg);
	}
}

@-o-keyframes rotate-loading { 
	0% {
		transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
	}
	
	100% {
		transform: rotate(360deg);
		-ms-transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		-o-transform: rotate(360deg);
		-moz-transform: rotate(360deg);
	}
}

@keyframes rotate-loading { 
	0% {
		transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
	}
	
	100% {
		transform: rotate(360deg);
		-ms-transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		-o-transform: rotate(360deg);
		-moz-transform: rotate(360deg);
	}
}

@-moz-keyframes rotate-loading { 
	0% {
		transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
	}
	
	100% {
		transform: rotate(360deg);
		-ms-transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		-o-transform: rotate(360deg);
		-moz-transform: rotate(360deg);
	}
}

@-webkit-keyframes rotate-loading { 
	0% {
		transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
	}
	
	100% {
		transform: rotate(360deg);
		-ms-transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		-o-transform: rotate(360deg);
		-moz-transform: rotate(360deg);
	}
}

@-o-keyframes rotate-loading { 
	0% {
		transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
	}
	
	100% {
		transform: rotate(360deg);
		-ms-transform: rotate(360deg);
		-webkit-transform: rotate(360deg);
		-o-transform: rotate(360deg);
		-moz-transform: rotate(360deg);
	}
}

@keyframes loading-text-opacity { 
	0% {
		opacity: 0
	}
	
	20% {
		opacity: 0
	}
	
	50% {
		opacity: 1
	}
	
	100%{
		opacity: 0
	}
}

@-moz-keyframes loading-text-opacity { 
	0% {
		opacity: 0
	}
	
	20% {
		opacity: 0
	}
	
	50% {
		opacity: 1
	}
	100%{
		opacity: 0
	}
}

@-webkit-keyframes loading-text-opacity { 
	0% {
		opacity: 0
	}
	
	20% {
		opacity: 0
	}
	
	50% {
		opacity: 1
	}
	
	100%{
		opacity: 0
	}
}

@-o-keyframes loading-text-opacity { 
	0% {
		opacity: 0
	}
	
	20% {
		opacity: 0
	}
	
	50% {
		opacity: 1
	}
	
	100%{
		opacity: 0
	}
}

.loading-container, .loading {
	height: 150px;
	position: relative;
	width: 150px;
	border-radius: 100%;
}

.loading-container {
	margin: 100px auto
}

.loading {
	border: 10px solid transparent;
	border-color: transparent #fff transparent #FFF;
	-moz-animation: rotate-loading 1.5s linear 0s infinite normal;
	-moz-transform-origin: 50% 50%;
	-o-animation: rotate-loading 1.5s linear 0s infinite normal;
	-o-transform-origin: 50% 50%;
	-webkit-animation: rotate-loading 1.5s linear 0s infinite normal;
	-webkit-transform-origin: 50% 50%;
	animation: rotate-loading 1.5s linear 0s infinite normal;
	transform-origin: 50% 50%;
}

.loading-container:hover .loading {
	border-color: transparent #E45635 transparent #E45635;
}

.loading-container:hover .loading, .loading-container .loading {
	-webkit-transition: all 0.5s ease-in-out;
	-moz-transition: all 0.5s ease-in-out;
	-ms-transition: all 0.5s ease-in-out;
	-o-transition: all 0.5s ease-in-out;
	transition: all 0.5s ease-in-out;
}

#loading-text {
	-moz-animation: loading-text-opacity 2s linear 0s infinite normal;
	-o-animation: loading-text-opacity 2s linear 0s infinite normal;
	-webkit-animation: loading-text-opacity 2s linear 0s infinite normal;
	animation: loading-text-opacity 2s linear 0s infinite normal;
	color: #ffffff;
	font-family: "Helvetica Neue, " Helvetica ", " "arial";
	font-size: 15px;
 	font-weight: 650;
	margin-top: 65px;
	opacity: 0;
	position: absolute;
	text-align: center;
	text-transform: uppercase;
	top: 0;
	width: 150px;
}
</style>
</head>

<body>
	<form name="theForm" id="theForm" action="" method="post" style="margin-top: 20px">
		<div class="loading-container">
			<div class="loading"></div>
			<div id="loading-text">PROCESSING...</div>
		</div>
	</form>
</body>
</html>