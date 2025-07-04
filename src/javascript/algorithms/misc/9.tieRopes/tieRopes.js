function tieRopes(ropeLengths, k) {
    let count = 0;
    let currentLength = 0;

    for (let i = 0; i < ropeLengths.length; i++) {
        currentLength += ropeLengths[i];
        if(currentLength >= k) {
            count++;
            currentLength = 0;
        }
    }

    return count;
}

// Example 1
const k1 = 4;
const ropes1 = [1, 2, 3, 4, 1, 1, 3];
console.log(tieRopes(ropes1, k1)); // Output: 3

// Example 2
const k2 = 5;
const ropes2 = [2, 2, 1, 1, 3, 2];
console.log(tieRopes(ropes2, k2)); // Output: 2

// Example 3
const k3 = 7;
const ropes3 = [1, 1, 1, 1, 1, 1, 1];
console.log(tieRopes(ropes3, k3)); // Output: 1