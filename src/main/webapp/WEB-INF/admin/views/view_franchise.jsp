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
	<!-- Required styles for MDC Web -->
<link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css">
<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<!-- Instantiate single textfield component rendered in the document -->
<script>
  mdc.textField.MDCTextField.attachTo(document.querySelector('.mdc-text-field'));
</script>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">

<body id="ctl_view_franchise" ng-controller="ctl_view_franchise">
	<div class="content-wrapper main" style="font-suze: 0.9em;">
		<section class="content-header">
			<h1>
				Franchise <small>Management</small>
			</h1>
			<ol class="breadcrumb">
				<li>MAIN NAVIGATION</li>
				<li>Franchise</li>
			</ol>
		</section>
		
		<section class="content" style="min-height: 85vh;">
			<div class="row">
				<div class="col-xs-12">
					<div class="box box-info">
						<div class="box-header">
							<div>
								<h3 class="box-title">Franchise Listing</h3>
								<button type="button" class="btn btn-social pull-right btn-primary bg-aqua" onclick="show_create_franchise_model('create')">
									<i class="fa fa-plus"></i> Add New Franchise								
								</button>
							</div>
							<br/>
							<!-- <select style="height: 30px; width: 25%;" id="tableSelection" onchange="refreshTable()">
								<option></option>
							</select> -->
						</div>
						<div class="box-body">
							<table id="datable_variant" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Company Name</th>
										<th></th>
									</tr>
								</thead>	
								<tbody></tbody>
								<tfoot></tfoot>																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	
	<!-- Modal Create Franchise -->
	<div class="modal fade" data-backdrop="static" id="create_franchise_modal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div>
						<form ng-submit="submitCreateFranchise()" name="createFranchiseForm">
							<button type="button" class="close" data-dismiss="modal" ng-click="resestFranchiseForm">&times;</button>
							<h4 ng-if="modalType=='create'" class="modal-title">CREATE FRANCHISE DETAILS</h4>
							<h4 ng-if="modalType=='update'" class="modal-title">UPDATE FRANCHISE DETAILS</h4>
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
									<div style="border: 1px solid #d2d6de; padding: 10px;">
										<select style="width: 100%;" ng-model="franchise.category" id="categoryFranchise" ng-options="x.name for x in listCategory.data"></select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 form-group">
									<label for="name">Name</label>
									<input type="text" class="mdc-text-field__input" ng-model="franchise.name" maxlength="20" required/>
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
								<div class="col-sm-12 form-group">
									<label for="imageUrl">Franchise Logo</label>
									<input id="createLogo_img" type="file" class="custom-file-input"/>
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
							<br/><br/>
							<div id="buttonRow" style="position: absolute; bottom: 0">
								<!-- create -->
								<input type="button" ng-show="modalType=='create'" class="btn btn-primary" ng-click="resetCreateFranchise()" value="Reset" id="reseBtnt"/>
								<input type="submit" ng-show="modalType=='create'" class="btn btn-primary" ng-disabled="createFranchiseForm.$invalid" value="Submit" id="submitBtn"/>
								<!-- update -->
								<input type="submit" ng-show="modalType=='update'" class="btn btn-primary" ng-disabled="createFranchiseForm.$invalid" value="Update" id="submitUpBtn"/>
							</div>
						</form>
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
						<jsp:include page="/WEB-INF/loading.jsp" flush="true"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
	$('.modal').on('hidden.bs.modal', function (e) {
	    if($('.modal').hasClass('in')) {
	    	('body').addClass('modal-open');
	    }    
	});
	
	$('input[type=file]').change(function(event){
		var element = event.target.id;
		var reader = new FileReader();
		var _URL = window.URL || window.webkitURL;
		var file = this.files[0];
		var check = fileCheck(file, element);
		if(check == false){
			return false;
		}
		reader.readAsDataURL(file);
		reader.onload = function(){
			if(element == "createLogo_img")
				$('createLogo_imgBase64').val(reader.result);
		}
		reader.onerror = function(error){
			
		}
	});
	
	function fileCheck(file, elementName){
		var img;
		if(file.type.indexOf("image") == -1){
			alert("Invalid image file");
			$('#' + elementName).wrap('<form>').closest('form').get(0).reset();
			#('#' + elementName).unwrap();
			return false;
		}
		//height and width checking not confirm yet
	}
</script>