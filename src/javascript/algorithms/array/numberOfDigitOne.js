const numberOfDigitOne = (A) => {
  if (A === 0) {
    return 0;
  }

  let base = 1;
  let sum = 0;

  while (base <= A) {
    const left = Math.floor(A / base / 10);
    const cur = Math.floor((A / base) % 10);
    const right = A % base;

    if (cur > 1) {
      sum += (left + 1) * base;
    } else if (cur === 1) {
      sum += left * base + right + 1;
    } else {
      sum += left * base;
    }

    base *= 10;
  }

  return sum;
};

// Example usage:
const number = 123;
console.log(numberOfDigitOne(number)); // Example output: 57

// Time Complexity - O(log10(A))
// Space Complexity - O(1)
