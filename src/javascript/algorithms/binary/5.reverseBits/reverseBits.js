// TC:O(32) ~ O(1) SC:O(1)

function reverseBits1(num) {
    let reverseBitResult = 0;
    for(let i=0; i<32; i++) {
        let bit = (num >> i) & 1;
        if( bit === 1) {
            reverseBitResult = reverseBitResult | bit << 31-i;
        }
    }
    return reverseBitResult;
}

function reverseBits2(num) {
    let reverseBitResult = 0;
    for(let i=0; i< 32; i++) {
        reverseBitResult <<= 1;
        reverseBitResult |= (1 & num);
        num >>= 1;
    }
    return reverseBitResult;
}

let num1 = 4;
console.log(reverseBits1(num1));
console.log(reverseBits2(num1));

let num2 = 8;
console.log(reverseBits1(num2));
console.log(reverseBits2(num2));