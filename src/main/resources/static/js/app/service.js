var app = angular.module('people');

app.factory('People', function ($http) {
    return {
        findAll: function () {
            var data = {};

            var config = {
                headers: {}
            };

            return $http.get('/rest/people/', data, config);
        },
        findById: function (id) {
            var data = {};

            var config = {
                headers: {}
            };

            return $http.get('/rest/people/' + id, data, config);
        },
        save: function (people) {
            var data = {
                name: people.name,
                nif: people.nif,
                placeType: people.placeType,
                place: people.place,
                number: people.number,
                neighborhood: people.neighborhood,
                city: people.city,
                state: people.state,
                cellphone: people.cellphone,
                telephone: people.telephone
            };

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };

            return $http.post('/rest/people/save' + people.id, data, config);
        },
        remove: function (id) {
            var data = {};

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };

            return $http.post('/rest/people/remove' + id, data, config);
        }
    };
});