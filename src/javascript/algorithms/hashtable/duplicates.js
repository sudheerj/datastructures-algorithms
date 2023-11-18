function findDuplicatesWithMap(arr) {
    let numCounts = new Map();
    let duplicates = [];
    for(const num of arr) {
        numCounts.set(num, (numCounts.get(num) || 0) + 1);
        if(numCounts.get(num) > 1 && !duplicates.includes(num)) {
            duplicates.push(num);
        }
    }
    
    return duplicates;
}

function findDuplicatesWithObject(arr) {
    let numCounts = {};
    let duplicates = [];
    for(const num of arr) {
        numCounts[num] = (numCounts[num] || 0) + 1;
        if(numCounts[num] > 1 && !duplicates.includes(num)) {
            duplicates.push(num);
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