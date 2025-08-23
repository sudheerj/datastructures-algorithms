function camelCaseCount(str) {
    if(str.length === 0) return 0;

    let count = 1;
    for (const char of str) {
        if (char >= 'A' && char <= 'Z') {
            count++;
        }
    }
    return count;
}

// Test cases
console.log(camelCaseCount("saveChangesInTheEditor")); // Output: 5
console.log(camelCaseCount("oneTwoThree")); // Output: 3
console.log(camelCaseCount("thisIsCamelCase")); // Output: 4
console.log(camelCaseCount("")); // Output: 0
console.log(camelCaseCount("singleword")); // Output: 1