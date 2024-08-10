// Dynamic programming:- TC:O(n) SC:O(n)

function countingBits1(num) {
    let ans = new Array(num+1).fill(0);
    let offset = 1; 
    for(let i=1; i< num+1; i++) {
        if(offset * 2 === i) {
            offset = i;
        }
        ans[i] = 1 +ans[i-offset];
    }
    return ans;
}

function countingBits2(num) {
    let ans = new Array(num+1).fill(0);
    for(let i=1; i< num+1; i++) {
        ans[i] = ans[i >> 1] + (i & 1);
    }
    return ans;
}

let num1 = 3;
let num2 = 6;

console.log(countingBits1(num1));
console.log(countingBits1(num2));

console.log(countingBits2(num1));
console.log(countingBits2(num2));