const mergeIntervals = (intervals, newInterval) => {
  const result = [];
  let i = 0;

  // Add intervals that come before newInterval
  while (i < intervals.length && intervals[i][1] < newInterval[0]) {
    result.push(intervals[i]);
    i++;
  }

  // Merge overlapping intervals
  while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
    i++;
  }

  // Add the merged interval
  result.push(newInterval);

  // Add intervals that come after newInterval
  while (i < intervals.length) {
    result.push(intervals[i]);
    i++;
  }

  return result;
};

// Example usage:
const intervals = [
  [1, 3],
  [6, 9],
];
const newInterval = [2, 5];
console.log(mergeIntervals(intervals, newInterval)); // Example output: [[1, 5], [6, 9]]

// Time Complexity - O(n)
// Space Complexity - O(n)
