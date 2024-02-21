//Optimistic solution without scanning zeros
function hammingWeight(num) {
    let count = 0;
    while(num != 0) {
        num &= num-1;
        count++;
    }
    return count;
}

function hammingWeight1(num) {
    let count = 0;
    while(num != 0) {
        count += num % 2;
        num >>= 1;
    }
    return count;
}

function hammingWeight2(num) {
    let count = 0;
    let mask = 1;
    while(num != 0) {
        for(let i=0; i< 32; i++) {
            if((num & mask) != 0) {
                count++;
            }
            num >>=1;
        }
    }
    return count;
}

let num = 11; // 00000000000000000000000000001011
console.log(hammingWeight(num));
console.log(hammingWeight1(num));
console.log(hammingWeight2(num));