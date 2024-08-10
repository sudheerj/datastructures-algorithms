// TC:O(32) ~ O(1), SC: O(1)

function findTwoSum(a, b) {
    while(b != 0) {
        let carry = (a & b) << 1;
        a = a ^ b;
        b = carry;
    }
    return a;
}

let a = 44, b = 32;
let a1 = 3, b1 = 2;
console.log(findTwoSum(a, b));
console.log(findTwoSum(a1, b1));