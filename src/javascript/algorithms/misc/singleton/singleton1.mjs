const globalMap = new Map();

export default {
    getInstance: function() {
        return globalMap;
    }
}