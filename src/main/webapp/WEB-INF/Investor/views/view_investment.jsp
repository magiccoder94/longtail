<html>
<head>
<style>
	.form-control {
		height: 55px;
	}
	
	html, body{
    	background-color: #DADADA;
	}
	
	.btn-font{
		font-size: 20px;
	}
	
	.img-resize{
		width: 3%;
		margin-right: 1%;
		margin-left: 1%;
	}
	
	.container-custom {
		max-width: 95%; 
		padding-left: 0px; 
		padding-right: 0px;
	}
</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">
<body ng-controller="ctl_view_investment">
	<div class="container" style="margin-top: 20%;">
	<div class="row">
			<div class="col-12 col-sm-12 col-md-3">
				<div class="card" style="width: initial; top: initial; margin-bottom: 10px;">
					<div class="card-body">
						<div>
							<big><strong>Franchise Search Filter</strong></big>
						</div>
					</div>
					<div class="card-body">
						<div id="sCon">
							<form>
								<div class="form-group">
									<input class="form-control" ng-model="search.keywords" placeholder="Franchise name or Keywords ..."
									type="text" maxlength="100" autocomplete="off"/>
								</div>
								<div class="form-group">
									<select class="form-control" ng-model="search.category" ng-options="x.name for x in listCategory.data"></select>
								</div>
								<div class="form-group">
									<select class="form-control" ng-model="search.franchise_type">
										<option value=99>All Franchise Type</option>
										<option value=0>Single</option>
										<option value=1>Multiple</option>
										<option value=2>Country Master</option>
										<option value=3>Area Master</option>
									</select>
								</div>
								<div class="form-group">
									<select class="form-control" ng-model="search.entity_type">
										<option value=99>All Entity Type</option>
										<option values=0>Private Limited</option>
										<option values=1>Public</option>
										<option values=2>Partnership</option>
										<option values=3>Sole Proprietorship</option>
									</select>
								</div>
								<div class="form-group">
									<button class="btn btn-primary btn-block btn-font" type="submit" ng-onclick="searchCriteria()">Search</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- <div class="col-12 col-sm-12 col-md-7">
				<div ng-repeat="franchise in listFranchise.data">
				<div class="card" style="margin-bottom: 5px;">
					<div class="card-body">
						<div class="position-title header-text">
							<h3>
								<a class="position-title-link" ng-href="{{franchise.url}}"><i>{{franchise.name}}</i></a>
							</h3>
						</div>
						<h4>
							<a><i>{{franchise.company_name}}</i></a>
						</h4>
						<ul>
							<span>{{franchise.short_description}}</span>
						</ul>
						<ul class="list-unstyled">
							<li>
								<i><span>{{franchise.category.name}}</span></i>
							</li>
							<li>
								<span>Currently {{franchise.interested}} investor interested</span>
							</li>
						</ul>
						<div>
							<span class="text-muted">Last update {{franchise.updatedDate}}</span>
						</div>
					</div>
				</div> -->
				<!-- <div class="panel" name="pagination">
					<div class="panel-body text-center">
						<ul class="pagination pull-left">
							<dir-pagination-controls
						       max-size="5"
						       direction-links="true"
						       boundary-links="true" >
						    </dir-pagination-controls>
						</ul>
					</div>
				</div> -->
			</div>
			
			<div class="col-12 col-sm-12 col-md-7" >
				<div class="card" style="margin-bottom: 5px;">
					<div class="card-body">
						<div class="position-title header-text">
							<h3>
								<a class="position-title-link" ng-href="#"><i>Kentucky Fried Chicken</i></a>
							</h3>
							<ul>
								<li>
									<i><span>description 1</span></i>
								</li>
								<li>
									<i><span>description 2</span></i>
								</li>
							</ul>
							<ul class="list-unstyled">
								<li>
									<img class="img-resize" src="${pageContext.request.contextPath}/assets/images/bookmark.png"/><span style="font-size:15px;">Category</span>
								</li>
								<li>
									<img class="img-resize" src="${pageContext.request.contextPath}/assets/images/point-up.png"/><span style="font-size:15px; font-weight: bold;">Currently 100 investor interested</span>
								</li>
							</ul>
							<div>
								<span class="text-muted">Last update 11-12-2018</span>
							</div>
						</div>
					</div>
				</div>
				<div class="card" style="margin-bottom: 5px;">
					<div class="card-body">
						<div class="position-title header-text">
							<h3>
								<a class="position-title-link" ng-href="#"><i>Farm Beetle</i></a>
							</h3>
							<ul>
								<li>
									<i><span>description 1</span></i>
								</li>
								<li>
									<i><span>description 2</span></i>
								</li>
							</ul>
							<ul class="list-unstyled">
								<li>
									<img class="img-resize" src="${pageContext.request.contextPath}/assets/images/bookmark.png"/><span style="font-size:15px;">Category</span>
								</li>
								<li>
									<img class="img-resize" src="${pageContext.request.contextPath}/assets/images/point-up.png"/><span style="font-size:15px; font-weight: bold;">Currently 100 investor interested</span>
								</li>
							</ul>
							<div>
								<span class="text-muted">Last update 11-12-2018</span>
							</div>
						</div>
					</div>
				</div>
				<div class="card" style="margin-bottom: 5px;">
					<div class="card-body">
						<div class="position-title header-text">
							<h3>
								<a class="position-title-link" ng-href="#"><i>McDonald Subang Jaya USJ</i></a>
							</h3>
							<ul>
								<li>
									<i><span>description 1</span></i>
								</li>
								<li>
									<i><span>description 2</span></i>
								</li>
							</ul>
							<ul class="list-unstyled">
								<li>
									<img class="img-resize" src="${pageContext.request.contextPath}/assets/images/bookmark.png"/><span style="font-size:15px;">Category</span>
								</li>
								<li>
									<img class="img-resize" src="${pageContext.request.contextPath}/assets/images/point-up.png"/><span style="font-size:15px; font-weight: bold;">Currently 100 investor interested</span>
								</li>
							</ul>
							<div>
								<span class="text-muted">Last update 11-12-2018</span>
							</div>
						</div>
					</div>
				</div>
				<div class="card" style="margin-bottom: 5px;">
					<div class="card-body">
						<div class="position-title header-text">
							<h3>
								<a class="position-title-link" ng-href="#"><i>Another Franchise Name</i></a>
							</h3>
							<ul>
								<li>
									<i><span>description 1</span></i>
								</li>
								<li>
									<i><span>description 2</span></i>
								</li>
							</ul>
							<ul class="list-unstyled">
								<li>
									<img class="img-resize" src="${pageContext.request.contextPath}/assets/images/bookmark.png"/><span style="font-size:15px;">Category</span>
								</li>
								<li>
									<img class="img-resize" src="${pageContext.request.contextPath}/assets/images/point-up.png"/><span style="font-size:15px; font-weight: bold;">Currently 100 investor interested</span>
								</li>
							</ul>
							<div>
								<span class="text-muted">Last update 11-12-2018</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
</body>
</html>