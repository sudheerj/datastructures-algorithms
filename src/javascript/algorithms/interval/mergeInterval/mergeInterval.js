// TC: O(n log n) + O(n)=> O(n log n) SC: O(n)

function mergeInterval(intervals) {
    let mergedIntervals = [];
    intervals.sort((a, b) => a[0]-b[0]);
    mergedIntervals.push(intervals[0]);

    for(let i=1; i< intervals.length; i++) {
        let currInterval = intervals[i];
        let latestMergeInterval = mergedIntervals[mergedIntervals.length-1];
        if(latestMergeInterval[1] < currInterval[0]) {
            mergedIntervals.push(currInterval);
        } else {
            mergedIntervals[mergedIntervals.length-1][1] = Math.max(latestMergeInterval[1], currInterval[1]);
        }
    }

    return mergedIntervals;
}

let intervals1 = [[1,3],[2,6],[8,10],[15,18]];
let intervals2 = [[1,5],[5,8]];
console.log(mergeInterval(intervals1));
console.log(mergeInterval(intervals2));