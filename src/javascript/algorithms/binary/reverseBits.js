// TC:O(32) ~ O(1) SC:O(1)

function reverseBits1(num) {
    let reverseBitResult = 0;
    for(let i=0; i< 32; i++) {
        reverseBitResult = reverseBitResult << 1;
        reverseBitResult = reverseBitResult | (1 & num);
        num = num >> 1;
    }
    return reverseBitResult;
}

function reverseBits2(num) {
    let reverseBitResult = 0;
    for(let i=0; i<32; i++) {
        if((num >> i & 1) === 1)
        reverseBitResult = reverseBitResult | 1 << 31-i;
    }
    return reverseBitResult;
}

let num = 11;
console.log(reverseBits1(num));
console.log(reverseBits2(num));