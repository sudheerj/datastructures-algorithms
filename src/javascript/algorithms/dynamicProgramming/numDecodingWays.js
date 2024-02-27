// TC:O(n) SC:O(1)
function numDecodingWays1(str){
    if(str.length === 0 || str.charAt(0) === '0') return 0;
    if(str.length === 1) return 1;

    let prevCount1 = prevCount2 = 1;
    for(let i=2; i<= str.length; i++) {
        let oneDigit = Number.parseInt(str.substr(i-1, i));
        let twoDigit = Number.parseInt(str.substr(i-2, i));
        let count = 0;

        if(oneDigit >=1) {
            count += prevCount2;
        }

        if(twoDigit >=10 && twoDigit <=26) {
            count += prevCount1;
        }

        prevCount1 = prevCount2;
        prevCount2 = count;
    }
    return prevCount2;
}

 // TC:O(n) SC:O(n)
 function numDecodingWays2(str){
    let dp = new Array(str.length+1).fill(0);

    dp[0] = 1;
    dp[1] = str.charAt(0) === '0' ? 0 : 1;

    for(let i=2; i<= str.length; i++) {
        let oneDigit = Number.parseInt(str.substr(i-1, i));
        let twoDigit = Number.parseInt(str.substr(i-2, i));

        if(oneDigit >=1) {
            dp[i] += dp[i-1];
        }

        if(twoDigit >=10 && twoDigit <=26) {
            dp[i] += dp[i-2];
        }
    }
    return dp[str.length];
 }

 let str1 = "221";
 let str2 = "06";
 console.log(numDecodingWays1(str1));
 console.log(numDecodingWays1(str2));
 console.log(numDecodingWays2(str1));
 console.log(numDecodingWays2(str2));