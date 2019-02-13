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
		
		$http.get("${pageContext.request.contextPath}/investcontroller/get_country_list")
		.then(function(response){
			if(response.status == "403"){
				alert("Session TIME OUT");
				$(location).attr('href', '${pageContext.request.contextPath}/home')
			} else {
				$scope.listCountry = response.data;
			}
		});
		
		$scope.submitSaveApplicant = function(){
			$('#submitButton').attr("disabled", true);
			//category should be made into JSONArray
			var postdata = {
				id : ($scope.applicant.formType=='create' ? undefined : $scope.form_id),
				address : $scope.applicant.address,
				bank_details : $scope.applicant.bank_details,
				seek_out : $scope.applicant.seekout_period,
				category : $scope.applicant.category,
				country_id : $scope.applicant.country,
				gender : $scope.applicant.gender,
				passport64 : $('#passPortImg64').val(),
				existing_passport : $scope.applicant.existing_passport,
				profile64 : $('#imgProfile64').val(),
				existing_profile : $scope.applicant.existing_profile,
				address64 : $('#addressImg64').val(),
				existing_address : $scope.applicant.existing_address,
				invest_range : $scope.applicant.invest_range,
				invest_range_currency : $scope.applicant.invest_range_currency,
				management_participate : $scope.applicant.management_participate,
				nationality : $scope.applicant.nationality,
				participant_name : $scope.applicant.participant_name,
				passport_number : $scope.applicant.passport_number,
				percentage_share_target : $scope.applicant.percentage_share_target,
				seekout_period : $scope.applicant.seekout_period,
				telephone_number : $scope.applicant.telephone_number,
				indicator : ($scope.applicant.formType=='create' ? 1 : 2)
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
		
		$('input[type=file]').change(function(event) {
			var element = event.target.id;
			var reader = new FileReader();
			var _URL = window.URL || window.webkitURL;
			var file = this.files[0];
			var check = fileCheck(file, element);
			if (check == false) {
				return false;
			}
			reader.readAsDataURL(file);
			reader.onload = function() {
				if (element === "passPortImg")
					$('#passPortImg64').val(reader.result);
				if (element === "addressImg")
					$('#addressImg64').val(reader.result);
				if (element === "imgProfile")
					$('#imgProfile64').val(reader.result);
			}
			reader.onerror = function(error) {
			}
		});
		
		function fileCheck(file, elementName) {
			var img;
			if (file.type.indexOf("image") == -1) {
				alert("Invalid image file.");
				$('#' + elementName).wrap('<form>').closest('form').get(0).reset();
				$('#' + elementName).unwrap();
				return false;
			}
			
			if (file.size > 50000) {
				alert("Image file must not exceed 50kb.");
				$('#' + elementName).wrap('<form>').closest('form').get(0).reset();
				$('#' + elementName).unwrap();
				return false;
			}
		};
	});
</script>
</html>