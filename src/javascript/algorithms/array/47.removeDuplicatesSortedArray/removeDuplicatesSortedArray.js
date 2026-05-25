// Two pointers TC: O(n) SC: O(1)
function removeDuplicates1(nums) {
    let left = 0;

    for (let j = 1; j < nums.length; j++) {
        if (nums[j] !== nums[left]) {
            left++;
            nums[left] = nums[j];
        }
    }

    return left + 1;
}

// Two pointers (previous element comparison) TC: O(n) SC: O(1)
function removeDuplicates2(nums) {
    let left = 1;

    for (let right = 1; right < nums.length; right++) {
        if (nums[right] !== nums[right - 1]) {
            nums[left++] = nums[right];
        }
    }

    return left;
}

const testCases = [
    { nums: [1, 1, 2],                     expectedK: 2, expectedArr: [1, 2] },
    { nums: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4], expectedK: 5, expectedArr: [0, 1, 2, 3, 4] },
    { nums: [1, 2, 3, 4, 5],               expectedK: 5, expectedArr: [1, 2, 3, 4, 5] },
    { nums: [1],                            expectedK: 1, expectedArr: [1] },
    { nums: [7, 7, 7, 7],                  expectedK: 1, expectedArr: [7] },
];

function runTests(fn, label) {
    console.log(`--- ${label} ---`);
    for (const { nums, expectedK, expectedArr } of testCases) {
        const arr = [...nums];
        const k = fn(arr);
        const resultArr = arr.slice(0, k);
        const pass = k === expectedK && resultArr.every((v, i) => v === expectedArr[i]);
        console.log(`[${pass ? "PASS" : "FAIL"}] k=${k} array=[${resultArr}]`);
    }
}

runTests(removeDuplicates1, "removeDuplicates1 (left pointer)");
runTests(removeDuplicates2, "removeDuplicates2 (prev element comparison)");

