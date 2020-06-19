/**
 * Created by Sunil on 3/16/2016.
 */
'use strict';

myApp.controller('ManageController', ['$scope', '$http', '$location', '$q', 'UserService', 'AlertService','$modal', '$log','$mdDialog',
    function ($scope, $http, $location, $q, UserService, AlertService, $modal, $log, $mdDialog) {

    UserService.getAllUser().then(function (response) {
        $scope.users = response;

        console.log("list of user \t" + JSON.stringify(response));

    });


    $scope.deleteUser = function (userToDelete) {
        var confirm = $mdDialog.confirm()
            .title('Would you like to delete User?')
            .textContent('you are about to delete user.')
            .ariaLabel('delete')

            .ok('DELETE!')
            .cancel('CANCEL!');

        $mdDialog.show(confirm).then(function() {


            UserService.deleteUser(userToDelete.id).then(function (response) {
                if(response)
                    $scope.users.splice($scope.users.indexOf(userToDelete),1);
                console.log(">>>>>>>>>delete operation<<<<<<<<<<<" + response);
            });
            $scope.status = 'You decided to delete of your user.';
        }, function() {
            $scope.status = 'You decided to keep your user.';
        });

    }


    //modal to show update form
    $scope.updateUser = function(size, selectedUser){
        console.log(">>>>>>>inside update user function<<<<<<<<<<"+ selectedUser);
        var modalInstance = $modal.open({
            templateUrl: 'resources/pages/update-user.jsp',
            controller: function($scope, $modalInstance, user){
                $scope.user = user;

                $scope.ok = function () {
                    $modalInstance.close($scope.selectedUser);
                };

                $scope.cancel = function () {
                    $modalInstance.dismiss('cancel');
                }
            },
            size: size,
            resolve:{
                user: function(){
                    return selectedUser;
                }
            }
        });
            modalInstance.result.then(function (selectedUser) {
                $scope.user = selectedUser;
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });
        };

    $scope.editUser = function(user){
        console.log(">>>>>>>>Inside update user controller<<<<<<<<<<<"+ user.id);
        UserService.updateUser(user);
    }


}]);