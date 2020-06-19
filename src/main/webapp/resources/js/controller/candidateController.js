'use strict';
myApp.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);


myApp.controller('candidateController',['$scope','$http', '$location','$q','candidateService',function ($scope,  $http, $location, $q, candidateService){	
	console.log("====== candidate Controller Loaded ========");
	$scope.candidate = {};
	$scope.success = false;
	var url="C:/test/upload";
	$scope.addcandidate = function (candidate) {
		console.log("========candidate==========");
		console.log(candidate);
		console.log("--------------------"+candidate.file);
		
		candidateService.addCandidate(url,candidate).then(function(response){
			console.log("++++++++++++++++++Response++++++++++++++++++")
			console.log(response);
			if(response.status == 500){
				console.log(">>>>>>>error 500 <<<<<<");
				$scope.error = true;
				$scope.errorMessage = JSON.parse(response.message);
				console.log(response.message);
			} else {
				$scope.user = response;
				console.log(">>>>>>>>>>>>>>>success <<<<<<");
				//AlertService.setSuccessMsg("User added successfully.");
				//console.log(AlertService.isSuccess());
				$location.path('/listCandidate');
			}
		})
	}
	
	candidateService.getAllTechnologies().then(function(response){
		$scope.technology = response;
		console.log("role in asadasdsa \t"+ JSON.stringify(response));
	})
	
}]);



