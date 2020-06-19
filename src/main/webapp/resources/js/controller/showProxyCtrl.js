myApp.controller('showProxyController', ['$scope', '$http', '$location' ,'ProxyService','$routeParams','$modal', '$log','$mdDialog', 
      function ($scope, $http, $location, ProxyService, $routeParams,$modal,$log,$mdDialog) {

    ProxyService.getAllProxy().then(function (response) {
        $scope.proxies = response;
        console.log("list of user \t" + JSON.stringify(response));

    });

    $scope.deleteProxy = function (proxyToDelete) {
        var confirm = $mdDialog.confirm()
            .title('Would you like to delete Proxy?')
            .textContent('you are about to delete proxy.')
            .ariaLabel('delete')

            .ok('DELETE!')
            .cancel('CANCEL!');

        $mdDialog.show(confirm).then(function() {


            ProxyService.deleteProxy(proxyToDelete.id).then(function (response) {
                if(response)
                    $scope.proxies.splice($scope.proxies.indexOf(proxyToDelete),1);
                console.log(">>>>>>>>>delete operation<<<<<<<<<<<" + response);
            });
            $scope.status = 'You decided to delete of your proxy.';
        }, function() {
            $scope.status = 'You decided to keep your proxy.';
        });

    }


    //modal to show update form
    $scope.updateProxy = function(size, selectedProxy){
        console.log(">>>>>>>inside update user function<<<<<<<<<<"+ selectedProxy);
        var modalInstance = $modal.open({
            templateUrl: 'resources/pages/update-proxy.jsp',
            controller: function($scope, $modalInstance, proxy){
                $scope.proxy = proxy;

                $scope.ok = function () {
                    $modalInstance.close($scope.selectedProxy);
                };

                $scope.cancel = function () {
                    $modalInstance.dismiss('cancel');
                }
            },
            size: size,
            resolve:{
                proxy: function(){
                    return selectedProxy;
                }
            }
        });
            modalInstance.result.then(function (selectedProxy) {
                $scope.proxy = selectedProxy;
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
        };

    $scope.editProxy = function(proxy){
        console.log(">>>>>>>>Inside update user controller<<<<<<<<<<<"+ proxy.id);
        ProxyService.updateProxy(proxy);
    }


}]);