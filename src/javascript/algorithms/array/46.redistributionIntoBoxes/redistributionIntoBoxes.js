// TC: O(m log m + n) SC: O(n)
function minBoxes(apples, capacity) {
    let total = apples.reduce((sum, count) => sum + count, 0);
    capacity.sort((a, b) => b - a);

    let minBoxes = 0;
    for (const cap of capacity) {
        total -= cap;
        minBoxes++;
        if (total <= 0) break;
    }

    return minBoxes;
}

// Test cases
console.log("Test 1:", minBoxes([1, 3, 2], [4, 3, 1, 5, 2])); // 2
console.log("Test 2:", minBoxes([5], [5])); // 1
console.log("Test 3:", minBoxes([2, 3, 1], [10, 1, 1])); // 1
console.log("Test 4:", minBoxes([1, 1, 1], [1, 1, 1])); // 3
console.log("Test 5:", minBoxes([5, 5, 5], [5, 5, 5])); // 3
console.log("Test 6:", minBoxes([1], [100, 50, 25])); // 1
