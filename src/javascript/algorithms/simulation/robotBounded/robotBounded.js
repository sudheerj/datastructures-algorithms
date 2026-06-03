// Robot Bounded in Circle (LC 1041)
// Simulation  TC: O(n)  SC: O(1)

/**
 * @param {string} instructions
 * @return {boolean}
 */
function isRobotBounded(instructions) {
    const dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]; // North, East, South, West
    let dir = 0; // facing north
    let x = 0, y = 0;

    for (const ch of instructions) {
        if (ch === 'G') {
            x += dirs[dir][0];
            y += dirs[dir][1];
        } else if (ch === 'L') {
            dir = (dir + 3) % 4;
        } else if (ch === 'R') {
            dir = (dir + 1) % 4;
        }
    }

    return (x === 0 && y === 0) || dir !== 0;
}

function runTests() {
    const tests = [
        { instructions: "GGLLGG",   expected: true  },
        { instructions: "GG",       expected: false },
        { instructions: "GL",       expected: true  },
        { instructions: "GRGRGRGR", expected: true  },
        { instructions: "GLGR",     expected: false },
        { instructions: "LLLGGG",   expected: true  },
    ];

    for (const { instructions, expected } of tests) {
        const result = isRobotBounded(instructions);
        const pass = result === expected;
        console.log(`[${pass ? "PASS" : "FAIL"}] instructions="${instructions}" result=${result} expected=${expected}`);
    }
}

runTests();
