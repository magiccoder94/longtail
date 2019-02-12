<head>
	<script src="${pageContext.request.contextPath}/assets/tinymce/tinymce.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/select2/select2.full.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/fieldchooser/dist/js/multiselect.js"></script>
	<script>
		$(".select2").select2();
	
		tinymce.init({
			selector : '.section_editor',
			height : 250,
			theme : 'modern',
			editor_selector : 'mceAdvanced',
			plugins : [
					'advlist autolink lists link image charmap print preview hr anchor pagebreak',
					'searchreplace wordcount visualblocks visualchars code fullscreen',
					'insertdatetime media nonbreaking save table contextmenu directionality',
					'emoticons template paste textcolor colorpicker textpattern imagetools codesample toc' ],
			toolbar1 : 'undo redo | insert | styleselect | bold italic fontsizeselect | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | table',
			toolbar2 : 'print preview media | forecolor backcolor emoticons | codesample',
			removed_menuitems : 'newdocument',
			image_advtab : true
		});
	</script>
	
<!-- Instantiate single textfield component rendered in the document -->
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">

<body class="adminbody" ng-controller="ctl_view_franchise">
	<div class="content-wrapper main">
		<section class="content-header">
		<br/>
			<h1>Franchise <small>Management</small></h1>
			<ol class="breadcrumb">
				<li>MAIN NAVIGATION</li>
			</ol>
		</section>
		
		<section class="content" style="min-height: 85vh;">
			<div class="row">
				<div class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
					<div class="card mb-3">
						<div class="card-header d-flex-row justify-content-between">
							<h3>Franchise List</h3>
							<button type="button"
								class="btn btn-social pull-right btn-primary bg-aqua"
								data-toggle="modal" data-target="#addFranchiseModal"
								ng-click="setModalType('create')">
								<span class="btn-label"><i class="fa fa-plus"></i></span>
								Add Franchise
							</button>
						</div>	
						<div class="card-body">
							<div class="table-responsive">
								<table id="franchiseList_table"
									class="table table-bordered table-hover display" style="width: 100%">
									<thead>
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Date Added</th>
											<th>Date Updated</th>
											<th></th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	
	<div class="modal fade" id="addFranchiseModal" role="dialog"
		aria-labelledby="addFranchiseModal" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body">
					<form ng-submit="submitCreateFranchise()" name="createFranchiseForm">
						<button type="button" class="close" data-dismiss="modal" ng-click="resestFranchiseForm">&times;</button>
						<h4 ng-if="franchise.action=='create'" class="modal-title">CREATE FRANCHISE DETAILS</h4>
						<h4 ng-if="franchise.action=='update'" class="modal-title">UPDATE FRANCHISE DETAILS</h4>
						<br/>
						<input type="hidden" id="franchiseId" ng-model="franchise.id"/>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Franchise Type</label>
								<select id="franchiseType" ng-model="franchise.type" class="form-control" ng-change="typeChange()">
									<option value=0>Single</option>
									<option value=1>Multiple</option>
									<option value=2>Country Master</option>
									<option value=3>Area Master</option>
								</select>
							</div>
							<div class="col-sm-6 form-group">
								<label>Category</label>
								<div>
									<select class="form-control" ng-model="franchise.category" id="categoryFranchise" ng-options="x.name for x in listCategory.data"></select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 form-group">
								<label for="name">Name</label>
								<input type="text" class="form-control" ng-model="franchise.name" maxlength="20" required/>
								<div class="mdc-line-ripple"></div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 form-group">
								<label for="">Company Name</label>
								<input type="text" class="form-control" ng-model="franchise.company" maxlength="20" required/>
							</div>
						</div>
						<div class="row">
							<div style="text-align: center">
								<img id="updateDbImg"/>
							</div>
							<div class="col-sm-6 form-group">
								<label for="imageUrl">Franchise Logo</label>
								<input id="createLogo_img" type="file" class="form-control-file	"/>
								<input type="hidden" id="createLogo_imgBase64"/>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 form-group">
								<label for="description">Franchise Description</label>
								<div style="border: 1px solid #d2d6de; padding: 10px;">
									<textarea class="section_editor" id="description" style="width: 100%; height: 400px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;" ng-model="franchise.description"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div id="buttonRow" class="pull-right">
						<!-- create -->
						<input type="button" ng-show="franchise.action=='create'" class="btn btn-primary" ng-click="resetCreateFranchise()" value="Reset" id="reseBtnt"/>
						<input type="submit" ng-show="franchise.action=='create'" class="btn btn-primary" ng-disabled="createFranchiseForm.$invalid" value="Submit" id="submitBtn"/>
						<!-- update -->
						<input type="submit" ng-show="franchise.action=='update'" class="btn btn-primary" ng-disabled="createFranchiseForm.$invalid" value="Update" id="submitUpBtn"/>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" data-backdrop="static" id="modal_loading" role="dialog" style="z-index: 9999;">
		<div class="modal-dialog">
			<div class="class-content">
				<div class="modal-body">
					<div style="display: flex; justify-content: cecnter;">
						<jsp:include page="/WEB-INF/admin/loading.jsp" flush="true"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	
</script>