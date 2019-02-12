<html>
<head>
	<style>
	label{
		font-weight: bold;
		color: black;
	}
	</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">

<body>
<div class="column one column_divider "><hr class="no_line" style="margin: 0 auto 100px;"></div>
<div class="column one column_divider "><hr class="no_line" style="margin: 0 auto 50px;"></div>
	<div class="container">
		<div class="col-12 col-sm-12">
			<div class="card mb-3">
				<div class="card-header">
					<h3><i class="fa fa-hand-pointer-o"></i>Registration Form</h3>
				</div>
				<div class="card-body">
					<form class="form-section" name="registrationForm" ng-submit="submitRegistration()">
						<h3>User Info</h3>
						<div class="row">
							<div class="col-8 col-sm-8 form-group">
								<label for="firstName">First Name:</label>
								<input type="text" class="form-control" ng-model="user.first_name" required/>
							</div>
							<div class="col-8 col-sm-8 form-group">
								<label for="lastName">Last Name:</label>
								<input type="text" class="form-control" ng-model="user.last_name" required/>
							</div>
						</div>
						<div class="row">
							<div class="col-6 col-sm-6 form-group">
								<label for="username">Username:</label>
								<input type="text" class="form-control" ng-model="user.username" required/>
							</div>
							<div class="col-6 col-sm-6 form-group">
								<label for="password">Password:</label>
								<input type="password" class="form-control" ng-model="user.password" required/>
							</div>
						</div>
						<div class="row">
							<div class="col-4 col-sm-4 form-group">
								<label for="yearBirth">Year of Birth:</label>
								<input type="number" class="form-control" id="yearBirth" ng-model="user.year_birth" required/>
							</div>
						</div>
						<div class="row">
							<div class="col-8 col-sm-8 form-group">
								<label for="nationality">Nationality:</label>
								<input type="text" class="form-control" id="nationality" ng-model="user.nationality" required/>
							</div>
							<div class="col-4 col-sm-4 form-group">
								<label for="maritalStatus">Marital Status:</label>
								<select id="maritalSelect" ng-model="user.marital" class="form-control" ng-change="maritalChange()">
									<option value=0>Single</option>
									<option value=1>Married</option>
									<option value=2>Divorced</option>
									<option value=3>Widowed</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-12 col-sm-6 form-group">
								<label for="telephone">Mobile Number:</label>
								<input type="text" class="form-control" id="mobilePhone" ng-model="user.mobile_number" required/>
							</div>
							<div class="col-12 col-sm-6 form-group">
								<label for="email">Email:</label>
								<input type="text" class="form-control" id="email" ng-model="user.email" required/>
							</div>
						</div>
						<!-- <div class="row">
							<div class="col-12 col-sm-12 form-group">
								<label for="residentialCountry">Address in Resident Country:</label>
								<textarea class="form-control" id="addressRC" ng-model="applicant.address_resident_country" rows="3"></textarea>
							</div>
						</div> -->
						<div class="row">
							<div class="col-6 col-sm-6 form-group">
								<label for="country">Country:</label>
								<div style="border: 1px solid #d2d6de; padding: 10px;">
									<select style="width: 100%;" ng-model="user.country" id="countrySelect" ng-options="x.name for x in listCountry.data"></select>
								</div>
							</div>
							<div class="col-6 col-sm-6 form-group">
								<label for="provider">Provider:</label>
								<input class="form-control" ng-model="user.provider"/>
							</div>
						</div>
						<div class="row">
							<div class="col-6 col-sm-6 form-group">
								<label for="profileImg">Profile Image:</label>
								<input class="custom-file-input" id="profileImg" type="file"/>
								<input type="hidden" id="profileImg64"/>
							</div>
						</div>
						<br/><br/>
						<div style="position: absolute; bottom: 15px; right: 15px;">
							<input type="button" class="btn btn-primary" ng-click="resetRegistration()" value="Reset"/>
							<input type="submit" class="btn btn-primary" ng-disabled="registrationForm.$invalid" value="Submit"/> 
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>