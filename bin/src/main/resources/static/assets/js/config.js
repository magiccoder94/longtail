function configState($routeProvider, $stateProvider, $urlRouterProvider, $compileProvider, $locationProvider) {

/*    // Optimize load start with remove binding information inside the DOM element
    $compileProvider.debugInfoEnabled(true);

    // Set default state
    $urlRouterProvider.otherwise("/dashboard");
    $stateProvider
    .state('salesProfile',{
            url: "/dashboard",
            templateUrl: "views/dashboardView.html",
            data: {
                pageTitle: '',
                pageDesc: ''
            },
            onEnter: function () {
            }
        })
    ;

    // use the HTML5 History API
    $locationProvider.html5Mode(false);*/
	
    $routeProvider
    .when("/", {
        templateUrl : "views/dashboardView.html"
    })
    .when("/red", {
        templateUrl : "red.htm"
    })
    .when("/green", {
        templateUrl : "green.htm"
    })
    .when("/blue", {
        templateUrl : "blue.htm"
    });
}


angular
    .module('salesConnect')
    .config(configState)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });



