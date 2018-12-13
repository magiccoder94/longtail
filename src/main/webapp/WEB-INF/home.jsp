<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    
    <!-- Page title set in pageTitle directive -->
    <title page-title>Project LongTail</title>
    
    <!-- ****BASE FOLDER DEFINE**** -->
    <!-- <base href="/admin/"> -->

    <%-- <link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/admin/favicon.png" /> --%>
	<style>
	/* Paste this css to your style sheet file or under head tag */
	/* This only works with JavaScript, 
	if it's not present, don't show loader */
	.no-js #loader { display: none;  }
	.js #loader { display: block; position: absolute; left: 100px; top: 0; }
	.se-pre-con {
		position: fixed;
		left: 0px;
		top: 0px;
		width: 100%;
		height: 100%;
		z-index: 9999;
		background: url(images/loader-64x/Preloader_2.gif) center no-repeat #fff;
	}
	</style>
	
  <!-- Bootstrap 4 --> 
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/iCheck/flat/blue.css">
 <%--  <!-- Morris chart -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/morris/morris.css"> --%>
  <!-- jvectormap -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dataTables-1.10.18/css/dataTables.bootstrap4.css">
  <!-- FontAwesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome-free-5.5.0-web/css/fontawesome.min.css"></link>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fontawesome-free-5.5.0-web/css/brands.min.css"></link>
  <!-- JQuery 3.3.1 -->
  <script src="${pageContext.request.contextPath}/assets/jQuery-3.3.1/jquery-3.3.1.min.js"></script>
  <!-- JQuery UI 1.12.1 -->
  <script src="${pageContext.request.contextPath}/assets/jquery-ui-1.12.1/jquery-ui.min.js"></script>
  <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
  <script>$.widget.bridge('uibutton', $.ui.button);</script>
  
  <!-- Bootstrap 4 JS -->
  <script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
  <!-- Momment* -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
  <!-- Bootstrap DatetimePicker* -->
  <!-- daterangepicker -->
  <%-- <script src="${pageContext.request.contextPath}/admin/plugins/daterangepicker/daterangepicker.js"></script>
  <!-- datepicker -->
  <script src="${pageContext.request.contextPath}/admin/plugins/datepicker/bootstrap-datepicker.js"></script>
  <!-- Bootstrap WYSIHTML5 -->
  <script src="${pageContext.request.contextPath}/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
  <!-- Slimscroll -->
  <script src="${pageContext.request.contextPath}/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
  <!-- FastClick -->
  <script src="${pageContext.request.contextPath}/admin/plugins/fastclick/fastclick.js"></script> --%>
  <!-- DataTable JS -->
  <script src="${pageContext.request.contextPath}/assets/dataTables-1.10.18/js/dataTables.bootstrap4.min.js"></script>
  
  <!-- ANGULAR JS IMPORT - Version 1.5 above -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.js"></script>

	<style>
	.main {
	  margin-top: 50px;
	}
	</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">
<body class="hold-transition skin-black sidebar-mini">
<!-- *****************************TO-DO : INCLUDE main_header***************************** -->
  <jsp:include page="/WEB-INF/admin/webpart/main_header.jsp" />  
<!-- *****************************TO-DO : INCLUDE main_header***************************** -->

<!-- *****************************TO-DO : INCLUDE menu_drawer***************************** -->
  <jsp:include page="/WEB-INF/admin/webpart/menu_drawer.jsp" />  
<!-- *****************************TO-DO : INCLUDE menu_drawer***************************** -->

<!-- Page view wrapper -->
<!-- <div id="siteloader"></div> -->
<div ng-view></div>

</body>

<script>
	var app = angular.module("myApp", [ngRoute]);
	app.config(function($routeProvider){
		$routeProvider
		.when("/", {
			templateUrl : "${pageContext.request.contextPath}/welcome",
			controller : "ctl_view_welcome"
		})
		.when("/franchise", {
			templateUrl : "${pageContext.request.contextPath}/admin/views/view_franchise",
			controller: "ctl_view_franchise"
		})
	});
</script>
