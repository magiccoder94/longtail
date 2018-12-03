<html>
<head>
<style>
.fixedMenuHeader{
	position: fixed;
	top: 0;
	width: 100%;
}
</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">
<body>
	<header class="main-header fixedMenuHeader">
		<!-- Logo -->
		<a class="logo">
			<span class="logo-lg"><b><i>LongTail</i></b></span>
		</a>
		<nav class="navbar navbar-static-top">
			<a class="sidebar-toggle" data-toggle="offcanvas" role="button">
				<span class="sr-only">Toggle navigation</span>
			</a>
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<li>
						<form action="${pageContext.request.contextPath}/admin/logout" method="post">
							<input type="submit" class="btn bg-black" value="Sign Out"/>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form>
					</li>
				</ul>
			</div>
		</nav>
	</header>
</body>
</html>