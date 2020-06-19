myApp.factory('CService', [ '$http',function($http) {
    return{
        getMyCandidates: function () {
            return $http({
                method: 'GET',
                url: '/mycandidates'
            }).then(function successCallback(response) {
               return response.data;
            }, function errorCallback(response) {
                return response.data;
            });
        }
    }
} ]);

