class InsertRemoveRandom {
    constructor() {
        this.numMap = new Map(); // val -> index
        this.nums = [];
    }

    // O(1) average
    insert(val) {
        if (this.numMap.has(val)) return false;
        this.numMap.set(val, this.nums.length);
        this.nums.push(val);
        return true;
    }

    // O(1) average
    remove(val) {
        if (!this.numMap.has(val)) return false;
        const index = this.numMap.get(val);
        const last = this.nums[this.nums.length - 1];
        this.nums[index] = last;
        this.numMap.set(last, index);
        this.nums.pop();
        this.numMap.delete(val);
        return true;
    }

    // O(1)
    getRandomValue() {
        return this.nums[Math.floor(Math.random() * this.nums.length)];
    }
}

const obj = new InsertRemoveRandom();

// Test 1: insert new element → true
const r1 = obj.insert(1);
console.log(`Test 1 - insert(1) new element: ${r1 === true ? '[PASS]' : '[FAIL]'} result=${r1} expected=true`);

// Test 2: insert duplicate → false
const r2 = obj.insert(1);
console.log(`Test 2 - insert(1) duplicate: ${r2 === false ? '[PASS]' : '[FAIL]'} result=${r2} expected=false`);

// Test 3 & 4: insert more elements
const r3 = obj.insert(2);
console.log(`Test 3 - insert(2): ${r3 === true ? '[PASS]' : '[FAIL]'} result=${r3} expected=true`);
const r4 = obj.insert(3);
console.log(`Test 4 - insert(3): ${r4 === true ? '[PASS]' : '[FAIL]'} result=${r4} expected=true`);

// Test 5: remove existing element → true
const r5 = obj.remove(2);
console.log(`Test 5 - remove(2) exists: ${r5 === true ? '[PASS]' : '[FAIL]'} result=${r5} expected=true`);

// Test 6: remove already-removed element → false
const r6 = obj.remove(2);
console.log(`Test 6 - remove(2) already removed: ${r6 === false ? '[PASS]' : '[FAIL]'} result=${r6} expected=false`);

// Test 7: remove element that never existed → false
const r7 = obj.remove(99);
console.log(`Test 7 - remove(99) never existed: ${r7 === false ? '[PASS]' : '[FAIL]'} result=${r7} expected=false`);

// Test 8: getRandomValue() returns element from current set {1, 3}
const valid8 = new Set([1, 3]);
const r8 = obj.getRandomValue();
console.log(`Test 8 - getRandomValue() in {1,3}: ${valid8.has(r8) ? '[PASS]' : '[FAIL]'} result=${r8} expected=one of {1,3}`);

// Test 9: getRandomValue() after insert; set becomes {1, 3, 4}
obj.insert(4);
const valid9 = new Set([1, 3, 4]);
const r9 = obj.getRandomValue();
console.log(`Test 9 - getRandomValue() in {1,3,4}: ${valid9.has(r9) ? '[PASS]' : '[FAIL]'} result=${r9} expected=one of {1,3,4}`);
