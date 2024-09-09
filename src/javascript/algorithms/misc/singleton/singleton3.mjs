const GlobalMap = (function(){
    const _internalMap = new Map();

    return {
        getInstance: function() {
            return _internalMap;
        }
    }
})();

export default GlobalMap;