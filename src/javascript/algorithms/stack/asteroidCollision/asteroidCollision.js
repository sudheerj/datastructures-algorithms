/**
 * Asteroid Collision (LeetCode 735)
 *
 * Given an array of asteroids (positive = right, negative = left), return the
 * state after all collisions. Larger destroys smaller; equal size destroys both.
 *
 * TC: O(n)  SC: O(n)
 */

function asteroidCollision(asteroids) {
    const stack = [];

    for (let a of asteroids) {
        while (stack.length > 0 && stack[stack.length - 1] > 0 && a < 0) {
            const top = stack[stack.length - 1];
            if (top < -a) {          // top is smaller → destroyed
                stack.pop();
                continue;
            }
            if (top === -a) {        // equal size → both destroyed
                stack.pop();
                a = 0;
                break;
            }
            a = 0;                   // current is smaller → destroyed
            break;
        }

        if (a !== 0) stack.push(a);
    }

    return stack;
}

const testCases = [
    { input: [5, 10, -5],    expected: [5, 10],         label: "-5 destroyed by 10" },
    { input: [8, -8],        expected: [],              label: "equal size, both destroyed" },
    { input: [10, 2, -5],    expected: [10],            label: "-5 destroys 2, blocked by 10" },
    { input: [-2, -1, 1, 2], expected: [-2, -1, 1, 2], label: "no collisions" },
    { input: [1, -2],        expected: [-2],            label: "-2 destroys 1 and survives" },
    { input: [-1, -2, 1, 2], expected: [-1, -2, 1, 2], label: "left-movers already past right-movers" },
];

testCases.forEach(({ input, expected, label }) => {
    const result = asteroidCollision([...input]);
    const ok = JSON.stringify(result) === JSON.stringify(expected);
    console.log(`  [${ok ? "PASS" : "FAIL"}] ${label}: [${result}]  (expected [${expected}])`);
});
