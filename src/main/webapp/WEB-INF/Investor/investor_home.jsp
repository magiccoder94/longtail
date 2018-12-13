<!DOCTYPE html>
<html ng-app="myApp">
<head>
  <!-- Bootstrap 4 --> 
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
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
  <!-- DataTable JS -->
  <script src="${pageContext.request.contextPath}/assets/dataTables-1.10.18/js/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/dataTables-1.10.18/js/dataTables.bootstrap4.min.js"></script>
  <!-- dirPagination -->
  <%-- <script src="${pageContext.request.contextPath}/assets/js/dirPagination.js"></script> --%>
  
  <!-- ANGULAR JS IMPORT - Version 1.5 above -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.js"></script>
  <script src="${pageContext.request.contextPath}/sample/Admin/assets/plugins/parsleyjs/parsley.min.js"></script>
  
  <script src="https://cdn.jsdelivr.net/npm/signature_pad@2.3.2/dist/signature_pad.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<!-- *****************************TO-DO : INCLUDE main_header***************************** -->
		<jsp:include page="/WEB-INF/Investor/webpart/top_nav_bar.jsp" />
		<!-- *****************************TO-DO : INCLUDE main_header***************************** -->

		<div ng-view></div>
	</div>
</body>
<script>
var app = angular.module("myApp", [ "ngRoute"]);
	app.config(function($routeProvider) {
		$routeProvider
			/* .when("/",{
				templateUrl : "${pageContext.request.contextPath}/investor/home"
			}) */
			.when("/register_applicant", {
				templateUrl : "${pageContext.request.contextPath}/investor/register",
				controller : "ctl_view_applicant_form"
			})
			.when("/investment", {
				templateUrl : "${pageContext.request.contextPath}/investor/invest",
				controller : "ctl_view_investment"
			})
			.when("/franchise", {
				templateUrl : "${pageContext.request.contextPath}/investor/view_franchise"
			})
			/* .when("/view_franchise/:franchiseId", {
				templateUrl : function(params){
					return '${pageContext.request.contextPath}/investor/view_franchise/'+params.franchiseId;
				},
				controller : "ctl_view_franchise"
			}) */
	});
</script>

<jsp:include page="/WEB-INF/Investor/controller/ctl_view_applicant_form.jsp" />
<jsp:include page="/WEB-INF/Investor/controller/ctl_view_investment.jsp" />
</html>