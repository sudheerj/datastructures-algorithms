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
 * Approach 1: Using a monotonic decreasing stack with array operations
 * For each day, find how many days until a warmer temperature
 * @param {number[]} temperatures - Array of daily temperatures
 * @returns {number[]} - Array where each element is the number of days to wait for a warmer temperature
 */
function dailyTemperatures1(temperatures) {
    // Input validation
    if (!Array.isArray(temperatures) || temperatures.length === 0) {
        throw new Error("Input must be a non-empty array of temperatures");
    }

    let days = Array(temperatures.length).fill(0);
    let stack = [];

    for (let currDay = 0; currDay < temperatures.length; currDay++) {
        while (stack.length > 0 && temperatures[stack[stack.length - 1]] < temperatures[currDay]) {
            let prevDay = stack.pop();
            days[prevDay] = currDay - prevDay;
        }
        stack.push(currDay);
    }
    return days;
}

/**
 * Approach 2: Using the custom MyStack class implementation
 * For each day, find how many days until a warmer temperature
 * @param {number[]} temperatures - Array of daily temperatures
 * @returns {number[]} - Array where each element is the number of days to wait for a warmer temperature
 */
function dailyTemperatures2(temperatures) {
    // Input validation
    if (!Array.isArray(temperatures) || temperatures.length === 0) {
        throw new Error("Input must be a non-empty array of temperatures");
    }

    let days = Array(temperatures.length).fill(0);
    let stack = new MyStack();

    for (let currDay = 0; currDay < temperatures.length; currDay++) {
        while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currDay]) {
            let prevDay = stack.pop();
            days[prevDay] = currDay - prevDay;
        }
        stack.push(currDay);
    }
    return days;
}

// Test cases
let temperatures1 = [72, 73, 74, 70, 68, 71, 75, 72];
console.log("Approach 1 result:", dailyTemperatures1(temperatures1));

let temperatures2 = [10, 20, 30, 40, 50, 60, 70];
console.log("Approach 1 result:", dailyTemperatures1(temperatures2));

console.log("--------------------------------");

console.log("Approach 2 result:", dailyTemperatures2(temperatures1));
console.log("Approach 2 result:", dailyTemperatures2(temperatures2));

// Edge case test
try {
    dailyTemperatures1([]);
} catch (e) {
    console.error("Error handling test:", e.message);
}
