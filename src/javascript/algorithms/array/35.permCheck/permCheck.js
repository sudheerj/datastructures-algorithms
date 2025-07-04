//Using set- TC: O(n) SC: O(n)
function permCheckUsingSet(nums) {
    const seen = new Set();

    for(let i =0; i<nums.length; i++){
        if(nums[i] < 1 || nums[i] > nums.length || seen.has(nums[i])){
            return 0;
        }

        seen.add(nums[i]);
    }

    return 1;
}

//Using set- TC: O(n) SC: O(n)
function permCheckUsingArray(nums) {
    const seen = Array(nums.length).fill(false);

    for(let i =0; i<nums.length; i++){
        if(nums[i] < 1 || nums[i] > nums.length || seen[nums[i]-1]){
            return 0;
        }

        seen[nums[i]-1] = true;
    }

    return 1;
}

console.log(permCheckUsingSet([4, 1, 3, 2]));     // Output: 1 (Valid permutation)
console.log(permCheckUsingSet([4, 1, 3]));        // Output: 0 (Missing 2)
console.log(permCheckUsingSet([1, 2, 2, 3]));     // Output: 0 (Duplicate)
console.log(permCheckUsingSet([1]));             // Output: 1
console.log(permCheckUsingSet([2, 1, 4, 3, 5]));  // Output: 1

console.log(permCheckUsingArray([4, 1, 3, 2]));     // Output: 1 (Valid permutation)
console.log(permCheckUsingArray([4, 1, 3]));        // Output: 0 (Missing 2)
console.log(permCheckUsingArray([1, 2, 2, 3]));     // Output: 0 (Duplicate)
console.log(permCheckUsingArray([1]));             // Output: 1
console.log(permCheckUsingArray([2, 1, 4, 3, 5]));  // Output: 1