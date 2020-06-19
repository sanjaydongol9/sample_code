myApp.factory('UserService', [ '$http', '$q', function($http, $q) {
	return{

		addUser: function (user) {

			return $http.post('admin/create-user', user, {headers: {'Content-Type': 'application/json', "Accept" : "application/json"}})
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

        getAllUser: function(){
			return $http({
				method : 'GET',
				url : 'user/allUser',
				data : '',
				DataType : 'application/json'
			}).then(function(response){
				return response.data;
				console.log(">>>>User in the service <<<<<<" + JSON.stringify(response.data));
			})
        },
      

		getRole : function() {
			return $http({
				method : 'GET',
				url : 'admin/roles',
				data : '',
				DataType : 'application/json',
				headers : {
					'Accept' : 'application/json; charset=utf-8',
					'Content-Type' : 'application/json; charset=utf-8'
				}
			}).then(function(response) {
				console.log(">>>>>>>>>>>>value in userservice<<<<<<<<<<<"+ response.data);
				return response.data;
			}, function(errResponse) {
				$q.reject(errResponse);
				return errResponse.data;
			});
		},

		updateUser : function(user){
			console.log(">>>>>>>>>user has been updated service<<<<<<<<<<<<"+user);
			return $http({
				method : 'PUT',
				url :'user/updateUser',
				data : user,
				DataType :'application/json'
			})
		},

		deleteUser: function(id){
			return $http({
				method : 'GET',
				url : 'user/deleteUser/' + id,
				data : '',
				DataType : 'application/json'
			})
		},

	
	}

	}
]);
