function isInterleave(s1, s2, s3) {
    const m = s1.length, n = s2.length;
    if (m + n !== s3.length) return false;
    const dp = Array.from({ length: m + 1 }, () => Array(n + 1).fill(false));
    dp[m][n] = true;
    for (let i = m; i >= 0; i--) {
        for (let j = n; j >= 0; j--) {
            if (i === m && j === n) continue;
            const k = i + j;
            const fromS1 = i < m && s1[i] === s3[k] && dp[i + 1][j];
            const fromS2 = j < n && s2[j] === s3[k] && dp[i][j + 1];
            dp[i][j] = fromS1 || fromS2;
        }
    }
    return dp[0][0];
}

console.log("Input: s1='aab', s2='axy', s3='aaxaby' -> Output:", isInterleave('aab', 'axy', 'aaxaby')); // true
console.log("Input: s1='aab', s2='axy', s3='abaaxy' -> Output:", isInterleave('aab', 'axy', 'abaaxy')); // false
console.log("Input: s1='', s2='', s3='' -> Output:", isInterleave('', '', ''));
console.log("Input: s1='abc', s2='', s3='abc' -> Output:", isInterleave('abc', '', 'abc'));
console.log("Input: s1='', s2='xyz', s3='xyz' -> Output:", isInterleave('', 'xyz', 'xyz'));
console.log("Input: s1='abc', s2='def', s3='abcd' -> Output:", isInterleave('abc', 'def', 'abcd'));
console.log("Input: s1='aa', s2='ab', s3='aaba' -> Output:", isInterleave('aa', 'ab', 'aaba'));
