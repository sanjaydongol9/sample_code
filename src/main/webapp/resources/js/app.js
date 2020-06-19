'use strict';

var myApp = angular.module('cubicApp', [ 'ngRoute', 'ui.bootstrap','ngCookies','ngReallyClickModule','ui.mask','ngMaterial','dndLists','angularTreeview']);

myApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.
	when('/masteradmin', {
		templateUrl : '/views/admin/dashboard.jsp',
		controller : 'DashboardCtrl'
	}).when('/admin', {
		templateUrl : '/views/admin/dashboard.jsp',
		controller : 'DashboardCtrl'
	}).when('/marketer', {
		templateUrl : '/views/admin/dashboard.jsp',
		controller : 'DashboardCtrl'
	}).when('/vc', {
		templateUrl : '/views/admin/dashboard.jsp',
		controller : 'DashboardCtrl'
	}).when('/bchecker', {
		templateUrl : '/views/admin/dashboard.jsp',
		controller : 'DashboardCtrl'
	}). when('/addUser', {
        templateUrl: 'resources/pages/add-user.jsp',
        controller: 'SignUpController'
    /*}). when('/user/edit/:id',{
        templateUrl: 'resources/pages/add-user.jsp',
        controller: 'SignUpController'*/
    }).when('/manage',{
        templateUrl :'resources/pages/manage.html',
        controller : 'ManageController'
    })
    .when('/addProxy', {
        templateUrl: 'resources/pages/add-proxy.jsp',
        controller : 'proxyController'
    }).when('/manage-vc-cand', {
        templateUrl: 'resources/pages/manage-vc-candidate.jsp',
        controller : 'AdminController'
    }).when('/searchCandidate', {
    	templateUrl: 'resources/templates/candidateSearch.html',
    	controller: 'BackgroundCheckerController'
    }).when('/manage-marketing-vc', {
        templateUrl: 'resources/pages/manage-marketing-vc.jsp',
        controller : 'AdminController'
    }).when('/user-hierarchical', {
        templateUrl: 'resources/pages/user-hierarchical.jsp',
        controller : 'TreeBrowserCtrl'
    })
    	.when('/listCandidate',{
    		templateUrl: 'resources/templates/candidateList.html',
    		controller: 'BackgroundCheckerController'
    	})
    .when('/addCandidate', {
        templateUrl: 'resources/pages/add-candidate.jsp',
        controller: 'candidateController'
    }).when('/manage-vc-cand', {
        templateUrl: 'resources/pages/manage-vc-candidate.jsp',
        controller : 'AdminController'
    }).when('/showProxy', {
        templateUrl: 'resources/pages/show-proxy.html',
        controller : 'showProxyController'
    }).when('/addTechnology', {
        templateUrl: 'resources/pages/add-technology.jsp',
        controller : 'AdminController'
    }).when('/technologyManage', {
        templateUrl: 'resources/pages/technologyManage.html',
        controller : 'AdminController'
    }).otherwise({
		redirectTo : '/'
	})
} ]);


angular.module('ngReallyClickModule', ['ui.bootstrap'])
  .directive('ngReallyClick', ['$uibModal',
    function($uibModal) {

      var ModalInstanceCtrl = function($scope, $uibModalInstance) {
        $scope.ok = function() {
        	$uibModalInstance.close();
        };

        $scope.cancel = function() {
        	$uibModalInstance.dismiss('cancel');
        };
      };

      return {
        restrict: 'A',
        scope:{
          ngReallyClick:"&",
          item:"="
        },
        link: function(scope, element, attrs) {
          element.bind('click', function() {
            var message = attrs.ngReallyMessage || "Are you sure ?";

            var modalHtml = '<div class="modal-body">' + message + '</div>';
            modalHtml += '<div class="modal-footer"><button class="btn btn-primary" ng-click="ok()">Yes</button><button class="btn btn-warning" ng-click="cancel()">Cancel</button></div>';

            var modalInstance = $uibModal.open({
              template: modalHtml,
              controller: ModalInstanceCtrl
            });

            modalInstance.result.then(function() {
              scope.ngReallyClick({item:scope.item}); //raise an error : $digest already in progress
            }, function() {
              //Modal dismissed
            });
            //*/
            
          });

        }
      }
    }
  ]);

/*
angular.module('UserValidation', []).directive('validPasswordC', function () {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            ctrl.$parsers.unshift(function (viewValue, $scope) {
                var noMatch = viewValue != scope.userForm.password.$viewValue
                ctrl.$setValidity('noMatch', !noMatch)
            })
        }
    }
});*/
