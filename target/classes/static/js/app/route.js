'use strict';

var app = angular.module('people');

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '../../templates/people.html',
        controller: 'peopleController'
    });
});