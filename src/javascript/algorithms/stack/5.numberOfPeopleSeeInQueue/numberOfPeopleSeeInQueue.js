class MyStack {
    constructor() {
        this.items = [];
    }

    // Core stack operations
    push(value) {
        this.items.push(value);
    }

    pop() {
        if (this.isEmpty()) {
            throw new Error("Stack Underflow: Cannot pop from an empty stack.");
        }
        return this.items.pop();
    }

    peek() {
        if (this.isEmpty()) {
            throw new Error("Stack Underflow: Cannot peek from an empty stack.");
        }
        return this.items[this.items.length - 1];
    }

    // Helper functions
    isEmpty() {
        return this.items.length === 0;
    }

    size() {
        return this.items.length;
    }

    printStack() {
        return this.items.join(' ');
    }
}

/**
 * Approach 1: Using a monotonic stack with native array operations
 * Calculate how many people each person can see to their right in the queue
 * @param {number[]} heights - Array of heights of people in the queue
 * @returns {number[]} - Array where each element is the number of people visible from that position
 */
function canSeePersonsCount1(heights) {
    // Input validation
    if (!Array.isArray(heights) || heights.length === 0) {
        throw new Error("Input must be a non-empty array of heights");
    }

    const length = heights.length;
    const visibilityCount = Array(length).fill(0);
    const stack = [];

    // Process from right to left (as we're looking rightward)
    for (let i = length - 1; i >= 0; i--) {
        // Pop shorter people from stack as they're blocked by current person
        while (stack.length && heights[i] > stack[stack.length - 1]) {
            stack.pop();
            visibilityCount[i]++; // Current person can see the popped person
        }

        // If stack is not empty, current person can see one more person (the first taller one)
        if (stack.length) {
            visibilityCount[i]++;
        }

        stack.push(heights[i]);
    }

    return visibilityCount;
}

/**
 * Approach 2: Using the custom MyStack class implementation
 * Calculate how many people each person can see to their right in the queue
 * @param {number[]} heights - Array of heights of people in the queue
 * @returns {number[]} - Array where each element is the number of people visible from that position
 */
function canSeePersonsCount2(heights) {
    // Input validation
    if (!Array.isArray(heights) || heights.length === 0) {
        throw new Error("Input must be a non-empty array of heights");
    }

    const length = heights.length;
    const visibilityCount = Array(length).fill(0);
    const stack = new MyStack();

    // Process from right to left (as we're looking rightward)
    for (let i = length - 1; i >= 0; i--) {
        // Pop shorter people from stack as they're blocked by current person
        while (!stack.isEmpty() && heights[i] > stack.peek()) {
            stack.pop();
            visibilityCount[i]++; // Current person can see the popped person
        }

        // If stack is not empty, current person can see one more person (the first taller one)
        if (!stack.isEmpty()) {
            visibilityCount[i]++;
        }

        stack.push(heights[i]);
    }

    return visibilityCount;
}

// Test cases
const heights1 = [10, 6, 8, 5, 11, 9];
console.log("Approach 1 result:", canSeePersonsCount1(heights1));

const heights2 = [6, 5, 4, 3, 2, 1];
console.log("Approach 1 result:", canSeePersonsCount1(heights2));

const heights3 = [1, 2, 3, 4, 5, 6];
console.log("Approach 1 result:", canSeePersonsCount1(heights3));

console.log("--------------------------------");

console.log("Approach 2 result:", canSeePersonsCount2(heights1));
console.log("Approach 2 result:", canSeePersonsCount2(heights2));
console.log("Approach 2 result:", canSeePersonsCount2(heights3));

// Edge case test
try {
    canSeePersonsCount1([]);
} catch (e) {
    console.error("Error handling test:", e.message);
}
