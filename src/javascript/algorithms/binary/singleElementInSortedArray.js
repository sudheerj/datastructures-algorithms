function singleNonDuplicate(nums) {
    let left = 0, right = nums.length - 1;
    while (left < right) {
        let mid = left + Math.floor((right - left) / 2);
        if (mid % 2 === 1) mid--;
        if (nums[mid] === nums[mid + 1]) {
            left = mid + 2;
        } else {
            right = mid;
        }
    }
    return nums[left];
}

function runTests() {
    const tests = [
        [1,1,2,3,3,4,4,8,8],
        [3,3,7,7,10,11,11],
        [1,1,2,2,3,3,4,4,5],
        [0,1,1,2,2,3,3],
        [1,1,2,2,3,3,4],
        [5],
        [1,1,2],
    ];
    const expected = [2,10,5,0,4,5,2];
    console.log("Testing singleNonDuplicate (binary search):");
    for (let i = 0; i < tests.length; i++) {
        const result = singleNonDuplicate([...tests[i]]);
        console.log(`Test ${i+1}: Output=${result}, Expected=${expected[i]} [${result === expected[i] ? 'PASS' : 'FAIL'}]`);
    }
}

runTests();
