<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Login</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
<base href="/" />
<!-- <link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"></link> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome-free-5.5.0-web/css/fontawesome.min.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome-free-5.5.0-web/css/brands.min.css"></link>
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/assets/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
</head>
 
<body>
 
 <div class="container">
 <h1>Login Using</h1>
 
 <form action="/connect/google" method="POST" style="display: inline">
 <input type="hidden" name="scope" value="profile email" />
 <button type="submit" class="btn btn-danger">
 Google <i class="fab fa-google-plus-g"></i>
 </button>
 </form>
 
 <form action="/connect/facebook" method="POST" style="display: inline">
 <input type="hidden" name="scope" value="public_profile,email" />
 <button type="submit" class="btn btn-primary">
 Facebook <i class="fab fa-facebook-f"></i>
 </button>
 </form>
 
 </div>
</body>
</html>