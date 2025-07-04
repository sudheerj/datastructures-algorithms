//Iteration over string TC: O(n), SC(1)
function binaryGap(number) {
    const binary = number.toString(2);

    let currentGap = 0, maxGap = 0, foundOne = false;

    for(const digit of binary) {
        if(digit === '1') {
            if(foundOne) {
                maxGap = Math.max(maxGap, currentGap);
            }

            currentGap = 0;
            foundOne = true;
        } else if(foundOne) {
            currentGap++;
        }
    }

    return maxGap;
}

console.log(binaryGap(1041)); // 5 → binary: "10000010001"
console.log(binaryGap(9));    // 2 → binary: "1001"
console.log(binaryGap(32));   // 0 → binary: "100000"
console.log(binaryGap(6));    // 0 → binary: "110"

