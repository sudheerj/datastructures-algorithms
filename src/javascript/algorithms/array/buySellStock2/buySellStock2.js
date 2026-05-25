// Approach 1: Greedy (accumulate positive daily gains) — O(n) time, O(1) space
function maxProfit1(prices) {
    let maxProfit = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] - prices[i - 1] > 0) {
            maxProfit += prices[i] - prices[i - 1];
        }
    }
    return maxProfit;
}

// Approach 2: Peak-Valley — O(n) time, O(1) space
function maxProfit2(prices) {
    let maxProfit = 0;
    let i = 0;
    while (i < prices.length - 1) {
        while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
        const valley = prices[i];
        while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
        const peak = prices[i];
        maxProfit += peak - valley;
    }
    return maxProfit;
}

const t1 = [7,1,5,3,6,4], t2 = [1,2,3,4,5], t3 = [7,6,4,3,1], t4 = [1,2,1,3,1,4], t5 = [2,1,2,0,1];
const e1 = 7, e2 = 4, e3 = 0, e4 = 6, e5 = 2;

// Approach 1: greedy
const r1 = maxProfit1(t1);
console.log(`Test 1 (greedy): ${r1 === e1 ? "[PASS]" : "[FAIL]"} result=${r1} expected=${e1}`);
const r2 = maxProfit1(t2);
console.log(`Test 2 (greedy): ${r2 === e2 ? "[PASS]" : "[FAIL]"} result=${r2} expected=${e2}`);
const r3 = maxProfit1(t3);
console.log(`Test 3 (greedy): ${r3 === e3 ? "[PASS]" : "[FAIL]"} result=${r3} expected=${e3}`);
const r4 = maxProfit1(t4);
console.log(`Test 4 (greedy): ${r4 === e4 ? "[PASS]" : "[FAIL]"} result=${r4} expected=${e4}`);
const r5 = maxProfit1(t5);
console.log(`Test 5 (greedy): ${r5 === e5 ? "[PASS]" : "[FAIL]"} result=${r5} expected=${e5}`);

// Approach 2: peak-valley
const r6 = maxProfit2(t1);
console.log(`Test 1 (peak-valley): ${r6 === e1 ? "[PASS]" : "[FAIL]"} result=${r6} expected=${e1}`);
const r7 = maxProfit2(t2);
console.log(`Test 2 (peak-valley): ${r7 === e2 ? "[PASS]" : "[FAIL]"} result=${r7} expected=${e2}`);
const r8 = maxProfit2(t3);
console.log(`Test 3 (peak-valley): ${r8 === e3 ? "[PASS]" : "[FAIL]"} result=${r8} expected=${e3}`);
const r9 = maxProfit2(t4);
console.log(`Test 4 (peak-valley): ${r9 === e4 ? "[PASS]" : "[FAIL]"} result=${r9} expected=${e4}`);
const r10 = maxProfit2(t5);
console.log(`Test 5 (peak-valley): ${r10 === e5 ? "[PASS]" : "[FAIL]"} result=${r10} expected=${e5}`);
