// Function to find the nth magic number
function findNthMagicNumber(n) {
  let power = 1; // Initialize the power of 5
  let magicNumber = 0; // Initialize the magic number

  while (n !== 0) {
    power *= 5; // Increase the power of 5

    // Check if the least significant bit of n is 1
    if (n & 1) {
      magicNumber += power; // Add the current power of 5 to the magic number
    }

    n >>= 1; // Right shift n by 1 bit to process the next bit
  }

  return magicNumber; // Return the final magic number
}

// Example usage
const n = 3;
const nthMagicNumber = findNthMagicNumber(n);
console.log(`The ${n}rd magic number is: ${nthMagicNumber}`);
