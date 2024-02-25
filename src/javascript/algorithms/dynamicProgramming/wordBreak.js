//TC: O(n*2 *m) SC:O(n)

function wordBreak(str, wordDict) {
    let dp = new Array(str.length+1).fill(false);
    dp[str.length] = true;
    for(let i=str.length-1; i>=0; i--) {
        for(let word of wordDict) {
            if((i+word.length <= str.length) && wordDict.includes(str.substr(i, word.length))) {
                dp[i] = dp[i+ word.length];
            }
            if(dp[i]) {
                break;
            }
        }
    }
    return dp[0];
}

let str = "applepenapple";
let wordDict = ["pen", "apple"];
let str1 = "catsandog", wordDict1 = ["cats","dog","sand","and","cat"]
console.log(wordBreak(str, wordDict));
console.log(wordBreak(str1, wordDict1));