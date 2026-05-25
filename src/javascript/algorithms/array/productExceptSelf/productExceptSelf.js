// Approach 1: Prefix/postfix optimized — O(n) time, O(1) space (output excluded)
function productExceptSelf1(nums) {
    const result = new Array(nums.length).fill(1);
    let prefix = 1;
    for (let i = 0; i < nums.length; i++) {
        result[i] = prefix;
        prefix *= nums[i];
    }
    let postfix = 1;
    for (let i = nums.length - 1; i >= 0; i--) {
        result[i] *= postfix;
        postfix *= nums[i];
    }
    return result;
}

// Approach 2: Prefix/postfix arrays — O(n) time, O(n) space
function productExceptSelf2(nums) {
    const n = nums.length;
    const prefix = new Array(n).fill(1);
    const postfix = new Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        prefix[i] = nums[i - 1] * prefix[i - 1];
    }
    for (let i = n - 2; i >= 0; i--) {
        postfix[i] = nums[i + 1] * postfix[i + 1];
    }
    return prefix.map((v, i) => v * postfix[i]);
}

// Approach 3: Division — O(n) time, O(1) space
function productExceptSelf3(nums) {
    let product = 1;
    let zeroCount = 0;
    for (const num of nums) {
        if (num !== 0) product *= num;
        else zeroCount++;
    }
    if (zeroCount > 1) return new Array(nums.length).fill(0);
    return nums.map(num => {
        if (zeroCount > 0) return num === 0 ? product : 0;
        return product / num;
    });
}

// Approach 4: Brute force — O(n²) time, O(1) space
function productExceptSelf4(nums) {
    const result = [];
    for (let i = 0; i < nums.length; i++) {
        let product = 1;
        for (let j = 0; j < nums.length; j++) {
            if (i === j) continue;
            product *= nums[j];
        }
        result.push(product);
    }
    return result;
}

const t1 = [1,2,3,4], t2 = [-1,1,0,-3,3], t3 = [1,2,3,4,5], t4 = [0,0], t5 = [2,3,4];
const e1 = "[24,12,8,6]", e2 = "[0,0,9,0,0]", e3 = "[120,60,40,30,24]", e4 = "[0,0]", e5 = "[12,8,6]";

// Approach 1: prefix/postfix optimized
const r1 = JSON.stringify(productExceptSelf1(t1));
console.log(`Test 1 (opt): ${r1 === e1 ? "[PASS]" : "[FAIL]"} result=${r1} expected=${e1}`);
const r2 = JSON.stringify(productExceptSelf1(t2));
console.log(`Test 2 (opt): ${r2 === e2 ? "[PASS]" : "[FAIL]"} result=${r2} expected=${e2}`);
const r3 = JSON.stringify(productExceptSelf1(t3));
console.log(`Test 3 (opt): ${r3 === e3 ? "[PASS]" : "[FAIL]"} result=${r3} expected=${e3}`);
const r4 = JSON.stringify(productExceptSelf1(t4));
console.log(`Test 4 (opt): ${r4 === e4 ? "[PASS]" : "[FAIL]"} result=${r4} expected=${e4}`);
const r5 = JSON.stringify(productExceptSelf1(t5));
console.log(`Test 5 (opt): ${r5 === e5 ? "[PASS]" : "[FAIL]"} result=${r5} expected=${e5}`);

// Approach 2: prefix/postfix arrays
const r6 = JSON.stringify(productExceptSelf2(t1));
console.log(`Test 1 (arr): ${r6 === e1 ? "[PASS]" : "[FAIL]"} result=${r6} expected=${e1}`);
const r7 = JSON.stringify(productExceptSelf2(t2));
console.log(`Test 2 (arr): ${r7 === e2 ? "[PASS]" : "[FAIL]"} result=${r7} expected=${e2}`);
const r8 = JSON.stringify(productExceptSelf2(t3));
console.log(`Test 3 (arr): ${r8 === e3 ? "[PASS]" : "[FAIL]"} result=${r8} expected=${e3}`);
const r9 = JSON.stringify(productExceptSelf2(t4));
console.log(`Test 4 (arr): ${r9 === e4 ? "[PASS]" : "[FAIL]"} result=${r9} expected=${e4}`);
const r10 = JSON.stringify(productExceptSelf2(t5));
console.log(`Test 5 (arr): ${r10 === e5 ? "[PASS]" : "[FAIL]"} result=${r10} expected=${e5}`);

// Approach 3: division
const r11 = JSON.stringify(productExceptSelf3(t1));
console.log(`Test 1 (div): ${r11 === e1 ? "[PASS]" : "[FAIL]"} result=${r11} expected=${e1}`);
const r12 = JSON.stringify(productExceptSelf3(t2));
console.log(`Test 2 (div): ${r12 === e2 ? "[PASS]" : "[FAIL]"} result=${r12} expected=${e2}`);
const r13 = JSON.stringify(productExceptSelf3(t3));
console.log(`Test 3 (div): ${r13 === e3 ? "[PASS]" : "[FAIL]"} result=${r13} expected=${e3}`);
const r14 = JSON.stringify(productExceptSelf3(t4));
console.log(`Test 4 (div): ${r14 === e4 ? "[PASS]" : "[FAIL]"} result=${r14} expected=${e4}`);
const r15 = JSON.stringify(productExceptSelf3(t5));
console.log(`Test 5 (div): ${r15 === e5 ? "[PASS]" : "[FAIL]"} result=${r15} expected=${e5}`);

// Approach 4: brute force
const r16 = JSON.stringify(productExceptSelf4(t1));
console.log(`Test 1 (brute): ${r16 === e1 ? "[PASS]" : "[FAIL]"} result=${r16} expected=${e1}`);
const r17 = JSON.stringify(productExceptSelf4(t2));
console.log(`Test 2 (brute): ${r17 === e2 ? "[PASS]" : "[FAIL]"} result=${r17} expected=${e2}`);
const r18 = JSON.stringify(productExceptSelf4(t3));
console.log(`Test 3 (brute): ${r18 === e3 ? "[PASS]" : "[FAIL]"} result=${r18} expected=${e3}`);
const r19 = JSON.stringify(productExceptSelf4(t4));
console.log(`Test 4 (brute): ${r19 === e4 ? "[PASS]" : "[FAIL]"} result=${r19} expected=${e4}`);
const r20 = JSON.stringify(productExceptSelf4(t5));
console.log(`Test 5 (brute): ${r20 === e5 ? "[PASS]" : "[FAIL]"} result=${r20} expected=${e5}`);
