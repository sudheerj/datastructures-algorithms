//Dynamic programming:- TC:O(m*n) OC:O(n)
function uniquePaths2(m, n) {
    let row = new Array(n).fill(1);

    for(let i=1; i<m; i++) {
        let newRow = new Array(n).fill(0);
        newRow[0] = 1;
        for(let j=1; j<n; j++) {
            newRow[j] = row[j] + newRow[j-1];
        }
        row = newRow;
    }
    return row[n-1];
}

//Dynamic programming:- TC:O(m*n) OC:O(m*n)
function uniquePaths1(m, n) {
    let dp = new Array(m).fill(0).map(x => new Array(n).fill(0));

    for(let i=0; i<m; i++) {
        for(let j=0; j<n; j++) {
            if(i === 0 || j === 0) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
    }
    return dp[m-1][n-1];
}


let m1 = 4, n1 = 5, m2 = 3, n2 = 3;
console.log(uniquePaths1(m1, n1));
console.log(uniquePaths2(m1, n1));
console.log(uniquePaths1(m2, n2));
console.log(uniquePaths2(m2, n2));