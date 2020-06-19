myApp.factory('AdminService', [
		'$http',
		'$q',
		function($http, $q) {
			return {
				/* Get Vendor and Respective Candidates */
				getVendorWithCandidate : function() {
					return $http({
						method : 'GET',
						url : 'admin/vc_candidates',
						data : '',
						dataType : 'application/json'
					}).then(function(response) {
								return response.data;
					})
				}, 
				
			   manageVcCndidateRole:function(vcModelAsJson) {
				   return $http.post('admin/vc_candidates', vcModelAsJson, {headers: {'Content-Type': 'application/json', "Accept" : "application/json"}})
		            .then(

		                    function(response){
		                        return response.data;
		                    },
		                    function(errResponse){
		                        $q.reject(errResponse);
		                        return errResponse.data;
		                    }
		            );
			   },
			   addTechnology : function(technology) {
					return $http.post('admin/create-technology', technology, {
						headers : {
							'Content-Type' : 'application/json',
							"Accept" : "application/json"
						}
					}).then(function(response) {
						return response.data;
					}, function(errResponse) {
						$q.reject(errResponse);
						return errResponse.data;
					});
				}, 
				getAllTechnologies:function() {
					return $http({
						method : 'GET',
						url : 'admin/get-technology',
						data : '',
						DataType : 'application/json',
						headers : {
							'Accept' : 'application/json; charset=utf-8',
							'Content-Type' : 'application/json; charset=utf-8'
						}
					}).then(function(response) {
						return response.data;
					}, function(errResponse) {
						$q.reject(errResponse);
						return errResponse.data;
					});
				},
		
			   getMarketerWithVc : function() {
					return $http({
						method : 'GET',
						url : 'admin/marketing_vctakers',
						data : '',
						dataType : 'application/json'
					}).then(function(response) {
								return response.data;
					})
				}, 
				
				manageMarketerVcRole:function(marketerModelAsJson) {
					   return $http.post('admin/marketing_vctakers', marketerModelAsJson, {headers: {'Content-Type': 'application/json', "Accept" : "application/json"}})
			            .then(
			                    function(response){
			                        return response.data;
			                    },
			                    function(errResponse){
			                        $q.reject(errResponse);
			                        return errResponse.data;
			                    }
			            );
				   }
			   
			}

} ]);
