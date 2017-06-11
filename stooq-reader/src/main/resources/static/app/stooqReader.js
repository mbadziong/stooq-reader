(function () {
    'use strict';

    require('angular');

    angular.module("stooqReader", ["ngWebSocket"]);

    require('./controllers');
    require('./factories');
}());