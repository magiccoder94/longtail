<!DOCTYPE html>
<html>
<head>
	<title>Long Tail</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
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
		
		.form-signin .form-control {
			position: relative;
			font-size: 16px;
			font-family: 'Open Sans', Arial, Helvetica, sans-serif;
			height: auto;
			padding: 10px;
			-webkit-box-sizing: border-box;
			-moz-box-sizing: border-box;
			box-sizing: border-box;
		}
		
		.img-responsive {
			display: block;
			max-width: 100%;
			height: auto;
			margin: auto;
		}
		
		.panel {
			margin-bottom: 20px;
			background-color: rgba(255,255,255,.15);
			border: 1px solid transparent;
			border-radius: 4px;
			-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
			box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
		}
		
		.login-label {
			font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
		    font-size: 14px;
		    line-height: 1.42857143;
		    color: #ffffff;
		}

	</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<body>
	<div class="container">
		<div class="row" style="padding-top: 100px;">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-transparent">
					<div class="panel-heading">
						<div class="row-fluid user-row">
							<!-- img here -->
						</div>
					</div>
					<div class="panel-body">
						<p style="color:red;">${exceptionMsg}</p>
						<form action="${pageContext.request.contextPath}/admin/signin" method="POST" accept-charset="UTF-8" role="form" class="form-signin">
							<fieldset>
								<label class="login-label">Email Address</label>
								<input class="form-control" name="username" placeholder="User Name" type="text" required> 
								<br>
								<label class="login-label">Password</label>
								<input class="form-control" name="userpassword" placeholder="Password" type="password" required>
								<br> 
								<input class="btn btn-lg btn-danger btn-block" type="submit" value="Login">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<br>
								<div style="text-align: center">
									<span class="underline" style="color: white" onclick="switchPage(1)">Forgot password?</span>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>