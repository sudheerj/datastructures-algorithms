// TC: O(n login + n) SC: O(n)

function mergeInterval(intervals) {
    let mergeResult = [];
    intervals.sort((a, b) => a[0]-b[0]);
    mergeResult.push(intervals[0]);

    for(let i=1; i< intervals.length; i++) {
        let currInterval = intervals[i];
        let latestMergeInterval = mergeResult[mergeResult.length-1];
        if(latestMergeInterval[1] < currInterval[0]) {
            mergeResult.push(currInterval);
        } else {
            mergeResult[mergeResult.length-1][1] = Math.max(latestMergeInterval[1], currInterval[1]);
        }
    }

    return mergeResult;
}

let intervals = [[1,3],[2,6],[8,10],[15,18]];
console.log(mergeInterval(intervals));