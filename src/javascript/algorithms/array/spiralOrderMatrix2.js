const spiralOrderMatrix2 = (A) => {
  const matrix = Array.from({ length: A }, () => Array(A).fill(0));
  let top = 0;
  let bottom = A - 1;
  let left = 0;
  let right = A - 1;

  let current = 1;

  while (current <= A * A) {
    for (let i = left; i <= right; i++) {
      matrix[top][i] = current;
      current++;
    }
    top++;

    for (let i = top; i <= bottom; i++) {
      matrix[i][right] = current;
      current++;
    }
    right--;

    for (let i = right; i >= left; i--) {
      matrix[bottom][i] = current;
      current++;
    }
    bottom--;

    for (let i = bottom; i >= top; i--) {
      matrix[i][left] = current;
      current++;
    }
    left++;
  }

  return matrix;
};

// Example usage:
const A = 4;
console.log(spiralOrderMatrix2(A));

// Time Complexity - O(A * A)
// Space Complexity - O(A * A)
