// Greedy: sort by (costB - costA), send first n to B, rest to A
// TC: O(n log n)  SC: O(n)
function twoCitySchedulingCost(costs) {
    const sorted = [...costs].sort((a, b) => (a[1] - a[0]) - (b[1] - b[0]));
    const n = sorted.length / 2;
    let total = 0;
    for (let i = 0; i < sorted.length; i++) {
        total += i < n ? sorted[i][1] : sorted[i][0]; // B for first half, A for second
    }
    return total;
}

const costs1 = [[10,20],[30,200],[400,50],[30,20]];
const r1 = twoCitySchedulingCost(costs1);
console.log(`Test 1 - [[10,20],[30,200],[400,50],[30,20]]: ${r1 === 110 ? '[PASS]' : '[FAIL]'} result=${r1} expected=110`);

const costs2 = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]];
const r2 = twoCitySchedulingCost(costs2);
console.log(`Test 2 - 6 people: ${r2 === 1859 ? '[PASS]' : '[FAIL]'} result=${r2} expected=1859`);

const costs3 = [[1,2],[3,4]];
const r3 = twoCitySchedulingCost(costs3);
console.log(`Test 3 - [[1,2],[3,4]]: ${r3 === 5 ? '[PASS]' : '[FAIL]'} result=${r3} expected=5`);

const costs4 = [[100,1],[1,100]];
const r4 = twoCitySchedulingCost(costs4);
console.log(`Test 4 - [[100,1],[1,100]]: ${r4 === 2 ? '[PASS]' : '[FAIL]'} result=${r4} expected=2`);

const costs5 = [[10,10],[10,10]];
const r5 = twoCitySchedulingCost(costs5);
console.log(`Test 5 - [[10,10],[10,10]]: ${r5 === 20 ? '[PASS]' : '[FAIL]'} result=${r5} expected=20`);
