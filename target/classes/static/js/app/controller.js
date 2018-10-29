'use strict';

var app = angular.module('people');

app.controller('peopleController', function ($scope, People) {
    $scope.peoples;

    $scope.findAll = function () {
        People.findAll().then(function (response) {
            $scope.peoples = response.data;
        });
    };

    $scope.findAll();
});