'use strict'

myApp
		.controller(
				'BackgroundCheckerController',
				[
						'$scope',
						'$http',
						'$location',
						'BackgroundCheckerService',
						function($scope, $http, $location,
								BackgroundCheckerService) {
							console
									.log("====== Background Checker Controller Loaded ========");
							/*
							 * $scope.candidateName = ""; $scope.success =
							 * false;
							 */

							/*
							 * $scope.search= function(candidate){
							 * console.log(candidate); var str=
							 * JSON.stringify(candidate); alert(str); };
							 */
							// $scope.candidateName= "Pradeep";
							// $scope.search($scope.candidateName);
							// -----------------candidate list-----------
							$scope.getAllCandidate = function() {

								console.log("========candidate==========");
								// console.log(proxy);
								BackgroundCheckerService
										.getAllCandidate()
										.then(
												function(response) {
													console
															.log("++++++++++++++++++Response++++++++++++++++++")
													console.log(response);
													if (response.status == 500) {
														$scope.error = true;
														$scope.errorMessage = JSON
																.parse(response.message);
														console
																.log(response.message);
													} else {
														$scope.candidates = response;
														$location
																.path('/listCandidate');
													}
												})
							}
							$scope.candidateSortOrder = "+firstName";

							// ---------------candidate search----------------
							/*
							 * var expectFriendNames = function(expectedNames,
							 * key) { element.all(by.repeater(key + ' in
							 * candidates').column(key +
							 * '.firstName')).then(function(arr) {
							 * arr.forEach(function(wd, i) {
							 * expect(wd.getText()).toMatch(expectedNames[i]);
							 * }); }); };
							 * 
							 * it('should search in specific fields when
							 * filtering with a predicate object', function() {
							 * var searchAny = element(by.model('search.$'));
							 * searchAny.clear(); searchAny.sendKeys('i');
							 * expectFriendNames(['Mary', 'Mike', 'Julie',
							 * 'Juliette'], 'friendObj'); });
							 */
						} ]);
