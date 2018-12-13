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
	</style>
</head>

<meta name="viewport" content="width=device-width, initial-scale=0.65">

<body ng-controller="ctl_view_applicant_form">
	<div class="container" style="margin-top: 20%;">
		<div class="col-12 col-sm-12">
			<div class="card mb-3">
				<div class="card-header">
					<h3><i class="fa fa-hand-pointer-o"></i>Applicant Form</h3>
				</div>
				<div class="card-body">
					<form class="demo-form" ng-submit="submitSaveApplicant()">
						<div class="form-section">
							<h3>Applicant Data</h3>
							<div class="row">
								<div class="col-8 col-sm-8 form-group">
									<label for="name">Name:</label>
									<input type="text" class="form-control" id="name" ng-model="applicant.name" required/>
								</div>
								<div class="col-4 col-sm-4 form-group">
									<label for="yearBirth">Year of Birth:</label>
									<input type="number" class="form-control" id="yearBirth" ng-model="applicant.year_birth" required/>
								</div>
							</div>
							<div class="row">
								<div class="col-8 col-sm-8 form-group">
									<label for="nationality">Nationality:</label>
									<input type="text" class="form-control" id="nationality" ng-model="applicant.nationality" required/>
								</div>
								<div class="col-4 col-sm-4 form-group">
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
								<div class="col-12 col-sm-6 form-group">
									<label for="telephone">Mobile Number:</label>
									<input type="text" class="form-control" id="mobilePhone" ng-model="applicant.mobile_number" required/>
								</div>
								<div class="col-12 col-sm-6 form-group">
									<label for="officeNumber">Office Number:</label>
									<input type="text" class="form-control" id="officePhone" ng-model="applicant.office_number" required/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-6 form-group">
									<label for="email">Email:</label>
									<input type="text" class="form-control" id="email" ng-model="applicant.email" required/>
								</div>
								<div class="col-12 col-sm-6 form-group">
									<label for="fax">Fax:</label>
									<input type="text" class="form-control" id="fax" ng-model="applicant.fax"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="residentialCountry">Address in Resident Country:</label>
									<textarea class="form-control" id="addressRC" ng-model="applicant.address_resident_country" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="academicQualification">Highest Academic / Professional Qualification:</label>
									<textarea class="form-control" id="academicQualify" ng-model="applicant.academic_professional" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="occupation_business">Present Occupation / Business engaged in:</label>
									<textarea class="form-control" id="occupationBusiness" ng-model="applicant.occupation_business" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="employer_business">Employer's Name / Name of own business:</label>
									<input type="text" class="form-control" id="employerBusiness" ng-model="applicant.employer_business"/>
								</div>
							</div>
						</div>
						
						<div class="form-section">
							<h3>Corporate Applicant</h3>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="companyName">Name of company / Business:</label>
									<input type="text" class="form-control" ng-model="applicant.company_name" required/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="incorporationRegistration">Country of Incorporation / Registration:</label>
									<input type="text" class="form-control" ng-model="applicant.incorporation_registration"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="residentialCountryC">Address in Resident Country:</label>
									<input type="text" class="form-control" ng-model="applicant.c_residential_country"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-6 form-group">
									<label for="telephone">Telephone:</label>
									<input type="text" class="form-control" ng-model="applicant.c_telephone"/>
								</div>
								<div class="col-12 col-sm-6 form-group">
									<label for="fax">Fax:</label>
									<input type="text" class="form-control" ng-model="applicant.c_fax"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="emailWebsite">Email / Website:</label>
									<input type="text" class="form-control" ng-model="applicant.email_website"/>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<label for="incorporateYear">Year of Incorporation:</label>
									<input type="number" class="form-control" ng-model="applicant.C_incorate_year"/>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<label for="incorparateNo">Incorporation No:</label>
									<input type="text" class="form-control" ng-model="applicant.C_incorporation_no"/>
								</div>
							</div>
							<div class="row">
								<div class="col-4 col-sm-4 form-group">
									<select id="entityType" ng-model="applicant.C_entity_type" class="form-control" ng-change="entityChange()">
										<option value=0>Private Limited</option>
										<option value=1>Public</option>
										<option value=2>Partnership</option>
										<option value=3>Sole Proprietorship</option>
										<option value=4>Others</option>
									</select>
								</div>
								<div class="col-6 col-sm-6 form-group">
									<label for="others">Please specify for others:</label>
									<input type="text" class="form-control" ng-model="applicant.entity_others" ng-disabled="applicant.C_entity_type == 4"/>
								</div>
							</div>
							<div class="row">
								<div class="col-6 col-sm-6 form-group">
									<input type="hidden" class="form-control" ng-model="applicant.capital_currency" ng-init="applicant.capital_currency='USD'"/>
									<label for="capitalisation">Capitalisation (Paid-Up): US$</label>
									<input type="number" class="form-control" ng-model="applicant.capitalisation"/>
								</div>
							</div>
							<div class="row">
								<div class="col-4 col-sm-4 form-group">
									<input type="hidden" class="form-control" ng-model="applicant.financial_year_sale_currency" ng-init="applicant.financial_year_sale_currency='USD'"/>
									<label for="yearSaleTurnOver">Previous Financial Year's Sales Turnover: US$</label>
									<input type="number" class="form-control" ng-model="applicant.financial_year_sale"/>
								</div>
								<div class="col-8 col-sm-8 form-group">
									<p>FY</p>
									<input type="number" class="form-control" ng-model="applicant.fy_param1"/>
									<p>to</p>
									<input type="number" class="form-control" ng-model="applicant.fy_param2"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label for="shareholdingStruct">
									Shareholding Structure: 
									<span>Please indicate name of individuals and/or companies and percentage held.</span>
									</label>
									<textarea class="form-control" ng-model="applicant.shareholding_structure" rows="4"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Name of the intended Managing Principal <i>(person who will manage the franchise)</i></label>
									<input type="text" class="form-control" ng-model="applicant.name_managing_principal" required/>
								</div>
							</div>
							<div class="row">
								<div class="col-2 col-sm-2 form-group">
									<label>Age:</label>
									<input type="number" class="form-control" ng-model="applicant.mp_age" required/>
								</div>
								<div class="col-4 col-sm-4 form-group">
									<label>Marital Status:</label>
									<select class="form-control" ng-model="applicant.mp_marital_status" ng-change="maritalChangeMP()">
										<option value=0>Single</option>
										<option value=1>Married</option>
										<option value=2>Divorced</option>
										<option value=3>Widowed</option>
									</select>
								</div>
								<div class="col-8 col-sm-8 form-group">
									<label>Nationality:</label>
									<input type="text" class="form-control" ng-model="applicant.mp_nationality"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Current Occupation or Designation within company:</label>
									<input type="text" class="form-control" ng-model="applicant.mp_occupation_designation"/>
								</div>
							</div>
						</div>
						<div class="form-section">
							<h3>Other Information</h3>
							<div class="row">
								<div class="col-8 col-sm-8 form-group">
									<input type="hidden" class="form-control" ng-model="applicant.funds_available_currency" ng-init="applicant.funds_available_currency='USD'"/>
									<label>Amount of funds available to invest in the business: US$</label>
									<input type="number" class="form-control" ng-model="applicant.funds_available" required/>
								</div>
							</div>
							<div class="row">
								<div class="col-4 col-sm-4 form-group">
									<label>Main source of funds</label>
									<select class="form-control" ng-model="applicant.source_funds" ng-change="sourceFundChange()">
										<option value=0>Internal</option>
										<option value=1>External</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-8 col-sm-8 form-group">
									<label>Which type of franchise are you interested to obtain</label>
									<select class="form-control" ng-model="applicant.franchise_type" ng-change="franchiseTypeChange()">
										<option value=0>Single</option>
										<option value=1>Multiple</option>
										<option value=2>Country Master</option>
										<option value=3>Area Master</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>In what country(s)/territory(s) do you plan to operate the franchise?</label>
									<textarea class="form-control" ng-model="applicant.operate_location" rows="2"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4 col-6 form-group">
									<label>How familiar are you with franchising? </label>
									<select class="form-control" ng-model="applicant.familiar">
										<option value=4>Very</option>
										<option value=3>Fairy</option>
										<option value=2>Little</option>
										<option value=1>Not</option>
									</select>
								</div>
								<div class="col-sm-4 col-6 form-group">
									<label>Have you operated a franchise business before?</label>
									<input type="radio" class="form-control" ng-model="applicant.operated" name="operated" value=true/> Yes<br/>
									<input type="radio" class="form-control" ng-model="applicant.operated" name="operated" value=false/> No<br/>
									<span><i>if yes, please state</i></span>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Franchise Name:</label>
									<input type="text" class="form-control" ng-model="applicant.franchise_name" ng-disabled="applicant.operated='false'" ng-required="'true'"/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<label>Country of Origin:</label>
									<input type="text" class="form-control" ng-model="applicant.country_origin" ng-disabled="applicant.operated='false'" ng-required="'true'"/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<label>Nature of business:</label>
									<input type="text" class="form-control" ng-model="applicant.business_nature" ng-disabled="applicant.operated='false'" ng-required="'true'"/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<label>Period of Franchise:</label>
									<input type="text" class="form-control" ng-model="pplicant.franchise_period" ng-disabled="applicant.operated='false'" ng-required="'true'"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>How familiar are you with the operation of an education-preschool / training business?</label>
									<select class="form-control" ng-model="applicant.operate_preschool">
										<option value=4>Very</option>
										<option value=3>Fairly</option>
										<option value=2>Little</option>
										<option value=1>Not</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Have you operated a kindergarden business before? </label>
									<input type="radio" class="form-control" ng-model="applicant.operated_kinder" value=true/> Yes<br/>
									<input type="radio" class="form-control" ng-model="applicant.operated_kinder" value=false/> No<br/>
									<span><i>if yes, please state</i></span>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Description of Business:</label>
									<input type="text" class="form-control" ng-model="applicant.business_desc" ng-disabled="applicant.operated_kinder='false'" ng-required="'true'"/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<label>Location of Business:</label>
									<input type="text" class="form-control" ng-model="applicant.business_location" ng-disabled="applicant.operated_kinder='false'" ng-required="'true'"/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<label>Period of Operation:</label>
									<input type="text" class="form-control" ng-model="applicant.business_period" ng-disabled="applicant.operated_kinder='false'" ng-required="'true'"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Do you presently own or rent premises which may be suitable for operating a restaurant?</label>
									<input type="radio" ng-model="applicant.rent_premises" name="premises" value=true/> Yes<br/>
									<input type="radio" ng-model="applicant.rent_premises" name="premises" value=false/> No<br/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<label>Location:</label>
									<input type="text" class="form-control" ng-model="applicant.premise_location" ng-disabled="applicant.rent_premises='false'" ng-required="'true'"/>
								</div>
								<div class="col-12 col-sm-12 form-group">
									<input type="hidden" class="form-control" ng-model="applicant.monthly_rent_currency" ng-init="applicant.monthly_rent_currency='USD'"/>
									<label>Monthly Rent: US$</label>
									<input type="text" class="form-control" ng-model="applicant.monthly_rent" ng-disabled="applicant.rent_premises='false'" ng-required="'true'"/>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Briefly, what are your reason for wanting to acquire the franchise? </label>
									<textarea class="form-control" ng-model="applicant.reason" rows="3"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Name some strength that you think will make you a good franchisee</label>
									<textarea class="form-control" ng-model="applicant.strength" rows="4"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-12 col-sm-12 form-group">
									<label>Other relevant information:</label>
									<textarea class="form-control" ng-model="applicant.relevant_info" rows="4"></textarea>
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
										<input type="datetime-local" class="form-control" ng-model="applicant.form_date" ng-model-options="{timezone: 'UTC'}" required/>
									</div>
								</div>
							</div>
						</div>
						<br/><br/>
						<div class="form-navigation">
							<button type="button" class="previous btn btn-info pull-left">&lt; Previous</button>
							<button type="button" class="next btn btn-info pull-right">Next &gt;</button>
							<input type="submit" class="btn btn-primary" id="submitButton" value="Submit"/>
							<span class="clearfix"></span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>