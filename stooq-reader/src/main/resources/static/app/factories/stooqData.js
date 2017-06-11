(function () {
    "use strict";

    function StooqData($rootScope, $websocket) {

        const WEBSOCKET_URL = "ws://localhost:3333/stooq";

        var StooqData = {};
        var dataStream = $websocket(WEBSOCKET_URL);

        dataStream.onMessage(function (message) {
            $rootScope.$broadcast("stooq-data-changed", JSON.parse(message.data));
        });

        return StooqData;
    }

    module.exports = StooqData;
}());