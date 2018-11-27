angular.module('salesConnect').service('salesPersonService',
    function( $http, $q ) {

		//#README# - [SEVICE NAMING MAPPING]
        return({
            getSalesPersonInfo: getSalesPersonInfo,
            getSalesPersonInfo_CustomerReview: getSalesPersonInfo_CustomerReview,
            getSalesPersonInfo_Myteam: getSalesPersonInfo_Myteam,
            getSalesPersonInfo_Carsold: getSalesPersonInfo_Carsold
        });

        function getSalesPersonInfo(salesPersonCode) {
            var request = $http({
                method: 'GET',
                url: 	'/salesConnect/salesPerson/' + salesPersonCode
            });
            return(request.then(handleSuccess, handleError));
        }
        
        function getSalesPersonInfo_CustomerReview(userid) {
            var request = $http({
                method: 'GET',
                url: 	'/salesConnect/salesPerson/customerReview/' + userid
            });
            return(request.then(handleSuccess, handleError));
        }
        
        function getSalesPersonInfo_Myteam(reportTo) {
            var request = $http({
                method: 'GET',
                url: 	'/salesConnect/salesPerson/myTeam/' + reportTo
            });
            return(request.then(handleSuccess, handleError));
        }
        
        function getSalesPersonInfo_Carsold(salesexecutiveid) {
            var request = $http({
                method: 'GET',
                url: 	'/salesConnect/salesPerson/carSold/' + salesexecutiveid
            });
            return(request.then(handleSuccess, handleError));
        }

        function handleError( response ) {
            // The API response from the server should be returned in a
            // nomralized format. However, if the request was not handled by the
            // server (or what not handles properly - ex. server error), then we
            // may have to normalize it on our end, as best we can.
            if (
                ! angular.isObject( response.data ) ||
                ! response.data.message
            ) {
                return( $q.reject( "An unknown error occurred." ) );
            }

            // Otherwise, use expected error message.
            return( $q.reject( response.data.message ) );
        };

        // I transform the successful response, unwrapping the application data
        // from the API response payload.
        function handleSuccess( response ) {
            return( response.data );
        }


    });