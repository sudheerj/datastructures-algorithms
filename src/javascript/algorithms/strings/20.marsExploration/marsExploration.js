function marsExploration(str) {
    let alteredCount = 0;
    const expected = "SOS";

    for(let i = 0; i < str.length; i++) {
        if(str[i] !== expected[i % 3]) {
            alteredCount++;
        }
    }
    return alteredCount;
}

// Test cases
console.log(marsExploration("SOSSPSSQSSOR")); // Output: 3
console.log(marsExploration("SOSSOT")); // Output: 1
console.log(marsExploration("SOSSOSSOS")); // Output: 0
console.log(marsExploration("SSSSSS")); // Output: 2