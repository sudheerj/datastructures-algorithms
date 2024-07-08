// Function to solve the problem of counting subarrays with bitwise OR 1
function subarraysWithBitwiseOR1(A, B) {
  // Initialize total count of subarrays
  let subArrCount = 0;

  // Iterate over array B from the end to start
  for (let i = A - 1; i >= 0; i--) {
    // If current element is 1, calculate number of subarrays ending at index i
    if (B[i] === 1) {
      let count = A - i;
      subArrCount += count;
    }
    // Add count of subarrays where B[i] is 0 (same as previous iteration)
    subArrCount += count || 0; // If count is undefined (i.e., first iteration), add 0
  }

  return subArrCount;
}

// Example usage
const A = 5;
const B = [0, 1, 0, 1, 1];
const result = subarraysWithBitwiseOR1(A, B);
console.log(`Total subarrays with bitwise OR 1: ${result}`);
