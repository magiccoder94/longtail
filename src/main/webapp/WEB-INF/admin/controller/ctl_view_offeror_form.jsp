<html>
<script>
	app.controller('ctl_view_offeror_form', function($scope, $http, $timeout){
		$scope.offeror = {};
		
		$scope.resetOfferorForm = function(){
			$scope.offeror.name = "";
			$scope.offeror.company_number = "";
			$scope.offeror.telephone_number = "";
			$scope.offeror.address = "";
			$scope.offeror.country_incorporation = "";
			
			$scope.offeror.dateInc = new Date();	
			var h = $scope.offeror.dateInc.getHours() +8;
			var m = $scope.offeror.dateInc.getMinutes();
			$scope.offeror.dateInc.setHours(h, m, 0, 0);
			
			$scope.offeror.principalContactName = "";
			$scope.offeror.principalContactNumber = "";
			$scope.offeror.category_id = 0;
			$scope.offeror.country_id = 0;
			$scope.offeror.offerAmount = "";
			
			$('#corporateDocImg').val("");
			$('#corporateDocImg64').val("");
			$('#disclosureDocImg').val("");
			$('#disclosureDocImg64').val("");
		};
		
		$scope.submitOfferorForm = function(){
			console.log("submitting form")
			var postdata = {
				name : $scope.offeror.name,
				company_number : $scope.offeror.company_number,
				telephone_number : $scope.offeror.telephone_number,
				address : $scope.offeror.address,
				country_incorporation : $scope.offeror.country_incorporation,
				dateInc : $scope.offeror.dateInc,
				principalContactName : $scope.offeror.principalContactName,
				principalContactNumber : $scope.offeror.principalContactNumber,
				category_id : $scope.offeror.category_id,
				country_id : $scope.offeror.country_id,
				offerAmount : $scope.offeror.offerAmount,
				offerCurrency : $scope.offeror.offerCurrency,
				corporateDocImg64 : $('#corporateDocImg64').val(),
				disclosureDocImg64 : $('#disclosureDocImg64').val()
			};
			
			console.log(JSON.stringify(postdata));
			
			$http({
				method : 'POST',
				headers : {'Content-Type' : 'application/json'},
				url : '${pageContext.request.contextPath}/admincontroller/save_offeror_form',
				data : {
					formfield : postdata
				}
			}).then(function(response){
				
			})
		};
		
		$('input[type=file]').change(function(event){
			var element = event.target.id;
			var reader = new FileReader();
			var _URL = window.URL || window.webkitURL;
			var file = this.files[0];
			var check = fileCheck(file, element);
			if (check == false) {
				return false;
			}
			reader.readAsDataURL(file);
			reader.onload = function(){
				if(element == "corporateDocImg")
					$('#corporateDocImg64').val(reader.result);
				if(element == "disclosureDocImg")
					$('#disclosureDocImg64').val(reader.result);
			}
			reader.onerror = function(error){
				
			}
		});
	});
</script>
</html>