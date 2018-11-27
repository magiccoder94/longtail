angular
    .module('salesConnect')
    .controller('salesProfileCtrl', salesProfileCtrl);


angular
.module('salesConnect').filter('trustAsHtml', [ '$sce', function($sce) {
	return function(text) {
		return $sce.trustAsHtml(text);
	};
} ]);  

function salesProfileCtrl ($location, $window, salesPersonService) {
	
    var vm = this;
    vm.data = {};
    vm.data_myteam = {};
    vm.data_customer_review = {};
    vm.salesPersonCode = $location.search().salesid;

    salesPersonService.getSalesPersonInfo(vm.salesPersonCode).then(function (data) {
        
        vm.data = data;
        //**LOG RESULT**//
        console.log(vm.data);
        
        salesPersonService.getSalesPersonInfo_Carsold(vm.data.user.id).then(function (data) {
        	vm.data_car_sold = data;
            console.log(vm.data_car_sold);
        });
        
        salesPersonService.getSalesPersonInfo_CustomerReview(vm.data.user.id).then(function (data) {
        	vm.data_customer_review = data;
            console.log(vm.data_customer_review);
        });
        
        salesPersonService.getSalesPersonInfo_Myteam(vm.data.report_To).then(function (data) {      	
            vm.data_myteam = data;
            //**LOG RESULT**//
            console.log(vm.data_myteam);
        });
        
    });
    


    vm.getStars = function (starRating) {
        return "<i class='fa fa-star star-gold fa-1x'></i>";
    };

    vm.openExternal = function (link) {
        $window.open(link);
    }

    vm.getStarCount = function(num) {
        console.log(num);
        if (!Number.isInteger(num)) {
            num = num - 0.5;
        }
        console.log(num);
        return new Array(num);
    }

    vm.isHalfStar = function (num) {
        if (Number.isInteger(num)) {
            return false;
        } return true;
    }

}