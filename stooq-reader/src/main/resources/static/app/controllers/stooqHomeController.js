(function () {
    'use strict';

    function StooqHomeController($rootScope, $scope, $http, stooqData, stooqPlot) {

        $scope.ctx = document.getElementById("canvas").getContext("2d");

        $scope.lineChartData = stooqPlot.defaultDataConfig();

        $scope.myLine = Chart.Line($scope.ctx, {
            data: $scope.lineChartData,
            options: stooqPlot.defaultPlotOptions()
        });

        $http({
            method: 'GET',
            url: '/report.json'
        }).then(function successCallback(response) {
            var stooqDataRows = response.data;
            for (var rowNum = 0; rowNum < stooqDataRows.length; rowNum++) {
                $scope.loadNewStooqDataRow(stooqDataRows[rowNum].marketIndex);
            }
        }, function errorCallback(response) {
            //nothing to init
        });

        $scope.loadNewStooqDataRow = function (stooqData) {
            $scope.lineChartData.labels.push(new Date());
            $scope.lineChartData.datasets[0].data.push(stooqData.wig);
            $scope.lineChartData.datasets[1].data.push(stooqData.wig20);
            $scope.lineChartData.datasets[2].data.push(stooqData.wig20fut);
            $scope.lineChartData.datasets[3].data.push(stooqData.mwig40);
            $scope.lineChartData.datasets[4].data.push(stooqData.swig80);
        };

        $rootScope.$on('stooq-data-changed', function (event, stooqData) {
            $scope.loadNewStooqDataRow(stooqData);
            $scope.myLine.update();
        });
    }

    angular
        .module('stooqReader')
        .controller('stooqHomeController', ['$rootScope', '$scope', '$http', 'StooqData', 'StooqPlot', StooqHomeController]);
}());