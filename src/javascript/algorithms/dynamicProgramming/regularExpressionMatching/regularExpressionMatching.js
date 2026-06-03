// Approach 1: Top-down memoization
function isMatch(s, p) {
    const m = s.length, n = p.length;
    const memo = new Map();

    function dfs(i, j) {
        const key = `${i},${j}`;
        if (memo.has(key)) return memo.get(key);
        if (j === n) {
            memo.set(key, i === m);
            return i === m;
        }

        const match = i < m && (p[j] === s[i] || p[j] === '.');

        let result;
        if (j + 1 < n && p[j + 1] === '*') {
            result = dfs(i, j + 2) || (match && dfs(i + 1, j));
        } else {
            result = match && dfs(i + 1, j + 1);
        }

        memo.set(key, result);
        return result;
    }

    return dfs(0, 0);
}

// Approach 2: Bottom-up DP
function isMatch1(s, p) {
    const m = s.length, n = p.length;
    const dp = Array.from({ length: m + 1 }, () => Array(n + 1).fill(false));
    dp[m][n] = true;

    for (let i = m; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            const match = i < m && (p[j] === s[i] || p[j] === '.');
            if (j + 1 < n && p[j + 1] === '*') {
                dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
            } else {
                dp[i][j] = match && dp[i + 1][j + 1];
            }
        }
    }

    return dp[0][0];
}

function runTests() {
    const tests = [
        { s: 'aa',  p: 'a',     expected: false },
        { s: 'aa',  p: 'a*',    expected: true  },
        { s: 'ab',  p: '.*',    expected: true  },
        { s: 'aab', p: 'c*a*b', expected: true  },
        { s: 'a',   p: '.',     expected: true  },
    ];

    tests.forEach(({ s, p, expected }, i) => {
        const r1 = isMatch(s, p);
        const r2 = isMatch1(s, p);
        console.log(`${r1 === expected ? 'PASS' : 'FAIL'} test ${i + 1} isMatch:  result=${r1} expected=${expected}`);
        console.log(`${r2 === expected ? 'PASS' : 'FAIL'} test ${i + 1} isMatch1: result=${r2} expected=${expected}`);
    });
}

runTests();
