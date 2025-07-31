//TC: O(n logn)+ O(n) SC:O(1):
// Time Complexity: O(n log n) for sorting + O(n) for scanning => O(n log n)
// Space Complexity: O(1) extra space (in-place sort)

function canAttendMeetings(intervals) {
    // Sort meetings by start time
    intervals.sort((a, b) => a[0] - b[0]);

    // Check for overlap
    for(let i=1; i< intervals.length; i++) {
        let startTime = intervals[i][0];
        let prevEndTime = intervals[i-1][1];

        if(prevEndTime > startTime) {
            return false; // Overlapping meetings
        }
    }

    return true;
}

// Test cases
const testCases = [
    {
        input: [[1, 3], [3, 7], [6, 8], [8, 10], [10, 12]],
        expected: false,
        reason: "Overlap between [3,7] and [6,8]",
    },
    {
        input: [[1, 5], [5, 7], [8, 10]],
        expected: true,
        reason: "All meetings end before next starts",
    },
    {
        input: [[1, 4], [2, 5], [7, 9]],
        expected: false,
        reason: "Overlap between [1,4] and [2,5]",
    },
    {
        input: [[1, 3], [3, 5], [5, 7]],
        expected: true,
        reason: "Meetings touch but do not overlap",
    },
    {
        input: [],
        expected: true,
        reason: "Empty list means no conflict",
    },
];

testCases.forEach(({ input, expected, reason }, index) => {
    const result = canAttendMeetings(input);
    console.log(`Test #${index + 1}: ${result === expected ? "✅ Passed" : "❌ Failed"} — ${reason}`);
});
