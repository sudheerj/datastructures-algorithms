/**
 * Maximum Gap
 *
 * Given an integer array nums, return the maximum difference between two
 * successive elements in its sorted form. Return 0 if fewer than 2 elements.
 *
 * Uses bucket sort (Pigeonhole principle) to achieve O(n) time.
 *
 * TC: O(n)
 * SC: O(n)
 */

function maximumGap(nums) {
  if (!nums || nums.length < 2) return 0;

  const n = nums.length;
  const minVal = Math.min(...nums);
  const maxVal = Math.max(...nums);

  if (minVal === maxVal) return 0;

  const bucketSize = Math.ceil((maxVal - minVal) / (n - 1));
  const bucketCount = Math.floor((maxVal - minVal) / bucketSize) + 1;

  const bucketMin = new Array(bucketCount).fill(Infinity);
  const bucketMax = new Array(bucketCount).fill(-Infinity);

  for (const num of nums) {
    const index = Math.floor((num - minVal) / bucketSize);
    bucketMin[index] = Math.min(bucketMin[index], num);
    bucketMax[index] = Math.max(bucketMax[index], num);
  }

  let maxGap = 0;
  let previousMax = minVal;

  for (let i = 0; i < bucketCount; i++) {
    if (bucketMin[i] === Infinity) continue;
    maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
    previousMax = bucketMax[i];
  }

  return maxGap;
}

const testCases = [
  { nums: [3, 6, 9, 1], expected: 3 },
  { nums: [10], expected: 0 },
  { nums: [1, 1, 1, 1], expected: 0 },
  { nums: [1, 10000000], expected: 9999999 },
  { nums: [1, 3, 6, 10], expected: 4 },
  { nums: [5, 1], expected: 4 },
];

testCases.forEach(({ nums, expected }) => {
  const result = maximumGap(nums);
  const status = result === expected ? "PASS" : "FAIL";
  console.log(
    `  [${status}] nums=[${nums}] → ${result} (expected ${expected})`,
  );
});
