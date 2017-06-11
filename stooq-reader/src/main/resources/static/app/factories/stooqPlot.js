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
                labels: [],
                datasets: [{
                    label: "WIG",
                    borderColor: colors.red,
                    backgroundColor: colors.red,
                    borderWidth: 1,
                    lineTension: 0,
                    fill: false,
                    data: []
                }, {
                    label: "WIG20",
                    borderColor: colors.blue,
                    backgroundColor: colors.blue,
                    borderWidth: 1,
                    lineTension: 0,
                    fill: false,
                    data: []
                }, {
                    label: "WIG20FUT",
                    borderColor: colors.green,
                    backgroundColor: colors.green,
                    borderWidth: 1,
                    lineTension: 0,
                    fill: false,
                    data: []
                }, {
                    label: "MWIG40",
                    borderColor: colors.orange,
                    backgroundColor: colors.orange,
                    borderWidth: 1,
                    lineTension: 0,
                    fill: false,
                    data: []
                }, {
                    label: "SWIG80",
                    borderColor: colors.purple,
                    backgroundColor: colors.purple,
                    borderWidth: 1,
                    lineTension: 0,
                    fill: false,
                    data: []
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
                },
                scales: {
                    xAxes: [{
                        display: false
                    }]
                }
            };
        };

        return StooqPlot;
    }

    module.exports = StooqPlot;
}());