'use strict';

myApp.controller('SignUpController',['$scope','$http','$location', '$q','UserService','AlertService','$filter',function ($scope, $http,$location, $q, UserService,AlertService,$filter){

	$scope.password = null;
	$scope.rePassword = null;

//	$scope.user = {};
//	$scope.success = false;
//	$scope.error = false;
//	$scope.closeSuccessAlert = function () {
//		$scope.success = false;
//	}
//	$scope.closeErrorAlert = function () {
//		$scope.error = false;
//	}
//	$scope.createUser = function (user) {
//		console.log(user);
//		return $http.post('/anon/user/add', user)
//        .then(
//                function(response){
//                	console.log(response);
//                	$scope.success = true;
//                	$scope.user = {};
//                    return response.data;
//                },
//                function(errresponse){
//                    console.error('error while creating user');
//                    $scope.error = true;
//                    $scope.errorMessage = errresponse.data.message;
//                    return $q.reject(errresponse);
//                }
//        );
//	}

	console.log("====== user Controller Loaded ========");


	$scope.user = {};
	$scope.success = false;

	$scope.adduser = function (user) {
	user.dob = $filter('date')(user.dob,'MM/dd/yyyy');
		console.log("========user==========");
		console.log(user);

		UserService.addUser(user).then(function(response){
			console.log("++++++++++++++++++Response++++++++++++++++++")
			console.log(response);


			if(response.status == 500){
				console.log(response.status);
				$scope.error = true;
				$scope.errorMessage = JSON.parse(response.message);
				console.log(response.message);
			} else {
				$scope.user = Response;
				AlertService.setSuccessMsg("User added successfully.");
				console.log(AlertService.isSuccess());
				$location.path('/manage');

			}
		})
	};

		UserService.getRole().then(function(response){
			$scope.roles = response;
			$scope.roles.shift();
			console.log("role in userCtrl \t"+ response);
		})
	
}]);

myApp.directive('passwordConfirm', ['$parse', function ($parse) {
	return {
		restrict: 'A',
		scope: {
			matchTarget: '=',
		},
		require: 'ngModel',
		link: function link(scope, elem, attrs, ctrl) {
			var validator = function (value) {
				ctrl.$setValidity('match', value === scope.matchTarget);
				return value;
			}

			ctrl.$parsers.unshift(validator);
			ctrl.$formatters.push(validator);

			// This is to force validator when the original password gets changed
			scope.$watch('matchTarget', function(newval, oldval) {
				validator(ctrl.$viewValue);
			});

		}
	};
}]);
// angular.module('UserValidation', []).directive('validPasswordC', function ()
// {
// return {
// require: 'ngModel',
// link: function (scope, elm, attrs, ctrl) {
// ctrl.$parsers.unshift(function (viewValue, $scope) {
// var noMatch = viewValue != scope.userForm.password.$viewValue
// ctrl.$setValidity('noMatch', !noMatch)
// })
// }
// }
// })
