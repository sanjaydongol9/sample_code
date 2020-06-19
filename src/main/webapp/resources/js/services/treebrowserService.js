myApp.factory('TreeBrowserService', [
		'$http',
		'$q',
		function($http, $q) {
			return {
				/* Get Vendor and Respective Candidates */
				getAllUser : function() {
					return $http({
						method : 'GET',
						url : 'admin/tree-view-user',
						data : '',
						dataType : 'application/json'
					}).then(function(response) {
								return response.data;
					})
				}
			   
			}

} ]);
