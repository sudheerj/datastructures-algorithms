function findDuplicatesWithMap(arr) {
    let numCounts = new Map();
    let duplicates = [];
    for(const num of arr) {
        numCounts.set(num, (numCounts.get(num) || 0) + 1);
    }

    for(const [key, value] of numCounts.entries()){
        if(value > 1) {
            duplicates.push(key);
        } 
    }
    
    return duplicates;
}

function findDuplicatesWithObject(arr) {
    let numCounts = {};
    let duplicates = [];
    for(const num of arr) {
        numCounts[num] = (numCounts[num] || 0) + 1;
    }

    for(const key in numCounts){
        if(numCounts[key] > 1) {
            duplicates.push(key);
        } 
    }
    
    return duplicates;
}



/**---------------
   No Duplicates
   --------------- */
console.log("Input: [6, 5, 4, 3, 2, 1]");
console.log("Output: ", findDuplicatesWithMap([6, 5, 4, 3, 2, 1]));
console.log("---------------");

/**---------------
   Single Duplicate
   --------------- */
console.log("Input: [6, 5, 5 , 4, 3, 2, 1]");
console.log("Output: ", findDuplicatesWithMap([6, 5, 5 , 4, 3, 2, 1]));
console.log("---------------");

/**---------------
   Multiple Duplicates
   --------------- */
console.log("Input: [5, 4, 4, 4, 3, 2, 1, 4, 2]");
console.log("Output: ", findDuplicatesWithObject([5, 4, 4, 4, 3, 2, 1, 4, 2]));
console.log("---------------");