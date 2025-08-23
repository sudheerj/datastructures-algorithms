function  superReducedString(str) {
    const stack = [];
    for (const char of str) {
        if (stack.length > 0 && stack[stack.length - 1] === char) {
            stack.pop();
        } else {
            stack.push(char);
        }
    }
    return stack.length === 0 ? "Empty String" : stack.join('');
}

// Test cases
console.log(superReducedString("aaabccddd")); // Output: "abd"
console.log(superReducedString("aa")); // Output: "Empty String"
console.log(superReducedString("baab")); // Output: "Empty String"
console.log(superReducedString("abc")); // Output: "abc"