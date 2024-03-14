//Two pointer TC: O(n logn + n) SC: O(n)

function minMeetingRooms1(intervals) {
    let startTimes = Array(intervals.length);
    let endTimes = Array(intervals.length);

    for(let [start, end] of intervals) {
        startTimes.push(start);
        endTimes.push(end);
    }

    startTimes.sort((a, b) => a-b);
    endTimes.sort((a, b) => a-b);

    let startTimeIndex = endTimeIndex = 0;
    let minMeetingRooms = count = 0; 

    while(startTimeIndex < intervals.length) {
        let startTime = startTimes[startTimeIndex];
        let endTime = endTimes[endTimeIndex];
        if(startTime < endTime) {
            startTimeIndex++;
            count++;
        } else {
            endTimeIndex++;
            count--;
        }
        minMeetingRooms = Math.max(minMeetingRooms, count);
    }
    return minMeetingRooms;
}

let intervals = [[2, 7], [3, 5], [3, 9], [5, 12], [8, 15], [9, 14]];
console.log(minMeetingRooms1(intervals));