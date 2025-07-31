 //TC:O(n) SC:O(n)
 function insertInterval(newInterval, intervals) {
    let result = [];
    let [newStart, newEnd] = newInterval;
    let isIntervalInserted = false;

    for(let [currStart, currEnd] of intervals) {
        if(newEnd < currStart) {
            // If the new interval ends before the current interval starts
            if(!isIntervalInserted) {
                result.push(newInterval);
                isIntervalInserted = true;
            }
            result.push([currStart, currEnd]);
        } else if(currEnd < newStart) {
            // If the current interval ends before the new interval starts
            result.push([currStart, currEnd]);
        } else {
            // Overlapping intervals
            newStart = Math.min(newStart, currStart);
            newEnd = Math.max(newEnd, currEnd);
        }
    }

     if(!isIntervalInserted) {
         result.push(newInterval);
     }
     return result;
 }

 let newInterval = [4, 8];
 let intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]];
 console.log(insertInterval(newInterval, intervals));

 const tests = [
     {
         label: "Original test",
         newInterval: [4, 8],
         intervals: [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]],
         expected: [[1, 2], [3, 10], [12, 16]],
     },
     {
         label: "Insert before all intervals (no overlap)",
         newInterval: [0, 1],
         intervals: [[2, 3], [4, 5]],
         expected: [[0, 1], [2, 3], [4, 5]],
     },
     {
         label: "Insert after all intervals (no overlap)",
         newInterval: [10, 12],
         intervals: [[1, 2], [3, 5], [6, 8]],
         expected: [[1, 2], [3, 5], [6, 8], [10, 12]],
     }
 ];

 // ---- Run All Tests ----
 tests.forEach(({ label, newInterval, intervals, expected }, i) => {
     const result = insertInterval([...newInterval], JSON.parse(JSON.stringify(intervals)));
     const passed = JSON.stringify(result) === JSON.stringify(expected);
     console.log(`Test ${i + 1} - ${label}: ${passed ? "✅ Passed" : "❌ Failed"}`);
     if (!passed) {
         console.log(`  Expected: ${JSON.stringify(expected)}`);
         console.log(`  Received: ${JSON.stringify(result)}`);
     }
 });