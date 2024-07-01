 //TC:O(n) SC:O(n)

 function insertInterval(newInterval, intervals) {
    let result = [];
    let insertedInterval = false;

    for(let interval of intervals) {
        if(newInterval[1] < interval[0]) {
            result.push(newInterval);
            result.push(interval);
            insertedInterval = true;
        } else if(insertedInterval || (interval[1] < newInterval[0])) {
            result.push(interval);
        } else {
            newInterval[0] = Math.min(interval[0], newInterval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }
    }
    if(insertedInterval === false) {
        result.push(newInterval);
    }

    return result;
 }

 let newInterval = [4, 8];
 let intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]];
 console.log(insertInterval(newInterval, intervals));