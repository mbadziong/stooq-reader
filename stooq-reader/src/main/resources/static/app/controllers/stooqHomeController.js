(function () {
    'use strict';

    function StooqHomeController($rootScope, $scope, stooqData, stooqPlot) {

        $scope.ctx = document.getElementById("canvas").getContext("2d");

        $scope.lineChartData = stooqPlot.defaultDataConfig();

        $scope.myLine = Chart.Line($scope.ctx, {
            data: $scope.lineChartData,
            options: stooqPlot.defaultPlotOptions()
        });

        $rootScope.$on('stooq-data-changed', function (event, stooqData) {
            $scope.lineChartData.labels.push(new Date());
            $scope.lineChartData.datasets[0].data.push(stooqData.wig);
            $scope.lineChartData.datasets[1].data.push(stooqData.wig20);
            $scope.lineChartData.datasets[2].data.push(stooqData.wig20fut);
            $scope.lineChartData.datasets[3].data.push(stooqData.mwig40);
            $scope.lineChartData.datasets[4].data.push(stooqData.swig80);

            $scope.myLine.update();
        });
    }

    angular
        .module('stooqReader')
        .controller('stooqHomeController', ['$rootScope', '$scope', 'StooqData', 'StooqPlot', StooqHomeController]);
}());