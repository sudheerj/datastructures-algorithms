//TC: O(n logn)+ O(n) SC:O(1)

function canAttendMeetings(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);

    for(let i=1; i< intervals.length; i++) {
        let startTime = intervals[i][0];
        let prevEndTime = intervals[i-1][1];

        if(prevEndTime > startTime) {
            return false;
        }
    }

    return true;
}

let intervals1 = [[1,3], [3,7], [6, 8], [8, 10], [10, 12]];
let intervals2 = [[1,5], [5,7], [8, 10]];
console.log(canAttendMeetings(intervals1));
console.log(canAttendMeetings(intervals2));