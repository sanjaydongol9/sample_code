/**
 * Created by Sunil on 3/16/2016.
 */
'use strict';
myApp.controller('AdminController', ['$scope', '$http', '$location', '$q', 'AdminService', 'AlertService', function ($scope, $http, $location, $q, AdminService, AlertService) {

//	  $scope.models = {
//		        selected: null,
//		        lists: {"Chandani": [], "Anil": []}
//		    };

		    // Generate initial model
//		    for (var i = 1; i <= 3; ++i) {
//		        $scope.models.lists.Chandani.push({label: "Candidate Chandani " + i});
//		        $scope.models.lists.Anil.push({label: "Candidate Anil " + i});
//		    }

		    // Model to JSON for demo purpose
//		    $scope.$watch('models', function(model) {
//		        $scope.modelAsJson = angular.toJson(model, true);
//		    }, true);
	$scope.getVendorWithCandidate = function () {
		AdminService.getVendorWithCandidate().then(function (response) {
	        $scope.vcModels = response;
	        console.log("list of user \t" + JSON.stringify(response));

	    });
		
		 // Model to JSON for demo purpose
	    $scope.$watch('vcModels', function(model) {
	        $scope.vcModelAsJson = angular.toJson(model, true);
	    }, true);
	    
	};
	
	/* Manage the Vendor Call Taker and Candidate */ 
	
	$scope.manageVendorWithCandidate = function (vcModelAsJson) {
		console.log("++++ Setting the Privilege");
		
		AdminService.manageVcCndidateRole(vcModelAsJson).then(function (response) {
			console.log("++++++++ Response from admin/vc_candidates+++++++++");
			console.log(response);
	        
	        if(response.status == 500){
				console.log(response.status);
				$scope.error = true;
				$scope.errorMessage = JSON.parse(response.message);
				console.log(response.message);
			} else {
				 $scope.vcModels = response;
				//AlertService.setSuccessMsg("User added successfully.");
				//console.log(AlertService.isSuccess());
				$location.path('/user-hierarchical');

			}

	    });
			    
	};
	
	$scope.getMarketerWithVc = function () {
		AdminService.getMarketerWithVc().then(function (response) {
	        $scope.marketerModels = response;
	        console.log("list of user \t" + JSON.stringify(response));

	    });
		
		 // Model to JSON for demo purpose
	    $scope.$watch('marketerModels', function(model) {
	        $scope.marketerModelAsJson = angular.toJson(model, true);
	    }, true);
	    
	};
	
	/* Manage the Marketer and Vendor Call Taker */ 
	$scope.manageMarketerWithVc = function (marketerModelAsJson) {
		console.log("++++ Setting the Privilege +++++++");
		
		AdminService.manageMarketerVcRole(marketerModelAsJson).then(function (response) {
			console.log("++++++++ Response from admin/marketing_vctakers +++++++++");
			console.log(response);
	        
	        if(response.status == 500){
				console.log(response.status);
				$scope.error = true;
				$scope.errorMessage = JSON.parse(response.message);
				console.log(response.message);
			} else {
				 $scope.marketerModels = response;
				 $location.path('/user-hierarchical');

			}

	    });
			    
	};
	
	$scope.addtechnology = function(name) {
		var technology = {};
		technology.name=name;
		console.log("========techhhhhh==========");
		console.log(technology);

		AdminService
				.addTechnology(technology)
				.then(
						function(response) {
							console
									.log("++++++++++++++++++Response++++++++++++++++++")
							console.log(response);

							if (response.status == 500) {
								console
										.log(response.status);
								$scope.error = true;
								$scope.errorMessage = JSON
										.parse(response.message);
								console
										.log(response.message);
							} else {
								$scope.user = Response;
								AlertService
										.setSuccessMsg("Technology added successfully.");
								console
										.log(AlertService
												.isSuccess());
								$location
										.path('/technologyManage');

							}
						})
	};

	AdminService.getAllTechnologies().then(
			function(response) {
				$scope.technology = response;
				console.log("role in asadasdsa \t"
						+ JSON.stringify(response));
			})

		    
		    
}]);
