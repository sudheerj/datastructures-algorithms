const sumOfAllSubmatrices = (A) => {
  const n = A.length;
  let sum = 0;

  // Using forEach for a functional approach
  A.forEach((row, i) => {
    row.forEach((value, j) => {
      let topLeft = (i + 1) * (j + 1);
      let bottomLeft = (n - i) * (n - j);
      sum += topLeft * bottomLeft * value;
    });
  });

  return sum;
};

// Example usage:
const matrix = [
  [1, 2],
  [3, 4],
];
console.log(sumOfAllSubmatrices(matrix)); // Example output: 120

// Time Complexity - O(n^2)
// Space Complexity - O(1)
