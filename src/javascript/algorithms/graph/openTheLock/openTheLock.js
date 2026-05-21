/**
 * Open the Lock (LeetCode 752)
 *
 * Find the minimum number of turns to reach target from "0000",
 * avoiding deadend combinations. Return -1 if impossible.
 *
 * Approach: BFS level-by-level
 * TC: O(10^4 * 4 * 2)  SC: O(10^4)
 *
 * @param {string[]} deadends
 * @param {string} target
 * @return {number}
 */
function openTheLock(deadends, target) {
    const dead = new Set(deadends);

    // cannot start if starting point itself is blocked
    if (dead.has("0000")) return 0;

    const queue = ["0000"];
    const visited = new Set(["0000"]);
    let steps = 0;

    while (queue.length > 0) {
        const size = queue.length;

        // process one BFS level
        for (let i = 0; i < size; i++) {
            const current = queue.shift();

            // found target
            if (current === target) return steps;

            const arr = current.split("");

            // try rotating 4 wheels
            for (let j = 0; j < 4; j++) {
                const original = arr[j];

                // two directions: +1 or -1
                for (const move of [1, -1]) {
                    arr[j] = String((parseInt(original) + move + 10) % 10);
                    const next = arr.join("");

                    // next state
                    if (!dead.has(next) && !visited.has(next)) {
                        visited.add(next);
                        queue.push(next);
                    }
                }
                arr[j] = original;
            }
        }
        steps++;
    }

    return -1;
}

const testCases = [
    { deadends: ["0201","0101","0102","1212","2002"], target: "0202", expected:  6, label: "classic example" },
    { deadends: ["8888"],                             target: "0009", expected:  1, label: "one-step rotation" },
    { deadends: ["8887","8889","8878","8898",
                 "8788","8988","7888","9888"],        target: "8888", expected: -1, label: "target surrounded by deadends" },
    { deadends: ["0000"],                             target: "8888", expected:  0, label: "start is a deadend" },
    { deadends: [],                                   target: "0001", expected:  1, label: "no deadends — one step" },
    { deadends: ["1234"],                             target: "0000", expected:  0, label: "target is starting position" },
];

testCases.forEach(({ deadends, target, expected, label }) => {
    const result = openTheLock(deadends, target);
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: ${result} (expected ${expected})`);
});
