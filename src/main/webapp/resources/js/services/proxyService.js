myApp.factory('ProxyService', [ '$http', '$q', function($http, $q) {
	return{  
		addProxy : function(proxy) {
			return $http.post('admin/addproxy', proxy, {
				headers : {
					'Content-Type' : 'application/json',
					"Accept" : "application/json"
				}
			}).then(function(response) {
				return response;
			}, function(errResponse) {
				$q.reject(errResponse);
				return errResponse;
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
getAllProxy: function(){
			return $http({
				method : 'GET',
				url : 'proxy/getProxy',
				data : '',
				DataType : 'application/json'
			}).then(function(response){
				return response.data;
				console.log(">>>>User in the service <<<<<<" + JSON.stringify(response.data));
			})
        },
        deleteProxy: function(id){
			return $http({
				method : 'GET',
				url : 'proxy/deleteProxy/' + id,
				data : '',
				DataType : 'application/json'
			})
		},
		getProxy:function(id){
			return $http({
				method:'GET',
				url:'proxy/getProxy/' +id,
				data:'',
				DataType : 'application/json'
				
			})
		},
		updateProxy : function(proxy){
			console.log(">>>>>>>>>proxy has been updated service<<<<<<<<<<<<"+proxy);
			return $http({
				method : 'PUT',
				url :'proxy/updateProxy',
				data : proxy,
				DataType :'application/json'
			})
		},
			}
}
	]);