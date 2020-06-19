
myApp.factory('candidateService', [ '$http', '$q', function($http, $q) {
	return{
		addCandidate: function (uploadUrl,candidate) {
			console.log('=========service================');
			var fd = new FormData();
		        fd.append("file", candidate.file);
		        delete candidate.file;
		        fd.append("candidate",angular.toJson(candidate));
		        return $http({
		            method: 'POST',
		            url: 'bchecker/create-candidate',
		            headers: {'Content-Type': undefined},
		            data: fd,
		            transformRequest: function(data, headersGetterFunction) {
		                return data;
		            }
		        }).then(
	                    function(response){
	                    	
	                    	console.log('====success in candidate service=====');
	                        return response.data;
	                    }, 
	                    function(errResponse){
	                        console.log('==== Error while creating user ====');
	                        console.log(errResponse);
	                        $q.reject(errResponse);
	                        return errResponse.data;
	                    }
	            ); 
		/*	return $http.post('admin/create-candidate',fd, {
				headers: {transformRequest: function(data, headersGetterFunction) {
			        return data; 
			    },'Content-Type': "multipart/form-data" }})
            .then(
                    function(response){
                    	
                    	console.log('====success in candidate service=====');
                        return response.data;
                    }, 
                    function(errResponse){
                        console.log('==== Error while creating user ====');
                        console.log(errResponse);
                        $q.reject(errResponse);
                        return errResponse.data;
                    }
            );*/
		},
		getAllTechnologies:function() {
			return $http({
				method : 'GET',
				url : 'bchecker/get-technology',
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
		}
	}
} ]);
