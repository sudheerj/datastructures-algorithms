// High Five
// Given [student_id, score] pairs, return [[id, floor(top5_avg)], ...] sorted by id.
// TC: O(n log 5) = O(n), SC: O(k) where k = number of distinct students

/**
 * @param {number[][]} items
 * @returns {number[][]}
 */
function highFive(items) {
  const map = new Map();

  for (const [id, score] of items) {
    if (!map.has(id)) map.set(id, []);
    const heap = map.get(id);

    // Insert maintaining sorted ascending order (min at index 0)
    let lo = 0,
      hi = heap.length;
    while (lo < hi) {
      const mid = (lo + hi) >> 1;
      if (heap[mid] < score) lo = mid + 1;
      else hi = mid;
    }
    heap.splice(lo, 0, score);

    if (heap.length > 5) heap.shift(); // evict the minimum
  }

  return [...map.keys()]
    .sort((a, b) => a - b)
    .map((id) => {
      const heap = map.get(id);
      const sum = heap.reduce((acc, v) => acc + v, 0);
      return [id, Math.floor(sum / 5)];
    });
}

// Test cases
const tests = [
  {
    items: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[2,100],[1,87],[1,100],[2,76]],
    expected: [[1, 87], [2, 88]],
  },
  {
    items: [[1,90],[1,80],[1,70],[1,60],[1,50]],
    expected: [[1, 70]],
  },
  {
    items: [[1,100],[1,100],[1,100],[1,100],[1,100],[1,1]],
    expected: [[1, 100]],
  },
  {
    items: [[1,100],[2,100],[3,100],[1,80],[2,80],[3,80],
            [1,60],[2,60],[3,60],[1,40],[2,40],[3,40],[1,20],[2,20],[3,20]],
    expected: [[1, 60], [2, 60], [3, 60]],
  },
  {
    items: [[1,88],[1,89],[1,90],[1,91],[1,92]],
    expected: [[1, 90]],
  },
  {
    items: [[3,80],[3,80],[3,80],[3,80],[3,80],[1,60],[1,60],[1,60],[1,60],[1,60]],
    expected: [[1, 60], [3, 80]],
  },
];

for (const { items, expected } of tests) {
  const result = highFive(items);
  const pass = JSON.stringify(result) === JSON.stringify(expected);
  console.log(`highFive(...) => ${JSON.stringify(result)} ${pass ? "✓" : `✗ (expected ${JSON.stringify(expected)})`}`);
}
