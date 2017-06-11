(function () {
    'use strict';

    require('bootstrap/dist/css/bootstrap.min.css');
    require('../../styles/stooq.css');

    angular
        .module('stooqReader')
        .controller('stooqHomeController', ['$rootScope', '$scope', '$http', 'StooqData', 'StooqPlot',
            require('./stooqHomeController')]);
}());