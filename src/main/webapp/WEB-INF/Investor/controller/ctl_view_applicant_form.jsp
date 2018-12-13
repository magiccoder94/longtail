<html>
<script>
	app.controller('ctl_view_applicant_form', function($scope, $http, $timeout){
		
		var canvas = document.getElementById('signPad');
		var clearButton = document.getElementById('clearBtn');
		var undoButton = document.getElementById('undoBtn');
		var signaturePad = new SignaturePad(canvas, {
		  // It's Necessary to use an opaque color when saving image as JPEG;
		  // this option can be omitted if only saving as PNG or SVG
		  backgroundColor: 'rgb(255, 255, 255)'
		});
		
		clearButton.addEventListener("click", function (event) {
			signaturePad.clear();
		});
		
		undoButton.addEventListener("click", function (event) {
			  var data = signaturePad.toData();

			  if (data) {
			    data.pop(); // remove the last dot or line
			    signaturePad.fromData(data);
			  }
		});
		
		$(document).ready(function () {
			console.log("test")
			var $sections = $('.form-section');
			
			function navigateTo(index){
				// Mark the current section with the class 'current'
				$sections
					.removeClass('current')
					.eq(index)
						.addClass('current');
				// Show only the navigation buttons that make sense for the current section:
				$('.form-navigation .previous').toggle(index > 0);
				var atTheEnd = index >= $sections.length - 1;
				$('.form-navigation .next').toggle(!atTheEnd);
				$('.form-navigation [type=submit]').toggle(atTheEnd);
			}
			
			function curIndex() {
				// Return the current index by looking at which section has the class 'current'
				return $sections.index($sections.filter('.current'));
			}
			
			// Previous button is easy, just go back
		    $('.form-navigation .previous').click(function() {
			  navigateTo(curIndex() - 1);
		    });
			
		    // Next button goes forward iff current block validates
		    $('.form-navigation .next').click(function() {
			  $('.demo-form').parsley().whenValidate({
			    group: 'block-' + curIndex()
			  }).done(function() {
			    navigateTo(curIndex() + 1);
			  });
		    });
		    
		    // Prepare sections by setting the `data-parsley-group` attribute to 'block-0', 'block-1', etc.
			$sections.each(function(index, section) {
			  $(section).find(':input').attr('data-parsley-group', 'block-' + index);
			});
			  navigateTo(0); // Start at the beginning
		});
		
		$scope.submitSaveApplicant = function(){
			$('#submitButton').attr("disabled", true);
			
			var postdata = {
				name : $scope.applicant.name,
				year_birth : $scope.applicant.year_brith,
				nationality : $scope.applicant.nationality,
				marital_status : $scope.applicant.marital,
				mobile_phone : $scope.applicant.mobile_number,
				office_phone : $scope.applicant.office_number,
				email : $scope.applicant.email,
				fax : $scope.applicant.fax,
				resident_country_address : $scope.applicant.address_resident_country,
				academic_qualification : $scope.applicant.academic_professional,
				occupation_business : $scope.applicant.occupation_business,
				employer_business_name : $scope.applicant.employer_business,
				company_business_name : $scope.applicant.company_name,
				incorporation_registration : $scope.applicant.incorporation_registration,
				c_resident_address : $scope.applicant.c_residential_country,
				corp_phone_no : $scope.applicant.c_telephone,
				corp_fax : $scope.applicant.c_fax,
				corp_email : $scope.applicant.email_website,
				year_incorporated : $scope.applicant.C_incorporate_year,
				incorporation_number : $scope.applicant.C_incorporation_no,
				entity_type : $scope.applicant.C_entity_type,
				other_entity : $scope.applicant.entity_others,
				capitalisation_currency : $scope.applicant.capital_currency,
				capitalisation_amount : $scope.applicant.capitalisation,
				preYearSales_currency : $scope.applicant.financial_year_sale_currency,
				preYearSales_amount : $scope.applicant.financial_year_sale,
				param1 : $scope.applicant.fy_param1,
				param2 : $scope.applicant.fy_param2,
				percentage_share : $scope.applicant.shareholding_structure,
				managing_principal : $scope.applicant.name_managing_principal,
				mPrincipal_age : $scope.applicant.mp_age,
				mPrincipal_marital_status : $scope.applicant.mp_marital_status,
				mPrincipal_nationality : $scope.applicant.mp_nationality,
				mPrincipal_occupation_designation : $scope.applicant.mp_occupation_designation,
				source_fund_currency : $scope.applicant.funds_available_currency,
				source_fund_amount : $scope.applicant.funds_available,
				source_fund : $scope.applicant.source_funds,
				franchise_interested : $scope.applicant.franchise_type,
				country_territory : $scope.applicant.operate_location,
				franchise_familiarity : $scope.applicant.familiar,
				operated_franchise : $scope.applicant.operated,
				franchise_name : $scope.applicant.franchise_name,
				country_origin : $scope.applicant.country_origin,
				business_nature : $scope.applicant.business_nature,
				franchise_period : $scope.applicant.franchise_period,
				operation_education_training : $scope.applicant.operate_preschool,
				operated_kindergarden : $scope.applicant.operated_kinder,
				business_description : $scope.applicant.business_desc,
				business_location : $scope.applicant.business_location,
				business_period : $scope.applicant.business_period,
				premise_own : $scope.applicant.rent_premises,
				premise_location : $scope.applicant.premise_location,
				monthly_rent_currency : $scope.applicant.monthly_rent_currency,
				monthly_rent_amount : $scope.applicant.monthly_rent,
				franchise_reason : $scope.applicant.reason,
				applicant_strength : $scope.applicant.strength,
				relevant_info : $scope.applicant.relevant_info,
				//canvas need to be save
				applicant_position : $scope.applicant.position,
				form_date : $scope.applicant.form_date,
				indicator : 1
			};
			console.log("postdata "+JSON.stringify(postdata));
			
			$http({
				method : 'POST',
				headers : {'Content-Type' : 'applicant/json'},
				url : '${pageContext.request.contextPath}/investorcontroller/save_applicant',
				data : {
					formfield : postdata
				}
			}).then(function(response){
				
			})
		}
	});
</script>
</html>