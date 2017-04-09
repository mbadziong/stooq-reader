(function () {
    "use strict";

    function StooqPlot() {

        var StooqPlot = {};

        var colors = {
            red: 'rgb(255, 99, 132)',
            orange: 'rgb(255, 159, 64)',
            yellow: 'rgb(255, 205, 86)',
            green: 'rgb(75, 192, 192)',
            blue: 'rgb(54, 162, 235)',
            purple: 'rgb(153, 102, 255)',
            grey: 'rgb(201, 203, 207)'
        };

        StooqPlot.defaultDataConfig = function () {
            return {
                labels: ["label1", "label2", "label3", "albel4", "label5"],
                datasets: [{
                    label: "WIG",
                    borderColor: colors.red,
                    backgroundColor: colors.red,
                    fill: false,
                    data: [66, 5, 2, 44, 2]
                }, {
                    label: "WIG20",
                    borderColor: colors.blue,
                    backgroundColor: colors.blue,
                    fill: false,
                    data: [5, 8, 0, 23, 1]
                }, {
                    label: "WIG20FUT",
                    borderColor: colors.green,
                    backgroundColor: colors.green,
                    fill: false,
                    data: [4, 5, 33, 12, 2]
                }, {
                    label: "MWIG40",
                    borderColor: colors.orange,
                    backgroundColor: colors.orange,
                    fill: false,
                    data: [33, 94, 2, 12, 3]
                }, {
                    label: "SWIG80",
                    borderColor: colors.purple,
                    backgroundColor: colors.purple,
                    fill: false,
                    data: [12, 3, 7, 11, 2]
                }]
            };
        };

        StooqPlot.defaultPlotOptions = function () {
            return {
                responsive: true,
                hoverMode: 'index',
                stacked: false,
                title: {
                    display: true,
                    text: 'Stooq Market Index'
                }
            };
        };

        return StooqPlot;
    }

    angular
        .module('stooqReader')
        .factory('StooqPlot', StooqPlot);
}());