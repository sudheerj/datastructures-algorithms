// Robot Return to Origin (LC 657)
// TC: O(n)  SC: O(1)

/**
 * @param {string} moves
 * @return {boolean}
 */
function judgeCircle(moves) {
    let x = 0, y = 0;
    for (const ch of moves) {
        if      (ch === 'U') y++;
        else if (ch === 'D') y--;
        else if (ch === 'L') x--;
        else if (ch === 'R') x++;
    }
    return x === 0 && y === 0;
}

function runTests() {
    const tests = [
        { moves: "UD",          expected: true  },
        { moves: "LL",          expected: false },
        { moves: "LRUD",        expected: true  },
        { moves: "LDRRUUUDDL",  expected: true  },
        { moves: "",            expected: true  },
        { moves: "UDLR",        expected: true  },
    ];

    for (const { moves, expected } of tests) {
        const result = judgeCircle(moves);
        const pass = result === expected;
        console.log(`[${pass ? "PASS" : "FAIL"}] moves="${moves}" result=${result} expected=${expected}`);
    }
}

runTests();
