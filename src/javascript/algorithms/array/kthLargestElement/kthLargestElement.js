/**
 * Sorting TC: O(n log n) SC: O(1)
 */
function kthLargest1(nums, k) {
    nums.sort((a, b) => a - b);
    return nums[nums.length - k];
}

/**
 * Min-heap of size k TC: O(n log k) SC: O(k)
 */
class MinHeap {
    constructor() { this.heap = []; }

    push(val) {
        this.heap.push(val);
        this._bubbleUp(this.heap.length - 1);
    }

    pop() {
        const top = this.heap[0];
        const last = this.heap.pop();
        if (this.heap.length > 0) {
            this.heap[0] = last;
            this._sinkDown(0);
        }
        return top;
    }

    peek() { return this.heap[0]; }
    size() { return this.heap.length; }

    _bubbleUp(i) {
        while (i > 0) {
            const parent = Math.floor((i - 1) / 2);
            if (this.heap[parent] <= this.heap[i]) break;
            [this.heap[parent], this.heap[i]] = [this.heap[i], this.heap[parent]];
            i = parent;
        }
    }

    _sinkDown(i) {
        const n = this.heap.length;
        while (true) {
            let smallest = i;
            const l = 2 * i + 1, r = 2 * i + 2;
            if (l < n && this.heap[l] < this.heap[smallest]) smallest = l;
            if (r < n && this.heap[r] < this.heap[smallest]) smallest = r;
            if (smallest === i) break;
            [this.heap[i], this.heap[smallest]] = [this.heap[smallest], this.heap[i]];
            i = smallest;
        }
    }
}

function kthLargest2(nums, k) {
    const heap = new MinHeap();
    for (const num of nums) {
        heap.push(num);
        if (heap.size() > k) heap.pop();
    }
    return heap.peek();
}

/**
 * Max-heap (sort descending) TC: O(n log n) SC: O(n)
 */
function kthLargest3(nums, k) {
    nums.sort((a, b) => b - a);
    return nums[k - 1];
}

/**
 * QuickSelect TC: O(n) avg SC: O(n) recursion stack
 */
function kthLargest4(nums, k) {
    const target = nums.length - k;

    function partition(left, right) {
        const pivot = nums[right];
        let i = left;
        for (let j = left; j < right; j++) {
            if (nums[j] < pivot) {
                [nums[i], nums[j]] = [nums[j], nums[i]];
                i++;
            }
        }
        [nums[i], nums[right]] = [nums[right], nums[i]];
        return i;
    }

    function quickSelect(left, right) {
        const pivotIdx = partition(left, right);
        if (pivotIdx === target) return nums[pivotIdx];
        if (pivotIdx < target) return quickSelect(pivotIdx + 1, right);
        return quickSelect(left, pivotIdx - 1);
    }

    return quickSelect(0, nums.length - 1);
}

// Test cases
const testCases = [
    { nums: [3, 2, 1, 5, 6, 4],           k: 2, expected: 5 },
    { nums: [3, 2, 3, 1, 2, 4, 5, 5, 6],  k: 4, expected: 4 },
    { nums: [1],                           k: 1, expected: 1 },
    { nums: [7, 6, 5, 4, 3, 2, 1],        k: 3, expected: 5 },
    { nums: [1, 2, 3, 4, 5],              k: 1, expected: 5 },
];

console.log("--- kthLargest1 (Sorting) ---");
for (const { nums, k, expected } of testCases) {
    const result = kthLargest1([...nums], k);
    console.log(`[${result === expected ? "PASS" : "FAIL"}] result=${result} expected=${expected}`);
}

console.log("--- kthLargest2 (MinHeap) ---");
for (const { nums, k, expected } of testCases) {
    const result = kthLargest2([...nums], k);
    console.log(`[${result === expected ? "PASS" : "FAIL"}] result=${result} expected=${expected}`);
}

console.log("--- kthLargest3 (MaxHeap) ---");
for (const { nums, k, expected } of testCases) {
    const result = kthLargest3([...nums], k);
    console.log(`[${result === expected ? "PASS" : "FAIL"}] result=${result} expected=${expected}`);
}

console.log("--- kthLargest4 (QuickSelect) ---");
for (const { nums, k, expected } of testCases) {
    const result = kthLargest4([...nums], k);
    console.log(`[${result === expected ? "PASS" : "FAIL"}] result=${result} expected=${expected}`);
}
