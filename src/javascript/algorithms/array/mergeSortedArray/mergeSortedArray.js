// Three pointers from the back  TC: O(m + n) SC: O(1)
function mergeSortedArray(nums1, m, nums2, n) {
    let i = m - 1, j = n - 1, k = m + n - 1;

    while (i >= 0 && j >= 0) {
        if (nums1[i] >= nums2[j]) {
            nums1[k] = nums1[i];
            i--;
        } else {
            nums1[k] = nums2[j];
            j--;
        }
        k--;
    }

    while (j >= 0) {
        nums1[k] = nums2[j];
        j--;
        k--;
    }

    return nums1;
}

function runTests() {
    const tests = [
        { nums1: [1, 2, 3, 0, 0, 0], m: 3, nums2: [2, 5, 6],  n: 3, expected: [1, 2, 2, 3, 5, 6] },
        { nums1: [1],                 m: 1, nums2: [],          n: 0, expected: [1] },
        { nums1: [0],                 m: 0, nums2: [1],         n: 1, expected: [1] },
        { nums1: [4, 5, 6, 0, 0, 0], m: 3, nums2: [1, 2, 3],  n: 3, expected: [1, 2, 3, 4, 5, 6] },
        { nums1: [1, 2, 4, 5, 6, 0], m: 5, nums2: [3],         n: 1, expected: [1, 2, 3, 4, 5, 6] },
    ];

    tests.forEach(({ nums1, m, nums2, n, expected }) => {
        const result = mergeSortedArray([...nums1], m, [...nums2], n);
        const status = JSON.stringify(result) === JSON.stringify(expected) ? "PASS" : "FAIL";
        console.log(`[${status}] result=[${result}] expected=[${expected}]`);
    });
}

runTests();
