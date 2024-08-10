//Optimistic solution without scanning zeros(Brian Kernighan's Algorithm)// TC: O(1), SC: O(1)
function hammingWeight1(num) {
    let count = 0;
    while(num != 0) {
        num &= num-1;
        count++;
    }
    return count;
}

//TC: O(32)-> O(1), SC: O(1)
function hammingWeight2(num) {
    let count = 0;
    while(num != 0) {
        count += num & 1;
        num >>= 1;
    }
    return count;
}

//TC: O(32)-> O(1), SC: O(1)
function hammingWeight3(num) {
    let count = 0;
    while(num != 0) {
        count += num % 2;
        num >>= 1;
    }
    return count;
}

// TC: O(32) -> O(1) SC: O(1)
function hammingWeight4(num) {
    let count = 0;
    let mask = 1;
    for(let i=0; i< 32; i++) {
        if((num & mask) != 0) {
            count++;
        }
        num >>=1;
    }
    return count;
}

let num1 = 12; // 00000000000000000000000000001100
let num2 = 128; // 00000000000000000000000010000000
console.log(hammingWeight1(num1));
console.log(hammingWeight2(num1));
console.log(hammingWeight3(num1));
console.log(hammingWeight4(num1));

console.log(hammingWeight1(num2));
console.log(hammingWeight2(num2));
console.log(hammingWeight3(num2));
console.log(hammingWeight4(num2));