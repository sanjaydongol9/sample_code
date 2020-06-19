'use strict';

myApp.controller('CController', ['$scope', '$http', '$location', 'CService',
    function ($scope, $http, $location, CService) {
        alert("ball");
        CService.getMyCandidates().then(function (response) {
            console.log(response);
        });
    }]);