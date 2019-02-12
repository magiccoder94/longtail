<html>
<head>
	<style>
	.form-section {
		padding-left: 15px;
		border-left: 2px solid #FF851B;
		display: none;
	}
	.form-section.current {
		display: inherit;
	}
	}
	</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=0.65">
<body>
	<div class="container" style="margin-top: 20%;">
		<div class="col-12 col-sm-12">
			<div class="card mb-3">
				<div class="card-header">
					<h3><i class="fa fa-hand-pointer-o"></i>Offeror Form</h3>
				</div>
				<div class="card-body">
					<form class="demo-form" ng-submit="submitOfferorForm()" name="offerorForm">
						<div class="form-section">
							<!-- <h3></h3> -->
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="name">Offeror Name:</label>
									<input type="text" class="form-control" ng-model="offeror.name"/>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label for="companyNumber">Company Number:</label>
									<input type="text" class="form-control" ng-model="offeror.company_number"/>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<label for="telephone">Telephone Number:</label>
									<input type="text" class="form-control" ng-model="offeror.telephone_number"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="address">Address:</label>
									<textarea class="form-control" ng-model="offeror.address" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label for="country">Country Incorporation:</label>
									<div style="border: 1px solid #d2d6de; padding: 10px;">
										<select style="width: 100%;" ng-model="offeror.country_incorporation" ng-options="x.name for x in listCountry.data"></select>
									</div>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<label for="dateIncorporation">Date Incorporated:</label>
									<input type="datetime-local" ng-model="offeror.dateInc" ng-model-options="{timezone : 'UTC'}" class="form-control"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="principalContactName">Principal Contact Name:</label>
									<input type="text" class="form-control" ng-model="offeror.principalContactName"/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<label for="principalContactNumber">Principal Contact Number:</label>
									<input type="text" class="form-control" ng-model="offeror.principalContactNumber"/>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label for="category">Category:</label>
									<div style="border: 1px solid #d2d6de; padding: 10px;">
										<select style="width: 100%;" ng-model="offeror.category_id" ng-options="x.name for x in listCategory.data"></select>
									</div>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<label for="country">Country:</label>
									<div style="border: 1px solid #d2d6de; padding: 10px;">
										<select style="width: 100%;" ng-model="offeror.country_id" ng-options="x.name for x in listCountry.data"></select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label for="fullAmountOffer">Amount Offering:</label>
									<input type="number" class="form-control" ng-model="offeror.offerAmount"/>
									<input type="hidden" class="form-control" id="offerCurrency"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="corporateDocument">Corporate Document:</label>
									<input type="file" id="corporateDocImg" class="form-control"/>
									<input type="hidden" id="corporateDocImg64" class="form-control"/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<label for="disclosureDocument">Disclosure Document:</label>
									<input type="file" id="disclosureDocImg" class="form-control"/>
									<input type="hidden" id="disclosureDocImg64" class="form-control"/>
								</div>
							</div>
						</div>
						<br/><br/>
						<div style="position: absolute; bottom: 15px; right: 15px;">
							<input type="button" class="btn btn-primary" ng-click="resetOfferorForm()" value="Reset"/>
							<input type="submit" class="btn btn-primaru" ng-disabled="offerorForm.$invalid" value="Submit"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>