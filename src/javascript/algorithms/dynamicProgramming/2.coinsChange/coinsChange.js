// TC: O(amount * numberOfCoins) SC: O(amount)
function coinsChange(coins, amount) {
    let dp = new Array(amount+1).fill(amount+1);
    dp[0] = 0;
    for(let i = 1; i<=amount; i++){
        for(let coin of coins) {
            if(i -coin >=0) {
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
    }
    return dp[amount] === amount+1 ? -1 : dp[amount];
}

let coins1 = [1, 3, 4, 5], amount1 = 7;
let coins2 = [2, 4], amount2 = 3;
console.log(coinsChange(coins1, amount1));
console.log(coinsChange(coins2, amount2));