//Greedy approach: TC: O(n logn + n), SC: O(1)

function eraseOverlappingIntervals(intervals) {
    let minRemoveCount = 0;
    let prevEnd = intervals[0][1];

    for(let i=1; i<intervals.length; i++){
        let start = intervals[i][0];
        let end = intervals[i][1];

        if(start >= prevEnd) {
            prevEnd = end;
        } else {
            minRemoveCount++;
            prevEnd = Math.min(prevEnd, end);
        }
    }
    return minRemoveCount;
}

let intervals = [[1, 2], [2, 3], [3, 4],  [1, 3]];
console.log(eraseOverlappingIntervals(intervals));