<html>
<script>
	app.controller('ctl_view_registration_form', function($scope, $http, $timeout){
		$scope.user = {};
		$scope.user.marital = 0;
		
		$scope.resetRegistration = function(){
			$scope.user.first_name = "";
			$scope.user.last_name = "";
			$scope.user.username = "";
			$scope.user.password = "";
			$scope.user.year_birth = "";
			$scope.user.nationality = "";
			$scope.user.marital = 0;
			$scope.user.mobile_number = "";
			$scope.user.email = "";
			$scope.user.country = 0;
			$scope.user.provider = "";
		};
		
		$scope.submitRegistration = function(){
			console.log("submitting data")
			var postdata = {
				first_name : $scope.user.first_name,
				last_name : $scope.user.last_name,
				username : $scope.user.username,
				password : $scope.user.password,
				year_birth : $scope.user.year_birth,
				nationality : $scope.user.nationality,
				marital : $scope.user.marital,
				mobile_number : $scope.user.mobile_number,
				email : $scope.user.email,
				country : $scope.user.country,
				provider : $scope.user.provider,
				profile_img : $('#profileImg64').val()
			};
			
			$http({
				method : 'POST',
				headers : {'Content-Type' : 'applicant/json'},
				url : '${pageContext.request.contextPath}/investorcontroller/register',
				data : {
					formfield : postdata
				}.then(function(response){
					
				})
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
				if(element == "profileImg")
					$('#profileImg64').val(reader.result);
			}
			reader.onerror = function(error){
				
			}
		});
		
	});
</script>
</html>