// Toggle i-th bit

// Function to toggle the B-th bit of an integer A
function toggleIthBit(A, B) {
  if ((1 << B) ^ A) {
    A = A ^ (1 << B);
  }
  return A;
}

// Example usage
const A = 5; // Binary: 101
const B = 1; // Toggle the 1st bit
const result = toggleIthBit(A, B);
console.log(`The result after toggling the ${B}th bit of ${A} is: ${result}`);
