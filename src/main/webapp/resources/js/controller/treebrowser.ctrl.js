//angular.module('adaptv.adaptStrapDocs')
'use strict';
myApp.controller('TreeBrowserCtrl', ['$scope','TreeBrowserService', function ($scope, TreeBrowserService) {
	
	$scope.getAllUser = function () {
		TreeBrowserService.getAllUser().then(function (response) {
			$scope.treedata = [];
			$scope.treedata.push(response);// = response;
	        console.log("list of user \t" + JSON.stringify(response));

	    });
	};
	
  }]);