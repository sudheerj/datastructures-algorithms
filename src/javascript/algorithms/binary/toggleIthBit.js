// Toggle i-th bit

// Function to toggle the B-th bit of an integer A
function toogleIthBit(A, B) {
  if ((1 << B) ^ A) {
    A = A ^ (1 << B);
  }
  return A;
}

// Example usage
const A = 5; // Binary: 101
const B = 1; // Toggle the 1st bit
const result = toogleIthBit(A, B);
console.log(`The result after toggling the ${B}th bit of ${A} is: ${result}`);
