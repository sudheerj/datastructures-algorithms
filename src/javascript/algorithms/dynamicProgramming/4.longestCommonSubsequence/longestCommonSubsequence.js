//Two dimensional DP bottom-up:- TC:O(m * n) SC:O(m* n)
function lengthOfLCS(str1, str2) {
    let dp = Array(str1.length + 1).fill().map(() => Array(str2.length + 1).fill(0));
    for(let i=str1.length-1; i>=0; i--) {
        for(let j=str2.length-1; j>=0; j--) {
            if(str1[i] === str2[j]) {
                dp[i][j] = 1 + dp[i+1][j+1];
            } else {
                dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
    }
    return dp[0][0];
}

let text1 = "abcdef", text2 = "acbefd", text3 = "abcd", text4 = "efgh";
console.log(lengthOfLCS(text1, text2));
console.log(lengthOfLCS(text3, text4));