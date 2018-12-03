<html>
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
	<link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css">
	<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
	<!-- Instantiate single textfield component rendered in the document -->
	<script>
	  mdc.textField.MDCTextField.attachTo(document.querySelector('.mdc-text-field'));
	</script>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">

<body>
	<div class="container">
		<div class="col-xs-12 col-sm-12">
			<div class="card mb-3">
				<div class="card-header">
					<h3><i class="fa fa-hand-pointer-o"></i>Applicant Form</h3>
				</div>
				<div class="card-body">
					<form>
						<div class="form-section">
							<h3>Applicant Data</h3>
							<div class="row">
								<div class="col-xs-8 col-sm-8 form-group">
									<label for="name">Name:</label>
									<input type="text" class="form-control" id="name" ng-model="applicant.name" required/>
								</div>
								<div class="col-xs-4 col-sm-4 form-group">
									<label for="yearBirth">Year of Birth:</label>
									<input type="number" class="form-control" id="yearBirth" ng-model="applicant.year_birth" required/>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-8 col-sm-8 form-group">
									<label for="nationality">Nationality:</label>
									<input type="text" class="form-control" id="nationality" ng-model="applicant.nationality" required/>
								</div>
								<div class="col-xs-4 col-sm-4 form-group">
									<label for="maritalStatus">Marital Status:</label>
									<select id="maritalSelect" ng-model="applicant.marital" class="form-control" ng-change="maritalChange()">
										<option value=0>Single</option>
										<option value=1>Married</option>
										<option value=2>Divorced</option>
										<option value=3>Widowed</option>
									</select>
								</div>
							</div>	
							<div class="row">
								<div class="col-xs-6 col-sm-6 form-group">
									<label for="telephone">Mobile Number:</label>
									<input type="text" class="form-control" id="mobilePhone" ng-model="applicant.mobile_number" required/>
								</div>
								<div class="col-xs-6 col-sm-6 form-group">
									<label for="officeNumber">Office Number:</label>
									<input type="text" class="form-control" id="officePhone" ng-model="applicant.office_number" required/>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6 col-sm-6 form-group">
									<label for="email">Email:</label>
									<input type="text" class="form-control" id="email" ng-model="applicant.email" required/>
								</div>
								<div class="col-xs-6 col-sm-6 form-group">
									<label for="fax">Fax:</label>
									<input type="text" class="form-control" id="fax" ng-model="applicant.fax"/>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 form-group">
									<label for="residentialCountry">Address in Resident Country:</label>
									<textarea class="form-control" id="addressRC" ng-model="applicant.address_resident_country" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 form-group">
									<label for="academicQualification">Highest Academic / Professional Qualification:</label>
									<textarea class="form-control" id="academicQualify" ng-model="applicant.academic_professional" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 form-group">
									<label for="occupation_business">Present Occupation / Business engaged in:</label>
									<textarea class="form-control" id="occupationBusiness" ng-model="applicant.occupation_business" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 form-group">
									<label for="employer_business">Employer's Name / Name of own business:</label>
									<input type="text" class="form-control" id="employerBusiness" ng-model="applicant.employer_business"/>
								</div>
							</div>
						</div>
						
						<div class="form-section">
							<h3>Corporate Applicant</h3>
							<div class="row">
								<div class="col-xs-12 col-sm-12 form-group">
									<label for="companyName">Name of company / Business:</label>
									<input type="text" class="form-control" ng-model="applicant.company_name" required/>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 form-group">
									<label for="incorporationRegistration">Country of Incorporation / Registration:</label>
									<input type="text" class="form-control" ng-model="applicant.incorporation_registration"/>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 form-group">
									<label for="residentialCountryC">Address in Resident Country:</label>
									<input type="text" class="form-control" ng-model="applicant.C_residential_country"/>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6 col-sm-6 form-group">
									<label for="telephone">Telephone:</label>
									<input type="text" class="form-control" ng-model="applicant.c_telephone"/>
								</div>
								<div class="col-xs-6 col-sm-6 form-group">
									<label for="fax">Fax:</label>
									<input type="text" class="form-control" ng-model="applicant.c_fax"/>
								</div>
							</div>
							<div class="row">
								<div class="">
								
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>