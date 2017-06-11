(function () {
    'use strict';

    angular
        .module("stooqReader")
        .factory("StooqData",
        require('./stooqData'));

    angular
        .module('stooqReader')
        .factory('StooqPlot',
        require('./stooqPlot'));
}());