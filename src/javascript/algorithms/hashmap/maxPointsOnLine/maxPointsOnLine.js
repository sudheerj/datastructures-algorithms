/**
 * Max Points on a Line
 *
 * Given an array of points, return the maximum number of points
 * that lie on the same straight line.
 *
 * TC: O(n^2)
 * SC: O(n)
 */

function gcd(a, b) {
  return b === 0 ? a : gcd(b, a % b);
}

function maxPointsOnLine(points) {
  const n = points.length;
  if (n <= 2) return n;

  let result = 0;

  for (let i = 0; i < n; i++) {
    const slopeMap = new Map();
    let duplicates = 0;
    let localMax = 0;

    for (let j = i + 1; j < n; j++) {
      let dx = points[j][0] - points[i][0];
      let dy = points[j][1] - points[i][1];

      if (dx === 0 && dy === 0) {
        duplicates++;
        continue;
      }

      const g = gcd(Math.abs(dx), Math.abs(dy));
      dx = Math.trunc(dx / g);
      dy = Math.trunc(dy / g);

      // Normalize sign: keep dx >= 0; if dx == 0 keep dy > 0
      if (dx < 0) {
        dx = -dx;
        dy = -dy;
      } else if (dx === 0) {
        dy = Math.abs(dy);
      }

      const key = `${dx}/${dy}`;
      slopeMap.set(key, (slopeMap.get(key) || 0) + 1);
      localMax = Math.max(localMax, slopeMap.get(key));
    }

    result = Math.max(result, localMax + duplicates + 1);
  }

  return result;
}

const testCases = [
  {
    points: [
      [1, 1],
      [2, 2],
      [3, 3],
    ],
    expected: 3,
    label: "all collinear",
  },
  {
    points: [
      [1, 1],
      [3, 2],
      [5, 3],
      [4, 1],
      [2, 3],
      [1, 4],
    ],
    expected: 4,
    label: "LeetCode example 2",
  },
  { points: [[0, 0]], expected: 1, label: "single point" },
  {
    points: [
      [0, 0],
      [1, 0],
      [2, 0],
    ],
    expected: 3,
    label: "horizontal line",
  },
  {
    points: [
      [0, 0],
      [0, 1],
      [0, 2],
    ],
    expected: 3,
    label: "vertical line",
  },
  {
    points: [
      [0, 0],
      [0, 0],
      [1, 1],
    ],
    expected: 3,
    label: "duplicate points",
  },
];

testCases.forEach(({ points, expected, label }) => {
  const result = maxPointsOnLine(points);
  const status = result === expected ? "PASS" : "FAIL";
  console.log(
    `  [${status}] ${label}: ${JSON.stringify(points)} → ${result} (expected ${expected})`,
  );
});
