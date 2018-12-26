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
		
		$scope.resetCreateFranchise = function(){
			$scope.franchise.name = "";
			$scope.franchise.company_name = "";
			$scope.franchise.description = "";
			$scope.franchise.type = 0;
			$scope.franchise.categoru = 0;
			
			document.getElementById("createLogo_img").value = "";
			document.getElementById("createLogo_imgBase64").value = "";
		}; 
		
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
				$scope.franchise.description = table.row(this).data().description;
				$scope.franchise.logoImg = table.row(this).data().logo_img;
				$scope.franchise.category = table.row(this).data().category;
				$scope.franchise.type = table.row(this).data().type;
				
				$compile(franchiseType)($scope);
				$compule(categoryFranchise)($scope);
				
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