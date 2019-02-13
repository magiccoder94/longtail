<html lang="en">
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
	label{
		font-weight: bold;
		color: black;
	}
	span{
		font-weight: bold;
		color: black;
	}
	.one.column {
    	width: 98%;
	}
	</style>
</head>

<meta name="viewport" content="width=device-width, initial-scale=0.65">
<body ng-controller="ctl_view_applicant_form">
<div class="column one column_divider "><hr class="no_line" style="margin: 0 auto 100px;"></div>
<div class="column one column_divider "><hr class="no_line" style="margin: 0 auto 50px;"></div>
	<div class="container">
		<div class="col-12 col-sm-12">
			<div class="card mb-3">
				<div class="card-header">
					<h3><i class="fa fa-hand-pointer-o"></i>Applicant Form</h3>
				</div>
				<div class="card-body">
					<form class="demo-form" ng-submit="submitSaveApplicant()">
						<div class="form-section">
							<h2>Participant Info</h2>
							<div class="row">
								<div class="col-8 col-sm-8 form-group">
									<label for="name">Name:</label>
									<input type="text" class="form-control" ng-model="applicant.participant_name"/>
								</div>
								<div class="col-4 col-sm-4 form-group">
									<label for="passport">Passport Number:</label>
									<input type="text" class="form-control" ng-model="applicant.passport_number"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="address">Address:</label>
									<textarea class="form-control" ng-model="applicant.address" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label for="nationality">Nationality:</label>
									<input type="text" class="form-control" ng-model="applicant.nationality"/>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<label for="gender">Gender:</label>
									<select class="form-control" ng-change="genderChange()" ng-model="applicant.gender">
										<option value=0>MALE</option>
										<option value=1>FEMALE</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label for="country">Country of choice for Investment:</label>
									<div style="border: 1px solid #d2d6de; padding: 10px;">
										<select style="width: 100%;" ng-model="applicant.country" ng-options="x.name for x in listCountry.data"></select>
									</div>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<label for="tele">Telephone Number:</label>
									<input type="text" class="form-control" ng-model="applicant.telephone_number"/>
								</div>
							</div>
							<div class="row">
								<span>We require your bank details for refund purposes.</span>
								<div class="col-12 col-sm-12 form-group">
									<label for="bankDetail">Bank Account Number:</label>
									<textarea class="form-control" ng-model="applicant.bank_details" rows="3"></textarea>
								</div>
							</div>
							<br/>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<span>Please include a profile photo not older than 3 months</span>
									<label for="profilePhoto">Upload Profile Photo:</label>
									<input type="file" class="file-input" id="imgProfile"/>
									<input type="hidden" class="form-control" id="imgProfile64"/>
								</div><br/>
								<div class="col-12 col-sm-12 form-group">
									<label for="passportImg">Upload IC/Passport:</label>
									<input type="file" class="file-input" id="passPortImg"/>
									<input type="hidden" class="form-control" id="passPortImg64"/>
								</div><br/>
								<div class="col-12 col-sm-12 form-group">
									<span>Please include a photo of your utility bill or bank statement as </span>
									<span>proof of address</span>
									<label for="addressImg">Upload Address Detail:</label>
									<input type="file" class="file-input" id="addressImg"/>
									<input type="hidden" class="form-control" id="addressImg64"/>
								</div>
								<!-- include multi select from CRM corp -->
							</div>
						</div>
						<div class="form-section">
							<h3>Investment Details</h3>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label for="investmentRange">Investment Range:</label>
									<input type="number" class="form-control" ng-model="applicant.invest_range"/>
									<input type="hidden" class="form-control"/>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<label for="percentageTarget">Percentage Share Target (%):</label>
									<input type="number" class="form-control" ng-model="applicant.percentage_share_target"/>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label>Please specify seek out period:</label>
									<select class="form-control" ng-change="seekOutChange()" ng-model="applicant.seekout_period">
										<option value=6>6 Months</option>
										<option value=9>9 Months</option>
										<option value=12>12 Months</option>
										<option value=24>24 Months</option>
									</select>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<input type="checkbox" name="management" ng-model="applicant.management_participate"/> Participate as Management
								</div>
							</div>
						</div>
						<div class="form-section">
							<h3>Declaration</h3>
							<span>
							I certify that all information provided herewith is true and accurate to the best of my knowledge. 
							I understand that should any of the above information prove to be false, my application for the franchise.name 
							franchise will be terminated immediately.
							</span>
							<br/>
							<div class="row">
								<div class="col-12 col-sm12 form-group">
									<div id="signature-pad" class="signature-pad">
										<div class="signature-pad--body">
											<canvas style="border: 1px solid blue; width: 100%" id="signPad" width="500" height="200" style="touch-action: none;"></canvas>
										</div>
										<div class="signature-pad--footer">
											<div class="description">Signature</div>
											<div class="signature-pad--actions">
												<div>
													<button id="clearBtn" type="button" class="button clear" data-action="clear">Clear</button>
													<button id="undoBtn" type="button" class="button" data-action="undo">Undo</button>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-6 col-sm-6 form-group">
										<label>Position:</label>
										<input type="text" class="form-control" ng-model="applicant.position"/>
									</div>
									<div class="col-6 col-sm-6 form-group">
										<label>Date:</label>
										<input type="datetime-local" class="form-control" ng-model="applicant.form_date" ng-model-options="{timezone: 'UTC'}"/>
									</div>
								</div>
							</div>
						</div>
						<br/><br/>
						<div class="form-navigation">
							<button type="button" class="previous btn btn-info pull-left">Previous</button>
							<button type="button" class="next btn btn-info pull-right">Next</button>
							<input type="submit" class="btn btn-primary pull-right" id="submitButton" value="Submit"/>
							<span class="clearfix"></span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>