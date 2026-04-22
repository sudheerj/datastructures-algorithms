function permutations(nums) {
    const result = [];
    function backtrack(current) {
        if (current.length === nums.length) {
            result.push([...current]);
            return;
        }
        for (const num of nums) {
            if (current.includes(num)) continue;
            current.push(num);
            backtrack(current);
            current.pop();
        }
    }
    backtrack([]);
    return result;
}

// Example 1: Standard case
console.log("Input: [1, 2, 3]");
console.log("Output:", permutations([1, 2, 3]));

// Example 2: Two elements
console.log("Input: [0, 1]");
console.log("Output:", permutations([0, 1]));

// Example 3: Single element
console.log("Input: [1]");
console.log("Output:", permutations([1]));

// Example 4: Empty array
console.log("Input: []");
console.log("Output:", permutations([]));

// Example 5: Negative numbers
console.log("Input: [-1, 2]");
console.log("Output:", permutations([-1, 2]));
