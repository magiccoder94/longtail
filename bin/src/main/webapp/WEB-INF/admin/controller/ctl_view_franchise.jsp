<html>
<script>
	app.controller('ctl_view_franchise', function($scope, $http, $compile, $timeout){
		$scope.modalType = '';
		$scope.franchise = {};
		
		$scope.setModalType = function(action_type){
			$scope.franchise.action = action_type;
		}
		
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
				$('#' + elementName).unwrap();
				return false;
			}
			//height and width checking not confirm yet
		};
		
		$http.get("${pageContext.request.contextPath}/admincontroller/get_category_list")
		.then(function(response){
			$scope.listCategory = response.data;
		}); 
		
		$scope.submitCreateFranchise = function(){
			if($scope.modalType =='create' && document.getElementById("createLogo_imgBase64").value == null ||
					$scope.modalType =='create' && document.getElementById("createLogo_imgBase64").value == "" ){
				$('#createLogo_img').focus();
				alert("Franchise logo cannot be blank.");
			} else {
				$('#modal_loading').modal("show");
				
				if($scope.modalType == 'create'){
					$('#submitBtn').attr("disabled".true);
					$('#resetBtn').attr("disabled".true);
				} else if($scope.modalType == 'update'){
					$('#submitUpBtn').attr("disabled", true);
				}
				
				var postdata = {
					id : ($scope.modalType == 'create' ? undefined : $scope.franchise.id),
					name : $scope.franchise.name,
					company_name : $scope.franchise.company_name,
					description : $scope.franchise.description,
					type : $scope.franchise.type,
					category : $scope.franchise.category,
					logo_img : $("#createLogo_imgBase64").val(),
					indicator : ($scope.modalType == 'create' ? 1 : 2)
					criteria : $scope.franchise.criteria_franchise,
					introduction : $scope.franchise.introduction_franchise,
					short_description : $scope.franchise.short_description,
					description_package : $scope.franchise.description_package,
					category_id : $scope.franchise.category,
					type : $scope.franchise.type,
					management_participant : $scope.franchise.management_participant,
					invest_participant : $scope.franchise.invest_participant,
					management_fee : $scope.franchise.management_service_fee_amount,
					management_currency : $scope.franchise.management_service_fee_currency,
					min_invest_amount : $scope.franchise.minimum_invest_amount,
					min_invest_currency : $scope.franchise.minimum_invest_currency,
					max_invest_amount : $scope.franchise.maximum_invest_amount,
					max_invest_currency : $scope.franchise.maximum_invest_currency
				};
				console.log("postdata "+ JSON.stringify(postdata));
				
				$http({
					method : 'POST',
					headers : {'Content-Type' : 'application/json'},
					url : "${pageContext.request.contextPath}/admincontroller/save_franchise",
					data : {formfield : postdata}
				}).then(function(){
					if(response.data.msg != null){
						console.log("response data: "+response.data.msg);
					}else{
						console.log("response "+response.data.error);
					}
					
					$('modal_loading').modal('hide');
					
					if($scope.modalType == 'create'){
						$('#submitBtn').attr("disabled", false);
						$('#resetBtn').attr("disabled", false);
					}else if($scope.modalType == 'update'){
						$('#submitUpBtn').attr("disabled", false);
					}
					
					$scope.resetCreateFranchise();
					refreshTable();
					$('#create_franchise_modal').modal('toggle');
				})
			}
		}; 
		
		$(document).ready(function(){
			$scope.franchise.type = '0';
			$scope.franchise.category = '0';
			refreshTable(); 
		})
		
		function refreshTable(){
			var table = $('#datable_variant').DataTable({
				"ajax" : {
					"url" : "${pageContext.request.contextPath}/admincontroller/get_franchise_list",
					"statusCode" : {
						403 : function(){
							alert("Session TIME OUT");
							$(location).attr('href',"${pageContext.request.contextPath}/user/signin")
						}
					}
				},
				"order" : [[0,"asc"]],
				"columns" : [
					{"data" : "id"},
					{"data" : "name"},
					{"data" : "company_name"},
					{"data" : "date_created"},
					{"data" : "date_updated"},
					{"orderable" : false,
					 "data" : "id",
					 "render" : function(data){
						 return '<a class="fa fa-minus-circle" style="color: red;" ng-click="removeFranchise(' + data + ')"></a>';
					 }
					}
				],
				"scrollX" : true,
				destroy : true
			});
			
			$('#datable_variant').off('click','tr');
			$('#datable_variant').on('click','tr', function(){
				$scope.franchise.name = table.row(this).data().name;
				$scope.franchise.company_name = table.row(this).data().company_name;
				$scope.franchise.criteria_franchise = table.row(this).data().criteria_franchise;
				$scope.franchise.introduction_franchise = table.row(this).data().introduction_franchise;
				$scope.franchise.short_description = table.row(this).data().short_description;
				$scope.franchise.description = table.row(this).data().description;
				$scope.franchise.logoImg = table.row(this).data().logo_img;
				$scope.franchise.category = table.row(this).data().category;
				$scope.franchise.type = table.row(this).data().type;
				$scope.franchise.management_participant = table.row(this).data().management_participant;
				$scope.franchise.invest_participant = table.row(this).data().invest_participant;
				$scope.franchise.management_service_fee_amount = table.row(this).data().management_service_fee_amount;
				$scope.franchise.management_service_fee_currency = table.row(this).data().management_service_fee_currency;
				$scope.franchise.minimum_invest_amount = table.row(this).data().minimum_invest_amount;
				$scope.franchise.minimum_invest_currency = table.row(this).data().minimum_invest_currency;
				$scope.franchise.maximum_invest_amount = table.row(this).data().maximum_invest_amount;
				$scope.franchise.maximum_invest_currency = table.row(this).data().maximum_invest_currency;
				
				$compile(franchiseType, categoryFranchise)($scope);
				
				$('#updateDbImg').attr("src", "${pageContext.request.contextPath}"+table.row(this).data().logoImg);
				
				$scope.show_create_franchise_model('update');
			});
			
			$scope.show_create_franchise_model = function(type){
				$scope.modalType = type;
				if($scope.modalType == 'create'){
					$('submitBtn').val('Save Franchise');
				}else if($scope.modalType == 'update'){
					$('submitBtn').val('Update Franchise');
				}
				
				$('#create_franchise_modal').modal('show');
			};
			
		}; 
		
		$scope.resetCreateFranchise = function(){
			$scope.franchise.name = "";
			$scope.franchise.company_name = "";
			$scope.franchise.criteria_franchise = "";
			$scope.franchise.introduction_franchise = "";
			$scope.franchise.short_description = "";
			$scope.franchise.description = "";
			$scope.franchise.type = 0;
			$scope.franchise.category = 0;
			$scope.franchise.management_participant = 0;
			$scope.franchise.invest_participant = 0;
			$scope.franchise.management_service_fee_amount = "";
			$scope.franchise.management_service_fee_currency = "";
			$scope.franchise.minimum_invest_amount = "";
			$scope.franchise.maximum_invest_amount = "";
			
			document.getElementById("createLogo_img").value = "";
			document.getElementById("createLogo_imgBase64").value = "";
		}; 
		
		$scope.removeFranchise = function(id){
			var confirmation = confirm("Confirm to remove franchise from list?");
			
			if(confirmation == true){
				$http({
					method : 'POST',
					headers : {
						'Content-Type' : 'application/json'
					},
					url : "${pageContext.request.contextPath}/admincontroller/remove_franchise/"+id
				})
				.then(function(){
					if(response.data.msg != null){
						alert(response.data.msg);
						refreshTable();
					}else{
						alert("There was an error performing the request. Please try again later");
					}
				})
			}
		} 
	})
</script>
</html>