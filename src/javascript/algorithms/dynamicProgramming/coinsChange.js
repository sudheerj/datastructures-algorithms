// TC: O(amount * numberOfCoins) SC: O(amount)
function coinsChange(coins, amount) {
    let dp = new Array(amount+1).fill(0);
    for(let i = 1; i<=amount; i++){
        let min = Number.MAX_VALUE;
        for(let j=0; j< coins.length; j++) {
            if(i >= coins[j] && dp[i-coins[j]] != -1) {
                min = Math.min(min, dp[i-coins[j]]);
            }
        }
        dp[i] = min === Number.MAX_VALUE ? -1 : 1 + min;
    }
    return dp[amount]; 
}

let coins = [1, 3, 4, 5];
let amount = 7;
console.log(coinsChange(coins, amount));