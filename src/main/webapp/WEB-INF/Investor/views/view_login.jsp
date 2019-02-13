<html lang="en">
<head>
	<title>LongTail | Member Login</title>
	
	<style>
		.form-signin input[type="text"] {
			margin-bottom: 5px;
			border-bottom-left-radius: 0;
			border-bottom-right-radius: 0;
		}
		.form-signin input[type="password"] {
			margin-bottom: 10px;
			border-top-left-radius: 0;
			border-top-right-radius: 0;
		}
		.img-responsive {
			display: block;
			max-width: 100%;
			height: auto;
			margin: auto;
		}
		
		.login-label {
			font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
		    font-size: 14px;
		    line-height: 1.42857143;
		    color: #ffffff;
		}
		
		.card {
			margin-bottom: 20px;
			background-color: #080808a0;
			border-radius: 4px;
		}
		.underline:hover {
			text-decoration: underline;
		}
	</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<body>
	<div class="container">
		<div class="row" style="padding-top: 100px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="card">
					<div class="card-header" style="padding: 15px;">
						<div class="row-fluid user-row">
							<img class="img-responsive" alt="Conxole Admin"/>
						</div>
					</div>
					<div class="card-body">
						<div class="carousel" data-interval="false">
							<div class="carousel-inner">
								<div class="item active">
									<label style="color:red; font-size: 16px;">${exceptionMsg}</label>
									<form action="${pageContext.request.contextPath}/user/signin" method="POST" accept-charset="UTF-8" role="form" class="form-signin">
										<fieldset>
											<label class="login-label">Username:</label>
											<input class="form-control" type="text" name="username" required/>
											<br/>
											<label class="login-label">Password:</label>
											<input class="form-control" type="password" name="password" required/>
											<br/>
											<input class="btn btn-lg btn-danger btn-block" type="submit" value="Login"/>
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											<br>
											<div style="text-align: center">
												<span class="underline" style="color: white" onclick="switchPage(1)">Forgot password?</span>
											</div>
										</fieldset>
									</form>
								</div>
								<div class="item">
									<label style="color:red; font-size: 16px;">${resetExceptionMsg}</label>
									<p style="color:#5bc0de">Please enter the registered email and username.</p>
									<form action="${pageContext.request.contextPath}/user/reset_password" method="POST" accept-charset="UTF-8" role="form">
										<fieldset>
											<label class="login-label">Username:</label>
											<input class="form-control" type="text" name="username_reset" required/>
											<br/>
											<label class="login-label">Registered Email Address:</label>
											<input class="form-control" style="margin-bottom: 10px;" type="email" name="email" required/>
											<br>
											<input class="btn btn-lg btn-info btn-block" type="submit" value="Reset Password">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											<br>
											<div style="text-align: center">
												<span class="underline" style="color: white" onclick="switchPage(0)">Back to Login</span>
											</div>
										</fieldset>
									</form>
								</div>
							</div>
						</div>					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
function switchPage(pageNo) {
	$('input[name=username]').val("");
	$('input[name=userpassword]').val("");
	$('input[name=username_reset]').val("");
	$('input[name=email]').val("");
	
	$('#carousel').carousel(pageNo);
};
</script>
</html>