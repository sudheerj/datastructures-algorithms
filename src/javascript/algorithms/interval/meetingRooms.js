//TC: O(n logn+ n) SC:O(1)

function canAttendMeetings(intervals) {
    let prevEndTime = intervals[0][1];

    for(let i=1; i< intervals.length; i++) {
        let startTime = intervals[i][0];
        let endTime = intervals[i][1];

        if(endTime > startTime) {
            return false;
        }
        prevEndTime = endTime;
    }

    return true;
}

let intervals = [[1,3], [3,7], [6, 8], [8, 10], [10, 12]];
console.log(canAttendMeetings(intervals));