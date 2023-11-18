function firstNonRepeatingCharWithMap(inputStr) {
    if(inputStr.length === 0) return null;
    let charCountsMap = new Map();
    for(let ch of inputStr) {
        charCountsMap.set(ch, (charCountsMap.get(ch) || 0) + 1);
    }
    
    for(let [key, value] of charCountsMap.entries()) {
        if(value === 1) {
            return key;
        }
    }
    return null;
}

function firstNonRepeatingCharWithObj(inputStr) {
    if(inputStr.length === 0) return null;
    let charCountsObj = {};
    for(let ch of inputStr) {
        charCountsObj[ch] = (charCountsObj[ch] || 0) + 1;
    }
    
    for(let [key, value] of Object.entries(charCountsObj)) {
        if(value === 1) {
            return key;
        }
    }
    return null;
}



/**---------------
   All Unique
   --------------- */
console.log("Input: 'abcdefgh'");
console.log("Output: ", firstNonRepeatingCharWithObj('abcdefgh'));
console.log("---------------");

/**---------------
   Some Duplicates
   --------------- */
console.log("Input: 'abccddefgggh'");
console.log("Output: ", firstNonRepeatingCharWithObj('abccddefgggh'));
console.log("---------------");

/** ---------------
    All Duplicates
    --------------- */
console.log("Input: 'aabbccdddeeeff'");
console.log("Output: ", firstNonRepeatingCharWithMap('aabbccdddeeeff'));
console.log("---------------");

/** ---------------
    Empty String
    --------------- */
console.log("Input: ''");
console.log("Output: ", firstNonRepeatingMap(''));
console.log("---------------");
