<html>
<head>
<style>
.fixedMenuHeader{
	position: fixed;
	top: 0;
	width: 100%;
}
.collapse {
  animation: collapse .5s ease forwards;
}
.open {
  animation: open .5s ease forwards;
}

@keyframes collapse {
  from {
    opacity: 1;
    top: 0;
  }
  to {
    opacity: 0;
    top: -$navBar-height;
  }
}

@keyframes open {
  from {
    opacity: 0;
    top: -$navBar-height;
  }
  to {
    opacity: 1;
    top: 0;
  }
}

.navbar-right {
    float: right!important;
    margin-right: -15px;
}

.img-resize-nav {
	width: 70%;
}

.header-section {
    background-image: url(https://www.bitcoin.com/wp-content/themes/betheme-child/images/getting-started.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    height: 400px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    background-position: 0% 60%;
    background-attachment: fixed;
}

.container-1 {
    width: 90%;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
    max-width: 1300px;
}

.header-h2 {
    font-size: 22px;
    font-family: 'Montserrat', sans-serif;
    font-weight: 600;
    color: #fab915;
    padding: 0;
    border-bottom: 1px solid rgba(255, 255, 255, 0.5);
    display: inline-block;
    padding-bottom: 20px;
    margin: 0;
    line-height: 1.2em !important;
}

.h1-1 {
    font-family: 'Montserrat', sans-serif;
    font-size: 45px;
    font-weight: 700;
    color: #fff;
    margin: 25px 0 0px;
    padding: 0;
    line-height: 1.2em !important;
}
</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">
<body>
	<header class="header">
		<div class="header_content d-flex flex-row align-items-center justify-content-start">
			
			<!-- Logo -->
			<div class="logo">
				<a href="#">
					<span>long<span>tail</span></span>
					<span></span>
				</a>
			</div>

			<!-- Main Navigation -->
			<nav class="main_nav">
				<ul class="d-flex flex-row align-items-center justify-content-start">
					<li class="active"><a href="#!">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#!register_applicant">Participate</a></li>
				</ul>
			</nav>

			<div class="header_right ml-auto d-flex flex-row align-items-center justify-content-start">
				<div class="log_reg">
					<ul class="d-flex flex-row align-items-start justify-content-start">
						<li><a href="#!login">Login</a></li>
						<li><a href="#!register_account">Register</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
	
	<%-- <nav id="navBar" class="navbar navbar-expand navbar-dark fixed-top bg-dark">
		<div class="container" id="navbarSupportedContent">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">LongTail</a>
			</div>
			<div class="navbar-collapse justify-content-between">
				<ul class="nav navbar-nav">
	      			<li class="nav-item">
	        			<a class="nav-link" href="#!register_applicant">
							<img class="img-resize-nav" src="${pageContext.request.contextPath}/assets/images/Picture3.png"/>
						</a>
	      			</li>
	      			<li class="nav-item">
	      				<a class="nav-link" href="#!register_account">
	      					<img class="img-resize-nav" src="${pageContext.request.contextPath}/assets/images/Picture2.png"/>
	      				</a>
	      			</li>
	      			<li class="nav-item">
	      				<a class="nav-link" href="#!franchise">
	      					<img class="img-resize-nav" src="${pageContext.request.contextPath}/assets/images/Picture4.png"/>
	      				</a>
	      			</li>
      			</ul>
      			<ul class="nav navbar-nav">
      				<li>
	      				<form action="${pageContext.request.contextPath}/investor/logout" method="post">
							<input type="image" src="${pageContext.request.contextPath}/assets/images/exit.png" value="Sign Out"/>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form>
	      			</li>
      			</ul>
			</div>
		</div>
	</nav> --%>
</body>
<script>
	//Store navbar classes
	/* var navClasses = document.getElementById('navBar').classList;
	var scrollState = 0;
	function downAction() {
	  navClasses.remove('open');
	  navClasses.add('collapse');
	}

	function upAction() {
	  navClasses.remove('collapse');
	  navClasses.add('open');
	}
	// returns current scroll position
	var scrollTop = function() {
		return window.scrollY;
	};
	
	function scrollHome() 
	{this.navBar.collapse=!1,this.navBar.open=!0}
	
	// Primary scroll event function
	var scrollDetect = function(home, down, up) {
	  // Current scroll position
	  var currentScroll = scrollTop();
	  if (scrollTop() === 0) {
	    home();
	  } else if (currentScroll > scrollState) {
	    down();
	  } else {
	    up();
	  }
	  // Set previous scroll position
	  scrollState = scrollTop();
	};
	
	window.addEventListener("scroll", function() {
		  scrollDetect(scrollHome, downAction, upAction);
	}); */
</script>
</html>