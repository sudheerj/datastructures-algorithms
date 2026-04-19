function medianSortedArrays(nums1, nums2) {
    if (nums1.length > nums2.length) return medianSortedArrays(nums2, nums1);
    const n1 = nums1.length, n2 = nums2.length;
    const total = n1 + n2;
    const half = Math.floor(total / 2);
    let left = 0, right = n1 - 1;
    while (true) {
        const i = Math.floor((left + right) / 2);
        const j = half - i - 2;
        const firstLeft = i >= 0 ? nums1[i] : -Infinity;
        const firstRight = (i + 1) < n1 ? nums1[i + 1] : Infinity;
        const secondLeft = j >= 0 ? nums2[j] : -Infinity;
        const secondRight = (j + 1) < n2 ? nums2[j + 1] : Infinity;
        if (firstLeft <= secondRight && secondLeft <= firstRight) {
            if (total % 2) {
                return Math.min(firstRight, secondRight);
            }
            return (Math.max(firstLeft, secondLeft) + Math.min(firstRight, secondRight)) / 2;
        } else if (firstLeft > secondRight) {
            right = i - 1;
        } else {
            left = i + 1;
        }
    }
}

// Example calls
console.log("Median (Even total):", medianSortedArrays([1, 3], [2, 4])); // Expected: 2.5
console.log("Median (Odd total):", medianSortedArrays([1, 2], [3, 4, 5])); // Expected: 3.0
console.log("Median (One empty):", medianSortedArrays([], [1])); // Expected: 1.0
try {
    console.log("Median (Both empty):", medianSortedArrays([], [])); // Expected: Exception or error
} catch (e) {
    console.log("Exception:", e.message);
}
console.log("Median (Negatives):", medianSortedArrays([-5, 3, 6], [-2, 4, 10])); // Expected: 3.5;

module.exports = { medianSortedArrays };