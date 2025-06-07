// TC: O(n), SC: O(1)
function numDecodingWays1(str) {
  if(str.length === 0 || str[0] === '0') return 0;
  if(str.length === 1) return 1;

  let prevCount1 = 1, prevCount2 = 1;
  for(let i=2; i<= str.length; i++) {
    let oneDigit = Number.parseInt(str.substring(i-1, i));
    let twoDigit = Number.parseInt(str.substring(i-2, i));
    let count = 0;

    if(oneDigit >=1) {
      count += prevCount2;
    }

    if(10 <= twoDigit <=26) {
      count += prevCount1;
    }

    prevCount1 = prevCount2;
    prevCount2 = count;
  }
  return prevCount2;
}

// TC: O(n), SC: O(n)
function numDecodingWays2(str) {
  if(str.length === 0 || str[0] === '0') return 0;
  let dp = new Array(str.length+1).fill(0);

  dp[0] = 1; // Base case: empty string has 1 way to decode
  dp[1] = 1; // First character is valid (already checked for '0')

  for(let i=2; i<= str.length; i++) {
    let oneDigit = Number.parseInt(str.substring(i-1, i));
    let twoDigit = Number.parseInt(str.substring(i-2, i));

    if(oneDigit >=1) {
      dp[i] += dp[i-1];
    }

    if(10 <= twoDigit && twoDigit <=26) {
      dp[i] += dp[i-2];
    }
  }
  return dp[str.length];
}

// Test cases
let testCases = ["221", "09", "12", "226", "0", "10", "100", ""];
for (const s of testCases) {
  console.log(
    `Input: '${s}' | Ways1: ${numDecodingWays1(s)} | Ways2: ${numDecodingWays2(
      s
    )}`
  );
}
