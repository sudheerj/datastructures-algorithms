// Dynamic programming:- TC:O(n) SC:O(n)

function countingBits(num) {
    let dp = new Array(num+1).fill(0);
    let offset = 1; 
    for(let i=1; i< num+1; i++) {
        if(offset * 2 === i) {
            offset = i;
        }
        dp[i] = 1 +dp[i-offset];
    }
    return dp;
}

let num = 3;
console.log(countingBits(num));