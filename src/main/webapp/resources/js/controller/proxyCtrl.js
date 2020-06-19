/**
 * 
 */
'use strict';

myApp.controller('proxyController', [ '$scope', '$http', '$q', 'ProxyService','$location',
		function($scope, $http, $q, ProxyService,$location) {

			console.log("====== proxy Controller Loaded ========");
			$scope.proxy = {};
			$scope.success = false;

			
			$scope.addproxy = function(proxy) {
				ProxyService.addProxy(proxy).then(function(response) {
					console.log(response)
					if (response.status == 500) {
						console.log(">>>>>>>>>>>>>server error in proxy controller<<<<<<<<<")
						$scope.error = true;
						$scope.errorMessage = JSON.parse(response.message);
						console.log(response.message);
					} else {
						$scope.proxy = response;
						console.log(">>>>>>>>>>data inserted in data<<<<<<<<<")
						$location.path('/showProxy');
					}
				})
			}
			ProxyService.getAllTechnologies().then(function(response){
				$scope.technology = response;
				console.log("role in asadasdsa \t"+ JSON.stringify(response));
			})
			
			

		} ]);
