// Approach 1: Two Pointers — O(n) time, O(1) space
function trappingRainWater1(height) {
    if (height.length === 0) return 0;
    let left = 0, right = height.length - 1;
    let leftMax = height[0], rightMax = height[right];
    let res = 0;
    while (left < right) {
        if (leftMax <= rightMax) {
            left++;
            leftMax = Math.max(leftMax, height[left]);
            res += leftMax - height[left];
        } else {
            right--;
            rightMax = Math.max(rightMax, height[right]);
            res += rightMax - height[right];
        }
    }
    return res;
}

// Approach 2: Prefix/Suffix Arrays — O(n) time, O(n) space
function trappingRainWater2(height) {
    const n = height.length;
    if (n === 0) return 0;
    const leftMax = new Array(n);
    const rightMax = new Array(n);
    leftMax[0] = height[0];
    for (let i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    rightMax[n - 1] = height[n - 1];
    for (let j = n - 2; j >= 0; j--) rightMax[j] = Math.max(rightMax[j + 1], height[j]);
    let water = 0;
    for (let i = 0; i < n; i++) water += Math.min(leftMax[i], rightMax[i]) - height[i];
    return water;
}

// Approach 3: Brute Force — O(n²) time, O(1) space
function trappingRainWater3(height) {
    const n = height.length;
    if (n === 0) return 0;
    let water = 0;
    for (let i = 0; i < n; i++) {
        let leftMax = 0;
        for (let j = 0; j <= i; j++) leftMax = Math.max(leftMax, height[j]);
        let rightMax = 0;
        for (let j = i; j < n; j++) rightMax = Math.max(rightMax, height[j]);
        water += Math.min(leftMax, rightMax) - height[i];
    }
    return water;
}

const t1 = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1];
const t2 = [4, 2, 0, 3, 2, 5];
const t3 = [1, 1];
const t4 = [];
const t5 = [3, 0, 0, 2, 0, 4];

// Approach 1: Two Pointers
const r1 = trappingRainWater1(t1);
console.log(`Test 1 (two-ptr): ${r1 === 6 ? '[PASS]' : '[FAIL]'} result=${r1} expected=6`);
const r2 = trappingRainWater1(t2);
console.log(`Test 2 (two-ptr): ${r2 === 9 ? '[PASS]' : '[FAIL]'} result=${r2} expected=9`);
const r3 = trappingRainWater1(t3);
console.log(`Test 3 (two-ptr): ${r3 === 0 ? '[PASS]' : '[FAIL]'} result=${r3} expected=0`);
const r4 = trappingRainWater1(t4);
console.log(`Test 4 (two-ptr): ${r4 === 0 ? '[PASS]' : '[FAIL]'} result=${r4} expected=0`);
const r5 = trappingRainWater1(t5);
console.log(`Test 5 (two-ptr): ${r5 === 10 ? '[PASS]' : '[FAIL]'} result=${r5} expected=10`);

// Approach 2: Prefix/Suffix Arrays
const r6 = trappingRainWater2(t1);
console.log(`Test 1 (prefix): ${r6 === 6 ? '[PASS]' : '[FAIL]'} result=${r6} expected=6`);
const r7 = trappingRainWater2(t2);
console.log(`Test 2 (prefix): ${r7 === 9 ? '[PASS]' : '[FAIL]'} result=${r7} expected=9`);
const r8 = trappingRainWater2(t3);
console.log(`Test 3 (prefix): ${r8 === 0 ? '[PASS]' : '[FAIL]'} result=${r8} expected=0`);
const r9 = trappingRainWater2(t4);
console.log(`Test 4 (prefix): ${r9 === 0 ? '[PASS]' : '[FAIL]'} result=${r9} expected=0`);
const r10 = trappingRainWater2(t5);
console.log(`Test 5 (prefix): ${r10 === 10 ? '[PASS]' : '[FAIL]'} result=${r10} expected=10`);

// Approach 3: Brute Force
const r11 = trappingRainWater3(t1);
console.log(`Test 1 (brute): ${r11 === 6 ? '[PASS]' : '[FAIL]'} result=${r11} expected=6`);
const r12 = trappingRainWater3(t2);
console.log(`Test 2 (brute): ${r12 === 9 ? '[PASS]' : '[FAIL]'} result=${r12} expected=9`);
const r13 = trappingRainWater3(t3);
console.log(`Test 3 (brute): ${r13 === 0 ? '[PASS]' : '[FAIL]'} result=${r13} expected=0`);
const r14 = trappingRainWater3(t4);
console.log(`Test 4 (brute): ${r14 === 0 ? '[PASS]' : '[FAIL]'} result=${r14} expected=0`);
const r15 = trappingRainWater3(t5);
console.log(`Test 5 (brute): ${r15 === 10 ? '[PASS]' : '[FAIL]'} result=${r15} expected=10`);
