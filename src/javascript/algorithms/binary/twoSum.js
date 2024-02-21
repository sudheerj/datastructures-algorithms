// TC:O(32) ~ O(1), SC: O(1)

function findTwoSum(a, b) {
    while(b != 0) {
        let carry = a & b;
        a = a ^ b;
        b = carry << 1;
    }
    return a;
}

let a = 44, b = 32;
console.log(findTwoSum(a, b));