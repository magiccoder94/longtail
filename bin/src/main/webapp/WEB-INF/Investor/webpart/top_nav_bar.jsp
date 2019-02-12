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
</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">
<body>
	<nav id="navBar" class="navbar navbar-expand navbar-dark fixed-top bg-dark">
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
	      				<a class="nav-link" href="#!investment">
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
			<%-- <ul class="navbar-nav mr-auto">
				<li class="nav-item active">
        			<a class="nav-link" href="#">LongTail <span class="sr-only">(current)</span></a>
     			</li>
      			<li class="nav-item">
        			<a class="nav-link" href="#!register_applicant">Fill in Applicant Form</a>
      			</li>
      			<li class="nav-item">
      				<img src="${pageContext.request.contextPath}/assets/images/briefcase.png"/>
      				<a class="nav-link" href="#!investment">Investor Page</a>
      			</li>
      			<li class="navbar-brand mr-auto">
      				<form action="${pageContext.request.contextPath}/investor/logout" method="post">
						<input type="image" src="${pageContext.request.contextPath}/assets/images/exit.png" value="Sign Out"/>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
      			</li>
			</ul> --%>
		</div>
	</nav>
</body>
<script>
	//Store navbar classes
	var navClasses = document.getElementById('navBar').classList;
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
	});
</script>
</html>