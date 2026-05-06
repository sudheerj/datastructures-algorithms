// Reverse Same Char Position
// Given a string, reverse it and count how many characters remain at the same position as in the original.
// Time Complexity: O(n), Space Complexity: O(1)

function reverseSameCharPosition(str) {
    const len = str.length;
    let count = 0;
    for (let i = 0; i < len; i++) {
        if (str[i] === str[len - 1 - i]) {
            count++;
        }
    }
    return count;
}

// Test 1: Palindrome - all chars same position after reverse
console.log("Test 1:", reverseSameCharPosition("abcba")); // 5

// Test 2: No chars same position after reverse
console.log("Test 2:", reverseSameCharPosition("abcd")); // 0

// Test 3: Even-length palindrome
console.log("Test 3:", reverseSameCharPosition("abba")); // 4

// Test 4: Only middle char stays
console.log("Test 4:", reverseSameCharPosition("hello")); // 1 (l at index 2)

// Test 5: All same characters
console.log("Test 5:", reverseSameCharPosition("aaaa")); // 4

// Test 6: Single character
console.log("Test 6:", reverseSameCharPosition("a")); // 1
