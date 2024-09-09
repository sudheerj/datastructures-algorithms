let globalMap;

export default {
    getInstance: function() {
        if(globalMap === undefined) {
            globalMap = new Map();
        }

        return globalMap;
    }
}