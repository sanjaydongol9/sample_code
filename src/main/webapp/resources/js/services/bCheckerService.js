myApp
		.factory(
				'BackgroundCheckerService',
				[
						'$http',
						'$q',
						function($http, $q) {
							return {
								/*
								 * getCandidate : function(candidate) { return
								 * $http({ method : 'GET', url :
								 * 'candidate/search', data : candidate,
								 * DataType : 'application/json', headers : {
								 * 'Accept' : 'application/json; charset=utf-8',
								 * 'Content-Type' : 'application/json;
								 * charset=utf-8' } }).then(function(response) {
								 * return response.data; },
								 * function(errResponse) {
								 * $q.reject(errResponse); return
								 * errResponse.data; }); }
								 */

								getAllCandidate : function() {
									console.log("+++ Getting++++");
									return $http(
											{
												method : 'GET',
												url : 'bchecker/all_candidate',
												data : '',
												DataType : 'application/json',
												headers : {
													'Accept' : 'application/json; charset=utf-8',
													'Content-Type' : 'application/json; charset=utf-8'
												}
											})
											.then(
													function(response) {
														console
																.log("+++ Get Candidates "
																		+ response.data);
														return response.data;

														return response.data;
														/*
														 * ,
														 * function(errResponse) {
														 * console.log("+++
														 * Error " +
														 * errResponse);
														 * $q.reject(errResponse);
														 * return
														 * errResponse.data;
														 */
													});
									;
								},
								updateCandidate : function(candidate) {
									console
											.log(">>>>>>>>>candidate has been updated service<<<<<<<<<<<<"
													+ user);
									return $http({
										method : 'PUT',
										url : 'candidate/updateCandidate',
										data : candidate,
										DataType : 'application/json'
									})
								},

								deleteCandidate : function(id) {
									return $http({
										method : 'GET',
										url : 'candidate/deleteCandidate/' + id,
										data : '',
										DataType : 'application/json'
									})
								}

							}
						} ]);
